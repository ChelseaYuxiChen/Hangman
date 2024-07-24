package connect;

/**
 * Created by Chelsea on 2024-06-24.
 */
public class ConnectFourModelImpl implements ConnectFourModel {
  private int rows;
  private int cols;
  private Player currentPlayer;
  private Player winner;
  private Player[][] board;
  private boolean gameOver;


  /**
   * Constructs a new ConnectFourModelImpl with the specified number of rows and columns.
   *
   * @param rows the number of rows in the game board
   * @param cols the number of columns in the game board
   * @throws IllegalArgumentException if the number of rows or columns is less than 4
   */
  public ConnectFourModelImpl(int rows, int cols) {
    if (rows < 4 || cols < 4) {
      throw new IllegalArgumentException("Rows and columns must be at least 4");
    }
    this.cols = cols;
    this.rows = rows;
    initializeBoard();
  }


  @Override
  public void initializeBoard() {
    board = new Player[this.rows][this.cols];
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        board[i][j] = null;
      }
    }
    currentPlayer = Player.RED;
    winner = null;
    gameOver = false;
  }

  @Override
  public void makeMove(int column) throws IllegalArgumentException {
    if (column >= this.cols || column < 0) {
      throw new IllegalArgumentException("Invalid columns");
    }
    if (gameOver) {
      throw new IllegalArgumentException("Game is over");
    }
    for (int i = this.rows - 1; i >= 0; i--) {
      if (board[i][column] == null) {
        board[i][column] = currentPlayer;
        if (checkWin()) {
          winner = currentPlayer;
          gameOver = true;
        } else if (isFull()) {
          gameOver = true;
        } else {
          switchPlayer();
        }
        return;
      }
    }
  }

  @Override
  public Player getTurn() {
    return currentPlayer;
  }

  @Override
  public boolean isGameOver() {
    return gameOver;
  }

  @Override
  public Player getWinner() {
    return winner;
  }

  @Override
  public void resetBoard() {
    initializeBoard();
  }

  @Override
  public Player[][] getBoardState() {
    Player[][] boardCopy = new Player[rows][cols];
    for (int i = 0; i < rows; i++) {
      System.arraycopy(board[i], 0, boardCopy[i], 0, cols);
    }
    return boardCopy;
  }

  /**
   * Checks if the current player has won the game.
   *
   * @return true if the current player has won, false otherwise
   */
  public boolean checkWin() {
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        if (board[i][j] != null) {
          if (checkDirection(i, j, 1, 0) || checkDirection(i, j, 0, 1)
              || checkDirection(i, j, 1, 1) || checkDirection(i, j, 1, -1)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Checks if there are four discs of the same player in a row in a given direction.
   *
   * @param row    the row of the cell to check
   * @param col    the column of the cell to check
   * @param rowDir the row direction to check
   * @param colDir the column direction to check
   * @return true if there are four discs of the same player in a row in the given direction
   */
  public boolean checkDirection(int row, int col, int rowDir, int colDir) {
    int count = 1;
    Player player = board[row][col];
    int newRow = row + rowDir;
    int newCol = col + colDir;
    while (newRow >= 0 && newRow < this.rows && newCol >= 0 && newCol < this.cols
        && board[newRow][newCol] == player) {
      count++;
      newRow += rowDir;
      newCol += colDir;
    }
    newRow = row - rowDir;
    newCol = col - colDir;
    while (newRow >= 0 && newRow < this.rows && newCol >= 0 && newCol < this.cols
        && board[newRow][newCol] == player) {
      count++;
      newRow -= rowDir;
      newCol -= colDir;
    }
    return count >= 4;
  }

  /**
   * Checks if the board is full.
   *
   * @return true if the board is full, false otherwise
   */
  public boolean isFull() {
    for (int i = 0; i < cols; i++) {
      if (board[0][i] == null) {
        return false;
      }
    }
    return true;
  }

  /**
   * Switches the current player.
   */
  public void switchPlayer() {
    currentPlayer = currentPlayer == Player.RED ? Player.YELLOW : Player.RED;
  }

  /**
   * transform the bord into String.
   *
   * @return the String of the bord
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == null) {
          sb.append(". ");
        } else {
          sb.append(board[i][j] == Player.RED ? "R " : "Y ");
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
