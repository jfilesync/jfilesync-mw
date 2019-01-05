package net.jfilesync.jfsmw.core.ui.impl.window;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import net.jfilesync.jfsmw.core.event.EventManager;
import net.jfilesync.jfsmw.core.ui.JfsMwUiManager;
import net.jfilesync.jfsmw.core.ui.event.UiCreatedEvent;
import net.jfilesync.jfsmw.core.ui.impl.internal.FxApplication;
import net.jfilesync.jfsmw.core.ui.menu.JfsMwMenuManager;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RunnableFuture;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class CoreJfsMwUiManager implements JfsMwUiManager {

  @Inject EventManager     eventBus;
  @Inject Injector         injector;
  @Inject JfsMwMenuManager menuManager;
  @Inject UiCreator        uiCreator;
  private ForkJoinTask<?>  fxAppTask;
  private Thread           fxApplicationThread;

  @Override
  public Application getApplication() {
    return FxApplication.getInstance();
  }

  @Override
  public Stage getPrimaryStage() {
    return FxApplication.getInstance().getPrimaryStage();
  }

  @Override
  public void hide() {
    final Stage primaryStage = getPrimaryStage();
    if (primaryStage != null) {
      runInUiThread(primaryStage::hide);
    }
  }

  @Override
  public <V> RunnableFuture<V> runInUiThread(final Callable<V> callable) {
    return null;
  }

  @Override
  public RunnableFuture<Void> runInUiThread(final Runnable runnable) {
    Platform.runLater(runnable);
    return null;
  }

  @Override
  public void show() {
    final Stage primaryStage = getPrimaryStage();
    if (primaryStage != null) {
      runInUiThread(primaryStage::show);
    }
  }

  @Override
  public void shutdown() {
    Platform.exit();
  }

  @Override
  public void start() {

    fxAppTask = ForkJoinTask.adapt(
        () -> FxApplication.launch(FxApplication.class)
    );
    ForkJoinPool.commonPool().execute(fxAppTask);

    int waitCount = 10;
    while (waitCount > 0
           &&
           (FxApplication.getInstance() == null
            || FxApplication.getInstance().getPrimaryStage() == null)
    ) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      waitCount--;
    }
    if (waitCount <= 0) {
      throw new IllegalStateException("Time out to wait for UI to start.");
    }

    runInUiThread(() -> {
      try {
        uiCreator.create(getPrimaryStage());
      } catch (Exception e) {
        Arrays.stream(e.getStackTrace())
              .forEach(System.err::println);
      }

      eventBus.forEvent(UiCreatedEvent.class).post(new UiCreatedEvent());
      Platform.setImplicitExit(true);
      show();
    });
  }

  @Override
  public void waitForShutdown() {
    fxAppTask.quietlyJoin();
  }
}
