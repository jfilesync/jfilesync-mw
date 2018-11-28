package net.jfilesync.jfsmw.core.event;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public abstract class JfsMwEventBase implements JfsMwEvent {
  private final String eventId;

  protected JfsMwEventBase(final String eventId) {
    this.eventId = eventId;
  }

  protected JfsMwEventBase() {
    this.eventId = getClass().getName();
  }

  @Override
  public String getId() {
    return eventId;
  }
}
