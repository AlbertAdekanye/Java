package week04files.day04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
  
  public static void main(String[] args) {

    // REMOVE DUPLICATE

    List<String> languages = List.of(
      "Java",
      "Java",
      "Python",
      "JavaScript"
    );

    System.out.println("===== REMOVE DUPLICATE =====");

    List<String> uniquelLanguages = languages.stream()
              .distinct()
              .toList();

    System.out.println(uniquelLanguages);

    System.out.println();

    // MAX() AND MIN() FIND THE LARGEST AND SMALLEST
    List<Integer> numbers = List.of(10, 45, 2, 89, 23);

    System.out.println("===== FIND THE LARGEST AND SMALLEST NUMBER =====");

    int maximum = numbers.stream()
            .max(Integer::compareTo)
            .orElseThrow();

    int minimum = numbers.stream()
            .min(Integer::compareTo)
            .orElseThrow();

    System.out.println("Maximum: " + maximum);
    System.out.println("Minium: " + minimum);

    System.out.println();

    // COMBINE VALUE INTO ONE RESULT
    List<Integer> prices = List.of(100, 200, 300, 400);
    
    System.out.println("===== COMBINE VALUE INTO ONE RESULT =====");

    int total = prices.stream()
              .reduce(0, Integer::sum);
    
    System.out.println("Total: " + total);

    System.out.println();

    // GROUP ITEMS BY A CONDITION
    List<String> langs = List.of(
      "Java",
      "Go",
      "Python",
      "C++",
      "Ruby"
    );

    Map<Integer, List<String>> grouped = langs.stream()
                  .collect(Collectors.groupingBy(String::length)); 

    System.out.println(grouped);
  }
}
