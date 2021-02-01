import java.io.InputStreamReader;

import controller.MarbleSolitaireControllerImpl;

import model.SimpleModel.MarbleSolitaireModelImpl;
import model.AbstractModel.AbstractSolitaireModelImpl;
import model.AbstractModel.EuropeanSolitaireModelImpl;
import model.AbstractModel.TriangleSolitaireModelImpl;

/**
 * Class to run a main method which will be used to actually play the game.
 */
public final class MarbleSolitaire {


  /**
   * Main method to run the game MarbleSolitaire.
   */
  public static void main(String[] args) {

    AbstractSolitaireModelImpl game = null;

    if (args[0].equals("english")) {
      if (args.length > 1) {
        if (args[1].equals("-row")) {
          game = new MarbleSolitaireModelImpl(
                  Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else if (args[1].equals("-size")) {
          game = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
        }
      } else {
        game = new MarbleSolitaireModelImpl();
      }

    }



    if (args[0].equals("european")) {
      if (args.length > 1) {
        if (args[1].equals("-row")) {
          game = new EuropeanSolitaireModelImpl(
                  Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else if (args[1].equals("-size")) {
          game = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
        }
      } else {
        game = new EuropeanSolitaireModelImpl();
      }

    }

    if (args[0].equals("triangle")) {
      if (args.length > 1) {
        if (args[1].equals("-row")) {
          game = new TriangleSolitaireModelImpl(
                  Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else if (args[1].equals("-size")) {
          game = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
        }
      }
      else {
        game = new TriangleSolitaireModelImpl();
      }
    }

    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
            System.out).playGame(game);


  }
}


