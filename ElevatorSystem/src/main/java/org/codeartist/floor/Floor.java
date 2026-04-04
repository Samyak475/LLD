package org.codeartist.floor;

import org.codeartist.dispatcher.ExternalDispatcher;
import org.codeartist.enums.ElevatorState;

public class Floor {
    ExternalButton up ;
    ExternalButton down;
    int floorId;
    public Floor(int id , ExternalDispatcher externalDispatcher)
    {
        this.floorId = id;
        this.up = new ExternalButton(externalDispatcher);
        this.down = new ExternalButton(externalDispatcher);
    }
    public void pressUp(){
        System.out.println("Up button is pressed at floor :- "+  floorId+" by Thread "+ Thread.currentThread().getName());
        up.pressButton(floorId,ElevatorState.UP);
    }
    public void pressDown(){
        System.out.println("Down button is pressed at floor :- "+  floorId+" by Thread "+ Thread.currentThread().getName());
        down.pressButton(floorId,ElevatorState.DOWN);
    }

}
