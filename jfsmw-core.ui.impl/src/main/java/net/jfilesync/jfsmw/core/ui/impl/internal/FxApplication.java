package net.jfilesync.jfsmw.core.ui.impl.internal;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class FxApplication extends Application {

  private static volatile FxApplication instance;
  private volatile        Stage         primaryStage;

  public static FxApplication getInstance() {
    return instance;
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }

  @Override
  public void start(Stage primaryStage) {
    if (instance != null) {
      throw new IllegalStateException("FxApplication already started.");
    }
    instance = this;
    this.primaryStage = primaryStage;
  }


}
