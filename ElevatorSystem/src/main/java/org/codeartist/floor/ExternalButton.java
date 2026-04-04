package org.codeartist.floor;

import org.codeartist.dispatcher.ExternalDispatcher;
import org.codeartist.enums.ElevatorState;

public class ExternalButton {
    ExternalDispatcher externalDispatcher;
    public ExternalButton (ExternalDispatcher externalDispatcher){
        this.externalDispatcher = externalDispatcher;
    }
    public void pressButton(int destination,ElevatorState elevatorState){
        System.out.println("Dispatcher routing request with destination :- "+destination+" in direction "+elevatorState);
        externalDispatcher.routeToSchedular(destination,elevatorState);
    }
}
