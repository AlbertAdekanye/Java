package week02oop.day02;

public class Main {

  public static void main(String[] args) {
      
    Book book1 = new Book(
      "Clean Code",
      "Robert C. Martin",
      2008
    );
  
    Book book2 = new Book(
      "Effective Java", 
      "Joshua Bloch", 
      2018
    );

    Car car1 = new Car(
      "BMW", 
      "IX5", 
      2025, 
      "$50000"
    );

    Car car2 = new Car(
      "Benz", 
      "G-wagon", 
      2026, 
      "$120000"
    );

    BankAccount account1 = new BankAccount(
      "Albert Adekanye",
      "02727269",
      150000
    );

    System.out.println("======= Product Card =======");
    Product product1 = new Product(
      "Laptop", 
      9000000, 
      "Computer", 
      5
    );    
    
    Product product2 = new Product(
      "Headphone", 
      20000, 
      "Gadget", 
      5
    );    
    
    Product product3 = new Product(
      "Smartphone", 
      600000, 
      "Gadget", 
      5
    );

    product1.displayInfo();
    System.out.println();

    product2.displayInfo();
    System.out.println();
    
    product3.displayInfo();
    System.out.println();

    System.out.println("===== BANK ACCOUNT ====");
    account1.displayAccount();

    System.out.println();

    System.out.println("====== CAR BRAND ======");
    car1.displayInfo();

    System.out.println();

    car2.displayInfo();
    System.out.println();

    System.out.println("======= BOOK =======");
    book1.displayInfo();

    System.out.println();

    book2.displayInfo();
  }
  
}
