package week01basics.day04;

import java.util.Scanner;

public class SumCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number;

        // Keep asking until the user enters a positive integer
        do {
            System.out.print("Enter a positive integer: ");
            number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Invalid number. Try again.");
            }

        } while (number <= 0);

        int total = 0;

        // Add every number from 1 to the entered number
        for (int currentNumber = 1;
             currentNumber <= number;
             currentNumber++) {

            total += currentNumber;
        }

        System.out.println(
                "The sum from 1 to " + number + " is " + total + "."
        );

        scanner.close();
    }
}