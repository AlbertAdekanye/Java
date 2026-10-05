package week03collections.day06;

import javax.naming.InsufficientResourcesException;

public class Main {
    // Task 1
    public static void checkAge(int age)
            throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException(
                "You must be 18 or older."
            );
        }

        System.out.println("Age is valid.");
    }
    // Task 2
    public static void withdraw(double balance, double amount) {
      throws InsufficientBalanceException {
        if (amount > balance) {}
      }
    }

    public static void main(String[] args) {

        try {

            checkAge(15);
            checkAge(25);

        } catch (InvalidAgeException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}