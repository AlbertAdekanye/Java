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
  }
}
