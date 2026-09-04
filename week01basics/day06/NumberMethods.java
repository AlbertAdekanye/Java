package week01basics.day06;

public class NumberMethods {

    public static void main(String[] args) {

        System.out.println(isEven(8));
        System.out.println(square(5));
        System.out.println(findLarger(7, 4));
    }

    // Return true if the number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Return the number multiplied by itself
    public static int square(int number) {
        return number * number;
    }

    // Compare two numbers and return the larger number
    public static int findLarger(
            int firstNumber,
            int secondNumber
    ) {
        if (firstNumber > secondNumber) {
            return firstNumber;
        } else {
            return secondNumber;
        }
    }
}