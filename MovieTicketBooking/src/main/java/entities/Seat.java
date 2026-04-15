package entities;

import enums.SeatType;

public class Seat {

    private final  int seatId;
    private final  SeatType seatType;

    public Seat(int seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }


}
