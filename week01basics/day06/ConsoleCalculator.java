package week01basics.day06;

import java.util.Scanner;

public class ConsoleCalculator {
  
  public static void main(String[] args) {
      
    Scanner scanner = new Scanner(System.in);

    int choice;

    // keep displaying the calculator until the user chooses 0
    do { 
        displayMenu();

        System.out.println("Choose an operation: ");
        choice = scanner.nextInt();

        // only ask for numbers when the selected operator is valid
        if (choice >= 1 && choice <= 4) {

          System.out.println("Enter first number: ");
          double firstNumber = scanner.nextDouble();

          System.out.println("Enter second number: ");
          double secondNumber = scanner.nextDouble();

          // call the appropriate calculation method
          switch (choice) {
            case 1 -> {
              double result = add(firstNumber, secondNumber);
              System.out.println("Result: " + result);
            }

            case 2 -> {
              double result = subtract(firstNumber, secondNumber);
              System.out.println("Result: " + result);
            }

            case 3 -> {
              double result = multiply(firstNumber, secondNumber);
              System.out.println("Result: " + result);
            }

            case 4 -> {
              // division by zero is not allowed
              if (secondNumber == 0) {
                System.out.println("Cannot divide by zero");
              } else {
                double result = divide(firstNumber, secondNumber);
                System.out.println("Result: " + result);
              }
            }
          }
        } else if (choice == 0) {
          // choosing 0 closes the calculator
          System.out.println("Calculator closed");
        } else {
          System.out.println("Invalid operator");
        }

        // print a blank before displaying the menu again
        System.out.println();

    } while (choice != 0);

    // close the scanner after the calculator 
    scanner.close();
  }
  // Display the available calculator operations
  public static void displayMenu() {
    System.out.println("===== JAVA CONSOLE CALCULATOR =====");
    System.out.println("1. Add");
    System.out.println("2. Subtract");
    System.out.println("3. Multiply");
    System.out.println("4. Divide");
    System.out.println("0. Exit");
  }

  // return the sum of two numbers
  public static double add(double firstNumber, double secondNumber){
    return firstNumber + secondNumber;
  }

  // return the difference of two numbers
  public static double subtract(double firstNumber, double secondNumber){
    return firstNumber - secondNumber;
  }

  // return the product of two numbers
  public static double multiply(double firstNumber, double secondNumber){
    return firstNumber * secondNumber;
  }

  // return the of dividing the first number by the second 
    public static double divide(double firstNumber, double secondNumber){
    return firstNumber / secondNumber;
  }
}
