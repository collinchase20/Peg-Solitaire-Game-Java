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
    helper(new cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModelImpl(),
           new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap));

    helper(new cs3500.marblesolitaire.model.AbstractModel.EuropeanSolitaireModelImpl(5),
           new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap));

    helper(new cs3500.marblesolitaire.model.AbstractModel.TriangleSolitaireModelImpl(3, 3),
           new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap));
  }

  private void makeAllModels() {
    cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModel m = null;
    m = new cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModelImpl();
    m = new cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModelImpl(3);
    m = new cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModelImpl(2, 2);
    m = new cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModelImpl(3, 2, 2);

    m = new cs3500.marblesolitaire.model.AbstractModel.EuropeanSolitaireModelImpl();
    m = new cs3500.marblesolitaire.model.AbstractModel.EuropeanSolitaireModelImpl(3);
    m = new cs3500.marblesolitaire.model.AbstractModel.EuropeanSolitaireModelImpl(2, 2);
    m = new cs3500.marblesolitaire.model.AbstractModel.EuropeanSolitaireModelImpl(3, 2, 2);

    m = new cs3500.marblesolitaire.model.AbstractModel.TriangleSolitaireModelImpl();
    m = new cs3500.marblesolitaire.model.AbstractModel.TriangleSolitaireModelImpl(3);
    m = new cs3500.marblesolitaire.model.AbstractModel.TriangleSolitaireModelImpl(2, 2);
    m = new cs3500.marblesolitaire.model.AbstractModel.TriangleSolitaireModelImpl(3, 2, 2);
  }
  
  private static void helper(
           cs3500.marblesolitaire.model.SimpleModel.MarbleSolitaireModel model,
           cs3500.marblesolitaire.controller.MarbleSolitaireController controller) {
    controller.playGame(model);
  }

}
