
public class Bishop extends Piece{
    
    PieceType Type = PieceType.BISHOP;
    String blackBishop = "\u265D";
    String whiteBishop = "\u2657";
    PieceColor color;

    
    public Bishop(PieceColor theColor) {
        super();
        this.color = theColor;

    }
    
    public void setColor(PieceColor color) {
        this.color = color;
        
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    
    public String toString() {
        // TODO Auto-generated method stub
        return Type + "";
    }

    @Override
    public boolean isValidMove(gameboard b, int x, int y, int firstX, int firstY) {
    
            if (Math.abs(x - firstX ) == Math.abs(y - firstY)) {
                return true;
                
            }else {
                return false;
                
            }
                
        
        
        
    }

    @Override
    public String showPiece() {
        if (this.color == PieceColor.WHITE) {
            return whiteBishop;
        }else {
            return blackBishop;  
        }
    }

    @Override
    public boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY) {
        // TODO Auto-generated method stub
        return false;
    }
    

}
