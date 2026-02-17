import CostStrategy.*;
import Entities.Vehicle;
import Enums.VehicleType;
import ParkingBuilding.ParkingBuilding;
import ParkingLevel.ParkingLevel;
import ParkingLot.ParkingLot;
import ParkingSpot.ParkingSpot;
import ParkingSpot.ParkingSpotManager;
import ParkingSpot.*;
import ParkingStrategy.*;
import PaymentMethod.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String []args){
        ParkingStrategy parkingStrategy = new RandomParkingStrategy();
        CostStrategy costStrategy = new FixedCostStrategy();
        PaymentMethod paymentMethod = new UPIPaymnet();

        List<ParkingSpot> parkingSpotList = Arrays.asList(new ParkingSpot("L1-B1"),new ParkingSpot("L1-B3")
                ,new ParkingSpot("L3-B2"),new ParkingSpot("L2-B1"));
        ParkingSpotManager parkingSpotManager = new TwoWheelerParkingManager(parkingStrategy,parkingSpotList);
        Map<VehicleType , ParkingSpotManager> parkingSpotManagerMap= new HashMap<>();

        List<ParkingSpot> parkingSpotList2 = Arrays.asList(new ParkingSpot("L2-B1"),new ParkingSpot("L2-B3")
                ,new ParkingSpot("L1-B2"),new ParkingSpot("L3-B1"));
        ParkingSpotManager parkingSpotManager2 = new FourWheelerParkingManager(parkingStrategy,parkingSpotList2);


        parkingSpotManagerMap.put(VehicleType.TWO_WHEELER,parkingSpotManager);
        parkingSpotManagerMap.put(VehicleType.FOUR_WHEELER,parkingSpotManager2);


        ParkingLevel parkingLevel = new ParkingLevel(parkingSpotManagerMap,1);


        List<ParkingLevel> parkingLevelList = Arrays.asList(parkingLevel);
         ParkingBuilding parkingBuilding = new ParkingBuilding(parkingLevelList);

         Vehicle vehicle = new Vehicle("102",VehicleType.TWO_WHEELER);
         ParkingLot parkingLot = new ParkingLot(parkingBuilding);

         parkingLot.entry(vehicle);
        System.out.println("entered in parkinglot ");

    }
}
