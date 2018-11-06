/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
module net.jfilesync.jfsmw.core.app {
  exports net.jfilesync.jfsmw.app;

  uses net.jfilesync.jfsmw.core.ui.common.UiSystem;
  uses net.jfilesync.jfsmw.core.ui.JfsMwUiManager;
  uses com.google.inject.AbstractModule;
  uses net.jfilesync.jfsmw.core.bundle.JfsMwAppBundle;

  requires net.jfilesync.jfsmw.core;
  requires net.jfilesync.jfsmw.core.impl;
  requires net.jfilesync.jfsmw.core.ui;
  requires net.jfilesync.jfsmw.core.ui.impl;
  requires javafx.base;
  requires javafx.controls;
  requires javafx.graphics;
  requires com.google.guice;

}
