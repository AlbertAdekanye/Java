package week01basics.day05;

public class StringMethods {

    public static void main(String[] args) {

        String message = "  Learning Java Backend  ";

        System.out.println(message.length());
        System.out.println(message.toUpperCase());
        System.out.println(message.toLowerCase());
        System.out.println(message.trim());
        System.out.println(message.contains("Java"));
        System.out.println(message.startsWith("Learning"));
        System.out.println(message.endsWith("Backend  "));
    }
}