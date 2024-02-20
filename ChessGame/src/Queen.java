
public class Queen extends Piece{
    
    PieceType Type = PieceType.QUEEN;
    String blackQueen = "\u265B";
    String whiteQueen = "\u2655";
    PieceColor color;

    public Queen(PieceColor theColor) {
        super();
        this.color = theColor;
   
    }
    public void setColor(PieceColor color) {
        this.color = color;
        
    }
    
    public PieceColor getColor() {
        return this.color;
    }
    
    
    public String toString() {
        // TODO Auto-generated method stub
        return Type + "";
    }


    @Override
    public boolean isValidMove(gameboard b, int x, int y, int firstX, int firstY) {
        
            if(x - firstX == y - firstY || x == firstX|| y == firstY) {
                return true;
            }else {
                return false;
                
            }
           

        }



        
    

    @Override
    public String showPiece() {
        if (this.color == PieceColor.WHITE) {
            return whiteQueen;
        }else {
            return blackQueen;  
        }
    }
    @Override
    public boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY) {
        if(Math.abs(y - firstY) == 9
                || Math.abs(y - firstY) == 7
                || Math.abs(y - firstY) == 7 && Math.abs(x - firstX) == 1 
                || Math.abs(y - firstY) == 8 && Math.abs(x - firstX) == 1 
                || Math.abs(y - firstY) == 9 && Math.abs(x - firstX) == 1 
                || Math.abs(y - firstY) == 14 
                || Math.abs(y - firstY) == 18
                || Math.abs(y - firstY) == 16 && Math.abs(x - firstX) == 2
                || Math.abs(y - firstY) == 14 && Math.abs(x - firstX) == 2
                || Math.abs(y - firstY) == 18 && Math.abs(x - firstX) == 2)  {
            return true;
        }else {
            return false;
            
        }
    }
    

}
