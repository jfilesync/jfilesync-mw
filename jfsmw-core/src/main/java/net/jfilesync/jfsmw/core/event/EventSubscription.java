package net.jfilesync.jfsmw.core.event;

import java.util.function.Consumer;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public interface EventSubscription<EVENT extends JfsMwEvent> {
  EventSubscription<EVENT> execute(Consumer<EVENT> function);

  EventSubscription<EVENT> execute(Runnable function);

  <ERROR extends Throwable> EventSubscription<EVENT> executeOnError(Consumer<ERROR> function);

  String getEventID();
}
