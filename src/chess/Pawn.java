package chess;


public class Pawn extends AbstractClass {
  
  public Pawn(int row, int col, Color color) {
    super(row, col, color);
    pawnHelper();
  }
  
  
  @Override
  public boolean canMove(int row, int col) {
    int rowMoved = Math.abs(this.row - row);
    int colMoved = Math.abs(this.col - col);
  
    switch (color) {
      case WHITE:
        if (row == this.row && col == this.col) {
          return false;
        }
        if (this.row == 1) { // white start at row 1.
          return (colMoved == 0 && (rowMoved == 1 || rowMoved == 2));  // one step or two steps.
        } else {
          return (colMoved == 0 && rowMoved == 1 && row > this.row);
        }
      case BLACK:
        if (row == this.row && col == this.col) {
          return false;
        }
        if (this.row == 6) {
          return (colMoved == 0 && (rowMoved == 1 || rowMoved == 2));
        } else {
          return (rowMoved == 1 && colMoved == 0 && row > this.row); // white on bottom.
        }
    }
    return false;
  }
  
  
  @Override
  public boolean canKill(ChessPiece piece) {
    int rowMoved = Math.abs(this.row - piece.getRow());
    int colMoved = Math.abs(this.col - piece.getColumn());
    
    return (rowMoved == 1 && colMoved == 1 && piece.getRow() > this.row
            && this.color != piece.getColor());
  }
}

