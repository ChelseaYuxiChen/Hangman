package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Created by Chelsea on 2024-06-11.
 */
public class KnightTest {
  Knight knight = new Knight(2, 3, Color.BLACK);
  King king = new King(6, 6, Color.WHITE);

  @Test
  public void getRow() {
    assertEquals(2, knight.getRow());
  }

  @Test
  public void getColumn() {
    assertEquals(3, knight.getColumn());
  }

  @Test
  public void getColor() {
    assertEquals(Color.BLACK, knight.getColor());
  }

  @Test
  public void canKill() {
    assertFalse(knight.canKill(king));
  }

  @Test
  public void canMove() {
    assertFalse(knight.canMove(1, 7));
  }
}