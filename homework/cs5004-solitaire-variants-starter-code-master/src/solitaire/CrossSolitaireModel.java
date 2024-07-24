package solitaire;

/**
 * Represents a cross-shaped solitaire game model.
 * The model keeps track of the game state and allows
 * moves to be made on the board.
 */
public class CrossSolitaireModel implements SolitaireModel {
  private static final int BOARD_SIZE = 7;
  private static final int INITIAL_MARBLE_COUNT = 32;

  private Slot[][] board;
  private int marbleCount;
  private int row;
  private int col;

  /**
   * Constructs a new CrossSolitaireModel with the specified starting position.
   *
   * @param startRow the row number of the empty slot (0-indexed)
   * @param startCol the column number of the empty slot (0-indexed)
   * @throws IllegalArgumentException if the starting position is invalid
   */
  public CrossSolitaireModel(int startRow, int startCol) {
    if (startRow < 0 || startCol < 0 || startRow >= BOARD_SIZE || startCol >= BOARD_SIZE) {
      throw new IllegalArgumentException(
          "Invalid start position (" + startRow + ", " + startCol + ")");
    }
    this.row = startRow;
    this.col = startCol;
    reset();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException(
          "Invalid move from (" + fromRow + ", " + fromCol + ") to (" + toRow + ", " + toCol + ")");
    }

    board[fromRow][fromCol] = Slot.EMPTY;
    board[toRow][toCol] = Slot.MARBLE;
    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = Slot.EMPTY;
    marbleCount--;
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
    if (marbleCount == 1) {
      return true;
    }
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (board[i][j] == Slot.MARBLE && canMove(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getMarbleCount() {
    return marbleCount;
  }

  @Override
  public void reset() {
    board = new Slot[BOARD_SIZE][BOARD_SIZE];
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if ((i < 2 || i > 4) && (j < 2 || j > 4)) {
          board[i][j] = Slot.FORBIDDEN;
        } else {
          board[i][j] = Slot.MARBLE;
        }
      }
    }
    board[row][col] = Slot.EMPTY;
    marbleCount = INITIAL_MARBLE_COUNT;
  }

  private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidIndex(fromRow, fromCol) || !isValidIndex(toRow, toCol)) {
      return false;
    }
    if (board[fromRow][fromCol] != Slot.MARBLE || board[toRow][toCol] != Slot.EMPTY) {
      return false;
    }
    if (fromRow == toRow && Math.abs(fromCol - toCol) == 2) {
      return board[fromRow][(fromCol + toCol) / 2] == Slot.MARBLE;
    }
    if (fromCol == toCol && Math.abs(fromRow - toRow) == 2) {
      return board[(fromRow + toRow) / 2][fromCol] == Slot.MARBLE;
    }
    return false;
  }

  private boolean canMove(int row, int col) {
    return isValidMove(row, col, row - 2, col)
        || isValidMove(row, col, row + 2, col)
        || isValidMove(row, col, row, col - 2)
        || isValidMove(row, col, row, col + 2);
  }

  private boolean isValidIndex(int row, int col) {
    return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
  }
}
