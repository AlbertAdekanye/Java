package week01basics.day04;

import java.util.Scanner;

public class AgeValidator {
  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      System.out.println("===========AGE VALIDATOR=======");

      System.out.println("Enter your age: ");
      int age = scanner.nextInt();

      while(age < 0 || age > 120) {
        System.out.println("Invalid age.");

        System.out.print("Enter an age between 0 and 120: ");
        age = scanner.nextInt();
      }

      System.out.println("Valid age: " + age);

      scanner.close();
  }
}
