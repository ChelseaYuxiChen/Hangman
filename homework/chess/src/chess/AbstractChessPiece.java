package chess;

/**
 * Created by Chelsea on 2024-06-10.
 */
abstract class AbstractChessPiece implements ChessPiece {
  protected int row;
  protected int column;
  protected Color color;

  public AbstractChessPiece(int row, int column, Color color) {
    if (row < 0 || row > 7 || column < 0 || column > 7) {
      throw new IllegalArgumentException("Invalid position.");
    }

    this.row = row;
    this.column = column;
    this.color = color;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.column;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return canMove(piece.getRow(), piece.getColumn());
  }

  /**
   * Determine if the destination is valid.
   *
   * @param row    the row where the piece might be moved to.
   * @param col the column where the piece might be moved to.
   */
  protected boolean validateMove(int row, int col) {

    if (row < 0 || row > 7 || col < 0 || col > 7
        || (this.row == row && this.column == col)) {
      return false;
    }
    return true;
  }
}
