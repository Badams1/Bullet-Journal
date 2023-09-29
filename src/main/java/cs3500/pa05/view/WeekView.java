package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the cs3500.pa05.view of the week cs3500.pa05.view. Will have the View of the week.
 */
public class WeekView implements View {

  private final FXMLLoader loader;

  /**
   * Constructs a WeekView.
   *
   * @param controller the controller for the week cs3500.pa05.view
   */
  public WeekView(Controller controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("BulletJournal.fxml"));
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
