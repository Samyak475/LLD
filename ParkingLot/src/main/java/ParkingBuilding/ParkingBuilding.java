package ParkingBuilding;

import CostStrategy.CostStrategy;
import Entities.Ticket;
import Entities.Vehicle;
import ParkingLevel.ParkingLevel;
import ParkingSpot.ParkingSpot;
import PaymentMethod.PaymentMethod;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class ParkingBuilding {

    List<ParkingLevel> parkingLevelList;

    public ParkingBuilding(List<ParkingLevel> parkingLevelList){
        this.parkingLevelList = parkingLevelList;
    }

    public Ticket Allocate(Vehicle vehicle){
        Ticket ticket = new Ticket();
        for(ParkingLevel parkingLevel: parkingLevelList)
        {
            System.out.println("Check which parking is available");
            if(parkingLevel.isParkingAvaliable(vehicle.getVehicleType())){
                System.out.println("parking available at level ");
             ticket.setParkingSpot(  parkingLevel.ParkYourVehicle(vehicle.getVehicleType()));
             ticket.setParkingLevel(parkingLevel);
             break;
            }
        }
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        return ticket;
    }

    public void deAllocate(Ticket ticket , PaymentMethod paymentMethod, CostStrategy costStrategy){
       int cost =  costStrategy.calculateCost(ticket);
      if( paymentMethod.doPayment(cost)==true){
          ticket.getParkingLevel().unParkYourVehicle(ticket.getParkingSpot() ,ticket.getVehicle().getVehicleType());
      }
        return;
    }
}
