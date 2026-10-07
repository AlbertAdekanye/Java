package week03collections.day07;

import java.awt.Choice;
import java.util.ArrayList;
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
  }

  // VIEW CONTACTS
  public static void viewContacts(ArrayList<Contact> contact) {

    
  }
}
