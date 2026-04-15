package managers;

import entities.*;
import enums.ReservationType;
import enums.VehicleType;

import java.time.LocalDate;
import java.util.List;

public class StoreManager {
    String location;
    int storeId;
    ReservationManager reservationManager;
    VehicleManager vehicleManager;
    BillManager billManager;
    PaymentManager paymentManager;
    public StoreManager(String location , int storeId,VehicleManager vehicleManager,ReservationManager  reservationManager ,BillManager billManager,PaymentManager paymentManager )
    {
        this.storeId=storeId;
        this.location=location;
        this.vehicleManager=new VehicleManager();
        this.billManager=new BillManager();
        this.paymentManager=new PaymentManager();
        this.reservationManager= new ReservationManager(vehicleManager);
    }
    public Reservation createReservation(LocalDate from , int vehicleId, LocalDate to, ReservationType reservationType, User user){

       return reservationManager.createReservation(user ,vehicleId,from , to , reservationType);
    }

    public List<Vehicle>getAllVehilces(LocalDate from , LocalDate to, VehicleType vehicleType){
       return vehicleManager.getAllVehicleAvailable(from, to , vehicleType);
    }

    public  void  cancelReservation(Integer id){
        reservationManager.cancelReservation(id);
    }
    public void startTrip(Integer id){
        reservationManager.startTrip(id);
    }

    public  void endTrip(Integer id){
        reservationManager.endTrip(id);
    }

    public Bill generateBill(int reservationId){
        Reservation r = reservationManager.getReservationById(reservationId);
        return billManager.generateBill(r);
    }



    public Payment doPayment(Bill bill,int reservationId){
        Reservation r = reservationManager.getReservationById(reservationId);

        reservationManager.removeReservation(reservationId);
        return paymentManager.doPayment(bill);
    }

    public VehicleManager getVehicleManager() {
        return vehicleManager;
    }

    public int getStoreId() {
        return storeId;
    }
}

