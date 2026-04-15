package managers;

import entities.Reservation;

import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    ConcurrentHashMap<Integer, Reservation> reservationMap;
    public void addReservation(Reservation reservation){
        reservationMap.put(reservation.getReservationId(), reservation);
    }
    public void cancelReservation(Reservation reservation){
        reservationMap.remove(reservation.getReservationId());
    }
    public Reservation getReservationById(Integer id){
        return reservationMap.get(id);
    }
    public void removeReservation(Integer id){
        reservationMap.remove(id);

    }
}
