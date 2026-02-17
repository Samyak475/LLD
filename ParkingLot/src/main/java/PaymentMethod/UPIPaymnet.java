package PaymentMethod;

public class UPIPaymnet implements PaymentMethod {

    @Override
    public boolean doPayment(int cost){
        System.out.println("Payment done for cost "+ cost);
        return true;
    }
}
