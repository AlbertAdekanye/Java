package week03collections.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

       ArrayList<String> programmingLanguages = new ArrayList<>();

       System.out.println("========PROGRAMMING lANGUAGES========");

       programmingLanguages.add("Java");
       programmingLanguages.add("JavaScript");
       programmingLanguages.add("GO");
       programmingLanguages.add("Python");
       programmingLanguages.add("C++");
       programmingLanguages.add("C");

       for (String language : programmingLanguages) {
        System.out.println(language);
       }

       System.out.println();

    //    HashSet
       HashSet<String> countries = new HashSet<>();

       System.out.println("======== COUNTRIES =======");

       countries.add("Nigeria");
       countries.add("Canada");
       countries.add("Germany");
       countries.add("Japan");
       countries.add("Nigeria");
       countries.add("Ghana");

       for (String country : countries) {
        System.out.println(country);
       }

       System.out.println();

    //HashMap
       HashMap<Integer, String> students = new HashMap<>();

       students.put(101, "Albert");
       students.put(102, "Adesoye");
       students.put(103, "John");
       students.put(104, "David");
       students.put(105, "Michael");

       for (Map.Entry<Integer, String> entry : students.entrySet()) {
        System.out.println(
            entry.getKey() + " -> " + entry.getValue()
        );
       }

       System.out.println();

       System.out.println("======= Key =======");
       for (Integer id : students.keySet()) {
         System.out.println(id);
       }

       System.out.println();
       System.out.println("======= Values =======");
       
       for (String name : students.values()) {
         System.out.println(name);
       }

       System.out.println();

       System.out.println("======== ITERATING CONDITION IF");
       for (Map.Entry<Integer, String> entry : students.entrySet()) {

        if (entry.getValue().startsWith("A")) {
            System.out.println(
                entry.getKey() + " -> " + entry.getValue()
            );
        }
      }
       
       System.out.println();

       System.out.println("======= ITERATOR ======");

       //  Iterator
      HashSet<String> names = new HashSet<>();

      names.add("Albert");
      names.add("Adesoye");
      names.add("John");
      names.add("Michael");
      names.add("David");
      Iterator<String> iterator = names.iterator();
          
      while (iterator.hasNext()) {
          String name = iterator.next();
          System.out.println(name);
      }
    }

}