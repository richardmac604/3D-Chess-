

public class Rook extends Piece {
    
    PieceType Type = PieceType.ROOK;
    String blackRook = "\u265C";
    String whiteRook = "\u2656";
    PieceColor color;

    
    public Rook(PieceColor theColor) {
        super();
        this.color = theColor;
      
    }
    
    public void setColor(PieceColor color) {
        this.color = color;
    }
    
    public PieceColor getColor() {
        return color;
    }
    

    public PieceType getPieceType() {
        return Type;
    }
    
    
    public String toString() {
        // TODO Auto-generated method stub
        return Type + "";
    }
    


    @Override
    public boolean isValidMove(gameboard b,int x, int y, int firstX, int firstY) {
         
            if(firstX == x ||firstY == y) {
                return true;
            }else {
                return false;
            }
              
        }

        
    


    @Override
    public String showPiece() {
        if (this.color == PieceColor.WHITE) {
            return whiteRook;
        }else {
            return blackRook;  
        }
        
            


        
    }

    @Override
    public boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY) {
        // TODO Auto-generated method stub
        return false;
    }
    

    

}
