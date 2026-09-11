package week02oop.day01;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();
        
        Student student1 = new Student();
        
        Car car1 = new Car();
        Car car2 = new Car();

        car1.brand = "BMW";
        car1.model = "IX5";
        car1.year = 2025;
        car1.price = "$60000";        
        
        car2.brand = "benz";
        car2.model = "G-wagon";
        car2.year = 2025;
        car2.price = "$60000";
        
        System.out.println("====== BRAND1=========");
        car1.displayInfo();

        System.out.println("========= BRAND2 =========");
        car2.displayInfo();


        book1.title = "Clean Code";
        book1.author = "Robert C. Martin";
        book1.year = 2008;

        book2.title = "Effective Java";
        book2.author = "Joshua Bloch";
        book2.year = 2018;

        student1.name = "Albert";
        student1.age = 24;
        student1.course = "Physics";

        // book1.displayInfo();
        // book2.displayInfo();
        // student1.displayInfo();

        System.out.println(book2.title);
        System.out.println(book2.author);
        System.out.println(book2.year);
    }
}