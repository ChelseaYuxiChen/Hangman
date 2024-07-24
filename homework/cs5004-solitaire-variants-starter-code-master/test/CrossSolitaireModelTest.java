import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import solitaire.CrossSolitaireModel;
import solitaire.Slot;

/**
 * Created by Chelsea on 2024-07-09.
 */
public class CrossSolitaireModelTest {

  private CrossSolitaireModel game;

  @Before
  public void setUp() {
    // Initialize the game with a valid start position
    game = new CrossSolitaireModel(3, 3);
  }

  @Test
  public void testValidMove() {
    // Make a valid move and check board state
    game.move(3, 1, 3, 3);
    assertEquals(Slot.EMPTY, game.getBoardState()[3][1]);
    assertEquals(Slot.MARBLE, game.getBoardState()[3][3]);
    assertEquals(Slot.EMPTY, game.getBoardState()[3][2]);
    assertEquals(31, game.getMarbleCount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    // Attempt an invalid move and verify exception
    game.move(0, 0, 0, 2);
  }

  @Test
  public void testIsGameOver() {
    assertFalse(game.isGameOver());

    // Perform moves to reach game over state
    game.move(5, 3, 3, 3);
    game.move(2, 3, 4, 3);
    game.move(3, 1, 3, 3);

    assertFalse(game.isGameOver());
  }

  @Test
  public void testReset() {
    game.move(3, 1, 3, 3);
    game.reset();
    assertEquals(Slot.EMPTY, game.getBoardState()[3][3]);
    assertEquals(Slot.MARBLE, game.getBoardState()[3][2]);
    assertEquals(32, game.getMarbleCount());
  }

  @Test
  public void testGetBoardState() {
    Slot[][] initialBoard = game.getBoardState();
    assertNotNull(initialBoard);
    assertEquals(7, initialBoard.length);
    assertEquals(7, initialBoard[0].length);
  }

  @Test
  public void testGetMarbleCount() {
    assertEquals(32, game.getMarbleCount());
    game.move(3, 1, 3, 3);
    assertEquals(31, game.getMarbleCount());
  }
}
