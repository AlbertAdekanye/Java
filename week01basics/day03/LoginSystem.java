package week01basics.day03;

import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String CORRECT_USERNAME = "albert";
        final String CORRECT_PASSWORD = "java123";

        // Collect user input
        System.out.println("===== LOGIN SYSTEM =====");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Are you an administrator? ");
        boolean isAdmin = scanner.nextBoolean();

        // Check username and password
        boolean loginIsCorrect =
                username.equals(CORRECT_USERNAME)
                && password.equals(CORRECT_PASSWORD);

        // Check login, age, and account role
        if (!loginIsCorrect) {
            System.out.println("Invalid username or password.");
        } else if (age < 18) {
            System.out.println(
                    "Login successful, but access is restricted because of your age."
            );
        } else if (isAdmin) {
            System.out.println(
                    "Welcome to the administrator dashboard."
            );
        } else {
            System.out.println(
                    "Welcome to the user dashboard."
            );
        }

        scanner.close();
    }
}