package week03collections.day06;

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
    public static void withdraw(double balance, double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance."
            );
        }

        System.out.println("Withdrawal successful.");
    }

    public static void main(String[] args) {

        // Test Task 1
        try {

            checkAge(15);

        } catch (InvalidAgeException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }

        System.out.println();

        // Test valid age
        try {

            checkAge(25);

        } catch (InvalidAgeException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }

        System.out.println();

        // Test Task 2
        try {

            withdraw(50000, 60000);

        } catch (InsufficientBalanceException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }

        System.out.println();

        // Test successful withdrawal
        try {

            withdraw(50000, 20000);

        } catch (InsufficientBalanceException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}