package week01basics.day02;

public class AssignmentOperators {

    public static void main(String[] args) {

        int score = 10;

        score += 5;
        System.out.println(score);

        score -= 3;
        System.out.println(score);

        score *= 2;
        System.out.println(score);

        score /= 4;
        System.out.println(score);

        // Increment and decrement
        int goals = 10;

        goals++;
        System.out.println(goals); // 11

        goals--;
        System.out.println(goals); // 10

        // Comparison operators
        int age = 24;

        System.out.println(age == 24);
        System.out.println(age != 24);
        System.out.println(age > 18);
        System.out.println(age < 18);
        System.out.println(age >= 24);
        System.out.println(age <= 30);

        // Logical operators
        // && AND 
        // ! NOT 
        int isAge = 24;
        boolean hasIdentification = true;

        boolean canEnter = isAge >= 18 && hasIdentification;

        boolean isWeekend = true;
        boolean isWeekDays = false;

        boolean canRest = isWeekDays || isWeekend;

        boolean isLoggedIn = false;

        System.out.println(!isLoggedIn); // true
        System.out.println(canEnter);
        System.out.println(canRest);


    }
}                                                                                