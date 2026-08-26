package week01basics.day04;

import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
      
    Scanner scanner = new Scanner(System.in);

    System.out.println("============MULTIPLIER==========");
    System.out.println("Enter a number: ");
    int selectedNumber = scanner.nextInt();

    for(int multiplier = 1; multiplier <= 12; multiplier++) {
      int result = selectedNumber * multiplier;

      System.out.println(selectedNumber + " x " + multiplier + " = " + result);
    }

    // divider
    System.out.println("============DIVIDER==========");
    System.out.println("Enter a number: ");
    int dividerNumber = scanner.nextInt();

    for(int divider = 2; divider <=12; divider+=2) {
      int result = dividerNumber / divider;

      System.out.println(dividerNumber + " / " + divider + " = " + result);
    }

    scanner.close();
  }
}
