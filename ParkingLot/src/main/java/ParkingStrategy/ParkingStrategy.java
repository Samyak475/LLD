package ParkingStrategy;

import ParkingSpot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    public ParkingSpot strategy(List<ParkingSpot> parkingSpotList);
}
