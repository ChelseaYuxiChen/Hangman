package connect;

import java.io.IOException;

/**
 * View component in the MVC architecture of a Connect Four game. This interface defines the core
 * functionalities required to display the game state and messages to the user.
 */
public interface ConnectFourView {

  /**
   * Displays the current state of the game board.
   *
   * @param gameState the current state of the game board
   * @throws IOException if an I/O error occurs
   */
  void displayGameState(String gameState) throws IOException;

  /**
   * Displays the player whose turn it is to make a move.
   *
   * @param player the player whose turn it is
   * @throws IOException if an I/O error occurs
   */
  void displayPlayerTurn(String player) throws IOException;

  /**
   * Displays an error message for an invalid move.
   *
   * @param invalidInput the invalid input that caused the error
   * @throws IOException if an I/O error occurs
   */
  void displayInvalidNumber(String invalidInput) throws IOException;

  /**
   * Displays an error message when there is an illegal argument.
   *
   * @param message the error message
   * @throws IOException if an I/O error occurs
   */
  void displayErrorMessage(String message) throws IOException;

  /**
   * Displays the game state when the player quits.
   *
   * @param gameState the game state when the player quits
   * @throws IOException if an I/O error occurs
   */
  void displayGameQuit(String gameState) throws IOException;

  /**
   * Displays the game over message, including the winner (if there is one).
   *
   * @param winner the winner of the game, or {@code null} if there is no winner
   * @throws IOException if an I/O error occurs
   */
  void displayGameOver(String winner) throws IOException;

  /**
   * Asks the player if they want to play again.
   *
   * @throws IOException if an I/O error occurs
   */
  void askPlayAgain() throws IOException;
}