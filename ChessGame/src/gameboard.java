import javax.swing.*;
import java.awt.*;


public class gameboard{
    
    Tiles tile[][]= new Tiles[8][24];
    BoardListener cl = new BoardListener(this);
    JPanel Panel = new JPanel();
    JFrame frame = new JFrame();
    Piece rook;
    Piece pawn; 
    Piece Queen;
    Piece King;
    Piece Knight;
    Piece Bishop;
    Piece piece;
    boolean turn = true;
    static int count = 0;

 
    public gameboard() {
        Panel.setLayout(new GridLayout(8,24));

        //layout buttons and listeners
        for(int i=0; i <tile.length; i++) {
            for(int j = 0; j < tile[i].length;j++) {
                
                this.tile[i][j] = new Tiles(i,j);

                
                if ((j % 2 ==1 && i % 2 == 1) || ( j % 2 == 0 && i % 2 ==0)){
                  
                    tile[i][j].button.setBackground(Color.WHITE);

                    
                }else {
                    
                    tile[i][j].button.setBackground(Color.BLACK);

                }
                tile[i][j].button.setFont(new Font("Default", Font.BOLD, 42));
                tile[i][j].button.addActionListener(cl);
                tile[i][j].button.setPreferredSize(new Dimension(100, 100));
                Panel.add(tile[i][j].button);

            }
            
            
        }

       setupChessBoard();
       updateBoardStatus();
     
       frame.add(Panel, BorderLayout.CENTER);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(2000,2000);
       frame.setTitle("CHESS GAME");
       frame.pack();
       frame.setVisible(true);
                
        
    }
    
    public void Display() {
        for(int i=0; i <tile.length; i++) {
            for(int j = 0; j < tile.length;j++) {
                System.out.print(tile[i][j] + " ");
                
                }
            System.out.println("");
            
            }
            
                
    }
    
 
    public boolean checkCollision(int firstY, int firstX, int y, int x) {
        
        if (firstY == y && firstX > x) {
            for (int i = firstX - 1; i > x; i--) {
                if (tile[i][firstY].getPiece() != null) {
                    return false;
                }
            }
        } else if (firstY < y && firstX == x) {
            for (int i = firstY + 1; i < y; i++) {
                if (tile[firstX][i].getPiece() != null) {
                    return false;
                }
            }
        } else if (firstY == y && firstX < x) { 
            for (int i = firstX + 1; i < x; i++) {
                if (tile[i][firstY].getPiece() != null) {
                    return false;
                }
            }
        } else if (firstY > y && firstX == x) { 
            for (int i = firstY - 1; i > y; i--) {
                if (tile[firstX][i].getPiece()!= null) {
                    return false;
                }
            }
        } else if (Math.abs(firstX - x) == Math.abs(firstY - y)) {
            if (firstY < y && firstX > x) { 
                System.out.println("First condition");
                for (int i = y - firstY; i > 0; i--) {
                    System.out.println(tile[firstY + i][firstX - i].getPiece());
                    if (tile[firstX - i][firstY + i].getPiece() != null) {
                        return false;
                    }
                }
            }else if(firstY < y && firstX < x){
                System.out.println("second condition");
                for (int i = y - firstY; i > 0; i--) {
                    if (tile[firstX + i][firstY + i].getPiece() != null) {
                        
                        return false;
                    }
                }
                
            }else if(firstY > y && firstX < x){
                System.out.println("Third condition");
                for (int i = firstY - y; i > 0; i--) {
                    if (tile[firstX + i][firstY - i].getPiece() != null) {
                        return false;
                    }
                }
            
            
            }else if(firstY > y && firstX > x){
                System.out.println("Fourth condition");
                for (int i = firstY - y; i > 0; i--) {
                    if (tile[firstX - i][firstY - i].getPiece() != null) {
                        return false;
                    }
                }
            
            }
        }
           


        return true;
    }
    

    
    public void Move(int x, int y, int firstX, int firstY) {

    
        piece = tile[firstX][firstY].getPiece();

        if(piece.isValidMove(this,x,y,firstX,firstY) && checkCollision(firstY, firstX, y, x)
                || piece.ThreeDimensionMovement(x,y,firstX,firstY)){
            System.out.println("valid move");
            if(x == firstX && y == firstY) {
                System.out.println("cannot move to same spot");

            }else {
                tile[x][y].setPiece(tile[firstX][firstY].getPiece());
                tile[firstX][firstY].setPiece(null); 
                count++;
                
                if(count%2 == 1) {
                    turn = false;
                }else {
                    turn = true;
                }

                

            }
        }else {
            System.out.println("not valid move");

        }
          
        
        
   
    }
    
    
    public void setupChessBoard( ) {
        tile[0][0].setPiece(new Rook(PieceColor.WHITE));
        tile[0][1].setPiece(new Knight(PieceColor.WHITE));
        tile[0][2].setPiece(new Bishop(PieceColor.WHITE));
        tile[0][3].setPiece(new Queen(PieceColor.WHITE));
        tile[0][4].setPiece(new King(PieceColor.WHITE));
        tile[0][5].setPiece(new Bishop(PieceColor.WHITE));
        tile[0][6].setPiece(new Knight(PieceColor.WHITE));
        tile[0][7].setPiece(new Rook(PieceColor.WHITE)); 
        tile[1][0].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][1].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][2].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][3].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][4].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][5].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][6].setPiece(new Pawn(PieceColor.WHITE));
        tile[1][7].setPiece(new Pawn(PieceColor.WHITE)); 
        
        tile[7][0].setPiece(new Rook(PieceColor.BLACK));
        tile[7][1].setPiece(new Knight(PieceColor.BLACK));
        tile[7][2].setPiece(new Bishop(PieceColor.BLACK));
        tile[7][3].setPiece(new Queen(PieceColor.BLACK));
        tile[7][4].setPiece(new King(PieceColor.BLACK));
        tile[7][5].setPiece(new Bishop(PieceColor.BLACK));
        tile[7][6].setPiece(new Knight(PieceColor.BLACK));
        tile[7][7].setPiece(new Rook(PieceColor.BLACK)); 
        tile[6][0].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][1].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][2].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][3].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][4].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][5].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][6].setPiece(new Pawn(PieceColor.BLACK));
        tile[6][7].setPiece(new Pawn(PieceColor.BLACK)); 
       
      
    }
    
    public void updateBoardStatus() {
       String unicode;
       Piece piece;
      
      for(int i = 0; i <tile.length; i++) {
          for(int j = 0; j < tile[i].length;j++) {
              if (tile[i][j].getPiece() != null) {
                  piece = tile[i][j].getPiece();
                  unicode = piece.showPiece();
                  tile[i][j].button.setText(unicode);
              }else {
                  tile[i][j].button.setText(" ");
                  
              }
              
              }
          }
      
               
            }
            
        
        
    }
    


