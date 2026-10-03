package week03collections.day05;

public class Main {

    public static void main(String[] args) {

        try {
            int result = 10 / 0;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by zero.");
        }

        System.out.println("Program continues...");
    }
}
