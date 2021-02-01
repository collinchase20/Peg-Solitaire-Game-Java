package controller;

import model.SimpleModel.MarbleSolitaireModel;


/**
 * Interface to represent the controller of the MarbleSolitaire Game.
 */

public interface MarbleSolitaireController {

  /**
   * Play Game method that runs game of MarbleSolitaire.
   */

  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException,
          IllegalStateException;

}
