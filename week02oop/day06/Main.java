package week02oop.day06;

public class Main {
  
  public static void main(String[] args) {

    Animal dog = new Dog("Chase");
    Animal cat = new Cat("Bub");

    dog.makeSound();
    dog.sleep();

    System.out.println();

    cat.makeSound();
    cat.sleep();
  }
}
