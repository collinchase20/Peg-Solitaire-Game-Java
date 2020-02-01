
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TriangleTest {

  AbstractSolitaireModelImpl emptyConstructor = new TriangleSolitaireModelImpl();
  AbstractSolitaireModelImpl rowColConstructor = new TriangleSolitaireModelImpl(4, 4);
  AbstractSolitaireModelImpl dimensionConstructor = new TriangleSolitaireModelImpl(7);
  AbstractSolitaireModelImpl rowColAndDimensionConstructor = new TriangleSolitaireModelImpl(
          7, 6, 4);

  @Test(expected = IllegalArgumentException.class)
  public void testBoardException1Argument() {
    MarbleSolitaireModel exception = new TriangleSolitaireModelImpl(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBoardException3Argument() {
    MarbleSolitaireModel exception = new TriangleSolitaireModelImpl(5, 7, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBoardException2Argument() {
    MarbleSolitaireModel exception = new TriangleSolitaireModelImpl(0, 1);
  }


  @Test
  public void testMoveSuccessfullyToPositionUpdatesRight() {
    AbstractSolitaireModelImpl tester = new TriangleSolitaireModelImpl(2, 2);
    tester.move(2, 0, 2, 2);

    assertEquals("    O\n" +
            "   O O\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O", tester.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdatesLeft() {
    AbstractSolitaireModelImpl tester = new TriangleSolitaireModelImpl(3, 1);
    tester.move(3, 3, 3, 1);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ _\n" +
            "O O O O O", tester.getGameState());
  }


  @Test
  public void testMoveSuccessfullyToPositionUpdatesDiagonalUpRight() {
    emptyConstructor.move(2, 0, 0, 0);

    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdatesDiagonalUpLeft() {
    emptyConstructor.move(2, 2, 0, 0);

    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdatesDiagonalDownLeft() {
    AbstractSolitaireModelImpl tester = new TriangleSolitaireModelImpl(3, 1);
    tester.move(1, 1, 3, 1);

    assertEquals("    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", tester.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdatesDiagonalDownRight() {
    AbstractSolitaireModelImpl tester = new TriangleSolitaireModelImpl(3, 3);
    tester.move(1, 1, 3, 3);

    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", tester.getGameState());
  }

  @Test
  public void testMoveExceptionMoreThan2() {

    TriangleSolitaireModelImpl moveMore2 = new TriangleSolitaireModelImpl(4, 4);

    try {

      moveMore2.move(4, 1, 4, 4);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionDiagonal() {
    try {

      emptyConstructor.move(1, 0, 0, 0);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveToMarble() {
    try {

      emptyConstructor.move(3, 3, 3, 1);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveFromEmpty() {
    try {

      emptyConstructor.move(0, 0, 2, 2);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveToNothing() {
    try {

      emptyConstructor.move(2, 0, 10, 8);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveFromNothing() {
    try {

      emptyConstructor.move(10, 8, 0, 0);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void TriangleGameStateTestEmpty() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", emptyConstructor.getGameState());
  }

  @Test
  public void TriangleGameStateTestDimension() {
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", dimensionConstructor.getGameState());
  }

  @Test
  public void TriangleGameStateTestRowCol() {
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O _", rowColConstructor.getGameState());
  }

  @Test
  public void TriangleGameStateTestRowColAndDimension() {
    assertEquals("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O _ O O", rowColAndDimensionConstructor.getGameState());
  }


  @Test
  public void TriangleGetScoreTestNoMoves() {
    assertEquals(14, emptyConstructor.getScore());
  }

  @Test
  public void testGameNotOver() {
    emptyConstructor.move(2, 2, 0, 0);
    emptyConstructor.move(2, 0, 2, 2);
    emptyConstructor.move(4, 3, 2, 1);
    emptyConstructor.move(4, 1, 4, 3);
    emptyConstructor.move(4, 0, 2, 0);
    emptyConstructor.move(1, 0, 3, 0);
    emptyConstructor.move(4, 4, 4, 2);
    assertEquals(false, emptyConstructor.isGameOver());
  }

  @Test
  public void testGameWinEmptyConstructor() {
    emptyConstructor.move(2, 2, 0, 0);
    emptyConstructor.move(2, 0, 2, 2);
    emptyConstructor.move(4, 3, 2, 1);
    emptyConstructor.move(4, 1, 4, 3);
    emptyConstructor.move(4, 0, 2, 0);
    emptyConstructor.move(1, 0, 3, 0);
    emptyConstructor.move(4, 4, 4, 2);
    emptyConstructor.move(4, 2, 2, 0);
    emptyConstructor.move(3, 0, 1, 0);
    emptyConstructor.move(3, 3, 1, 1);
    emptyConstructor.move(0, 0, 2, 2);
    emptyConstructor.move(2, 2, 2, 0);
    emptyConstructor.move(2, 0, 0, 0);
    assertEquals(true, emptyConstructor.isGameOver());
  }
}