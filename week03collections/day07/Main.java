package week03collections.day07;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
  
//  ADD CONTACTS
  public static void addContact(ArrayList<Contact> contacts, Scanner scanner) {
    
    System.out.println("Enter name: ");
    String name = scanner.nextLine();

    System.out.println("Enter phone number: ");
    String phone = scanner.nextLine();

    System.out.println("Enter email: ");
    String email = scanner.nextLine();

    Contact contact = new Contact(name, phone, email);

    contacts.add(contact);
    System.out.println("Contact added successfully");

    Contact contact1 = new Contact(
      "Albert", 
      "09076542345", 
      "Albert@example.com"
    );
    Contact contact2 = new Contact(
      "Jae", 
      "0802345673", 
      "Jae@example.com"
    );

    contacts.add(contact1);
    contacts.add(contact2);
  }

  // VIEW CONTACTS
  public static void viewContacts(ArrayList<Contact> contacts) {

    if (contacts.isEmpty()) {
      System.out.println("No contacts found");

      return;
    }

    System.out.println("===== CONTACTS =====");

    for (Contact contact : contacts) {
      contact.displayContact();
    }
  }

  // SEARCH CONTACTS
  public static void searchContact(ArrayList<Contact> contacts, Scanner scanner) {

    System.out.println("Enter contact name: ");
    String searchName = scanner.nextLine();

    boolean found = false;

    for (Contact contact : contacts) {

      if (contact.getName().equals(searchName)) {
        contact.displayContact();

        found = true;

        break;
      }
    }

    if (!found) {
      System.out.println("Contact not found.");
    }
  }

  // DELETE CONTACT
  public static void deleteContact(ArrayList<Contact> contacts, Scanner scanner) {

    System.out.println("Enter contact name: ");

    String name = scanner.nextLine();

    Iterator<Contact> iterator = contacts.iterator();

    while (iterator.hasNext()) {

      Contact contact = iterator.next();

      if (contact.getName().equalsIgnoreCase(name)) {
        iterator.remove();

        System.out.println("Contact deleted successfully.");

        return;
      }
    }

    System.out.println("Contact not found");
  }

  public static void main(String[] args) {
      
    ArrayList<Contact> contacts = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    int Choice;

    do {

      System.out.println();
      System.out.println("===== CONTACT MANAGER =====");

      System.out.println("1. Add Contact");
      System.out.println("2. View Contact");
      System.out.println("3. Search Contact");
      System.out.println("4. Delete Contact");
      System.out.println("5. Exit");

      System.out.println("Choose an option.");

      Choice = scanner.nextInt();

      scanner.nextLine();

      switch (Choice) {

        case 1: 
          addContact(
            contacts, 
            scanner
          );
          break;

        case 2: 
          viewContacts(contacts);
          break;

        case 3: 
          searchContact(contacts, scanner);
          return;

        case 4: 
          deleteContact(contacts, scanner);
          return;

        case 5: 
          System.out.println("Goodbye!");
          break;

        default: 
          System.out.println("Invalid option.");
        
      }
    } while (Choice != 5);

    scanner.close();
  }
}
