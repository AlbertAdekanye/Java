package week02oop.day01;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();

        Student student1 = new Student();

        Car car1 = new Car();
        Car car2 = new Car();

        BankAccount bankAccount = new BankAccount();

        bankAccount.accountName = "Albert Adekanye";
        bankAccount.accountNumber = "02727269";
        bankAccount.balance = 150000;

        System.out.println("====== BANK ACCOUNT ======");
        bankAccount.displayAccount();

        car1.brand = "BMW";
        car1.model = "IX5";
        car1.year = 2025;
        car1.price = "$60000";

        car2.brand = "Benz";
        car2.model = "G-Wagon";
        car2.year = 2025;
        car2.price = "$60000";

        System.out.println("====== BRAND 1 ======");
        car1.displayInfo();

        System.out.println("====== BRAND 2 ======");
        car2.displayInfo();

        System.out.println("====== BOOK 1 ======");
        book1.title = "Clean Code";
        book1.author = "Robert C. Martin";
        book1.year = 2008;
        book1.displayInfo();

        System.out.println("====== BOOK 2 ======");
        book2.title = "Effective Java";
        book2.author = "Joshua Bloch";
        book2.year = 2018;
        book2.displayInfo();

        System.out.println("====== STUDENT 1 ======");
        student1.name = "Albert";
        student1.age = 24;
        student1.course = "Physics";
        student1.displayInfo();
    }
}