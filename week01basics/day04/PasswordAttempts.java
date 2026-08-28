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

            if (password.equals(CORRECT_PASSWORD)) {
                System.out.println("Access granted.");

                accessGranted = true;
                break;
            } else {
                int attemptsRemaining = MAX_ATTEMPTS - attempts;

                if (attemptsRemaining > 0) {
                    System.out.println("Incorrect password.");
                    System.out.println(
                            attemptsRemaining + " attempt(s) remaining."
                    );
                }
            }
        }

        if (!accessGranted) {
            System.out.println("Account locked.");
        }

        scanner.close();
    }
}