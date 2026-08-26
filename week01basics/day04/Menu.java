package week01basics.day04;

import java.util.Scanner;

public class Menu {
  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      int choice;

      do { 
          System.out.println();
          System.out.println("=======MENU=======");
          System.out.println("1. View profile");
          System.out.println("2. View balance");
          System.out.println("0. Exit");

          System.out.println("Choose an option: ");
          choice = scanner.nextInt();

        switch (choice) {
          case 1 -> System.out.println("Profile selected");
          case 2 -> System.out.println("Balance selected");
          case 0 -> System.out.println("Goodbye!");
          default -> System.out.println("Invalid option."); 
        }

      } while (choice != 0);

      scanner.close();
  }
}
