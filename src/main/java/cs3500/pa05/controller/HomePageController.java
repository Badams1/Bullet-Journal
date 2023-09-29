package cs3500.pa05.controller;

import cs3500.pa05.view.View;
import cs3500.pa05.view.WeekView;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller for the home page.
 */
public class HomePageController implements Controller {
  private final Stage stage;
  @FXML
  private Button prevWeekButton;
  @FXML
  private Button newWeekButton;

  @FXML
  private Controller weekController;

  public HomePageController(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void run() throws IllegalStateException {
    setup();
  }

  private void setup() {
    prevWeekButton.setOnAction(e -> loadPrevWeek());
    newWeekButton.setOnAction(e -> newWeek());
  }

  private void loadPrevWeek() {
    // Create a FileChooser
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    FileChooser.ExtensionFilter extensionFilter =
        new FileChooser.ExtensionFilter("Bujo Files (*.bujo)", "*.bujo");
    fileChooser.getExtensionFilters().add(extensionFilter);
    File selectedFile = fileChooser.showOpenDialog(stage);


    if (selectedFile.length() != 0) {

      this.weekController = new WeekController(this.stage, selectedFile, true);
      View weekView = new WeekView(weekController);

      try {
        // load and place the view's scene onto the stage
        this.stage.setScene(weekView.load());

        // fetch the view's controller
        weekController.run();

        // render the stage
        this.stage.show();
      } catch (IllegalStateException | IOException e) {
        System.err.println("Unable to load GUI.");
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Invalid File");
      alert.setContentText("The file you selected is invalid. Please select a valid file.");
      alert.showAndWait();
    }
  }

  private void newWeek() {
    this.weekController = new WeekController(this.stage);
    View weekView = new WeekView(weekController);

    try {
      // load and place the view's scene onto the stage
      this.stage.setScene(weekView.load());

      // fetch the view's controller
      weekController.run();
      // render the stage
      this.stage.show();
    } catch (IllegalStateException | IOException e) {
      System.err.println("Unable to load GUI.");
    }
  }
}