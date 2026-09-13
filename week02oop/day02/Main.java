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
    
    book1.displayInfo();

    System.out.println();

    book2.displayInfo();
  }
  
}
