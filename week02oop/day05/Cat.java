package week02oop.day05;

public class Cat extends Animal {

  @Override
  public void makeSound() {
    System.out.println(name + " says: Meow!");
  }
}