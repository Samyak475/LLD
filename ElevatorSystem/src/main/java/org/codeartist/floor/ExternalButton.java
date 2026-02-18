package org.codeartist.floor;

import org.codeartist.dispatcher.ExternalDispatcher;
import org.codeartist.enums.ElevatorState;

public class ExternalButton {
    ExternalDispatcher externalDispatcher;
    public ExternalButton (ExternalDispatcher externalDispatcher){
        this.externalDispatcher = externalDispatcher;
    }
    public void pressButton(int destination,ElevatorState elevatorState){
        externalDispatcher.routeToSchedular(destination,elevatorState);
    }
}
