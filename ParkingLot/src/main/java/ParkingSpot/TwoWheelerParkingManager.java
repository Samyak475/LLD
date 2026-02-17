package ParkingSpot;

import Entities.Vehicle;
import ParkingStrategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingManager implements ParkingSpotManager{

     ParkingStrategy parkingStrategy ;
    List<ParkingSpot> parkingSpotList;
    public TwoWheelerParkingManager(ParkingStrategy parkingStrategy, List<ParkingSpot>parkingSpotList){
        this.parkingStrategy = parkingStrategy;
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public boolean isSpotFree() {
       for(ParkingSpot parkingSpot: parkingSpotList){
           if(parkingSpot.isFree())return true;
       }
       return false;
    }

    @Override
    public ParkingSpot park(){
       ParkingSpot spot =  parkingStrategy.strategy(parkingSpotList);
       spot.park();
       return spot;
    }

    @Override
    public void unPark(ParkingSpot spot) {
         spot.unPark();
    }


}
