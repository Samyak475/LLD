package entities;

import enums.SeatStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Shows {

    private final  Movie movie;
    private final  LocalDate startDate;
    private final  LocalTime  startTime;
    private final  ConcurrentHashMap<Integer, SeatStatus> currentSeatStatus = new ConcurrentHashMap<>();
    private final  ConcurrentHashMap<Integer, ReentrantLock> seatLockList = new ConcurrentHashMap<>();

    public Shows(Movie movie, Screen screen, LocalDate startDate, LocalTime startTime
                 ) {
        this.movie = movie;
        this.startDate = startDate;
        this.startTime = startTime;
        for( Seat seat : screen.getSeatInScreen()){
            seatLockList.put(seat.getSeatId(),new ReentrantLock());
            currentSeatStatus.put(seat.getSeatId(),SeatStatus.AVAILABLE);
        }
    }

    public Boolean lockSeat(List<Integer>seatToBeBooked){
        ArrayList<Integer>sortedSeat =new ArrayList<>(seatToBeBooked)  ;
        Collections.sort(sortedSeat);
       List<ReentrantLock>acquiredLock = new ArrayList<>();
       try{
           for(Integer seatId : sortedSeat){
               ReentrantLock  lock = seatLockList.get(seatId);
               lock.lock();
               acquiredLock.add(lock);
           }
           for (Integer seatId : sortedSeat){
               if(currentSeatStatus.get(seatId) == SeatStatus.BOOKED) return false;
           }
           for(Integer seatID: sortedSeat){
               currentSeatStatus.put(seatID,SeatStatus.IN_BOOKING);
           }
           return true;
       }finally {
           for(ReentrantLock lock : acquiredLock){
               lock.unlock();
           }
       }
    }
    public Boolean bookSeat(List<Integer>seatToBeBooked){

        for(Integer seatToBe: seatToBeBooked){
            currentSeatStatus.put(seatToBe,SeatStatus.BOOKED);
        }
        return true;
    }
    public void releaseSeat(List<Integer>seatToBeReleased){
        for (Integer seatToBe: seatToBeReleased){
            currentSeatStatus.put(seatToBe, SeatStatus.AVAILABLE);
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public ConcurrentHashMap<Integer, SeatStatus> getCurrentSeatStatus() {
        return currentSeatStatus;
    }
}
