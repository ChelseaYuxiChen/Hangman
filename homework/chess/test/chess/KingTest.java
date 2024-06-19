package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Created by Chelsea on 2024-06-11.
 */
public class KingTest {
  Bishop bishop = new Bishop(2, 3, Color.WHITE);
  King king = new King(4, 4, Color.WHITE);

  @Test
  public void getRow() {
    assertEquals(4, king.getRow());
  }

  @Test
  public void getColumn() {
    assertEquals(4, king.getColumn());
  }

  @Test
  public void getColor() {
    assertEquals(Color.WHITE, king.getColor());
  }

  @Test
  public void canKill() {
    assertFalse(king.canKill(bishop));
  }

  @Test
  public void canMove() {
    assertFalse(king.canMove(5, 7));
  }
}