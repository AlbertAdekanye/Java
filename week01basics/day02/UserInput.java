package week01basics.day02;

import java.util.Scanner;

public class UserInput {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter Your Name: ");
      String name = scanner.nextLine();

      System.out.print("Enter your age: ");
      int age = scanner.nextInt();

      System.out.println("Enter your height in metres: ");
      double height = scanner.nextDouble();

      System.out.println();
      System.out.println("Hello, " + name + "!");
      System.out.println("you are " + age + " years old.");
      System.out.println("your height is " + height + " metres.");

      scanner.close();
  }
}
