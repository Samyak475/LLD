package entities;

import enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    private final PaymentStatus status;
    private final UUID paymentId;

    public PaymentStatus getStatus() {
        return status;
    }



    public UUID getPaymentId() {
        return paymentId;
    }



    public Payment(PaymentStatus status) {
        this.status = status;
        this.paymentId = UUID.randomUUID();
    }
}
