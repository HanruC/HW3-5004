package chess;

/**
 * This is the class for Pawn which extends AbstractClass.
 */
public class Pawn extends AbstractClass {
  
  /**
   * This is the constructor for pawn.
   * @param row
   * @param col
   * @param color
   */
  public Pawn(int row, int col, Color color) {
    super(row, col, color);
    pawnHelper();
  }
  
  /**
   * This is the canMove method for pawn includes the moving rules.
   * @param row row
   * @param col col
   * @return true or false
   */
  @Override
  public boolean canMove(int row, int col) {
    int rowMoved = Math.abs(this.row - row);
    int colMoved = Math.abs(this.col - col);
  
    switch (color) {
      case WHITE:
        if (this.row == 1) { // white start at row 1.
          return (colMoved == 0 && (rowMoved == 1 || rowMoved == 2));  // one step or two steps.
        } else {
          return (colMoved == 0 && rowMoved == 1 && row > this.row);
        }
      case BLACK:
        if (this.row == 6) {
          return (colMoved == 0 && (rowMoved == 1 || rowMoved == 2));
        } else {
          return (rowMoved == 1 && colMoved == 0 && row > this.row); // white on bottom.
        }
    }
    return false;
  }
  
  /**
   * This is the canKill method for pawn includes killing rules.
   * @param piece target chess
   * @return true or false
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int rowMoved = Math.abs(this.row - piece.getRow());
    int colMoved = Math.abs(this.col - piece.getColumn());
    
    return (rowMoved == 1 && colMoved == 1 && piece.getRow() > this.row
            && this.color != piece.getColor());
  }
}

