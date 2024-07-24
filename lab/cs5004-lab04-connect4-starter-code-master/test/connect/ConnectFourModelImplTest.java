package connect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Created by Chelsea on 2024-06-26.
 */
public class ConnectFourModelImplTest {
  private ConnectFourModelImpl test;

  /**
   * Sets up the game.
   */
  @org.junit.Before
  public void setUp() {
    test = new ConnectFourModelImpl(6, 7);
  }

  /**
   * test for constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    test = new ConnectFourModelImpl(3, 3);
  }

  /**
   * test for initializeBoard method.
   */
  @org.junit.Test
  public void initializeBoard() {
    test.initializeBoard();
    Player[][] board = test.getBoardState();
    for (int i = 0; i < test.getBoardState().length; i++) {
      for (int j = 0; j < test.getBoardState()[0].length; j++) {
        assertEquals(null, board[i][j]);
      }
    }
    assertEquals(Player.RED, test.getTurn());
    assertEquals(null, test.getWinner());
    assertEquals(false, test.isGameOver());
    assertEquals(false, test.isFull());
  }

  /**
   * test for makeMove method.
   */
  @org.junit.Test
  public void makeMove() {
    test.initializeBoard();
    test.makeMove(0);
    assertEquals(Player.RED, test.getBoardState()[5][0]);
    assertEquals(Player.YELLOW, test.getTurn());
    test.makeMove(0);
    assertEquals(Player.YELLOW, test.getBoardState()[4][0]);
    assertEquals(Player.RED, test.getTurn());
    test.makeMove(0);
    assertEquals(Player.RED, test.getBoardState()[3][0]);
    assertEquals(Player.YELLOW, test.getTurn());
    test.makeMove(0);
    assertEquals(Player.YELLOW, test.getBoardState()[2][0]);
    assertEquals(Player.RED, test.getTurn());
    test.makeMove(0);
    assertEquals(Player.RED, test.getBoardState()[1][0]);
    assertEquals(Player.YELLOW, test.getTurn());
    test.makeMove(0);
    assertEquals(Player.YELLOW, test.getBoardState()[0][0]);
    assertEquals(Player.RED, test.getTurn());
  }

  /**
   * test for makeMove method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void makeMoveInvalidColumn() {
    test.initializeBoard();
    test.makeMove(9);
  }

  /**
   * test for makeMove method.
   */
  @org.junit.Test
  public void isGameOver() {
    test.initializeBoard();
    assertEquals(false, test.isGameOver());
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    assertEquals(true, test.isGameOver());
  }

  /**
   * test for makeMove method.
   */
  @org.junit.Test
  public void getWinner() {
    test.initializeBoard();
    assertEquals(null, test.getWinner());
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    assertEquals(Player.RED, test.getWinner());
  }

  /**
   * test for makeMove method.
   */
  @org.junit.Test
  public void resetBoard() {
    test.initializeBoard();
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.makeMove(1);
    test.makeMove(0);
    test.resetBoard();
    Player[][] board = test.getBoardState();
    for (int i = 0; i < test.getBoardState().length; i++) {
      for (int j = 0; j < test.getBoardState()[0].length; j++) {
        assertEquals(null, board[i][j]);
      }
    }
    assertEquals(Player.RED, test.getTurn());
    assertEquals(null, test.getWinner());
    assertEquals(false, test.isGameOver());
    assertEquals(false, test.isFull());
  }

  /**
   * test for makeMove method.
   */
  @org.junit.Test
  public void getBoardState() {
    test.initializeBoard();
    Player[][] board = test.getBoardState();
    for (int i = 0; i < test.getBoardState().length; i++) {
      for (int j = 0; j < test.getBoardState()[0].length; j++) {
        assertEquals(null, board[i][j]);
      }
    }
  }
}