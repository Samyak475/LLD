package org.codeartist.elevator;

import org.codeartist.enums.ElevatorState;
import org.codeartist.strategy.ElevatorSelectonStrategy;

import java.util.List;

public class ElevatorSchedular {
    List<ElevatorController> elevatorControllerList;
    ElevatorSelectonStrategy elevatorSelectonStrategy;
    public ElevatorSchedular(List<ElevatorController>elevatorControllerList,ElevatorSelectonStrategy elevatorSelectonStrategy){
        this.elevatorControllerList =elevatorControllerList;
        this.elevatorSelectonStrategy = elevatorSelectonStrategy;
    }
    public void selectAndAssignElevator(int destination , ElevatorState elevatorState){
        ElevatorController selectedElevator = elevatorSelectonStrategy.scheduleElevator(elevatorControllerList,destination,elevatorState);
        selectedElevator.addToElevator(destination);
    }
}
