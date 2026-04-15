package entities;

import java.util.List;
import java.util.UUID;

public class Booking {
    private final User user;
    private final Shows shows;
    private final List<Integer> seatList;
    private final  UUID bookingId;
    private final Payment  payment;

    public Booking(User user, Shows shows, List<Integer> seatList, Payment paymentStatus) {
        this.user = user;
        this.shows = shows;
        this.seatList = seatList;
        this.bookingId = UUID.randomUUID();
        this.payment = paymentStatus;
    }

    public User getUser() {
        return user;
    }

    public Shows getShows() {
        return shows;
    }

    public List<Integer> getSeatList() {
        return seatList;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public Payment getPayment() {
        return payment;
    }
}
