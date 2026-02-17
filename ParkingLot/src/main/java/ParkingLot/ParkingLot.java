    package ParkingLot;

    import CostStrategy.CostStrategy;
    import Entities.Ticket;
    import Entities.Vehicle;
    import ParkingBuilding.ParkingBuilding;
    import PaymentMethod.PaymentMethod;

    public class ParkingLot {
         ParkingBuilding parkingBuilding;


         public  ParkingLot(ParkingBuilding parkingBuilding){
             this.parkingBuilding = parkingBuilding;

         }

         public Ticket entry(Vehicle vehicle){
             System.out.println("Entering parking lot");
             return parkingBuilding.Allocate(vehicle);
         }
         public void exit(Ticket ticket, PaymentMethod paymentMethod,  CostStrategy costStrategy){
            parkingBuilding.deAllocate(ticket,paymentMethod,costStrategy);
         }
    }
