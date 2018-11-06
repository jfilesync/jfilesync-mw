package net.jfilesync.jfsmw.core.ui.impl.bundle;

import com.google.inject.AbstractModule;
import net.jfilesync.jfsmw.core.ui.common.UiSystem;
import net.jfilesync.jfsmw.core.ui.impl.window.CoreJfsMwUiManager;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class JfsMwCoreUiImplGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(UiSystem.class).to(CoreJfsMwUiManager.class);
  }
}
