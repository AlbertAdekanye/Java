package week02oop.day05;

public class Bird extends Animal {
  
  @Override 
  public void makeSound() {
    System.out.println(name + " says: Chirp!");
  }
}
