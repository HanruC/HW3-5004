package chess;

public abstract class AbstractClass implements ChessPiece {
  protected int row;
  protected  int col;
  protected Color color;
  
  public AbstractClass(int row, int col, Color color) {
    this.row = row;
    this.col = col;
    this.color = color;
  }
  
  protected void helper() {
    int lowBoundary = 0;
    int highBoundary = 7;
    if (row < lowBoundary || row > highBoundary || col < lowBoundary || col > highBoundary) {
      throw new IllegalArgumentException("Invalid Position.");
    }
  }
  
  protected void pawnHelper() {
    int whiteBoundary = 0;
    int blackBoundary = 7;
    
    if (color == Color.WHITE) {
      if (row == whiteBoundary) {
        throw new IllegalArgumentException("White pawns in wrong row.");
      }
    }
    else if (color == Color.BLACK) {
      if (row == blackBoundary) {
        throw new IllegalArgumentException("Black pawns in wrong row");
      }
    }
  }
  
  @Override
  public int getRow() {
    return this.row;
  }
  
  @Override
  public int getColumn() {
    return this.col;
  }
  
  @Override
  public Color getColor() {
    return this.color;
  }
  
  @Override
  public abstract boolean canMove(int row, int col);
  
  @Override
  public abstract boolean canKill(ChessPiece piece);
}
