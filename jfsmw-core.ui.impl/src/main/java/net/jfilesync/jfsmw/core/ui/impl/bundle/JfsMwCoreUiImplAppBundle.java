package net.jfilesync.jfsmw.core.ui.impl.bundle;

import com.google.inject.Inject;
import net.jfilesync.jfsmw.core.bundle.JfsMwAppBundle;
import net.jfilesync.jfsmw.core.event.EventManager;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class JfsMwCoreUiImplAppBundle implements JfsMwAppBundle {
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
