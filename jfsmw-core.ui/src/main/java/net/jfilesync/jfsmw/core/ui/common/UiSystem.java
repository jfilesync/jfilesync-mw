package net.jfilesync.jfsmw.core.ui.common;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public interface UiSystem {
  void start();

  void shutdown();

  void waitForShutdown();
}
