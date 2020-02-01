package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Class that creates a MarbleSolitaireController to to interact with Marble Solitaire game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Appendable ap;
  private final Scanner scan;

  /**
   * Constructs a MarbleSolitaire Controller to provide input for the Marble Solitaire Model.
   *
   * @param rd the input readable.
   * @param ap the output appendable.
   * @throws IllegalArgumentException if either input is null.
   */

  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException();
    } else {
      this.ap = ap;
      scan = new Scanner(rd);
    }
  }

  @Override
  public void playGame(MarbleSolitaireModel model) {
    String input;
    ArrayList<Integer> four = new ArrayList<Integer>();
    Integer accum = 0;

    try {

      if (model == null) {
        throw new IllegalArgumentException();
      }

      while (!model.isGameOver()) {

        if (accum == 0) {
          this.ap.append(model.getGameState() + "\n");
          this.ap.append("Score: " + model.getScore() + "\n");
          accum += 1;
        }

        if (!scan.hasNext()) {
          throw new IllegalStateException();
        }

        input = scan.next();

        if (isValidNum(input) && accum > 0 && accum < 5) {
          four.add(Integer.parseInt(input));
          accum += 1;
        }

        if (accum == 5) {
          try {
            model.move(four.get(0) - 1, four.get(1) - 1, four.get(2) - 1, four.get(3) - 1);
          } catch (IllegalArgumentException e) {
            this.ap.append("Invalid move. Play Again. " + e + "\n");
          }
          accum = 0;
          four.clear();
        }

        if (input.equals("q") || input.equals("Q")) {
          this.ap.append("Game quit!" + "\n");
          this.ap.append("State of game when quit:" + "\n");
          this.ap.append(model.getGameState() + "\n");
          this.ap.append("Score: " + model.getScore());
          return;
        }
      }
      this.ap.append("Game over!" + "\n");
      this.ap.append(model.getGameState() + "\n");
      this.ap.append("Score: " + model.getScore());

    } catch (IOException ex) {
      ex.printStackTrace();
      throw new IllegalStateException();
    }
  }


  private boolean isValidNum(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
