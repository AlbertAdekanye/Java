package week02oop.day05;

public class BankTransfer extends Payment{
  
  @Override 
  public void processPayment() {
    System.out.println("Processing bank transfer.....");
  }
}
