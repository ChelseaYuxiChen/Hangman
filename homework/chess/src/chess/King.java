package chess;

/**
 * Created by Chelsea on 2024-06-10.
 */
public class King extends AbstractChessPiece {

  public King(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    boolean valid = validateMove(row, col);
    if (!valid) {
      return false;
    }
    return Math.abs(this.row - row) <= 1 && Math.abs(this.column - col) <= 1;
  }

}
