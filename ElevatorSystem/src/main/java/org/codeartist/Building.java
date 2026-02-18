package org.codeartist;

import org.codeartist.dispatcher.ExternalDispatcher;
import org.codeartist.floor.ExternalButton;
import org.codeartist.floor.Floor;

import java.util.List;

public class Building {
    List<Floor>floors;
    public Building(int floorsN , ExternalDispatcher externalDispatcher){
        for(int i=1;i<=floorsN;i++){
            Floor floor = new Floor(i,externalDispatcher);
            floors.add(floor);
        }
    }
    public Floor getFloor(int id){
        return floors.get(id-1);
    }
}
