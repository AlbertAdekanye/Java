package week02oop.day02;

public class Product {
  
  String name;
  double price;
  String category;
  int quantity;

  public Product(String name, double price, String category, int quantity) {
    this.name = name;
    this.price = price;
    this.category = category;
    this.quantity = quantity;
  }

  void displayInfo() {
    System.out.println("Product Name: " + name);
    System.out.println("Product Price: " + price);
    System.out.println("Product Category: " + category);
    System.out.println("Price Quantity: " + quantity);
  }
}
