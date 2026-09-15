package week02oop.day03;

public class Product {
  
  private String name;
  double price;
  private String category;
  private int quantity;

  public Product(String name, double price, String category, int quantity) {
    this.name = name;
    this.price = price;
    this.category = category;
    this.quantity = quantity;
  }

  // create GETTERS
  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  public int getQuantity() {
    return quantity;
  }

  // create SETTERS
  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    if (price > 0) {

    }
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setQuantity(int quantity) {
    if (quantity >= 0 ) {

    }
  }

  public void displayProduct() {
    System.out.println("Product Name: " + name);
    System.out.println("Product Price: " + price);
    System.out.println("Product Category: " + category);
    System.out.println("Product Quantity: " + quantity);
  }
}
