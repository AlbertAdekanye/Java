package week01basics.day05;

import java.util.Scanner;

public class UserScores {
  public static void main(String[] args) {
      
    Scanner scanner = new Scanner(System.in);

    int[] scores = new int[5];

    for(int index = 0; index < scores.length; index++) {
      System.out.println("Enter score " + (index + 1) + ": ");
      
      scores[index] = scanner.nextInt();
    }

    System.out.println();
    System.out.println(scores);

    for(int score : scores) {
      System.out.println(score);
    }
    
    scanner.close();
  }
}
