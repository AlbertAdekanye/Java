package week01basics.day06;

public class CalculatorMethod {
  
  public static void main(String[] args) {
      double result = multiply(10, 4);
      System.out.println("Result: " + result);
  }

  public static double add(double firstNumber, double secondNumber) {
    return firstNumber + secondNumber;
  }  
  
  public static double subtract(double firstNumber, double secondNumber) {
    return firstNumber - secondNumber;
  }  
  
  public static double multiply(double firstNumber, double secondNumber) {
    return firstNumber * secondNumber;
  }  
  
  public static double divide(double firstNumber, double secondNumber) {
    return firstNumber / secondNumber;
  }
}
