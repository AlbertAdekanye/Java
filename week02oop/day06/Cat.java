package week02oop.day06;

public class Cat extends Animal {
  
  public Cat(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.println(name + " says: Meow!");
  }
}
