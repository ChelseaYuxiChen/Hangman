package hangman;

import java.util.Scanner;

/**
 * The main class for the Hangman game.
 */
public class HangmanMain {
  /**
   * The main method for the Hangman game.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    HangmanModel game = new HangmanModelImpl("res/words.txt");

    Scanner scanner = new Scanner(System.in);

    while (!game.isGameOver()) {
      System.out.println(game.getCurrentState());
      System.out.println("Guesses remaining: " + game.getGuessesRemaining());
      System.out.print("Enter a letter: ");
      String input = scanner.nextLine();
      if (input.length() != 1) {
        System.out.println("Please enter a single letter.");
        continue;
      }
      char letter = input.charAt(0);
      try {
        game.makeGuess(letter);
      } catch (IllegalArgumentException e) {
        System.out.println("You already guessed that letter.");
      } catch (IllegalStateException e) {
        System.out.println("The game is over.");
        break;
      }
    }
    if (game.getGuessesRemaining() == 0) {
      System.out.println("You lose!");
    } else {
      System.out.println("You win!");
    }




  }
}
