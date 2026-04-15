package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Payment {
    private final AtomicInteger paymentId= new AtomicInteger(100);
    AtomicInteger     billId;

    public Payment(AtomicInteger billId){
        this.billId = billId;
        paymentId.getAndIncrement();}



    public AtomicInteger getBillId() {
        return billId;
    }

    public void setBillId(AtomicInteger billId) {
        this.billId = billId;
    }
    public AtomicInteger getPaymentId(){
return paymentId;}
}
