package week03collections.day05.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // ArithmeticException
        try {
            int result = 10/0;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by zero");
        }

        System.out.println("Program continues....");

        System.out.println();

        // ArrayIndexOutOfBoundsException
        System.out.println("=====ArrayIndexOutOfBoundsException=====");
        try {
            int [] numbers = {10, 20, 30};
            System.out.println(numbers[5]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            System.out.println("That index does not exist.");
        }

        System.out.println();

        // NumberFormatException
        System.out.println("======NumberFormatException=====");
        try {
            String name = "Albert";
            int number = Integer.parseInt(name);
            System.out.println(number);
        } catch ( NumberFormatException e) {
            // TODO: handle exception
            System.out.println("Invalid, This is not a valid number");
        }

        System.out.println();

        // InputMismatchException
        System.out.println("===== InputMismatchException ======");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your age: ");
            int age = scanner.nextInt();

            System.out.println("Your age is: " + age);

        } catch (InputMismatchException e) {
            // TODO: handle exception
            System.out.println("Please enter a valid number");
            System.out.println("Error: " + e.getMessage());
        } finally {

            scanner.close();
        }

        // throw
        try {
            int age = 15;
            if (age < 18) {
                throw new IllegalArgumentException(
                    "Age must be 18 or above"
                );
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}