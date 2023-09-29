package cs3500.pa05.controller;

import java.io.IOException;

/**
 * Represents a cs3500.pa05.controller.
 */
public interface Controller {

  /**
   * Runs the cs3500.pa05.controller.
   *
   * @throws IllegalStateException if the cs3500.pa05.controller cannot be run
   */
  void run() throws IllegalStateException, IOException;
}
