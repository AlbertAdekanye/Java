package week02oop.day04;

public class Animal {
  
  String name;
  int age;

  void eat() {
    System.out.println(name + " is eating.....");
  }

  void sleep() {
    System.out.println(name + " is sleeping");
  }

  void displayPetInfo() {
    System.out.println(name );
    System.out.println(age );
  }
}
