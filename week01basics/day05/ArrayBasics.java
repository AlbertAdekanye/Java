package week01basics.day05;

public class ArrayBasics {
  public static void main(String[] args) {
      
    int [] scores = {75, 81, 91, 68};

    System.out.println("Original scores: " + scores[1]);

    scores[1] = 88;

    System.out.println("Updated score: " + scores[1]);
    System.out.println("Number of scores:  " + scores.length);

    String[] countries = new String[3];

    countries[0] = "Germany";
    countries[1] = "United State Of America";
    countries[2] = "Norway";

    System.out.println("I will relocate to " + countries[0]);
  }
}
