package net.jfilesync.jfsmw.core.event;

import com.google.common.eventbus.DeadEvent;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public interface EventPublisher<EVENT extends JfsMwEvent> {
  /**
   * Posts an event to all registered subscribers. This method will return successfully after the
   * event has been posted to all subscribers, and regardless of any exceptions thrown by
   * subscribers.
   *
   * <p>If no subscribers have been subscribed for {@code event}'s class, and {@code event} is not
   * already a {@link DeadEvent}, it will be wrapped in a DeadEvent and reposted.
   *
   * @param event event to post.
   */
  EventPublisher<EVENT> post(EVENT event);
}
