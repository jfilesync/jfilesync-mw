package net.jfilesync.jfsmw.core.bundle;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import net.jfilesync.jfsmw.core.event.EventManager;
import net.jfilesync.jfsmw.core.event.JfsMwEventBus;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class JfsMwCoreGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    final JfsMwEventBus instance = new JfsMwEventBus(ForkJoinPool.commonPool());
    bind(EventBus.class).toInstance(instance);
    bind(EventManager.class).toInstance(instance);
  }
}
