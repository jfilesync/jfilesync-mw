package net.jfilesync.jfsmw.core.ui.impl.window;

import com.google.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.jfilesync.jfsmw.core.JfsMwConsts;
import net.jfilesync.jfsmw.core.ui.menu.JfsMwMenuManager;

import java.net.URL;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class UiCreator {

  @Inject
  JfsMwMenuManager menuManager;

  public void create(Stage stage) throws Exception {
    stage.setTitle(JfsMwConsts.APP_NAME + " v" + JfsMwConsts.APP_CONFIG_VERSION);
    URL fxmlUrl = this.getClass()
                      .getResource("/fxml/main.fxml");

    // Load the FXML document
    BorderPane root = FXMLLoader.load(fxmlUrl);

    String javaVersion   = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    Label l =
        new Label("UiCreator Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    Scene scene = new Scene(root, 640, 480);
    stage.setScene(scene);
    createMenu(scene);
    stage.show();
  }

  private void createMenu(final Scene scene) {

  }
}
