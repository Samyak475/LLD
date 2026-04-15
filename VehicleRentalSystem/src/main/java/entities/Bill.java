package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Bill {
    private AtomicInteger billId=new AtomicInteger(100);
    Integer reservationId;
    Double amount;
    public Bill(Integer reservationId,Double amount) {
        billId.getAndIncrement();
        this.reservationId = reservationId;
        this.amount = amount;
    }

    public AtomicInteger getBillId() {
        return billId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
}
