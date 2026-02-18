package org.codeartist.strategy;

import org.codeartist.elevator.ElevatorController;
import org.codeartist.enums.ElevatorState;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class NearestElevatorFirst implements ElevatorSelectonStrategy{
    public ElevatorController scheduleElevator(List<ElevatorController> elevatorControllerList, int destination , ElevatorState elevatorState){
        ElevatorController minEffortElevator = null;
        int minEffort =Integer.MAX_VALUE;
        for(ElevatorController controller : elevatorControllerList){
            int nextStoppage = controller.elevatorCar.getNextStoppage();
            if(controller.elevatorCar.getElevatorState().equals(elevatorState)){
                if((elevatorState == ElevatorState.UP && nextStoppage>=destination )||(elevatorState == ElevatorState.DOWN&& nextStoppage<=destination)){
                    int dist =Integer.min(abs(destination-nextStoppage),minEffort);
                    if(minEffort>dist) {
                        minEffortElevator = controller;
                        minEffort =dist;
                    }
                }
            }
        }
        if(minEffortElevator !=null){
            return minEffortElevator;
        }
        if(minEffortElevator == null){
            for(ElevatorController controller: elevatorControllerList){
                if(controller.elevatorCar.getElevatorState() == ElevatorState.IDLE){
                    return controller;
                }
            }
        }
        return elevatorControllerList.getFirst();
    }
}
