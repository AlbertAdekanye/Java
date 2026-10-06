package week03collections.day07;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {

    ArrayList<Contact> contacts = new ArrayList<>();

    Contact contact1 = new Contact(
      "Albert",
      "09058647535",
      "albert@example.com"
    );
  
    Contact contact2 = new Contact(
      "Adesoye", 
      "08049191133", 
      "adesoye@example.com"
    );
  
    Contact contact3 = new Contact(
      "John", 
      "09048855387", 
      "john@example.com"
    );
  
    contacts.add(contact1);
    contacts.add(contact2);
    contacts.add(contact3);
  
    for (Contact contact : contacts) {
      contact.displayContact();
    }

    Scanner scanner = new Scanner(System.in);

    int choice;

    do {

      System.out.println("===== CONTACT MANAGER =====");
      System.out.println("1. Add Contact");
      System.out.println("2. View Contacts");
      System.out.println("3. Search Contact");
      System.out.println("4. Delete Contact");
      System.out.println("5. Exit");

      System.out.println("Choose an option: ");
      choice = scanner.nextInt();
      scanner.nextLine();

    } while (choice !=5);

    scanner.close();
  }

  public static void viewContacts(ArrayList<Contact> contacts) {
    
    if (contacts.isEmpty()) {
      System.out.println("No contacts found.");
      return;
    }

    for (Contact contact : contacts) {
      contact.displayContact();
    }
  }

}
