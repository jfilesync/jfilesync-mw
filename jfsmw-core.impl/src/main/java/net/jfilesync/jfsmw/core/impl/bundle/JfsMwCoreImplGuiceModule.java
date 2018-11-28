package net.jfilesync.jfsmw.core.impl.bundle;

import com.google.inject.AbstractModule;
import net.jfilesync.jfsmw.core.event.EventManager;
import net.jfilesync.jfsmw.core.impl.event.CoreEventManager;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class JfsMwCoreImplGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    final EventManager instance = new CoreEventManager();
    bind(EventManager.class).toInstance(instance);
  }
}
