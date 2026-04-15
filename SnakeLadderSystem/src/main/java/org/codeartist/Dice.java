package org.codeartist;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int minRange=1;
    int maxRange=6;
    int diceCnt;
    public Dice(int diceCnt){
        this.diceCnt=  diceCnt;
    }

    public int rollDice(){
       int curDiceCnt=0;
       int totSum =0;
        System.out.println("Come here to rollDice ");
       while(curDiceCnt<diceCnt){
           totSum+= ThreadLocalRandom.current().nextInt(minRange,maxRange+1);
           curDiceCnt++;
       }
        System.out.println("Dice move came as "+ totSum);
       return totSum;
    }
}
