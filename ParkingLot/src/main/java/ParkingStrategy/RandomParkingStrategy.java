package ParkingStrategy;

import ParkingSpot.ParkingSpot;

import java.util.List;

public class RandomParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot strategy(List<ParkingSpot> parkingSpotList) {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.isFree()){

                return spot;
            }
        }
        throw new RuntimeException("No Spot Avalaible at this level for parking");
    }
}
