package week02oop.day04;

public class Main {

  public static void main(String[] args) {
      
    Car car1 = new Car();
  
    car1.brand = "BMW";
    car1.year = 2025;
    car1.numberOfDoors = 4;

    System.out.println("Brand: " + car1.brand);
    System.out.println("Year: " + car1.year);
    System.out.println("Doors: " + car1.numberOfDoors);

    System.out.println();

    car1.start();
    car1.drive();
    car1.stop();

    // EMPLOYEE
    Developer developer1 = new Developer();

    developer1.name = "Albert";
    developer1.salary = 60000;
    developer1.programmingLanguage = "Java";

    System.out.println();

    developer1.displayWorkerInfo();
    developer1.work();
    developer1.code();

    // ANIMALS
    Dog pet1 = new Dog();
    Cat pet2 = new Cat();

    pet1.name = "Chase";
    pet1.age = 2;

    pet2.name = "Bub";
    pet2.age = 2;

    System.out.println();

    pet1.displayPetInfo();
    pet1.eat();
    pet1.sleep();
    pet1.bark();
    
    System.out.println();
    
    pet2.displayPetInfo();
    pet2.eat();
    pet2.sleep();
    pet2.meow();

  }
}
