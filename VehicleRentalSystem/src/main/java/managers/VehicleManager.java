package managers;

import entities.DateInterval;
import entities.Reservation;
import entities.Vehicle;
import enums.VehicleStatus;
import enums.VehicleType;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleManager {
    // vehicleId --> Vehicle
    private  final ConcurrentHashMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();
    // VehicleId --> ReservationId
    private final ConcurrentHashMap<Integer, List<Integer>>bookedVehicle = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer,ReentrantLock> lockVehicle = new ConcurrentHashMap<>();
    private  ReservationRepository reservationRepository;

    public void setReservationRepository(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }
    public Optional<Vehicle> getVehicle(int vehicleId){
        return  Optional.ofNullable(vehicles.get(vehicleId));
    }
    private ReentrantLock putLockOnVehicle(int VehicleId){
        lockVehicle.putIfAbsent(VehicleId,new ReentrantLock());
        return lockVehicle.get(VehicleId);
    }
//----Check Availablity

    public Boolean isAvailable(int vehicleId, LocalDate from , LocalDate to){
        Vehicle  chkVehicle = vehicles.get(vehicleId);
        if(chkVehicle==null||chkVehicle.getVehicleStatus().compareTo(VehicleStatus.AVAILABLE)!=0){
            return  false;
        }
        DateInterval requested = new DateInterval(from,to);
        List<Integer> vehicleReservation = bookedVehicle.get(vehicleId);
        if(vehicleReservation == null || vehicleReservation.isEmpty())return  true;
        for(Integer reservationId : vehicleReservation){
            Reservation reservation = reservationRepository.getReservationById(reservationId);
            DateInterval currDate = new DateInterval(reservation.getStartDate(),reservation.getEndDate());
            if(requested.overLaps(currDate)){
                return false;
            }
        }
        return true;
    }
    // Atomic Booking
    public Boolean bookVehicle(int vehicleId,int reservationId,LocalDate from , LocalDate to){
        ReentrantLock lock = lockVehicle.get(vehicleId);
        lock.lock();
        try{
            if(!isAvailable(vehicleId,from,to))return false;
            bookedVehicle.putIfAbsent(vehicleId,new ArrayList<>());
            bookedVehicle.get(vehicleId).add(reservationId);
            vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
            return true;
        }finally {
            lock.unlock();
        }
    }
    public  void releaseVehicle(int vehicleId,int reservationId){
        ReentrantLock lock = lockVehicle.get(vehicleId);
        lock.lock();
        try{
           List<Integer>listOfReservation = bookedVehicle.get(vehicleId);
           if(listOfReservation!=null){
               listOfReservation.remove(reservationId);
           }
            if(listOfReservation.isEmpty()){
                vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.AVAILABLE);
            }
        }finally {
            lock.unlock();
        }
    }

    //getAllVehicleAvailable
    public List<Vehicle> getAllVehicleAvailable(LocalDate from , LocalDate to, VehicleType vehicleType){
        return vehicles.values().stream()
                .filter(v->v.getVehicleType()==vehicleType)
                .filter(v->isAvailable(v.getVehicleId(),from,to))
                .collect(Collectors.toList());
    }
}
