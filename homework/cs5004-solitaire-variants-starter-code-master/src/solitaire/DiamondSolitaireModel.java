package solitaire;

/**
 * Represents a cross-shaped solitaire game model.
 * The model keeps track of the game state and allows
 * moves to be made on the board.
 */
public class DiamondSolitaireModel implements SolitaireModel {
  private static final int BOARD_SIZE = 9;
  private Slot[][] board;

  public DiamondSolitaireModel() {
    reset();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid move");
    }

    // Make the move
    board[fromRow][fromCol] = Slot.EMPTY;
    board[toRow][toCol] = Slot.MARBLE;
    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Slot.EMPTY;
  }

  @Override
  public Slot[][] getBoardState() {
    Slot[][] copy = new Slot[BOARD_SIZE][BOARD_SIZE];
    for (int i = 0; i < BOARD_SIZE; i++) {
      System.arraycopy(board[i], 0, copy[i], 0, BOARD_SIZE);
    }
    return copy;
  }

  @Override
  public boolean isGameOver() {
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[row][col] == Slot.MARBLE) {
          if (canMove(row, col)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public int getMarbleCount() {
    int count = 0;
    for (Slot[] row : board) {
      for (Slot slot : row) {
        if (slot == Slot.MARBLE) {
          count++;
        }
      }
    }
    return count;
  }

  @Override
  public void reset() {
    board = new Slot[BOARD_SIZE][BOARD_SIZE];
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (isValidSlot(row, col)) {
          board[row][col] = Slot.MARBLE;
        } else {
          board[row][col] = Slot.FORBIDDEN;
        }
      }
    }
    // Set the center position as empty
    board[BOARD_SIZE / 2][BOARD_SIZE / 2] = Slot.EMPTY;
  }

  private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    // Check if from and to positions are valid
    if (!isValidSlot(fromRow, fromCol) || !isValidSlot(toRow, toCol)) {
      return false;
    }
    // Check if move is exactly two slots away in a straight line
    if (Math.abs(fromRow - toRow) == 2 && fromCol == toCol) {
      return board[fromRow][fromCol] == Slot.MARBLE
          && board[toRow][toCol] == Slot.EMPTY
          && board[(fromRow + toRow) / 2][fromCol] == Slot.MARBLE;
    }
    if (Math.abs(fromCol - toCol) == 2 && fromRow == toRow) {
      return board[fromRow][fromCol] == Slot.MARBLE
          && board[toRow][toCol] == Slot.EMPTY
          && board[fromRow][(fromCol + toCol) / 2] == Slot.MARBLE;
    }
    return false;
  }

  private boolean canMove(int row, int col) {
    return isValidMove(row, col, row - 2, col)
        || isValidMove(row, col, row + 2, col)
        || isValidMove(row, col, row, col - 2)
        || isValidMove(row, col, row, col + 2);
  }

  private boolean isValidSlot(int row, int col) {
    int center = BOARD_SIZE / 2;
    int dist = Math.abs(row - center) + Math.abs(col - center);
    return dist <= center;
  }
}
