package cs3500.marblesolitaire.model.hw04;


import cs3500.marblesolitaire.model.hw02.Cell;

/**
 * Class that creates a triangle MarbleSolitaireModelImpl extending AbstractSolitaire.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructs {@code TriangleSolitaireModelImpl} object.
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }

  /**
   * Constructs {@code TriangleSolitaireModelImpl} object.
   *
   * @param dimensions the dimension of the board
   */
  public TriangleSolitaireModelImpl(int dimensions) {
    this(dimensions, 0, 0);
  }

  /**
   * Constructs {@code TriangleSolitaireModelImpl} object.
   *
   * @param row the row of the starting empty space
   * @param col the column of the starting empty space
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this(5, row, col);
  }

  /**
   * Constructs {@code TriangleSolitaireModelImpl} object.
   *
   * @param dimensions the dimension of the board
   * @param row        the row of the starting empty space
   * @param col        the column of the starting empty space
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {
    super(dimensions, row, col);
  }

  @Override
  public void resetGame() {
    for (int i = 1; i < this.armThickness + 1; i++) {
      for (int k = 0; k < i; k++) {
        this.board.add(new Cell(i - 1, k, 'O'));
      }
    }
    this.checkThickness();
    this.checkCenter();
  }

  @Override
  public void checkThickness() throws IllegalArgumentException {
    if (this.armThickness < 2) {
      throw new IllegalArgumentException("Dimension must be a positive number higher than 1");
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int x = 0;
    int y = 0;
    /**
     * If the move is not valid, throw an exception. The move is either off the board
     * or cant be performed due to it being too far away, or its trying to move onto
     * another marble.
     */
    if (!this.isValid(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("That is an invalid move!");
    } else {
      for (Cell c : this.board) {
        if (c.x == fromRow && c.y == fromCol) {
          c.letter = '_';
        }
      }
      for (Cell i : this.board) {
        if (i.x == toRow && i.y == toCol) {
          i.letter = 'O';
        }
      }
      if (fromRow == toRow) {
        x = toRow;
        y = (fromCol + toCol) / 2;

      }
      if (fromCol == toCol) {
        y = toCol;
        x = (fromRow + toRow) / 2;
      }
      if (toRow == fromRow - 2 && toCol == fromCol - 2) {
        x = fromRow - 1;
        y = fromCol - 1;
      }
      if (toRow == fromRow + 2 && toCol == fromCol + 2) {
        x = fromRow + 1;
        y = fromCol + 1;
      }
      for (Cell b : this.board) {
        if (b.x == x && b.y == y) {
          b.letter = '_';
        }
      }
    }
  }

  @Override
  public boolean isValid(int fromRow, int fromCol, int toRow, int toCol) {
    boolean valid = false;
    Cell from = new Cell(-1, -1, 'O');
    Cell to = new Cell(-1, -1, 'O');
    for (Cell c : this.board) {
      if ((c.x == fromRow && c.y == fromCol) && c.letter == 'O') {
        from = new Cell(c.x, c.y, c.letter);
      }
      if ((c.x == toRow && c.y == toCol) && c.letter == '_') {
        to = new Cell(c.x, c.y, c.letter);
      }
    }
    if (((to.x == from.x - 2) || to.x == from.x + 2) && to.y == from.y && to.x >= 0
            && to.letter != ' ' && to.letter != 'O') {
      for (Cell each : this.board) {
        if (each.y == from.y && each.x == (fromRow + toRow) / 2) {
          return each.letter == 'O';
        }
      }
    }
    if (((to.y == from.y - 2) || to.y == from.y + 2) && to.x == from.x && to.y >= 0
            && to.letter != ' ' && to.letter != 'O') {
      for (Cell each : this.board) {
        if (each.x == from.x && each.y == (fromCol + toCol) / 2) {
          return each.letter == 'O';
        }
      }
    }
    if ((to.x == from.x - 2 && to.y == from.y - 2) && (to.letter != ' ') && (to.letter != 'O')) {
      for (Cell each : this.board) {
        if (each.x == from.x - 1 && each.y == from.y - 1 && each.letter == 'O') {
          return true;
        }
      }
    }
    if ((to.x == from.x + 2 && to.y == from.y + 2) && (to.letter != ' ') && (to.letter != 'O')) {
      for (Cell each : this.board) {
        if (each.x == from.x + 1 && each.y == from.y + 1 && each.letter == 'O') {
          return true;
        }
      }
    }
    return valid;
  }


  @Override
  public boolean isGameOver() {
    boolean b = true;
    for (Cell c : this.board) {
      if (this.isValid(c.x, c.y, c.x - 2, c.y - 2)) {
        b = false;
      }
      if (this.isValid(c.x, c.y, c.x + 2, c.y + 2)) {
        b = false;
      }
      if (this.isValid(c.x, c.y, c.x + 2, c.y)) {
        b = false;
      }
      if (this.isValid(c.x, c.y, c.x, c.y + 2)) {
        b = false;
      }
      if (this.isValid(c.x, c.y, c.x - 2, c.y)) {
        b = false;
      }
      if (this.isValid(c.x, c.y, c.x, c.y - 2)) {
        b = false;
      }
    }
    int accum = 0;
    for (Cell c : this.board) {
      if (c.letter == 'O') {
        accum += 1;
      }
    }
    if (accum == 1) {
      b = true;
    }

    return b;
  }


  @Override
  public String getGameState() {
    StringBuilder finalString = new StringBuilder();
    int accum = 0;
    for (Cell c : this.board) {
      if (c.y == 0 && c.x == 0) {
        for (int i = 0; i < (this.armThickness - 1) - c.x; i++) {
          finalString.append(' ');
        }
        finalString.append(c.letter).append('\n');
        accum += 1;
        continue;
      }
      if (c.y == 0 && c.x != 0) {
        for (int i = 0; i < (this.armThickness - 1) - c.x; i++) {
          finalString.append(' ');
        }
        finalString.append(c.letter).append(' ');
        continue;
      }
      if (c.x == c.y && accum < this.armThickness - 1) {
        finalString.append(c.letter).append('\n');
        accum += 1;
        continue;
      }
      if (c.x == c.y && accum == this.armThickness - 1) {
        finalString.append(c.letter);
      }
      if (c.x != c.y && c.y != 0) {
        finalString.append(c.letter).append(' ');
      }
    }
    return finalString.toString();
  }
}
