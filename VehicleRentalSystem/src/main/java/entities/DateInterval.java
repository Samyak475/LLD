package entities;

import java.time.LocalDate;

public class DateInterval {
    LocalDate to;
    LocalDate from;
    public DateInterval(LocalDate bookTo, LocalDate bookFrom ){
        if(bookTo.isBefore(bookFrom)) {
            throw  new IllegalArgumentException(" Booking date can not be greater than return date");
        }
        to = bookTo;
        from = bookFrom;
    }

    public LocalDate getTo(){
        return to;
    }
    public LocalDate getFrom(){
        return from;
    }

    public Boolean overLaps(DateInterval other){
        return !(to.isBefore(other.from) || from.isAfter(other.to));
    }
}
