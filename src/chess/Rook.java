package chess;

public class Rook extends AbstractClass {
  public Rook(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.col) {
      return false;
    } else return (row == this.row || col == this.col);
  }
  
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow = piece.getRow();
    int pieceCol = piece.getColumn();
    
    return canMove(pieceRow, pieceCol);
  }
}
