package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Created by Chelsea on 2024-06-11.
 */
public class QueenTest {
  Queen queen = new Queen(1, 2, Color.BLACK);
  Pawn pawn = new Pawn(5, 4, Color.WHITE);

  @Test
  public void getRow() {
    assertEquals(1, queen.getRow());
  }

  @Test
  public void getColumn() {
    assertEquals(2, queen.getColumn());
  }

  @Test
  public void getColor() {
    assertEquals(Color.BLACK, queen.getColor());
  }

  @Test
  public void canKill() {
    assertFalse(queen.canKill(pawn));
  }

  @Test
  public void canMove() {
    assertFalse(queen.canMove(6, 5));
  }
}