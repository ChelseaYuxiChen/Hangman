package connect;

import java.io.IOException;
import java.util.Objects;

/**
 * View component in the MVC architecture of a Connect Four game. This class defines the core
 * functionalities required to display the game state and messages to the user.
 */
public class ConnectFourConsoleView implements ConnectFourView {

  private final Appendable out;

  /**
   * Constructor for the ConnectFourConsoleView class.
   *
   * @param out the output destination for game state and messages
   */
  public ConnectFourConsoleView(Appendable out) {
    this.out = Objects.requireNonNull(out, "Appendable can't be null");
  }

  @Override
  public void displayGameState(String gameState) throws IOException {
    out.append(gameState).append("\n");
  }

  @Override
  public void displayPlayerTurn(String player) throws IOException {
    out.append("Player ").append(player).append(", make your move: ").append("\n");
  }

  @Override
  public void displayInvalidNumber(String invalidInput) throws IOException {
    out.append("Not a valid number: ").append(invalidInput).append("\n");
  }

  @Override
  public void displayErrorMessage(String message) throws IOException {
    out.append(message).append("\n");
  }

  @Override
  public void displayGameQuit(String gameState) throws IOException {
    out.append("Game quit! Ending game state:\n").append(gameState).append("\n");
  }

  @Override
  public void displayGameOver(String winner) throws IOException {
    if (winner == null) {
      out.append("Game over! It's a tie!\n");
    } else {
      out.append("Game over! ").append(winner).append(" is the winner!\n");
    }
  }

  @Override
  public void askPlayAgain() throws IOException {
    out.append("Do you want to play again? (yes/no)\n");
  }
}