package net.jfilesync.jfsmw.core.ui;

import javafx.application.Application;
import net.jfilesync.jfsmw.core.ui.common.UiExecutor;
import net.jfilesync.jfsmw.core.ui.common.UiSystem;
import net.jfilesync.jfsmw.core.ui.window.PrimaryStageProvider;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public interface JfsMwUiManager extends UiExecutor, UiSystem, PrimaryStageProvider {

  Application getApplication();

  void show();
  void hide();
}
