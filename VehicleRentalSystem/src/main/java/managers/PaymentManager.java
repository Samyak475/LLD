package managers;

import entities.Bill;
import entities.Payment;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PaymentManager {
    Payment payment;
ConcurrentHashMap<AtomicInteger, Payment>PaymentMap;
    public Payment doPayment(Bill bill){
        System.out.println("Payment Done for Bill id "+bill.getBillId());
        payment = new Payment(bill.getBillId());
        PaymentMap.put(payment.getPaymentId(),payment);
        return payment;
    }
}
