package ParkingSpot;

import Entities.Vehicle;

import java.util.List;

public interface ParkingSpotManager {
    public boolean isSpotFree();
    public ParkingSpot park();
    public void unPark(ParkingSpot spot);
}
