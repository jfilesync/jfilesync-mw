import net.jfilesync.jfsmw.core.bundle.JfsMwAppBundle;
import net.jfilesync.jfsmw.core.bundle.JfsMwCoreAppBundle;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
module net.jfilesync.jfsmw.core {
  exports net.jfilesync.jfsmw.core.model;
  exports net.jfilesync.jfsmw.core.model.files;
  exports net.jfilesync.jfsmw.core.model.project;
  exports net.jfilesync.jfsmw.core.config.project;
  exports net.jfilesync.jfsmw.core.config.app;
  exports net.jfilesync.jfsmw.core.process.input;
  exports net.jfilesync.jfsmw.core.process.input.event;
  exports net.jfilesync.jfsmw.core.exception;
  exports net.jfilesync.jfsmw.core.event;
  exports net.jfilesync.jfsmw.core.bundle;

  requires com.google.common;
  requires com.google.guice;

  provides com.google.inject.AbstractModule with net.jfilesync.jfsmw.core.bundle.JfsMwCoreGuiceModule;
  provides JfsMwAppBundle with JfsMwCoreAppBundle;

  opens net.jfilesync.jfsmw.core.bundle to com.google.guice;
}
