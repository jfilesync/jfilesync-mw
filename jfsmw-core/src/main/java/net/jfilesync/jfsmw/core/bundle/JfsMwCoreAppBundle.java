package net.jfilesync.jfsmw.core.bundle;

import com.google.inject.Inject;
import net.jfilesync.jfsmw.core.event.EventManager;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class JfsMwCoreAppBundle implements JfsMwAppBundle {

  @Inject
  EventManager eventManager;

  @Override
  public void init() {

  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {

  }
}
