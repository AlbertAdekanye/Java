package week01basics.day05;

public class ScoreAverage {
  public static void main(String[] args) {
      
    int[] scores = {75, 82, 68, 84};

    int total = 0;

    for (int score : scores) {
      total += score;
    }

    double average = (double) total / scores.length;

    System.out.println("Total: " + total);
    System.out.println("Average: " + average);
  }
}
