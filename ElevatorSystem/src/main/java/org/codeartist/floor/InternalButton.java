package org.codeartist.floor;

import org.codeartist.elevator.ElevatorController;

public class InternalButton {
    ElevatorController elevatorController;

    public InternalButton (ElevatorController elevatorController){
        this.elevatorController =elevatorController;
    }
    public void pressButton(int destination){
        elevatorController.addToElevator(destination);
    }
}
