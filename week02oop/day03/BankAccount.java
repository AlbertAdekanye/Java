package week02oop.day03;

public class BankAccount {

  private String accountName;
  private String accountNumber;
  private double balance;
  
  public BankAccount(String accountName, String accountNumber, double balance) {
    this.accountName = accountName;
    this.accountNumber = accountName;

    if (balance >= 0) {
      this.balance = balance;
    } else {
      this.balance = 0;
    }
  }

  public String getAccountName() {
    return accountName;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }

  public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    }
  }

  public void displayAccount() {
    System.out.println("Account Name: " + accountName);
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Balance: " + balance);
  }
}


// ////////////////////////////////////////

// BankAccount
// │
// ├── private balance
// │
// ├── deposit()
// ├── withdraw()
// └── getBalance()

///////////////////////////////////////////