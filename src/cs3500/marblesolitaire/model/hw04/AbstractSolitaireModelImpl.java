package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.Cell;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract Class for implementations of a MarbleSolitaireModel.
 */
public abstract class AbstractSolitaireModelImpl implements MarbleSolitaireModel {

  protected int armThickness;
  protected int sRow;
  protected int sCol;
  protected ArrayList<Cell> board;

  /**
   * Constructs {@code AbstractSolitaireModelImpl} object.
   */
  public AbstractSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs {@code AbstractSolitaireModelImpl} object.
   *
   * @param sRow the row of the starting empty space
   * @param sCol the column of the starting empty space
   */
  public AbstractSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructs {@code AbstractSolitaireModelImpl} object.
   *
   * @param armThickness the arm thickness of the board
   */
  public AbstractSolitaireModelImpl(int armThickness) {
    this(armThickness, ((armThickness + (2 * armThickness - 3)) / 2),
            ((armThickness + (2 * armThickness - 3)) / 2));
  }

  /**
   * Constructs {@code AbstractSolitaireModelImpl} object.
   *
   * @param armThickness the arm thickness of the board
   * @param sRow         the row of the starting empty space
   * @param sCol         the column of the starting empty space
   */
  public AbstractSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new ArrayList<Cell>();
    this.resetGame();
  }

  protected void resetGame() {
    for (int i = 0; i <= (this.armThickness + (2 * this.armThickness - 3)); i++) {
      for (int j = 0; j <= (this.armThickness + (2 * this.armThickness - 3)); j++) {
        this.board.add(new Cell(i, j, 'O'));
      }
    }
    this.checkThickness();
    this.fixBadSquares();
    this.checkCenter();
  }

  protected void checkThickness() throws IllegalArgumentException {
    if (this.armThickness < 3 || ((this.armThickness % 2) == 0)) {
      throw new IllegalArgumentException("Arm thickness must be a positive odd number!");
    }
  }

  protected void checkCenter() throws IllegalArgumentException {
    boolean empty = false;
    ArrayList<Cell> appender = new ArrayList<Cell>();
    appender.addAll(0, this.board);
    for (Cell c : this.board) {
      if (c.x == this.sRow && c.y == this.sCol && (c.letter == 'O' || c.letter == '_')) {
        empty = true;
        this.board.set(appender.indexOf(c), new Cell(c.x, c.y, '_'));
      } else if (c.x == this.sRow && c.y == this.sCol && c.letter == ' ') {
        empty = false;
      }
    }
    if (!empty) {
      throw new IllegalArgumentException(
              "Invalid empty cell position " + "(" + this.sRow + ", " + this.sCol + ")");
    }
  }


  protected void fixBadSquares() {
    int badSquares = this.armThickness - 1;
    int armthickplus1 = this.armThickness + 1;
    int armthicktimes2 = this.armThickness * 2;
    int lengthOfSide = this.armThickness + (armthicktimes2 - 3);
    for (Cell c : this.board) {
      if (c.x < badSquares && c.y < badSquares) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
      if (c.x < badSquares && c.y >= this.armThickness + (armthicktimes2 - armthickplus1) &&
              c.y <= lengthOfSide) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
      if (c.x >= this.armThickness + (armthicktimes2 - armthickplus1) && c.x <= lengthOfSide &&
              c.y < badSquares) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
      if (c.x >= this.armThickness + (armthicktimes2 - armthickplus1) && c.x <= lengthOfSide &&
              c.y >= this.armThickness + (armthicktimes2 - armthickplus1) &&
              c.y <= lengthOfSide) {
        this.board.set(this.board.indexOf(c), new Cell(c.x, c.y, ' '));
      }
    }
  }

  @Override
  public int getScore() {
    int accum = 0;
    for (Cell each : this.board) {
      if (each.letter == 'O') {
        accum += 1;
      }
    }
    return accum;
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
      for (Cell b : this.board) {
        if (b.x == x && b.y == y) {
          b.letter = '_';
        }
      }
    }
  }

  protected boolean isValid(int fromRow, int fromCol, int toRow, int toCol) {
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
    return valid;
  }

  @Override
  public boolean isGameOver() {
    for (Cell c : this.board) {
      if (this.isValid(c.x, c.y, c.x + 2, c.y)) {
        return false;
      }
      if (this.isValid(c.x, c.y, c.x, c.y + 2)) {
        return false;
      }
      if (this.isValid(c.x, c.y, c.x - 2, c.y)) {
        return false;
      }
      if (this.isValid(c.x, c.y, c.x, c.y - 2)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    StringBuilder finalString = new StringBuilder();
    int armthicktimes2 = this.armThickness * 2;
    int lengthOfSide = this.armThickness + (armthicktimes2 - 2);
    int half = (lengthOfSide - 1) / 2;
    char[][] newBoard = new char[lengthOfSide][lengthOfSide];
    morphBoard(newBoard);
    for (int x = 0; x <= lengthOfSide - 1; x++) {
      for (int y = 0; y <= lengthOfSide - 1; y++) {
        if (y < half || (newBoard[x][y] == '_' || newBoard[x][y] == 'O')) {
          finalString.append(newBoard[x][y]);
          if (y + 1 < lengthOfSide) {
            if (y < half ||
                    (newBoard[x][y + 1] == '_' || newBoard[x][y + 1] == 'O')) {
              finalString.append(' ');
            }
          }
        }
      }
      if (x < lengthOfSide - 1) {
        finalString.append("\n");
      }
    }
    return finalString.toString();
  }

  protected void morphBoard(char[][] board) {
    int armthicktimes2 = this.armThickness * 2;
    int lengthOfSide = this.armThickness + (armthicktimes2 - 2);
    for (int x = 0; x < lengthOfSide; x++) {
      for (int y = 0; y < lengthOfSide; y++) {
        board[x][y] = this.board.get(lengthOfSide * x + y).letter;
      }
    }
  }
}
