package week02oop.day05;

public class Dog extends Animal{
  
  @Override
  void makeSound() {
    System.out.println(name + " says: Woof!");
  }
}
