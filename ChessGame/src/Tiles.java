import javax.swing.JButton;


public class Tiles{
    
    private int posX;
    private int posY;
    Piece piece;
    Boolean isOccupied = false;
    JButton button; 
    
    public Tiles(int x, int y) {
        this.button = new JButton();
        this.posX = x;
        this.posY = y;    
        
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    
    public Piece getPiece() {
        return piece;
    }

    
    public void setPiece(Piece piece) {
        isOccupied = true;
        this.piece = piece;
       
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.piece + "";
    }
    
    
    
    

}
