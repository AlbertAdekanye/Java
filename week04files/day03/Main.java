package week04files.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    
    List<String> languages = new ArrayList<>();

    languages.add("Java");
    languages.add("JavaSctipt");
    languages.add("Python");
    languages.add("C++");
    languages.add("TypeScript");

    languages.stream()
             .filter(language -> language.contains("J"))
             .map(language -> language.toUpperCase())
             .forEach(System.out::println);

    List<String> javaLanguages = languages.stream()
              .filter(language -> language.startsWith("J"))
              .collect(Collectors.toList());
    System.out.println(javaLanguages);
  }
}
