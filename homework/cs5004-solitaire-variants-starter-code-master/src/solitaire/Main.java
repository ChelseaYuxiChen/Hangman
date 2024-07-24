package solitaire;

/**
 * Main class to demonstrate the solitaire games.
 */
public class Main {
  /**
   * Main method to demonstrate the solitaire games.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Diamond Solitaire Game:");
    DiamondSolitaireModel diamondGame = new DiamondSolitaireModel();
    playGameDiamond(diamondGame);

    System.out.println("\nCross Solitaire Game:");
    CrossSolitaireModel crossGame = new CrossSolitaireModel(3, 3);
    playGameCross(crossGame);
  }

  private static void playGameCross(SolitaireModel game) {
    printBoard(game.getBoardState());

    // Example moves for demonstration
    try {
      System.out.println("Making moves...");
      // Diamond Solitaire moves
      game.move(5, 3, 3, 3);
      printBoard(game.getBoardState());

      game.move(2, 3, 4, 3);
      printBoard(game.getBoardState());

      game.move(4, 5, 4, 3);
      printBoard(game.getBoardState());
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }

    System.out.println("Game over: " + game.isGameOver());
    System.out.println("Marbles remaining: " + game.getMarbleCount());
  }

  private static void playGameDiamond(SolitaireModel game) {
    printBoard(game.getBoardState());

    // Example moves for demonstration
    try {
      System.out.println("Making moves...");
      // Diamond Solitaire moves
      game.move(2, 4, 4, 4);
      printBoard(game.getBoardState());

      game.move(5, 4, 3, 4);
      printBoard(game.getBoardState());

      game.move(4, 6, 4, 4);
      printBoard(game.getBoardState());
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }

    System.out.println("Game over: " + game.isGameOver());
    System.out.println("Marbles remaining: " + game.getMarbleCount());
  }

  private static void printBoard(Slot[][] board) {
    for (Slot[] row : board) {
      for (Slot slot : row) {
        System.out.print(slot + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
