package cs3500.marblesolitaire.model.SimpleModel;


import cs3500.marblesolitaire.model.AbstractModel.AbstractSolitaireModelImpl;

/**
 * Class that creates the English MarbleSolitaireModelImpl. This class was entirely changed to
 * simply extend the new AbstractSolitaireModelImpl which inherited all the orignal methods from
 * this class. This is so the European and Triangle can also extend the abstract with the basic
 * methods.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructs {@code MarbleSolitaireModelImpl} object.
   */
  public MarbleSolitaireModelImpl() {
    super();
  }

  /**
   * Constructs {@code MarbleSolitaireModelImpl} object.
   *
   * @param sRow the row of the starting empty space
   * @param sCol the column of the starting empty space
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    super(sRow, sCol);
  }

  /**
   * Constructs {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the side lengths of the board
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    super(armThickness);
  }

  /**
   * Constructs {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the side lengths of the board
   * @param sRow         the row of the starting empty space
   * @param sCol         the column of the starting empty space
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
  }
}







