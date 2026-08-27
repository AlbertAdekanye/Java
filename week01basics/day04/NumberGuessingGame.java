package week01basics.day04;

import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int SECRET_NUMBER = 7;

        int guess;
        int attempts = 0;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            System.out.print("Guess a number from 1 to 10: ");
            guess = scanner.nextInt();

            attempts++;

            if (guess < SECRET_NUMBER) {
                System.out.println("Too low. Try again.");
            } else if (guess > SECRET_NUMBER) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Correct!");
            }

        } while (guess != SECRET_NUMBER);

        System.out.println(
                "You guessed the number in " + attempts + " attempts."
        );

        scanner.close();
    }
}