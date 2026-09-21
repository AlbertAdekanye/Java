package week03collections.day02;

import java.util.HashSet;

public class Main {
  
  public static void main(String[] args) {
      
    HashSet<String> names = new HashSet<>();

    names.add("Albert");
    names.add("Adesoye");
    names.add("Adekanye");

    names.add("Jea");
    System.out.println(names);
    System.out.println(names.size());
  }
}
