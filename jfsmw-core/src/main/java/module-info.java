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
  requires com.google.common;
}
