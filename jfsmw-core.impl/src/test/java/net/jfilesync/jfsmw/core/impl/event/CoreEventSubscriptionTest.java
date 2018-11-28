package net.jfilesync.jfsmw.core.impl.event;

import net.jfilesync.jfsmw.core.event.JfsMwEventBase;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
class CoreEventSubscriptionTest {

  class TestEvent extends JfsMwEventBase {

    private final String msg;

    public TestEvent(final String t1) {
      this.msg=t1;
    }

    TestEvent() {
      msg=null;
    }
  }

  @Test
  void executePost() {
    final CoreEventSubscription<TestEvent> sut    = new CoreEventSubscription<>("test.1", getCoreEventManagerMock());
    final List<String>                     actual = new ArrayList<>();
    sut.execute(() -> actual.add("t1"));
    sut.post(new TestEvent());
    MatcherAssert.assertThat(actual, Matchers.hasSize(1));
    MatcherAssert.assertThat(actual, Matchers.hasItem("t1"));

    actual.clear();
    sut.execute((ev) -> actual.add(ev.msg));
    sut.post(new TestEvent("t2"));
    MatcherAssert.assertThat(actual, Matchers.hasSize(2));
    MatcherAssert.assertThat(actual, Matchers.hasItem("t1"));
    MatcherAssert.assertThat(actual, Matchers.hasItem("t2"));
  }

  private CoreEventManager getCoreEventManagerMock() {
    return new CoreEventManager();
  }
}
