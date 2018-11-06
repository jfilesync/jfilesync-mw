package net.jfilesync.jfsmw.core.ui.common;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public interface UiExecutor {
  <V> RunnableFuture<V> runInUiThread(Callable<V> callable);

  RunnableFuture<Void> runInUiThread(Runnable runnable);
}
