package org.codeartist.elevator;

import org.codeartist.enums.ElevatorState;

import java.util.PriorityQueue;

public class ElevatorController  implements Runnable{
    public ElevatorCar elevatorCar;
    public PriorityQueue<Integer> topMinPQ;
    public PriorityQueue<Integer> bottomMaxPQ;
    private  final   Object monitor = new Object();
    public ElevatorController(ElevatorCar  elevatorCar ){
        this.elevatorCar = elevatorCar;
        topMinPQ = new PriorityQueue<>();
        bottomMaxPQ = new PriorityQueue<>();
    }
    public void addToElevator(int destination){
        int nextStoppage = elevatorCar.nextStoppage;
        System.out.println("here to add Destination :- "+destination +" in elevator "+elevatorCar.getId()+ " By thread "+Thread.currentThread().getName());
        if(destination==nextStoppage)return;
        if(destination>nextStoppage){
            if(!topMinPQ.contains(destination)){
                topMinPQ.offer(destination);

            }
        }
        else
        {
            if(!bottomMaxPQ.contains(destination)){
                bottomMaxPQ.offer(destination);
            }
        }
        synchronized (monitor){
            monitor.notify();
        }
        System.out.println("Floor "+ destination+ "  added to elevator ");
    }
    @Override
    public void run(){
        runElevator();
    }
    public void runElevator(){
        while(true){
            synchronized (monitor){
                while(topMinPQ.isEmpty()&& bottomMaxPQ.isEmpty()){
                    try {
                        System.out.println("Elevator with id :- "+elevatorCar.getId()+" is in IDLE state");
                        elevatorCar.elevatorState = ElevatorState.IDLE;
                        monitor.wait();
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while(!topMinPQ.isEmpty()){

                int destination = topMinPQ.poll();
                System.out.println("Elevator with id :- "+elevatorCar.getId()+" is moving UP to destination "+ destination);
                elevatorCar.MoveElevator(destination);
            }
            while(!bottomMaxPQ.isEmpty()){
                int destination = bottomMaxPQ.poll();
                System.out.println("Elevator with id :- "+elevatorCar.getId()+" is moving DOWN to destination "+ destination);
                elevatorCar.MoveElevator(destination);
            }
        }

    }

}
