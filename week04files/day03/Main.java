
package week04files.day03;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> languages = List.of(
            "Java",
            "JavaScript",
            "Python",
            "C++",
            "TypeScript",
            "Go",
            "Kotlin",
            "Ruby"
        );

        // Exercise 1: Print every language
        System.out.println("===== ALL LANGUAGES =====");

        languages.stream()
                 .forEach(System.out::println);

        // Exercise 2: Filter languages starting with J
        System.out.println("\n===== STARTS WITH J =====");

        languages.stream()
                 .filter(language -> language.startsWith("J"))
                 .forEach(System.out::println);

        // Exercise 3: Convert languages to uppercase
        System.out.println("\n===== UPPERCASE =====");

        languages.stream()
                 .map(language -> language.toUpperCase())
                 .forEach(System.out::println);

        // Exercise 4: Collect languages longer than 4 characters
        System.out.println("\n===== LENGTH GREATER THAN 4 =====");

        List<String> longLanguages = languages.stream()
                .filter(language -> language.length() > 4)
                .toList();

        System.out.println(longLanguages);

        // Exercise 5: Count languages longer than 4 characters
        System.out.println("\n===== COUNT =====");

        long count = languages.stream()
                .filter(language -> language.length() > 4)
                .count();

        System.out.println("Count: " + count);

        // Exercise 6: Filter, uppercase, sort, and collect
        System.out.println("\n===== COMBINED OPERATIONS =====");

        List<String> results = languages.stream()
                .filter(language -> language.length() > 4)
                .map(language -> language.toUpperCase())
                .sorted()
                .toList();

        System.out.println(results);
    }
}
