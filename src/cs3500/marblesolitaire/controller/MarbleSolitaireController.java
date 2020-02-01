package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


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
