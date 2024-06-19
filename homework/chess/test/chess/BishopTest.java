package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Chelsea on 2024-06-11.
 */
public class BishopTest {
  Bishop bishop = new Bishop(2, 3, Color.WHITE);
  King king = new King(4, 4, Color.WHITE);

  @org.junit.Test
  public void getRow() {
    assertEquals(2, bishop.getRow());
  }

  @org.junit.Test
  public void getColumn() {
    assertEquals(3, bishop.getColumn());
  }

  @org.junit.Test
  public void getColor() {
    assertEquals(Color.WHITE, bishop.getColor());
  }

  @org.junit.Test
  public void canKill() {
    assertFalse(bishop.canKill(king));
  }


  @org.junit.Test
  public void canMove() {
    assertFalse(bishop.canMove(5, 7));
  }
}