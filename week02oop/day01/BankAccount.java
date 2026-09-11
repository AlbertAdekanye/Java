package week02oop.day01;

public class BankAccount {

    String accountName;
    String accountNumber;
    double balance;

    void deposit(double amount) {
        balance += amount;

        System.out.println("Amount Deposited: " + amount);
    }

    void withdraw(double amount) {
        balance -= amount;

        System.out.println("Amount Withdrawn: " + amount);
    }

    void displayAccount() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + balance);
    }
}