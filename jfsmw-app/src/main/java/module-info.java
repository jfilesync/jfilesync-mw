/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
module net.jfilesync.jfsmw.core.app {
  exports net.jfilesync.jfsmw.app;
  requires net.jfilesync.jfsmw.core.ui.impl;
  requires net.jfilesync.jfsmw.core.ui;
  requires javafx.base;
  requires javafx.controls;
  requires javafx.graphics;
}
