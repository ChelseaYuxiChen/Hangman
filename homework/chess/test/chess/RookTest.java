package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by Chelsea on 2024-06-11.
 */
public class RookTest {
  Queen queen = new Queen(1, 2, Color.BLACK);
  Rook rook = new Rook(7, 6, Color.WHITE);

  @Test
  public void getRow() {
    assertEquals(7, rook.getRow());
  }

  @Test
  public void getColumn() {
    assertEquals(6, rook.getColumn());
  }

  @Test
  public void getColor() {
    assertEquals(Color.WHITE, rook.getColor());
  }

  @Test
  public void canKill() {
    assertFalse(rook.canKill(queen));
  }

  @Test
  public void canMove() {
    assertTrue(rook.canMove(7, 7));
  }
}