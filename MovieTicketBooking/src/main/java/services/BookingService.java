package services;

import entities.Booking;
import entities.Payment;
import enums.PaymentStatus;
import entities.User;
import entities.Shows;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BookingService {
    private final ConcurrentHashMap<UUID, Booking>bookingIdMap= new ConcurrentHashMap<>();

    public Booking book (List<Integer> seatList, User user, Shows shows){
        if(!shows.lockSeat(seatList)){
            throw  new RuntimeException("Seat are locked ");
        }
        Payment payment = new Payment(PaymentStatus.DONE);
        if(payment.getStatus() == PaymentStatus.DONE){
            shows.bookSeat(seatList);
            Booking booking = new Booking(user,shows,seatList,payment);
            bookingIdMap.put(booking.getBookingId(),booking);
            return booking;
        }else {
            shows.releaseSeat(seatList);
            throw  new RuntimeException(" Payment is not done getting issue here");
        }
    }
    public Booking getBookingById(UUID bookingId){
        return bookingIdMap.get(bookingId);
    }
    public List<Booking> getBookingByUserId(Integer  userId) {
        return bookingIdMap.values().stream().
                filter(booking -> booking.getUser().getId() == userId).collect(Collectors.toList());
    }
}
