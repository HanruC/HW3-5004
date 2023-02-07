package chess;

public interface ChessPiece {
  int getRow();
  int getColumn();
  Color getColor();
  boolean canKill(ChessPiece piece);
  boolean canMove(int row, int col);
  
  
}
