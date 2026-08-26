package week01basics.day04;

public class SumNumbers {
  
  public static void main(String[] args) {
      
    int total = 0;

    for (int number = 1; number <= 5; number++) {
      total += number;
    }

    System.out.println("Total: " + total);
  }
}
