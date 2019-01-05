/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
module net.jfilesync.jfsmw.core.ui {
  requires net.jfilesync.jfsmw.core;
  requires javafx.base;
  requires javafx.controls;
  requires javafx.graphics;
  requires com.google.common;
  requires com.google.guice;

  exports net.jfilesync.jfsmw.core.ui;
  exports net.jfilesync.jfsmw.core.ui.common;
  exports net.jfilesync.jfsmw.core.ui.event;
  exports net.jfilesync.jfsmw.core.ui.menu;

  provides net.jfilesync.jfsmw.core.bundle.JfsMwAppBundle with net.jfilesync.jfsmw.core.ui.bundle.JfsMwCoreUiAppBundle;
  provides com.google.inject.AbstractModule with net.jfilesync.jfsmw.core.ui.bundle.JfsMwCoreUiGuiceModule;

  opens net.jfilesync.jfsmw.core.ui.bundle to com.google.guice;
}
