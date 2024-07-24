package connect;

// TODO
// Create a controller for Connect Four that allows a user to play the game.
// The controller should use the model to execute the game and the view to convey
// the game state to the user.

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Represents a Controller for Connect Four: handle user moves by executing them
 * using the model; convey move outcomes to the user in some form.
 */
public class ConnectFourConsoleController implements ConnectFourController {
  private final Readable in;
  private final ConnectFourView view;

  public ConnectFourConsoleController(Readable in, ConnectFourView view) {
    this.in = in;
    this.view = view;
  }

  @Override
  public void playGame(ConnectFourModel m) throws IllegalArgumentException {
    Scanner scanner = new Scanner(this.in);
    boolean playing = true;

    while (playing) {
      try {
        view.displayGameState(m.toString());
        view.displayPlayerTurn(m.getTurn().toString());

        if (scanner.hasNextInt()) {
          int column = scanner.nextInt() - 1;
          try {
            m.makeMove(column);
          } catch (IllegalArgumentException e) {
            view.displayInvalidNumber(String.valueOf(column + 1));
          }
        } else {
          String input = scanner.next();
          if ("q".equals(input)) {
            view.displayGameQuit(m.toString());
            playing = false;
            break;
          } else {
            view.displayErrorMessage("Invalid input");
          }
        }

        if (m.isGameOver()) {
          view.displayGameState(m.toString());
          view.displayGameOver(m.getWinner() == null ? "Tie" : m.getWinner().toString());
          view.askPlayAgain();

          if (scanner.hasNext()) {
            String playAgain = scanner.next();
            if ("yes".equalsIgnoreCase(playAgain)) {
              m.resetBoard();
            } else {
              return;
            }
          }
        }
      } catch (IOException e) {
        throw new IllegalStateException("Error communicating with the view", e);
      } catch (NoSuchElementException e) {
        // Stop the game if there is no more input
        playing = false;
      }
    }
  }
}