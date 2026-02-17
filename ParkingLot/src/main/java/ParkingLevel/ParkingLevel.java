package ParkingLevel;

import Entities.Ticket;
import Entities.Vehicle;
import Enums.VehicleType;
import ParkingSpot.ParkingSpot;
import ParkingSpot.ParkingSpotManager;
import java.util.Map;

public class ParkingLevel {
    Map<VehicleType, ParkingSpotManager> parkingSpotMap;
    int  LevelId;

    public ParkingLevel(Map<VehicleType, ParkingSpotManager> parkingSpotMap, int LevelId) {
        this.parkingSpotMap = parkingSpotMap;
        this.LevelId = LevelId;
    }

    public ParkingSpot ParkYourVehicle(VehicleType vehicleType){
        ParkingSpotManager manager = parkingSpotMap.get(vehicleType);
        ParkingSpot parkingSpot = null;
        if(manager.isSpotFree()){
           parkingSpot= manager.park();
        }
        return parkingSpot;
    }

    public  void unParkYourVehicle(ParkingSpot parkingSpot,VehicleType vehicleType){
        ParkingSpotManager manager = parkingSpotMap.get(vehicleType);
        manager.unPark(parkingSpot);
        return;
    }

    public boolean isParkingAvaliable(VehicleType vehicleType){
        ParkingSpotManager manager = parkingSpotMap.get(vehicleType);
        return manager.isSpotFree();
    }
}
