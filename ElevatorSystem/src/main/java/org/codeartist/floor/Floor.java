package org.codeartist.floor;

import org.codeartist.dispatcher.ExternalDispatcher;
import org.codeartist.enums.ElevatorState;

public class Floor {
    ExternalButton up ;
    ExternalButton down;
    int floorId;
    public Floor(int id , ExternalDispatcher externalDispatcher)
    {
        floorId = id;
        up = new ExternalButton(externalDispatcher);
        down = new ExternalButton(externalDispatcher);
    }
    public void pressUp(){
        up.pressButton(floorId,ElevatorState.UP);
    }
    public void pressDown(){
        down.pressButton(floorId,ElevatorState.DOWN);
    }

}
