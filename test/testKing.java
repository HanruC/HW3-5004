import chess.ChessPiece;
import chess.Color;
import chess.King;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class testKing {
  
  @Test
  public void getterTest() {
    King king = new King(3,3,Color.WHITE);
    assertEquals(3, king.getRow());
    assertEquals(3, king.getColumn());
    assertEquals(Color.WHITE, king.getColor());
  }
  
  @Test
  public void canMoveTest() {
    King king  = new King(2, 3, Color.BLACK);
    assertTrue(king.canMove(3,4));
    assertFalse(king.canMove(4,5));
  }

  @Test
  public void canKillTest() {
    King king = new King(2,2,Color.BLACK);
    ChessPiece piece = new King(3,3, Color.WHITE);
    assertTrue(king.canKill(piece));
    ChessPiece piece2 = new King(4,4, Color.WHITE);
    assertFalse(king.canKill(piece2));
    ChessPiece piece3 = new King(3,3, Color.BLACK);
    assertFalse(king.canKill(piece3));
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidPos() {
    King king = new King(1, 10, Color.WHITE);
  }
}
