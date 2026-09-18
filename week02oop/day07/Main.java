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

        Book[] books = {
            book1,
            book2,
            book3
        };

        Member member1 = new Member(
            "Albert Adekanye",
            101
        );

        Member member2 = new Member(
            "John Doe",
            102
        );

        Member[] members = {
            member1,
            member2
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

        book1.borrowBook();

        System.out.println();

        library.displayBooks();

        System.out.println();

        book1.returnBook();
    }
}