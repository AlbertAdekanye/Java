package week03collections.day02;

import java.util.HashSet;

public class Main {
  
  public static void main(String[] args) {
      
    HashSet<String> names = new HashSet<>();

    HashSet<Integer> numbers = new HashSet<>();

    HashSet<String> languages = new HashSet<>();

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
    System.out.println("========== NUMBERS ===========");
    numbers.add(24);
    numbers.add(24);
    numbers.add(23);
    numbers.add(22);
    numbers.add(21);
    numbers.add(20);

    System.out.println(numbers);

    System.out.println();
    
    // Languages`
    languages.add("Java");
    languages.add("C");
    languages.add("C++");
    languages.add("Python");
    languages.add("JavaScript");
    
    // print languages
    System.out.println("Languages: " + languages);

    System.out.println();

    // print number of languages
    System.out.println("Number of Languages: " + languages.size());

    System.out.println();

    if (languages.contains("Java")) {
      System.out.println("Java Exist");
    }
  }
}
