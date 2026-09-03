package week01basics.day06;
public class ReturnValue {
  public static void main(String[] args) {
    int result = add(5, 10);

    System.out.println("Result: " + result);
  }
  public static int add(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber; 
  }
}
