package cs3500.pa05.model;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.HomePageController;
import cs3500.pa05.view.HomePageView;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents the starter application for the Bullet Journal Application.
 */
public class BjFxApplication extends Application {
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Welcome Screen");

    Controller homePage = new HomePageController(primaryStage);

    View homeView = new HomePageView(homePage);

    try {
      // load and place the view's scene onto the stage
      primaryStage.setScene(homeView.load());

      // fetch the view's controller
      homePage.run();
      // render the stage
      primaryStage.show();
    } catch (IllegalStateException | IOException e) {
      System.err.println("Unable to load GUI.");
    }
  }
}
