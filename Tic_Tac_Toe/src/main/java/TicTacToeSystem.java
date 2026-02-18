import Objects.*;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeSystem {
  private   Deque<Person>people;
  private  PlayingBoard playingBoard ;

    public void initialiseGame(){
        PlayingPieceX playingPieceX = new PlayingPieceX(PieceType.X);
        PlayingPieceY playingPieceY = new PlayingPieceY(PieceType.Y);

        Person personA = new Person("Samyak", playingPieceX);
        Person personB = new Person("Sami" , playingPieceY);

        people = new LinkedList<>();
        people.add(personA);
        people.add(personB);

        playingBoard = new PlayingBoard(3);

    }

    public String startGame(){

        Boolean noWinner = true;
        while(noWinner){
            Person currentPerson  = people.getFirst();
            people.removeFirst();
            playingBoard.showBoard();
            System.out.println("Enter co-ordinate where you what to place ");
            Scanner  sc = new Scanner(System.in);
            String val =   sc.next();

            String[] values = val.split(",");

            int row  =  Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);
            List<Cell> emptySlot = playingBoard.isFree();
            if(emptySlot.isEmpty()){
                noWinner=false;
                continue;
            }

            if(playingBoard.addPiece(row,col,currentPerson.getPieceType())==false){
                System.out.println("This position is already filed, pls provide another place");
                people.addFirst(currentPerson);
                continue;
            }
            if(playingBoard.checkWinner( row, col,currentPerson.getPieceType())){
                playingBoard.showBoard();
                return currentPerson.getName();
            }
            people.addLast(currentPerson);
        }
        return "No winner , game is tied";
    }

}
