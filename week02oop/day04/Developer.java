package week02oop.day04;

public class Developer extends Employee {
  
  String programmingLanguage;

  void code() {
    System.out.println(name + " is coding in " + programmingLanguage);
  }
}
