package week02oop.day07;

public class Book {

    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println(title + " has been returned.");
    }

    public void displayBook() {
        System.out.println(
            "Title: " + title +
            " | Author: " + author +
            " | Available: " + available
        );
    }
}