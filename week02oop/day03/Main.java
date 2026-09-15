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
    }
}