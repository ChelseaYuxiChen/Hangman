package chess;

/**
 * Created by Chelsea on 2024-06-10.
 */
public class Rook extends AbstractChessPiece {
  public Rook(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    boolean valid = validateMove(row, col);
    if (!valid) {
      return false;
    }
    return this.row == row || this.column == col;
  }
}
