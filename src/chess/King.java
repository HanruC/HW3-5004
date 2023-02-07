package chess;

public class King extends AbstractClass {
  public King(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.col) {
      return false;
    } else {
      return Math.abs(this.row - row) <= 1 && Math.abs(this.col - col) <= 1;
    } // Only one move in any direction.
  }
  
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow = piece.getRow();
    int pieceCol = piece.getColumn();
    
    return canMove(pieceRow, pieceCol);
    //same checking process in canMove.
  }
}
