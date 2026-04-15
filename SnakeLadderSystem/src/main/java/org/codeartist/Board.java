package org.codeartist;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    int boardSize;
    public Board(int n,int noOfSnake,int noOfLadder){
        boardSize = n*n;
        cells= new Cell[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                cells[i][j]= new Cell(null);
            }
        }
        addSnakeLadder(noOfLadder,noOfSnake);
    }
    public void addSnakeLadder(int noOfLadder,int noOfSnake){
        while(noOfLadder>0){
            int start = ThreadLocalRandom.current().nextInt(0,boardSize);
            int end = ThreadLocalRandom.current().nextInt(0,boardSize);
            if(start>=end)continue;
            Jump jump = new Jump(start,end);
            Cell curCell = getCell(start);
            curCell.setJump(jump);
            noOfLadder--;
            System.out.println("Ladder are placed  at start "+ start+ " with end at "+end);
        }
        while(noOfSnake>0){
            int start = ThreadLocalRandom.current().nextInt(0,boardSize-1);
            int end = ThreadLocalRandom.current().nextInt(0,boardSize-1);
            if(start<=end)continue;
            Jump jump = new Jump(start,end);
            Cell curCell = getCell(start);
            curCell.setJump(jump);
            noOfSnake--;
            System.out.println("Snake are placed  at start "+ start+ " with end at "+end);

        }
    }
    public Cell getCell(int start){
        int row = start/10;
        int col = start%10;
        return cells[row][col];
    }
}
