package week03collections.day05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Task 1- Division
        try {
            int number1 = 20;
            int number2 = 0;
            int result = number1/number2;

            System.out.println(result);
            
        } catch (ArithmeticException e) {
            // TODO: handle exception
            System.out.println("Cannot divide by zero.");
        }
        System.out.println();

        // Task 2- Array
        try {
             int[] numbers = {10, 20, 30, 40, 50};
             System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            System.out.println("Invalid array index.");
        }
        System.out.println();

        // Task 3 — String to Integer
        try {
            String text = "123";
            text = "hello";
            int number = Integer.parseInt(text);
            
            System.out.println(number);
        } catch (NumberFormatException e) {
            // TODO: handle exception
            System.out.println("Invalid number format.");
        }
        System.out.println();

        // Task 4 — User Input
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your age: ");
            int age = scanner.nextInt();

            System.out.println("Your age is: " + age);
        } catch (InputMismatchException e) {
            // TODO: handle exception
            System.out.println("InputMismatchException");
        } finally {
            scanner.close();
        }
        System.out.println();

        // Task 5 — Multiple Catch
        try {

    int age = 15;

    if (age < 18) {
        throw new IllegalArgumentException(
            "You must be 18 or above."
        );
    }

    int[] numbers = {10, 20, 30};

        System.out.println(numbers[5]);
    
    } catch (IllegalArgumentException e) {
    
        System.out.println(e.getMessage());
    
    } catch (ArrayIndexOutOfBoundsException e) {
    
        System.out.println("Invalid array index.");
    
    } finally {
    
        System.out.println("Program continues...");
    }
    
    }
}