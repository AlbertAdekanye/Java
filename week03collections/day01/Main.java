package week03collections.day01;

import java.util.ArrayList;

public class Main {
  
  public static void main(String[] args) {
      
    ArrayList<Book> books = new ArrayList<>();

    Book book1 = new Book(
      "Clean Code", 
      "Robert C. Martin"
    );

    Book book2 = new Book(
      "Effective Code", 
      "Joshua Bloch"
    );    
    
    Book book3 = new Book(
      "Head First Java", 
      "Kathy Sierra"
    );    
    
    Book book4 = new Book(
      "The Complete Reference", 
      "Russ Walter"
    );    
    
    Book book5 = new Book(
      "Effective Code", 
      "Joshua Bloch"
    );

    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    books.add(book5);

    System.out.println("Numbers of books: " + books.size());

    System.out.println();

    books.remove(4);
    
    Book book6 = new Book(
      "Java Concurrency in Practice",
      "Brian Goetz"
    );
    books.add(book6);

    
    books.get(0).displayBook();
    books.get(1).displayBook();
    books.get(2).displayBook();
    books.get(3).displayBook();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase("Head First Java")) {
        System.out.println("The book exists.");
      }
    }

    System.out.println("Number of books: " + books.size());

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase("Head First Java")) {
        System.out.println("Book found!");
        book.displayBook();
      }
    }

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase("Java Programming")) {
        System.out.println("Book found!");
        book.displayBook();
      }
  } 
  }
}
