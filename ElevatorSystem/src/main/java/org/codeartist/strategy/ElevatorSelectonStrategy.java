package org.codeartist.strategy;

import org.codeartist.elevator.ElevatorController;
import org.codeartist.enums.ElevatorState;

import java.util.List;

public interface ElevatorSelectonStrategy {
    public ElevatorController scheduleElevator(List<ElevatorController> elevatorControllerList, int destination  , ElevatorState elevatorState);
}
