package org.codeartist.elevator;

import org.codeartist.enums.ElevatorState;

public class ElevatorCar {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNextStoppage() {
        return nextStoppage;
    }

    public void setNextStoppage(int nextStoppage) {
        this.nextStoppage = nextStoppage;
    }

    int id;
    ElevatorState elevatorState;
    int floor;
    int nextStoppage;

    public ElevatorCar(int id ){
        elevatorState = ElevatorState.IDLE;
        floor =0;
        this.id = id;
        nextStoppage =0;
    }
    public void showDisplay(){
        System.out.println("Elevator with id :- "+id +" is currently at  "+floor+" is moving to Desination floor "+ nextStoppage);
    }

    public void MoveElevator(int destinationFloor){
        this.nextStoppage = destinationFloor;
        if(nextStoppage == floor){
            System.out.println("Elevator already on destination floor");
        }
        if(nextStoppage>=floor){
            System.out.println("Elevator is moving in Upwards direction");
            elevatorState = ElevatorState.UP;
            for(int i=floor+1 ;i<=nextStoppage;i++){
                try{

                    Thread.sleep(5000);
                }catch (Exception e){

                }
                setFloor(i);
                showDisplay();
            }
        }else{
            System.out.println("Elevator is moving in Downward direction");
            elevatorState = ElevatorState.DOWN;
            for(int i=floor-1 ;i>=nextStoppage;i--){
                try{

                    Thread.sleep(5000);
                }catch (Exception e){

                }
                setFloor(i);
                showDisplay();
            }
        }

    }
}
