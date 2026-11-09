package com.codewithkanye.ui;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.codewithkanye.model.Product;
import com.codewithkanye.service.InventoryService;

public class ConsoleUI {

    private final Scanner scanner;
    private final InventoryService inventoryService;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.inventoryService = new InventoryService();
    }

    // Start the application
    public void start() {

        boolean running = true;

        System.out.println("\nWelcome to Inventory Management System!");

        while (running) {

            displayMenu();

            int choice = readInt("Choose an option: ");

            try {
                switch (choice) {

                    case 1 -> addProduct();

                    case 2 -> viewAllProducts();

                    case 0 -> {
                        running = false;
                        System.out.println("Thank you for using the system!");
                    }

                    default -> System.out.println(
                            "Invalid option. Please try again."
                    );
                }

            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Display application menu
    private void displayMenu() {

        System.out.println("\n====================================");
        System.out.println("     INVENTORY MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Search Product");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Receive Stock");
        System.out.println("7. Remove Stock");
        System.out.println("8. View Low-Stock Products");
        System.out.println("9. View Inventory Value");
        System.out.println("10. View Stock Movement History");
        System.out.println("0. Exit");
        System.out.println("====================================");
    }

    // Read integer input safely
    private int readInt(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Add a new product
    private void addProduct() throws SQLException {

        System.out.println("\n--- ADD PRODUCT ---");

        System.out.print("Enter SKU: ");
        String sku = scanner.nextLine().trim();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine().trim());

        int quantity = readInt("Enter initial quantity: ");

        int threshold = readInt("Enter low-stock threshold: ");

        Product product = new Product(
                0,
                sku,
                name,
                price,
                quantity,
                threshold
        );

        Product savedProduct = inventoryService.addProduct(product);

        System.out.println("\nProduct added successfully!");
        System.out.println("Product ID: " + savedProduct.id());
        System.out.println("SKU: " + savedProduct.sku());
        System.out.println("Name: " + savedProduct.name());
    }

    // View all products
    private void viewAllProducts() throws SQLException {

        System.out.println("\n--- ALL PRODUCTS ---");

        List<Product> products = inventoryService.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        for (Product product : products) {

            System.out.println("------------------------------------");
            System.out.println("ID: " + product.id());
            System.out.println("SKU: " + product.sku());
            System.out.println("Name: " + product.name());
            System.out.println("Price: " + product.price());
            System.out.println("Quantity: " + product.quantity());
            System.out.println(
                    "Low-stock threshold: " + product.lowStockThreshold()
            );
        }

        System.out.println("------------------------------------");
    }
}