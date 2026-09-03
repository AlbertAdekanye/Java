package week01basics.day06;

public class MethodBasics {
  
  public static void main(String[] args) {
    System.out.println("============= Methods =============");

    greetUser();
    displayProfile("Albert", 24); // Correct
    
  }

  public static void greetUser() {
    System.out.println("Welcome to Java Programming!");
  }

  public static void displayProfile(String name, int age) {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
  }
  
}
