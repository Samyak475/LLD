package org.codeartist.strategy;

import org.codeartist.elevator.ElevatorCar;
import org.codeartist.elevator.ElevatorController;
import org.codeartist.enums.ElevatorState;

import java.util.List;

public class LeastBusyElevatorFirst implements ElevatorSelectonStrategy{
    @Override
    public ElevatorController scheduleElevator(List<ElevatorController> elevatorControllerList, int destination  , ElevatorState elevatorState){
        int leastTrafficElevator = Integer.MAX_VALUE;
        ElevatorController leastBusyController = null;
        for(ElevatorController controller : elevatorControllerList){
            int trafficInElevator = controller.topMinPQ.size()+controller.bottomMaxPQ.size();
            if(trafficInElevator<leastTrafficElevator){
                leastBusyController = controller;
                leastTrafficElevator = trafficInElevator;
            }
        }
        return leastBusyController;
    }
}
