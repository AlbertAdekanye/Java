package week03collections.day07;

import java.util.ArrayList;

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
  }

}
