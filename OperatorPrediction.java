public class OperatorPrediction {

    public static void main(String[] args) {

        int number = 10;
        double result = number / 4;

        System.out.println(result);

        number += 6;
        number /= 4;

        System.out.println(number);
        System.out.println(number > 3 && number < 10);
    }
}