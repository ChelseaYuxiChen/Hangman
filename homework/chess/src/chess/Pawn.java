package chess;

/**
 * Created by Chelsea on 2024-06-10.
 */
public class Pawn extends AbstractChessPiece {
  /**
   * Constructor of Pawn.
   * @param row the row of Pawn
   * @param column the column of Pawn
   * @param color the color of Pawn
   */
  public Pawn(int row, int column, Color color) {
    super(row, column, color);
    if (row < 1 || row > 6) {
      throw new IllegalArgumentException("Invalid position.");
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    boolean valid = validateMove(row, col);
    if (!valid) {
      return false;
    }
    if (this.color == Color.WHITE) {
      return (this.column == col && row == this.row + 1)
          || (this.row == 1 && this.column == col && row == this.row + 2);
    } else {
      return (this.column == col && row == this.row - 1)
          || (this.row == 6 && this.column == col && row == this.row - 2);
    }
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    }
    int rowDiff = this.color == Color.WHITE ? 1 : -1;
    return (piece.getRow() == this.row + rowDiff)
        && (Math.abs(piece.getColumn() - this.column) == 1);
  }
}
