package hangman;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a Controller for the Hangman game. The controller is responsible for handling user
 * moves by executing them using the model and conveying move outcomes to the user.
 */
public class HangmanConsoleController implements HangmanController {

  private final Readable in;
  private final Appendable out;
  private final HangmanView view;

  /**
   * Constructs a new HangmanConsoleController.
   *
   * @param in   the input source
   * @param out  the output source
   * @param view the view for the game
   * @throws IllegalArgumentException if in or out is null
   */
  public HangmanConsoleController(Readable in, Appendable out, HangmanView view)
      throws IllegalArgumentException {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.in = in;
    this.out = out;
    this.view = view;
  }

  @Override
  public void playGame(HangmanModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    Scanner scan = new Scanner(in);
    try {
      out.append(view.getWelcomeMessage());
      // TODO
      // Interact with the model and view to play the game.

      // Control the game flow by repeatedly asking the user for a guess and updating the view.
      while (!model.isGameOver()) {
        out.append(view.getHangman(model.getGuessesRemaining()));
        out.append(view.getCurrentGuessMessage(model.getCurrentState()));
        out.append(view.getGuessesRemainingMessage(model.getGuessesRemaining()));
        out.append(view.getEnterGuessMessage());
        String guess = scan.next();
        if (guess.equals("?")) {
          out.append("Goodbye!");
          return;
        }
        char letter = guess.charAt(0);
        try {
          model.makeGuess(letter);
        } catch (IllegalArgumentException e) {
          out.append(e.getMessage());
          out.append("\n");
        }
      }
      if (model.isGameOver()) {
        if (model.getGuessesRemaining() == 0) {
          out.append(view.getHangman(model.getGuessesRemaining()));
          out.append(view.getLoseMessage(model.getAnswer()));
        } else {
          out.append(view.getWinMessage(model.getAnswer()));
        }
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}