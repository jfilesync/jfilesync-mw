package net.jfilesync.jfsmw.core.event;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executor;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class JfsMwEventBus extends AsyncEventBus implements EventManager {
  public JfsMwEventBus(final Executor executor) {
    super("JfsMwEventBus", executor);
  }
}
