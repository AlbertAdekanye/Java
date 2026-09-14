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
