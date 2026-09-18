package week02oop.day06;

public class CardPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing card payment...");
    }
}