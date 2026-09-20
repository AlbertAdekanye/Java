package week03collections;

import java.util.ArrayList;

public class Main {
  
  public static void main(String[] args) {

      ArrayList<String> names = new ArrayList<>();

      names.add("Albert");
      names.add("Oluwagbenga");
      names.add("Adesoye");

      // Changing an Element
      names.set(1, "Michael");

      // Removing an Element
      names.remove(1);


      System.out.println(names);
      // Getting an Element
      System.out.println(names.get(0));
      // Getting the Size
      System.out.println(names.size());

      // Checking if the List Is Empty
      if (names.contains("Albert")) {
        System.out.println("present");
      }

      // Checking if the List Is Empty
      if (names.isEmpty()) {
        
      }
  }
}
