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
      "Effective Java", 
      "Joshua Bloch"
    );

    Book book3 = new Book(
      "Head First Java", 
      "Kathy Sierra"
    );

    books.add(book1);
    books.add(book2);
    books.add(book3);

    System.out.println("Number of books: " + books.size());

    System.out.println();

    books.get(0).displayBook();
    books.get(1).displayBook();
    books.get(2).displayBook();
  }
}
