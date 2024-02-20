
public class Pawn extends Piece{
    
    PieceType Type = PieceType.PAWN;
    String blackPawn = "\u265F";
    String whitePawn = "\u2659";
    PieceColor color;

    
    public Pawn(PieceColor theColor) {
        super();
        this.color = theColor;
        
    }
    
    public PieceType getType() {
        return Type;
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Type + "";
    }


    @Override
    public boolean isValidMove(gameboard b,int x, int y, int firstX, int firstY)  {
        
        if(firstX == 1 || firstX==6) {
            return(y == firstY && Math.abs(x - firstX) <= 2);
        }else {
            return(y == firstY && Math.abs(x - firstX) <= 1 || Math.abs(y - firstY) == 8 && Math.abs(x - firstX) <= 1);
        }



    }

    @Override
    public String showPiece() {
        if (this.color == PieceColor.WHITE) {
            return whitePawn;
        }else {
            return blackPawn;  
        }
    }

    @Override
    public boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY) {
        if(firstX == 1 || firstX==6) {
            return(Math.abs(y - firstY) == 8 && Math.abs(x - firstX) <= 1 
                   || Math.abs(y - firstY) == 16 && Math.abs(x - firstX) <= 2);
        }else {
            return(Math.abs(y - firstY) == 8 && Math.abs(x - firstX) <= 1);
        }

    }
    

}
