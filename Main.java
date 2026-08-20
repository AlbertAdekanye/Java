import java.util.Date;
import java.awt.*;

// primitive vs reference
public class Main {
    public static void main(String[] args) {
        // primitive type
        byte myAge = 24;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;

        // reference type
        byte age = 24;
        Date now = new Date();
        System.out.println(now);

        // primitive vs reference
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);
        System.out.println(myAge);
        System.out.println(viewsCount);
        System.out.println(price);
        System.out.println(letter);
        System.out.println(isEligible);
        System.out.println(age);
    }
}