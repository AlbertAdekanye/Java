package week01basics.day06;

public class ReturnMethod {
  
  public static void main(String[] args) {
      System.out.println(checkAge(-5));
      System.out.println(checkAge(24));
      System.out.println(checkAge(15));
  }

  public static String checkAge(int age) {
    if (age < 0) {
      return "Invalid age";
    }
    if (age >= 18) {
      return "Adult";
    }
    return "Minor";
  }
}
