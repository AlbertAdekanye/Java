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

      System.out.println("===== LIBRARY MEMBERS =====");

      for (Member member : members) {
          member.displayMember();
      }
  }

  public void searchBook(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        book.displayBook();
      }
    }
  }

 public void borrowBook(String title) {
    for (Book book : books) {

        if (book.getTitle().equalsIgnoreCase(title)) {
            book.borrowBook();
            return;
        }
    }

    System.out.println("Book not found.");
  }
}