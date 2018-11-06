import net.jfilesync.jfsmw.core.impl.bundle.JfsMwCoreImplGuiceModule;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
module net.jfilesync.jfsmw.core.impl {
  requires net.jfilesync.jfsmw.core;
  requires com.google.common;
  requires com.google.guice;
  requires java.xml.bind;
  requires jaxb.core;
  requires org.slf4j;

  provides com.google.inject.AbstractModule with JfsMwCoreImplGuiceModule;
  provides net.jfilesync.jfsmw.core.bundle.JfsMwAppBundle with net.jfilesync.jfsmw.core.impl.bundle.JfsMwCoreImplAppBundle;

  opens net.jfilesync.jfsmw.core.impl.bundle to com.google.guice;

}
