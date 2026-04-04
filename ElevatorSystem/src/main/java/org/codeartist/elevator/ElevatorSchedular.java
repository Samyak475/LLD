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
        System.out.println("Going for Strategy selection ");
        ElevatorController selectedElevator = elevatorSelectonStrategy.scheduleElevator(elevatorControllerList,destination,elevatorState);
        System.out.println("As per strategy request will be fulfilled by Elevator :- "+selectedElevator.elevatorCar.getId());
        selectedElevator.addToElevator(destination);
    }
}
