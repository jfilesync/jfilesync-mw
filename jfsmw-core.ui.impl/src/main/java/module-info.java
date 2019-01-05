import net.jfilesync.jfsmw.core.ui.impl.bundle.JfsMwCoreUiImplGuiceModule;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
module net.jfilesync.jfsmw.core.ui.impl {
  exports net.jfilesync.jfsmw.core.ui.impl.window;
  exports net.jfilesync.jfsmw.core.ui.impl.internal;
  requires net.jfilesync.jfsmw.core;
  requires net.jfilesync.jfsmw.core.ui;
  requires com.google.common;
  requires com.google.guice;
  requires javafx.base;
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.fxml;

//  provides net.jfilesync.jfsmw.core.ui.JfsMwUiManager with net.jfilesync.jfsmw.core.ui.impl.CoreJfsMwUiManager;
//  provides net.jfilesync.jfsmw.core.ui.common.UiSystem with net.jfilesync.jfsmw.core.ui.impl.CoreJfsMwUiManager;
  provides com.google.inject.AbstractModule with JfsMwCoreUiImplGuiceModule;
  provides net.jfilesync.jfsmw.core.bundle.JfsMwAppBundle with net.jfilesync.jfsmw.core.ui.impl.bundle.JfsMwCoreUiImplAppBundle;

  opens net.jfilesync.jfsmw.core.ui.impl.window to com.google.guice;
  opens net.jfilesync.jfsmw.core.ui.impl.bundle to com.google.guice;
  opens net.jfilesync.jfsmw.core.ui.impl.menu to com.google.guice;
}
