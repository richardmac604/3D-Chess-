
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BoardListener implements ActionListener{
    gameboard chessboard;
    Boolean tracker = true;;
    int firstPosX;
    int firstPosY;
    Piece pieceOne;
    Piece pieceTwo;
    Boolean player = true;
    

    
    BoardListener(gameboard b){
        this.chessboard = b;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 24;j++){
                if(e.getSource() == chessboard.tile[i][j].button) {
                   //player 1
                   if (chessboard.turn) {
                       if(tracker){
                           // checks if first click has a piece
                           if (chessboard.tile[i][j].getPiece() != null && chessboard.tile[i][j].piece.getColor() == PieceColor.WHITE) {
                               firstPosX = i;
                               firstPosY = j;
                               tracker = false;
                               pieceOne = chessboard.tile[i][j].getPiece();
                               pieceTwo = chessboard.tile[firstPosX][firstPosY].getPiece();
                           }else {
                               tracker = true;
                               System.out.println("this tile has no piece");
                           }
                       //click 2
                       }else if (!tracker) {
                           chessboard.Move(i,j,firstPosX,firstPosY);
                           chessboard.updateBoardStatus();
                           tracker = true; 
                           player = false;
                       }
                   //player 2    
                   }else if (!chessboard.turn){
                       //click 1
                       if(tracker){
                           // checks if first click has a piece
                           if (chessboard.tile[i][j].getPiece() != null && chessboard.tile[i][j].piece.getColor() == PieceColor.BLACK) {
                               firstPosX = i;
                               firstPosY = j;
                               tracker = false;
                               pieceOne = chessboard.tile[i][j].getPiece();
                               pieceTwo = chessboard.tile[firstPosX][firstPosY].getPiece();
                
                           }else {
                               tracker = true;
                               System.out.println("this tile has no piece");
                           }
                       //click 2
                       }else if (!tracker) {
                           chessboard.Move(i,j,firstPosX,firstPosY);
                           chessboard.updateBoardStatus();
                           tracker = true; 
                       }
                       
                   }

                }
                
                }
            }
            
        
    }

}
