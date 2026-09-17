package week02oop.day06;

abstract public class Animal {
  
  String name;

  public Animal(String name) {
    this.name = name;
  }

  public void sleep() {
    System.out.println(name + " is sleeping.");
  }

  public abstract void makeSound();
}
