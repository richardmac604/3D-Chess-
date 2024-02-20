
public class Knight extends Piece{
    
    PieceType Type = PieceType.KNIGHT;
    String blackKnight = "\u265E";
    String whiteKnight = "\u2658";
    PieceColor color;

    
    public Knight(PieceColor theColor) {
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
       
        if(x != firstX - 1 && x != firstX + 1 && x  != firstX + 2 && x != firstX - 2) {
            return false;
        }
         
        if(y != firstY - 2 && y != firstY + 2 && y != firstY - 1 && y != firstY + 1) {
            return false;
        }
          

        return true;
    }

    @Override
    public String showPiece() {
        if (this.color == PieceColor.WHITE) {
            return whiteKnight;
        }else {
            return blackKnight;  
        }
    }

    @Override
    public boolean ThreeDimensionMovement(int x, int y, int firstX, int firstY) {
        // TODO Auto-generated method stub
        return false;
    }
    

}
