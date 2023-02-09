import chess.AbstractClass;
import chess.ChessPiece;
import chess.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class testAbstract {
  @Test
  public void AbstractTest() {
    AbstractClass abstractClass = new AbstractClass(2, 2, Color.WHITE) {
      @Override
      public boolean canMove(int row, int col) {
        return false;
      }
      
      @Override
      public boolean canKill(ChessPiece piece) {
        return false;
      }
    };
    assertEquals(2, abstractClass.getRow());
    assertEquals(2, abstractClass.getColumn());
    assertEquals(Color.WHITE, abstractClass.getColor());
  }
}
