package week01basics.day04;

import java.util.Scanner;

public class PasswordAttempts {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String CORRECT_PASSWORD = "java123";
        final int MAX_ATTEMPTS = 3;

        int attempts = 0;
        boolean accessGranted = false;

        while (attempts < MAX_ATTEMPTS) {

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            attempts++;

            // Compare the entered password with CORRECT_PASSWORD

            // If it is correct:
            // 1. Print "Access granted."
            // 2. Set accessGranted to true
            // 3. Exit the loop using break

            // Otherwise, show how many attempts remain
        }

        // If access was not granted, print "Account locked."

        scanner.close();
    }
}