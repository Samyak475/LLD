package Objects;



import java.util.ArrayList;
import java.util.List;

public class PlayingBoard {
   private int size;
   private PlayingPiece[][] board;

    public  PlayingBoard(int size){
        this.size= size;
        this.board= new PlayingPiece[size][size];
    }
    public boolean addPiece(int row , int col , PlayingPiece pieceType){
        if(row<0||row>=size||col<0||col>=size) return false;
        if(board[row][col]!=null){
            return false;
        }
        board[row][col] = pieceType;
        return true;
    }

    public void showBoard()
    {
        for(int r =0;r < size ; r ++){
            for(int c = 0 ; c<size ; c++){
                if(board[r][c]!=null){
                    System.out.print( board[r][c].pieceType +"  |  ");
                }
                else{
                    System.out.print("  |  ");
                }
            }
            System.out.println();
            System.out.println("-------------");

        }
    }

    public List<Cell> isFree(){
        List<Cell>emptyPlaces = new ArrayList<>();
        for(int r =0;r < size ; r ++) {
            for (int c = 0; c < size; c++) {
               if(board[r][c]==null){

                   emptyPlaces.add(new Cell(r,c));
               }
            }
        }
        return emptyPlaces;
    }
    public boolean checkWinner(int row,int col,PlayingPiece playingPiece){
        boolean rowMatch = true, colMatch = true, diagMatch = true , antiDiagMatch = true;
        for(int r = 0; r<size ; r++){
            if(board[r][col]!=playingPiece ){
                rowMatch=false;
                break;
            }
        }
        for(int c = 0; c<size ; c++){
            if(board[row][c]!=playingPiece ){
                colMatch=false;
                break;
            }
        }
        for(int r=0,c = 0; c<size ; r++,c++){
            if(board[r][c]!=playingPiece ){
                diagMatch=false;
                break;
            }
        }

        for(int r=0,c = size-1; r<size ; r++,c--){
            if(board[r][c]!=playingPiece ){
                antiDiagMatch=false;
                break;
            }
        }
        return rowMatch||colMatch||diagMatch||antiDiagMatch;
    }
}
