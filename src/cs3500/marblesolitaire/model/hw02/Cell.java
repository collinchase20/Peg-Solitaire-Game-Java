package cs3500.marblesolitaire.model.hw02;

/**
 * Class that creates a Cell to be used as a space in a marblesolitairegame.
 */
public class Cell {
  public int x;
  public int y;
  public char letter;

  /**
   * Constructs {@code Cell} object.
   * @param x      the column of the cell
   * @param y      the row of the cell
   * @param letter the character in the cell
   */
  public Cell(int x, int y, char letter) {
    this.x = x;
    this.y = y;
    this.letter = letter;
  }
}
