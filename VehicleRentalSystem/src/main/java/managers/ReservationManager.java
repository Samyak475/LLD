package managers;

import entities.Reservation;
import entities.User;
import entities.Vehicle;
import enums.ReservationStatus;
import enums.ReservationType;
import enums.VehicleStatus;
import enums.VehicleType;
import jdk.internal.net.http.ResponseTimerEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    ReservationRepository reservationRepository;
    VehicleManager vehicleManager;
    public  final AtomicInteger revervationIdGenerator = new AtomicInteger(100);
    public ReservationManager(VehicleManager vehicleManager ){
        this.reservationRepository = new ReservationRepository();
        this.vehicleManager  = vehicleManager;
        vehicleManager.setReservationRepository(reservationRepository);
    }


    public Reservation getReservationById(Integer id){
        return reservationRepository.getReservationById(id);
    }
    public Reservation createReservation(User user , int vehicleId, LocalDate from , LocalDate to , ReservationType reservationType){
        Integer reservationId = revervationIdGenerator.getAndIncrement();
        Boolean isBooked = vehicleManager.bookVehicle(vehicleId,reservationId,from , to);
        if(!isBooked)
        {
            throw new IllegalArgumentException("Booking is not available for selected vehicle");
        }
        Reservation reservation = new Reservation(reservationId, user.getUserId(),vehicleId,
                                                    from,to,reservationType, ReservationStatus.BOOKED);
        reservationRepository.addReservation(reservation);
        return reservation;

    }
    public void cancelReservation(Integer reservationId){
        Reservation reservation = getReservationById(reservationId);
        if(reservation == null){
            throw  new IllegalArgumentException("No booking exit with this reservation id");
        }
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
        vehicleManager.releaseVehicle(reservation.getVehicleId(),reservationId);
        reservationRepository.removeReservation(reservationId);
    }
    public void startTrip(Integer id){
        Reservation reservation = getReservationById(id);
        reservation.setReservationStatus(ReservationStatus.ONGOING);

    }
    public void endTrip(Integer id){
        Reservation reservation = getReservationById(id);
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
        vehicleManager.releaseVehicle(reservation.getVehicleId(),id);
    }

    public void removeReservation(int reservationId) {
        reservationRepository.removeReservation(reservationId);
    }
}
