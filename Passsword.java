import java.util.Scanner;

/**
 * Passsword
 */
public class Passsword {

  public static void main(String[] args) {
      
    Scanner scanner = new Scanner(System.in);

    final String CORRECT_PASSWORD = "codewithkanye";
    final int MAX_ATTEMPTS = 3;

    int attempts = 0;
    boolean accessGranted = false;

    while (attempts < MAX_ATTEMPTS) { 
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        attempts++;

        // Compare the entered password with CORRECT_PASSWORD

        if (password.equals(CORRECT_PASSWORD)) {
          System.out.println("Access granted");

          accessGranted = true;
          break;
        } else {
          int attemptsRemaining = MAX_ATTEMPTS - attempts;

          System.out.println(attemptsRemaining + "attempt(s) remaining.");
        }
    }
     // If access was not granted, print "Account locked."

     if(!accessGranted) {
      System.out.println("Account locked.");
     }

    scanner.close();
  }
}