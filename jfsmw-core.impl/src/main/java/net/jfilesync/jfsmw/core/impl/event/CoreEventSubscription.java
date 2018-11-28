package net.jfilesync.jfsmw.core.impl.event;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import net.jfilesync.jfsmw.core.event.EventHandler;
import net.jfilesync.jfsmw.core.event.EventPublisher;
import net.jfilesync.jfsmw.core.event.EventSubscription;
import net.jfilesync.jfsmw.core.event.JfsMwEvent;

import java.util.function.Consumer;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class CoreEventSubscription<EVENT extends JfsMwEvent> implements EventHandler<EVENT> {

  abstract class EventExec<T> {
    public abstract void execute();
  }

  class ConsumerEventExec<T> extends EventExec<Consumer<T>> {
    public void execute() {

    }
  }

  class RunnableEventExec extends EventExec<Runnable> {

    @Override
    public void execute() {

    }
  }

  final         Subject<EVENT>   subject;
  private final CoreEventManager coreEventManager;
  private final String           eventId;

  public CoreEventSubscription(final String eventId, final CoreEventManager coreEventManager) {

    this.eventId = eventId;
    this.coreEventManager = coreEventManager;
    subject = PublishSubject.create();
  }

  @Override
  public EventSubscription<EVENT> execute(final Consumer<EVENT> function) {
    subject.subscribe(function::accept);
    return null;
  }

  @Override
  public EventSubscription<EVENT> execute(final Runnable function) {
    subject.subscribe((ev) -> function.run());
    return this;
  }

  @Override
  public <ERROR extends Throwable> EventSubscription executeOnError(final Consumer<ERROR> function) {
    return this;
  }

  @Override
  public String getEventID() {
    return eventId;
  }

  @Override
  public EventPublisher<EVENT> post(final EVENT event) {
    subject.onNext(event);
    return this;
  }
}
