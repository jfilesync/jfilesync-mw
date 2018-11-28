package net.jfilesync.jfsmw.core.impl.event;

import net.jfilesync.jfsmw.core.event.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
@SuppressWarnings("unchecked")
public class CoreEventManager implements EventManager {
  private Map<String, EventHandler<? extends JfsMwEvent>> eventSubscriptionMap = new HashMap<>();

  @Override
  public <EV extends JfsMwEvent> EventPublisher<EV> forEvent(final String eventId) {
    if (!eventSubscriptionMap.containsKey(eventId)) {
      eventSubscriptionMap.put(eventId, new CoreEventSubscription<EV>(eventId, this));
    }
    return (EventPublisher<EV>) eventSubscriptionMap.get(eventId);
  }

  @Override

  public <EV extends JfsMwEvent> EventPublisher<EV> forEvent(final Class<EV> eventId) {
    return (EventPublisher<EV>) forEvent(eventId.getName());
  }

  @Override
  public <EV extends JfsMwEvent> EventSubscription<EV> on(final String eventId) {
    if (!eventSubscriptionMap.containsKey(eventId)) {
      eventSubscriptionMap.put(eventId, new CoreEventSubscription<EV>(eventId, this));
    }
    return (EventSubscription<EV>) eventSubscriptionMap.get(eventId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <EV extends JfsMwEvent> EventSubscription<EV> on(final Class<EV> eventId) {
    return (EventSubscription<EV>) forEvent(eventId.getName());
  }
}
