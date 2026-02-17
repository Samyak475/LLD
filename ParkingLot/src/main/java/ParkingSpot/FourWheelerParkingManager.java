package ParkingSpot;

import ParkingStrategy.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingManager implements ParkingSpotManager{

    ParkingStrategy parkingStrategy ;
    List<ParkingSpot> parkingSpotList;
    public FourWheelerParkingManager(ParkingStrategy parkingStrategy, List<ParkingSpot>parkingSpotList){
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
        return  parkingStrategy.strategy(parkingSpotList);
    }

    @Override
    public void unPark(ParkingSpot spot) {
        spot.unPark();
    }


}
