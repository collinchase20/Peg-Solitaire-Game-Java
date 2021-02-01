
import org.junit.Test;

import model.SimpleModel.MarbleSolitaireModel;
import model.SimpleModel.MarbleSolitaireModelImpl;
import model.AbstractModel.AbstractSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class SolitaireTest {
  AbstractSolitaireModelImpl emptyConstructor = new MarbleSolitaireModelImpl();
  AbstractSolitaireModelImpl rowColConstructor = new MarbleSolitaireModelImpl(4, 4);
  AbstractSolitaireModelImpl armThickConstructor = new MarbleSolitaireModelImpl(5);
  AbstractSolitaireModelImpl rowColandThickConstructor = new MarbleSolitaireModelImpl(7, 7, 8);

  @Test
  public void testGetScoreEmptyConstructor() {

    assertEquals(32,
            emptyConstructor.getScore());
  }

  @Test
  public void testGetScoreRowColConstructor() {

    assertEquals(32,
            rowColConstructor.getScore());
  }

  @Test
  public void testGetScoreArmThickConstructor() {

    assertEquals(104,
            armThickConstructor.getScore());
  }

  @Test
  public void testGetScoreRowColAndThickConstructor() {

    assertEquals(216,
            rowColandThickConstructor.getScore());
  }

  @Test
  public void testGetGameStateEmptyConstructor() {

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            emptyConstructor.getGameState());
  }

  @Test
  public void testGetGameStateRowColConstructor() {

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ O O\n" +
                    "    O O O\n" +
                    "    O O O",
            rowColConstructor.getGameState());
  }


  @Test
  public void testGetGameStateArmThickConstructor() {

    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            armThickConstructor.getGameState());
  }

  @Test
  public void testGetGameStateRowColAndThickConstructor() {

    assertEquals("            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O _ O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O",
            rowColandThickConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyFromPositionUpdatesTop() {
    emptyConstructor.move(1, 3, 3, 3);

    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyFromPositionUpdatesBottom() {
    emptyConstructor.move(5, 3, 3, 3);

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdatesRight() {
    emptyConstructor.move(5, 3, 3, 3);

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdatesLeft() {
    emptyConstructor.move(3, 1, 3, 3);

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testMoveSuccessfullyToPositionUpdates() {
    emptyConstructor.move(1, 3, 3, 3);

    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", emptyConstructor.getGameState());
  }

  @Test
  public void testIsGameOverFalse() {

    assertEquals(false,
            emptyConstructor.isGameOver());
  }

  @Test
  public void testIsGameOverTrue() {
    emptyConstructor.move(3, 5, 3, 3);
    emptyConstructor.move(3, 2, 3, 4);
    emptyConstructor.move(3, 0, 3, 2);
    emptyConstructor.move(5, 3, 3, 3);
    emptyConstructor.move(2, 3, 4, 3);
    emptyConstructor.move(0, 3, 2, 3);

    assertEquals(true,
            emptyConstructor.isGameOver());
  }


  @Test
  public void testMoveExceptionMoreThan2() {
    try {

      emptyConstructor.move(5, 3, 0, 2);

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
  public void testMoveExceptionMovetoMarble() {
    emptyConstructor.move(3, 5, 3, 3);
    try {

      emptyConstructor.move(3, 3, 1, 3);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMovefromEmpty() {
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
  public void testMoveExceptionMovetoNothing() {
    try {

      emptyConstructor.move(2, 5, 0, 5);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test
  public void testMoveExceptionMovefromNothing() {
    try {

      emptyConstructor.move(0, 5, 2, 5);

      fail("Exception was not thrown!");

    } catch (IllegalArgumentException e) {

      assertEquals(e.getMessage(), "That is an invalid move!");

    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBoardThicknessException() {
    MarbleSolitaireModel exception = new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test2ArgumentsException() {
    MarbleSolitaireModel exception = new MarbleSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testrowColAndThickConstructorException() {
    MarbleSolitaireModel exception = new MarbleSolitaireModelImpl(4, 7, 8);
  }

}

