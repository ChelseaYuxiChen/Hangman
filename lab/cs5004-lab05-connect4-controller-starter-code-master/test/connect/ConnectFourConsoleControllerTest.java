package connect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.io.StringWriter;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chelsea on 2024-07-17.
 * test of the controller using existing model.
 */
public class ConnectFourConsoleControllerTest {
  private ConnectFourModel model;
  private ConnectFourView view;
  private StringWriter viewOutput;

  /**
   * Sets up the game.
   */
  @Before
  public void setUp() {
    model = new ConnectFourModelImpl(6, 7);
    viewOutput = new StringWriter();
    view = new ConnectFourConsoleView(viewOutput);
    // why not controller?
  }

  /**
   * test for valid move.
   */
  @Test
  public void testValidMove() {
    StringReader input = new StringReader("1\n0\n");
    ConnectFourConsoleController controller = new ConnectFourConsoleController(input, view);
    controller.playGame(model);
    assertEquals(Player.YELLOW, model.getTurn());
    assertFalse(model.isGameOver());
  }

  /**
   * test for winning move.
   */
  @Test
  public void testWinningMove() {
    StringReader input = new StringReader("1\n1\n2\n2\n3\n3\n4\n0\n");
    ConnectFourConsoleController controller = new ConnectFourConsoleController(input, view);
    controller.playGame(model);
    assertEquals(Player.RED, model.getTurn());
    assertTrue(model.isGameOver());
    assertTrue(viewOutput.toString().contains("Game over! RED is the winner!"));
  }

  /**
   * test for tie game.
   */
  @Test
  public void testQuitGame() {
    StringReader input = new StringReader("q\n");
    ConnectFourConsoleController controller = new ConnectFourConsoleController(input, view);
    controller.playGame(model);
    assertTrue(viewOutput.toString().contains("Game quit! Ending game state:"));
  }

  /**
   * test for tie game.
   */
  @Test
  public void testInvalidMove() {
    StringReader input = new StringReader("8\n0\n");
    ConnectFourConsoleController controller = new ConnectFourConsoleController(input, view);
    controller.playGame(model);
    assertTrue(viewOutput.toString().contains("Not a valid number: 8"));
  }

  /**
   * test for invalid input.
   */
  @Test
  public void testInvalidInput() {
    StringReader input = new StringReader("a\n0\n");
    ConnectFourConsoleController controller = new ConnectFourConsoleController(input, view);
    controller.playGame(model);
    assertTrue(viewOutput.toString().contains("Invalid input"));
  }
}