package chess;


public class Pawn extends AbstractClass {
  private PawnMove step;
  
  public Pawn(int row, int col, Color color) {
    super(row, col, color);
    pawnHelper();
    if (this.color == Color.WHITE) {
      if (step == PawnMove.FIRST_MOVE) {
        this.row = 1;
      }
    } else if (this.color == Color.BLACK) {
      if (step == PawnMove.FIRST_MOVE) {
        this.row = 6;
      }
    }
    step = PawnMove.FIRST_MOVE;
  }
  
  private void helperStep() {
    if (step == PawnMove.FIRST_MOVE) {
    
    }
  }
  
  @Override
  public boolean canMove(int row, int col) {
    int rowMoved = Math.abs(this.row - row);
    int colMoved = Math.abs(this.col - col);
    
    switch (step) {
      case FIRST_MOVE:
        if (this.color == Color.WHITE) {
          if (row == this.row && col == this.col) {
            return false;
          }
          if (colMoved == 0 && (rowMoved == 1 || rowMoved == 2)) { // one step or two steps.
            step = PawnMove.AFTER_FIRST_MOVE;
            return true;
          }
        }
        else if (this.color == Color.BLACK) {
          if (row == this.row && col == this.col) {
            return false;
          }
          if (colMoved == 0 && (rowMoved == 1 || rowMoved == 2)) { // one step or two steps.
            step = PawnMove.AFTER_FIRST_MOVE;
            return true;
          }
        }
        break;
      case AFTER_FIRST_MOVE:
        if (this.color == Color.WHITE) {
          if (row == this.row && col == this.col) {
            return false;
          }
          if (rowMoved == 1 && colMoved == 0 && row > this.row) { // white on bottom.
            return true;
          }
        }
        else if (this.color == Color.BLACK) {
          if (row == this.row && col == this.col) {
            return false;
          }
          if (rowMoved == 1 && colMoved == 0 && row < this.row) { //black on top.
            return true;
          }
        }
        break;
    }
    return false;
  }
  
  @Override
  public boolean canKill(ChessPiece piece) {
    int rowMoved = Math.abs(this.row - piece.getRow());
    int colMoved = Math.abs(this.col - piece.getColumn());
    
    return (rowMoved == 1 && colMoved == 1 && this.color != piece.getColor());
  }
}

