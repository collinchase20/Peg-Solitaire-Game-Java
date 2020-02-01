package cs3500.marblesolitaire.model.hw04;


import cs3500.marblesolitaire.model.hw02.Cell;

/**
 * Class that creates the European MarbleSolitaireModelImpl extending AbstractSolitaire.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructs {@code EuropeanSolitaireModelImpl} object.
   */
  public EuropeanSolitaireModelImpl() {
    super();
  }

  /**
   * Constructs {@code EuropeanSolitaireModelImpl} object.
   *
   * @param armThickness the side lengths of the board
   */
  public EuropeanSolitaireModelImpl(int armThickness) {
    super(armThickness);
  }

  /**
   * Constructs {@code EuropeanSolitaireModelImpl} object.
   *
   * @param row the row of the starting empty space
   * @param col the column of the starting empty space
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    super(row, col);
  }

  /**
   * Constructs {@code EuropeanSolitaireModelImpl} object.
   *
   * @param armThickness the side lengths of the board
   * @param row          the row of the starting empty space
   * @param col          the column of the starting empty space
   */
  public EuropeanSolitaireModelImpl(int armThickness, int row, int col) {
    super(armThickness, row, col);
  }

  @Override
  public void fixBadSquares() {
    int badSquares = this.armThickness - 1;
    int armthickplus1 = this.armThickness + 1;
    int armthicktimes2 = this.armThickness * 2;
    int lengthOfSide = this.armThickness + (armthicktimes2 - 3);
    for (Cell c : this.board) {
      if (c.x < badSquares && c.y < badSquares && c.x + c.y < badSquares) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
      if (c.x < badSquares && c.y >= this.armThickness + (armthicktimes2 - armthickplus1) &&
              c.y <= lengthOfSide &&
              c.y - c.x > (this.armThickness + (armthicktimes2 - 2)) - this.armThickness) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
      if (c.x >= this.armThickness + (armthicktimes2 - armthickplus1) && c.x <= lengthOfSide &&
              c.y < badSquares &&
              c.x - c.y > (this.armThickness + (armthicktimes2 - 2)) - this.armThickness) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
      if (c.x >= this.armThickness + (armthicktimes2 - armthickplus1) && c.x <= lengthOfSide &&
              c.y >= this.armThickness + (armthicktimes2 - armthickplus1) &&
              c.y <= lengthOfSide && c.x + c.y > (5 * this.armThickness) - 5) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
    }
  }
}
