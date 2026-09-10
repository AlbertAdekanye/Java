package week02oop.day01;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();

        book1.title = "Clean Code";
        book1.author = "Robert C. Martin";
        book1.year = 2008;

        book2.title = "Effective Java";
        book2.author = "Joshua Bloch";
        book2.year = 2018;

        // book1.displayInfo();
        book2.displayInfo();

        // System.out.println(book2.title);
        // System.out.println(book2.author);
        // System.out.println(book2.year);
    }
}