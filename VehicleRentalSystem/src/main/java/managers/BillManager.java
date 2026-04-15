package managers;

import entities.Bill;
import entities.Reservation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BillManager {
    ConcurrentHashMap<AtomicInteger , Bill> billMap;
    VehicleManager vehicleManager;
    public Bill generateBill(Reservation reservation){
       Double amount = vehicleManager.getVehicle(reservation.getVehicleId()).get().getDailyBasisRent() * 100;
       Bill bill = new Bill(reservation.getReservationId(),amount);
       billMap.put(bill.getBillId(),bill);
       return bill;
    }
}
