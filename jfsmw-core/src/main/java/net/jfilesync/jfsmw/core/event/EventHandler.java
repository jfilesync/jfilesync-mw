package net.jfilesync.jfsmw.core.event;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public interface EventHandler<EVENT extends JfsMwEvent> extends EventSubscription<EVENT>, EventPublisher<EVENT> {
}
