package week02oop.day02;

public class Car {
  
  String model;
  String brand;
  int year;
  String price;

  Car(String model, String brand, int year, String price) {
    this.model = model;
    this.brand = brand;
    this.year = year;
    this.price = price;
  }

  void displayInfo() {
    System.out.println("Model: " + model);
    System.out.println("Brand: " + brand);
    System.out.println("Year: " + year);
    System.out.println("Price: " + price);
  }
}
