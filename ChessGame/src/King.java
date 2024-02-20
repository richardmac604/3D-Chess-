
public class King extends Piece{
    
    PieceType Type = PieceType.KING;
    String blackKing  = "\u265A";
    String whiteKing  = "\u2654";
    PieceColor color;
 

    
    public King(PieceColor theColor) {
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
    public boolean isValidMove(gameboard b,int x, int y, int firstX, int firstY) {
        if(Math.sqrt(Math.pow(Math.abs((x - firstX)),2)) + Math.pow(Math.abs((y - firstY)), 2) != Math.sqrt(2)){
            return true;
        }else {
            return false;
        }

        
    }


    @Override
    public String showPiece() {
        if (this.color == PieceColor.WHITE) {
            return whiteKing;
        }else {
            return blackKing;  
        }
    }

    @Override
    public boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY) {
        // TODO Auto-generated method stub
        return false;
    }
    

}