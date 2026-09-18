package week02oop.day07;

public class Library {
  
  private String name;
  private Book[] books;
  private Member[] members;

  public Library(String name, Book[] books, Member[] members) {
    this.name = name;
    this.books = books;
    this.members = members;
  }

  public void displayBooks() {

    System.out.println("===== LIBRARY BOOKS =====");

    for (Book book : books) {
      book.displayBook();
    }
  }

  public void displayMembers() {
    for (Member members : members) {
      members.displayMembers();
    }
  }
}
