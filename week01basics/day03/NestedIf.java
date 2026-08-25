package week01basics.day03;

public class NestedIf {
  public static void main(String[] args) {
      int age = 24;
      boolean hasTicket = false;

      if (age >= 18) {
        if (hasTicket) {
          System.out.println("You may enter.");
        } else {
          System.out.println("You need a ticket.");
        }
      } else {
        System.out.println("You must be at least 18.");
      }
  }
}
