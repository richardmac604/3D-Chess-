
public abstract class Piece {
    
    PieceType pieceType;
    PieceColor color;
    

    public Piece() {
      
      
    }
    
    
    public abstract boolean isValidMove(gameboard b, int x, int y, int newX, int newY);
    
    public abstract String showPiece();

    public abstract boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY);

    protected abstract PieceColor getColor();



   
        
    
    

}
