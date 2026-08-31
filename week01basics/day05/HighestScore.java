package week01basics.day05;

public class HighestScore {
  
  public static void main(String[] args) {
      
    // find the hightest score
    int[] scores = {75, 82, 91, 84};

    int highestScore = scores[0];

    for(int score : scores) {
      if (score > highestScore) {
        highestScore = score;
      }
    }

    // find the lowest score
    int lowestScore = scores[0];

    for(int score : scores) {
      if (score < lowestScore) {
        lowestScore = score;
      }
    }

    System.out.println("============ HIGHEST SCORE ===========");
    System.out.println("Highest score: " + highestScore);

    System.out.println("========-- LOWEST SCORE =======");
    System.out.println("Lowest score: " + lowestScore);
  }
}
