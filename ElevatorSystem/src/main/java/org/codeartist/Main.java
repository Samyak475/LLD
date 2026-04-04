package org.codeartist;

import org.codeartist.dispatcher.ExternalDispatcher;
import org.codeartist.elevator.ElevatorCar;
import org.codeartist.elevator.ElevatorController;
import org.codeartist.elevator.ElevatorSchedular;
import org.codeartist.floor.InternalButton;
import org.codeartist.strategy.ElevatorSelectonStrategy;
import org.codeartist.strategy.NearestElevatorFirst;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            ElevatorController elevatorController1 = new ElevatorController(new ElevatorCar(1));
            ElevatorController elevatorController2 = new ElevatorController(new ElevatorCar(2));
            ElevatorController elevatorController3 = new ElevatorController(new ElevatorCar(3));
            List<ElevatorController> elevatorControllerList = Arrays.asList(elevatorController1, elevatorController2, elevatorController3);
            ElevatorSelectonStrategy elevatorSelectonStrategy = new NearestElevatorFirst();
            ElevatorSchedular elevatorSchedular = new ElevatorSchedular(elevatorControllerList, elevatorSelectonStrategy);

            ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorSchedular);
            Building building = new Building(10, externalDispatcher);
            InternalButton internalButton1 = new InternalButton(elevatorController1);
            InternalButton internalButton2 = new InternalButton(elevatorController2);
            InternalButton internalButton3 = new InternalButton(elevatorController3);

            new Thread(elevatorController1,"controller-1").start();
            new Thread(elevatorController2,"controller-2").start();
            new Thread(elevatorController3,"controller-3").start();
// Lets submit the requests
            /*
                1. External Call : Floor 3 UP
                2. External Call : Floor 5 DOWN
                3. Internal Call : Elevator 1 (press 4)
                4. Internal Call : Elevator 1 (press 5)
                5. External Call : Floor 1 DOWN
                6. External Call : Floor 2 UP
             */
            building.getFloor(3).pressUp();
            Thread.sleep(5);



            building.getFloor(5).pressDown();
            Thread.sleep(5);

            internalButton1.pressButton(4);
            Thread.sleep(5);
            internalButton1.pressButton(5);
            Thread.sleep(5);
            building.getFloor(1).pressDown();
            Thread.sleep(5);
            building.getFloor(2).pressUp();
            Thread.sleep(5);
            internalButton1.pressButton(2);
            Thread.sleep(500000);

        }catch(Exception  e){
            e.printStackTrace();
        }
    }
}