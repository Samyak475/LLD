package org.codeartist;

import java.sql.SQLOutput;
import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player>players;

    public Game(){
        initialiseGame();
    }
    public void initialiseGame(){
        board = new Board(10,4,3);
        dice = new Dice(1);
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
    }

    public void  startGame(){
        Boolean noWinner = true;
        while(noWinner){
            Player curPlayer = players.getFirst();
            players.removeFirst();
            players.addLast(curPlayer);
            int move = dice.rollDice();
            int nextPos = curPlayer.curPos+move;
            System.out.println("Player with id "+ curPlayer.playerId+" has moved to "+nextPos);
            nextPos = nextPostion(nextPos);
            curPlayer.curPos = nextPos;
            System.out.println("Player with id "+ curPlayer.playerId+" has moved to "+nextPos+" after getting Jump");
            if(nextPos >= board.boardSize){
                noWinner=false;
                System.out.println("We have got a winner. Player with id "+curPlayer.playerId+" has completed the game ");
            }
        }
    }
    public int nextPostion(int nextPos){
        if(nextPos>= board.boardSize) return board.boardSize;
        Cell nextCell = board.getCell(nextPos);
        if(nextCell.jump !=  null){
            if(nextPos == nextCell.jump.start){
                nextPos = nextCell.jump.end;

                return nextPos;
            }
        }
        return nextPos;
    }
}
