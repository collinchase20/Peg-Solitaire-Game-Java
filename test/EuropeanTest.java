
import org.junit.Test;

import model.SimpleModel.MarbleSolitaireModel;
import model.AbstractModel.AbstractSolitaireModelImpl;
import model.AbstractModel.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EuropeanTest {

  AbstractSolitaireModelImpl emptyConstructor = new EuropeanSolitaireModelImpl();
  AbstractSolitaireModelImpl armThick5 = new EuropeanSolitaireModelImpl(5);
  AbstractSolitaireModelImpl rowColConstructor = new EuropeanSolitaireModelImpl(4, 4);
  AbstractSolitaireModelImpl gameOverBoard = new EuropeanSolitaireModelImpl(0, 2);
  AbstractSolitaireModelImpl rowColandThickConstructor = new EuropeanSolitaireModelImpl(7, 7, 8);

  @Test
  public void testEmptyConstructorGetGameState() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testArmThick5ConstructorGetGameState() {
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", armThick5.getGameState());
  }

  @Test
  public void testGetGameStateRowColConstructor() {

    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ O O\n" +
                    "  O O O O O\n" +
                    "    O O O",
            rowColConstructor.getGameState());
  }

  @Test
  public void testGetGameStateRowColAndThickConstructor() {

    assertEquals("            O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O _ O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O O O O O O O\n" +
                    "    O O O O O O O O O O O O O O O\n" +
                    "      O O O O O O O O O O O O O\n" +
                    "        O O O O O O O O O O O\n" +
                    "          O O O O O O O O O\n" +
                    "            O O O O O O O",
            rowColandThickConstructor.getGameState());
  }

  @Test
  public void testGetScoreEmptyConstructor() {
    assertEquals(36, emptyConstructor.getScore());
  }


  @Test
  public void testGetScoreRowColConstructor() {

    assertEquals(36,
            rowColConstructor.getScore());
  }

  @Test
  public void testGetScoreArmThickConstructor() {

    assertEquals(128,
            armThick5.getScore());
  }

  @Test
  public void testGetScoreRowColAndThickConstructor() {

    assertEquals(276,
            rowColandThickConstructor.getScore());
  }


  @Test
  public void testGetGameStateArmThickConstructor() {

    assertEquals("        O O O O O\n" +
                    "      O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "      O O O O O O O\n" +
                    "        O O O O O",
            armThick5.getGameState());
  }


  @Test
  public void testMoveSuccessfullyTwoRowsAbove() {
    emptyConstructor.move(1, 3, 3, 3);

    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyTwoRowsBelow() {
    emptyConstructor.move(5, 3, 3, 3);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyTwoRowsRight() {
    emptyConstructor.move(3, 5, 3, 3);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyTwoRowsLeft() {
    emptyConstructor.move(3, 1, 3, 3);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", emptyConstructor.getGameState());

  }

  @Test
  public void testMoveSuccessfullyFromEuroCorner() {
    EuropeanSolitaireModelImpl tester = new EuropeanSolitaireModelImpl(3, 1);
    tester.move(1, 1, 3, 1);

    assertEquals("    O O O\n" +
            "  _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", tester.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToEuroCorner() {
    EuropeanSolitaireModelImpl tester = new EuropeanSolitaireModelImpl(1, 1);
    tester.move(3, 1, 1, 1);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O _ O O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", tester.getGameState());
  }

  @Test
  public void testIsGameOverFalse() {

    assertEquals(false,
            emptyConstructor.isGameOver());
  }

  @Test
  public void testIsGameOverTrue() {
    gameOverBoard.move(2, 2, 0, 2);
    gameOverBoard.move(4, 2, 2, 2);
    gameOverBoard.move(6, 2, 4, 2);
    gameOverBoard.move(6, 4, 6, 2);
    gameOverBoard.move(4, 3, 6, 3);
    gameOverBoard.move(4, 4, 6, 4);
    gameOverBoard.move(2, 3, 4, 3);
    gameOverBoard.move(2, 4, 4, 4);
    gameOverBoard.move(2, 6, 2, 4);
    gameOverBoard.move(3, 6, 3, 4);
    gameOverBoard.move(3, 0, 3, 2);
    gameOverBoard.move(5, 1, 3, 1);
    gameOverBoard.move(2, 1, 4, 1);
    gameOverBoard.move(0, 3, 2, 3);
    gameOverBoard.move(2, 3, 2, 1);
    gameOverBoard.move(1, 5, 1, 3);
    gameOverBoard.move(1, 1, 3, 1);
    gameOverBoard.move(4, 2, 2, 2);
    gameOverBoard.move(4, 1, 2, 1);
    gameOverBoard.move(3, 4, 1, 4);
    gameOverBoard.move(5, 5, 3, 5);
    gameOverBoard.move(4, 4, 4, 2);
    gameOverBoard.move(2, 1, 2, 3);
    gameOverBoard.move(1, 3, 1, 5);


    assertEquals(true,
            gameOverBoard.isGameOver());
  }


  @Test
  public void testMoveExceptionMoreThan2() {
    try {

      emptyConstructor.move(3, 5, 3, 2);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionDiagonal() {
    try {

      emptyConstructor.move(2, 2, 3, 3);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveToMarble() {
    emptyConstructor.move(3, 5, 3, 3);
    try {

      emptyConstructor.move(3, 3, 1, 3);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveFromNoMarble() {
    emptyConstructor.move(3, 5, 3, 3);
    try {

      emptyConstructor.move(3, 5, 3, 3);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testDiagonalMove() {
    try {

      emptyConstructor.move(2, 2, 3, 3);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveToNothing() {
    try {

      emptyConstructor.move(1, 3, 0, 0);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMoveFromNothing() {
    try {

      emptyConstructor.move(0, 0, 3, 3);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionJumpOverEmpty() {
    emptyConstructor.move(3, 5, 3, 3);
    try {

      emptyConstructor.move(3, 3, 3, 5);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionOneArgument() {
    MarbleSolitaireModel exception = new EuropeanSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionTwoArguments() {
    MarbleSolitaireModel exception = new EuropeanSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionThreeArgumentsInvalidArmThickness() {
    MarbleSolitaireModel exception = new EuropeanSolitaireModelImpl(4, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionThreeArgumentsInvalidPosition() {
    MarbleSolitaireModel exception = new EuropeanSolitaireModelImpl(3, 0, 0);
  }

}
