package net.jfilesync.jfsmw.core.impl.event;

import net.jfilesync.jfsmw.core.event.EventSubscription;
import net.jfilesync.jfsmw.core.event.JfsMwEventBase;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
class CoreEventManagerTest {
  class TestEvent extends JfsMwEventBase {

    private final String msg;

    public TestEvent(final String t1) {
      this.msg = t1;
    }

    TestEvent() {
      msg = null;
    }
  }

  @Test
  void forEvent() {
    final CoreEventManager  sut = new CoreEventManager();
    final EventSubscription tt  = sut.on("test.hh");
    assertNotNull(tt);
    assertEquals("test.hh", tt.getEventID());
  }

  @Test
  void on() {
    final CoreEventManager sut    = new CoreEventManager();
    final List<String>     actual = new ArrayList<>();

    assertNotNull(sut.forEvent("test.hh"));
    sut.on("test.hh").execute(() -> actual.add("test.hh"));
    sut.forEvent("test.hh").post(new TestEvent("test.hh"));
    MatcherAssert.assertThat(actual, Matchers.hasSize(1));
    MatcherAssert.assertThat(actual, Matchers.hasItem("test.hh"));

    sut.on(TestEvent.class).execute(() -> actual.add("test"));
    sut.forEvent("test.hh").post(new TestEvent("test.hh"));
    MatcherAssert.assertThat(actual, Matchers.hasSize(2));
    MatcherAssert.assertThat(actual, Matchers.hasItems("test.hh", "test.hh"));

    sut.forEvent(TestEvent.class).post(new TestEvent("test.hh"));
    MatcherAssert.assertThat(actual, Matchers.hasSize(3));
    MatcherAssert.assertThat(actual, Matchers.hasItems("test.hh", "test.hh", "test"));
  }
}
