package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the cs3500.pa05.view of the home page. Will have the initial View of the application.
 * Where the user will open the file or create a new file.
 */
public class HomePageView implements View {
  private final FXMLLoader loader;
  public HomePageView(Controller controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("WelcomeScreen.fxml"));
    this.loader.setController(controller);
  }

  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
