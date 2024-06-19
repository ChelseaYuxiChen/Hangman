package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Created by Chelsea on 2024-06-11.
 */
public class PawnTest {
  Knight knight = new Knight(1, 2, Color.BLACK);
  Pawn pawn = new Pawn(3, 4, Color.WHITE);

  @Test
  public void getRow() {
    assertEquals(3, pawn.getRow());
  }

  @Test
  public void getColumn() {
    assertEquals(4, pawn.getColumn());
  }

  @Test
  public void getColor() {
    assertEquals(Color.WHITE, pawn.getColor());
  }

  @Test
  public void canKill() {
    assertFalse(pawn.canKill(knight));
  }

  @Test
  public void canMove() {
    assertFalse(pawn.canMove(1, 7));
  }
}