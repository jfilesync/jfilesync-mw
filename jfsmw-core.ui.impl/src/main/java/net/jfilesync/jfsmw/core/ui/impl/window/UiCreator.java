package net.jfilesync.jfsmw.core.ui.impl.window;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author Christoph Graupner <ch.graupner@workingdeveloper.net>
 */
public class UiCreator {

  public void create(Stage stage) {
    stage.setTitle("Hallo APP");
    String javaVersion   = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    Label  l             = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    Scene  scene         = new Scene(l, 640, 480);
    stage.setScene(scene);
    stage.show();
  }
}
