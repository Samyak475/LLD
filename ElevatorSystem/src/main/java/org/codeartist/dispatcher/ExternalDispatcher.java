package org.codeartist.dispatcher;

import org.codeartist.elevator.ElevatorSchedular;
import org.codeartist.enums.ElevatorState;

public class ExternalDispatcher {
    ElevatorSchedular elevatorSchedular;
    public ExternalDispatcher(ElevatorSchedular elevatorSchedular){
        this.elevatorSchedular =elevatorSchedular;
    }
    public void routeToSchedular(int destination , ElevatorState elevatorState){
        elevatorSchedular.selectAndAssignElevator(destination,elevatorState);
    }
}
