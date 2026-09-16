package week02oop.day03;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(
            "Albert Adekanye",
            "02727269",
            150000
        );

       
        System.out.println("===== INITIAL ACCOUNT =====");
        account1.displayAccount();

        System.out.println();

        account1.deposit(50000);

        System.out.println("===== AFTER DEPOSIT =====");
        account1.displayAccount();

        System.out.println();

        account1.withdraw(20000);

        System.out.println("===== AFTER WITHDRAWAL =====");
        account1.displayAccount();

        System.out.println();

        System.out.println("Current Balance: " + account1.getBalance());

        // Product product = new Product();
        Product item = new Product(
            "Mac book pro M4", 
            900000, 
            "Laptop", 
            4
        );

        System.out.println();

        item.displayProduct();

        // test invalid values
        System.out.println();
        item.setPrice(-500);
        item.setQuantity(-10);
        item.displayProduct();

        // STUDENT
        Student profile = new Student(
            "Albert Adekanye", 
            24, 
            "Physics"
        );

        System.out.println();

        profile.displayStudent();
    }
}