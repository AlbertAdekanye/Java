package week02oop.day05;

public class CardPayment extends Payment {
  
  @Override
  public void processPayment() {
    System.out.println("Processing card payment.....");
  }
}
