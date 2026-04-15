package controllers;

import entities.Booking;
import services.BookingService;
import entities.User;
import entities.Shows;

import java.util.List;
import java.util.UUID;

public class BookingController {
    private final BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }
    public Booking book (List<Integer> seatList, User user, Shows shows){
       return bookingService.book(seatList,user,shows);
    }
    public Booking getBookingById(UUID bookingId){
        return bookingService.getBookingById(bookingId);
    }
    public List<Booking> getBookingByUserId(Integer  userId) {
       return bookingService.getBookingByUserId(userId);
    }
}

