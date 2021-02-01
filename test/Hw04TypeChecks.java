import controller.MarbleSolitaireController;
import controller.MarbleSolitaireControllerImpl;
import model.AbstractModel.EuropeanSolitaireModelImpl;
import model.AbstractModel.TriangleSolitaireModelImpl;
import model.SimpleModel.MarbleSolitaireModel;
import model.SimpleModel.MarbleSolitaireModelImpl;

/**
 * Do not modify this file. This file should compile correctly with your code!
 * You DO NOT need to submit this file.
 */
public class Hw04TypeChecks {

  /**
   * The contents of this method are meaningless.
   * They are only here to ensure that your code compiles properly.
   */
  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helper(new MarbleSolitaireModelImpl(),
           new MarbleSolitaireControllerImpl(rd, ap));

    helper(new EuropeanSolitaireModelImpl(5),
           new MarbleSolitaireControllerImpl(rd, ap));

    helper(new TriangleSolitaireModelImpl(3, 3),
           new MarbleSolitaireControllerImpl(rd, ap));
  }

  private void makeAllModels() {
    MarbleSolitaireModel m = null;
    m = new MarbleSolitaireModelImpl();
    m = new MarbleSolitaireModelImpl(3);
    m = new MarbleSolitaireModelImpl(2, 2);
    m = new MarbleSolitaireModelImpl(3, 2, 2);

    m = new EuropeanSolitaireModelImpl();
    m = new EuropeanSolitaireModelImpl(3);
    m = new EuropeanSolitaireModelImpl(2, 2);
    m = new EuropeanSolitaireModelImpl(3, 2, 2);

    m = new TriangleSolitaireModelImpl();
    m = new TriangleSolitaireModelImpl(3);
    m = new TriangleSolitaireModelImpl(2, 2);
    m = new TriangleSolitaireModelImpl(3, 2, 2);
  }
  
  private static void helper(
           MarbleSolitaireModel model,
           MarbleSolitaireController controller) {
    controller.playGame(model);
  }

}
