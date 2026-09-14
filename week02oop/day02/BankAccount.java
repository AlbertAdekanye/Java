package week02oop.day02;

public class BankAccount {
  
  String accountName;
  String accountNumber;
  double balance;

  public BankAccount(String accountName, String accountNumber, double balance) {

    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  void deposit(double amount) {
    balance += amount;

    System.out.println("Amount Deposited: " + amount);
  }

  void withdraw(double amount) {
    balance -= amount;

    System.out.println("Amount withdrawn: " + amount);
  }

  void displayAccount() {
    System.out.println("Account Name: " + accountName);
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Balance: " + balance);
  }
}
