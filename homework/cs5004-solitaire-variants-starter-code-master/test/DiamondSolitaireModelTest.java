import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import solitaire.DiamondSolitaireModel;
import solitaire.Slot;

/**
 * Created by Chelsea on 2024-07-09.
 */
public class DiamondSolitaireModelTest {

  private DiamondSolitaireModel game;

  @Before
  public void setUp() {
    game = new DiamondSolitaireModel();
  }

  @Test
  public void testInitialBoardState() {
    Slot[][] board = game.getBoardState();
    int center = board.length / 2;
    assertEquals(Slot.EMPTY, board[center][center]);
    assertEquals(40, game.getMarbleCount());

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (Math.abs(i - center) + Math.abs(j - center) <= center) {
          if (i != center || j != center) {
            assertEquals(Slot.MARBLE, board[i][j]);
          }
        } else {
          assertEquals(Slot.FORBIDDEN, board[i][j]);
        }
      }
    }
  }

  @Test
  public void testValidMove() {
    // Initial valid move
    game.move(2, 4, 4, 4);
    Slot[][] board = game.getBoardState();
    assertEquals(Slot.EMPTY, board[2][4]);
    assertEquals(Slot.MARBLE, board[3][3]);
    assertEquals(39, game.getMarbleCount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    // Invalid move - move to a non-adjacent position
    game.move(3, 1, 3, 4);
  }

  @Test
  public void testGameOver() {
    // Simulate a game over state by making some moves
    game.move(2, 4, 4, 4);
    game.move(5, 4, 3, 4);
    game.move(4, 6, 4, 4);
    assertFalse(game.isGameOver());
  }

  @Test
  public void testMarbleCount() {
    // Initial marble count
    assertEquals(40, game.getMarbleCount());

    // Make a move and check marble count
    game.move(2, 4, 4, 4);
    assertEquals(39, game.getMarbleCount());
  }

  @Test
  public void testReset() {
    game.move(2, 4, 4, 4);
    game.reset();
    Slot[][] board = game.getBoardState();
    int center = board.length / 2;
    assertEquals(Slot.EMPTY, board[center][center]);
    assertEquals(40, game.getMarbleCount());

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (Math.abs(i - center) + Math.abs(j - center) <= center) {
          if (i != center || j != center) {
            assertEquals(Slot.MARBLE, board[i][j]);
          }
        } else {
          assertEquals(Slot.FORBIDDEN, board[i][j]);
        }
      }
    }
  }
}
