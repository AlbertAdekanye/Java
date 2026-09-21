package week03collections.day02;

import java.util.HashSet;

public class Main {
  
  public static void main(String[] args) {
      
    HashSet<String> names = new HashSet<>();

    HashSet<Integer> numbers = new HashSet<>();

    names.add("Albert");
    names.add("Adesoye");
    names.add("Adekanye");
    //Duplicate values
    names.add("Albert");
    names.add("Albert");
    names.add("Albert");

    names.add("Jea");
    names.remove("Albert");
    System.out.println(names);
    System.out.println(names.size());

    if (names.contains("Adekanye")) {
      System.out.println("Present");
    } if (names.contains("Albert")) {
      System.out.println("present");
    } else {
      System.out.println("Absent");
    }

    if (names.isEmpty()) {
      System.out.println("The set is empty.");
    }

    System.out.println();
    // HashSet with numbers
    numbers.add(24);
    numbers.add(24);
    numbers.add(23);
    numbers.add(22);
    numbers.add(21);
    numbers.add(20);

    System.out.println(numbers);
  }
}
