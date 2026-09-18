package week02oop.day07;

public class Main {

    public static void main(String[] args) {

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

        Book book4 = new Book(
          "The Complete Reference", 
          "Herbert Schildt"
        );

        Book[] books = {
            book1,
            book2,
            book3,
            book4
        };

        Member member1 = new Member(
            "Albert Adekanye",
            101
        );

        Member member2 = new Member(
            "John Doe",
            102
        );

        Member member3 = new Member(
          "Adesoye", 
          007
        );

        Member[] members = {
            member1,
            member2,
            member3
        };

        Library library = new Library(
            "CodeWithKanye Library",
            books,
            members
        );

        library.displayBooks();

        System.out.println();

        library.displayMembers();

        System.out.println();

        library.borrowBook("Clean Code");
        library.borrowBook("Clean Code");

        library.borrowBook("Effective Java");
        library.borrowBook("Effective Java");

        System.out.println();

        library.displayBooks();

        System.out.println();

        book1.returnBook();

        System.out.println();

        System.out.println("===== SEARCH RESULT =====");
        library.searchBook("Clean Code");
        library.searchBook("Java: The Complete Reference");
        library.searchBook("Something That Does Not Exist");
    }
}