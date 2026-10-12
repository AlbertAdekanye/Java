package week04files.day04.exercises;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> languages = List.of(
            "Java",
            "Python",
            "Java",
            "JavaScript",
            "Python",
            "Go",
            "Kotlin",
            "Ruby",
            "Go"
        );

        List<Integer> numbers = List.of(
            10, 25, 5, 40, 15, 25
        );

        // TASK 1: Remove duplicate languages
        System.out.println("===== REMOVE DUPLICATE =====");

        List<String> duplicateLanguages = languages.stream()
                          .distinct()
                          .toList();

        System.out.println(duplicateLanguages);

        System.out.println();

        // TASK 2: Find the largest number
        System.out.println("===== FIND THE LARGEST NUMBER =====");

        int maximum = numbers.stream()
                  .max(Integer::compareTo)
                  .orElseThrow();

        System.out.println(maximum);

        // TASK 3: Find the smallest number
        System.out.println("===== FIND THE SMALLEST NUMBER =====");

        int minimum = numbers.stream()
                  .min(Integer::compareTo)
                  .orElseThrow();

        System.out.println(minimum);

        System.out.println();

        // TASK 4: Calculate the sum of all numbers
        // Hint: reduce()
        System.out.println("===== COMBINE VALUE INTO ONE RESULT =====");

        int total = numbers.stream()
                 .reduce(0, Integer::sum);

        System.out.println("Total: " + total);

        System.out.println();

        // TASK 5: Calculate the average
        // Hint: mapToInt() and average()
        System.out.println("===== CALCULATE THE AVERAGE =====");

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
            
        System.out.println("Average: " + average);

        System.out.println();

        // TASK 6: Group languages by their length
        // Hint: Collectors.groupingBy()
        System.out.println("===== GROUP LANGUAGE BY THEIR LENGTH");

        Map<Integer, List<String>> grouped = languages.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(grouped);

        System.out.println();

        // TASK 7: Get unique languages, convert them to uppercase,
        // sort them alphabetically, and collect them into a list.

        System.out.println("===== UNIQUE, UPPERCASE, SORTED =====");

        List<String> results = languages.stream()
                    .distinct()
                    .map(String::toUpperCase)
                    .sorted()
                    .toList();

        System.out.println(results);

    }
}
