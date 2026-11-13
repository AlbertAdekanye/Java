package com.codewithkanye.ui;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
                    
                    case 3 -> searchProduct();

                    case 4 -> updateProduct();

                    case 5 -> deleteProduct();

                    case 6 -> receiveStock();

                    case 7 -> removeStock();

                    case 8 -> viewLowStockProducts();

                    case 9 -> viewInventoryValue();

                    case 0 -> {
                        running = false;
                        System.out.println("Thank you for using the system!");
                    }

                    case 19 -> 
                        System.out.println("This feature will be implemented next.");

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

    // searchProducts
    private void searchProduct() throws SQLException {

        System.out.println("\n--- SEARCH PRODUCT ---");
        System.out.println("1. Search by Product ID");
        System.out.println("2. Search by Product SKU");
        System.out.println("0. Back to Main Menu");

        int choice = readInt("Choose search method: ");

        Optional<Product> result = Optional.empty();
        switch (choice) {

            case 1 -> {
                long id = readInt("Enter product ID: ");
                result = inventoryService.getProductById(id);
            }

            case 2 -> {
                System.out.println("Enter product SKU: ");
                String sku = scanner.nextLine().trim();

                result = inventoryService.getProductBySku(sku);
            }

            case 0 -> {
                return;
            }

            default -> {
                System.out.println("Invalid search option.");
            }
        }

        if (result.isPresent()) {
            System.out.println("\nProduct found!");
            displayProduct(result.get());
        } else {
            System.out.println("\nNo product found.");
        }
    }

    private void displayProduct(Product product) {

        System.out.println("------------------------------------");
        System.out.println("Product ID: " + product.id());
        System.out.println("SKU: " + product.sku());
        System.out.println("Name: " + product.name());
        System.out.println("Price: " + product.price());
        System.out.println("Quantity: " + product.quantity());
        System.out.println("Low-stock threshold: " + product.lowStockThreshold());
        System.out.println("Inventory value: " + product.getInventoryValue());
        System.out.println("----------------------------------------");
    }

    // updateProduct
    private void updateProduct() throws SQLException {

        System.out.println("\n--- UPDATE PRODUCT ---");

        long id = readInt("Enter product ID to update: ");

        // Find the existing product
        Optional<Product> result = inventoryService.getProductById(id);

        if (result.isEmpty()) {
            System.out.println("Product not found.");
            return;
        }

        Product existingProduct = result.get();

        // Display current product details
        System.out.println("\nCurrent product details:");
        displayProduct(existingProduct);

        System.out.println("\nEnter new details.");
        System.out.println("Press Enter to keep the current value.");

        // Update SKU
        System.out.println("New SKU [" + existingProduct.sku() + "]: ");
        String sku = scanner.nextLine().trim();

        if (sku.isEmpty()) {
            sku = existingProduct.sku();
        }

        // Update name
        System.out.println("New name [" + existingProduct.name() + "]: " );
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            name = existingProduct.name();
        }

        // Update price
        System.out.println("New price [" + existingProduct.price() + "]: ");
        String priceInput = scanner.nextLine().trim();

        BigDecimal price = priceInput.isEmpty()
                ? existingProduct.price()
                : new BigDecimal(priceInput);
        
        // Update low-stock threshold
        System.out.println("New low-stock threshold [" 
                    + existingProduct.lowStockThreshold() + "]: ");
        
        String thresholdInput = scanner.nextLine().trim();

        int threshold = thresholdInput.isEmpty()
                    ? existingProduct.lowStockThreshold()
                    : Integer.parseInt(thresholdInput);

        // Create updated product
        Product updatedProduct = new Product(
            existingProduct.id(),
            sku,
            name,
            price,
            existingProduct.quantity(),
            threshold
        );

        // Save changes
        boolean updated = inventoryService.updateProduct(updatedProduct);

        if (updated) {
            System.out.println("\nProduct updated successfully!");
            displayProduct(updatedProduct);
        } else {
            System.out.println("\nProduct update failed.");
        }
    }

    // Delete product
    private void deleteProduct() throws SQLException {

        System.out.println("\n---- DELETE PRODUCT ----");

        long id = readInt("Enter product ID to delete: ");

        Optional<Product> result = inventoryService.getProductById(id);

        if (result.isEmpty()) {
            System.out.println("Product not found.");
            return;
        }

        Product product = result.get();

        System.out.println("\nProduct selected for deletion: ");
        displayProduct(product);

        System.out.println("Are sure you want to delete this product? (yes/no): ");

        String confirmation = scanner.nextLine().trim();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Product deletion cancelled.");
            return;
        }

        boolean deleted = inventoryService.deleteProduct(id);

        if (deleted) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product deletion failed.");
        }
    }

    // Receive stock
    private void receiveStock() throws SQLException {
        
        System.out.println("\n--- RECEIVE STOCK ---");

        long productId = readInt("Enter product ID: ");

        Optional<Product> result = inventoryService.getProductById(productId);

        if (result.isEmpty()) {
            System.out.println("Product not found.");
        }

        Product product = result.get();

        System.out.println("\nSelected product: ");
        displayProduct(product);

        int quantity = readInt("Enter quantity received: ");

        inventoryService.receiveStock(productId, quantity);

        System.out.println("\nStock received successfully!");

        // Retrieve the updated product from the database
        Product updateProduct = inventoryService.getProductById(productId).orElseThrow();

        displayProduct(updateProduct);
    }

    // Remove stock
 
    private void removeStock() throws SQLException {

        System.out.println("\n--- REMOVE STOCK ---");

        long productId = readInt("Enter product ID: ");

        Optional<Product> result =
                inventoryService.getProductById(productId);

        if (result.isEmpty()) {
            System.out.println("Product not found. Please check the product ID.");
            return;
        }

        Product product = result.get();

        System.out.println("\nSelected product:");
        displayProduct(product);

        int quantity = readInt("Enter quantity to remove: ");

        inventoryService.removeStock(productId, quantity);

        System.out.println("\nStock removed successfully!");

        Optional<Product> updatedResult =
                inventoryService.getProductById(productId);

        if (updatedResult.isPresent()) {
            displayProduct(updatedResult.get());
        }
    }

    // view low stock products
    private void viewLowStockProducts() throws SQLException {

        System.out.println("\n--- LOW-STOCK PRODUCTS ---");

        List<Product> products = inventoryService.getLowStockProducts();

        if (products.isEmpty()) {
            System.out.println("NO low-stock products found.");
            return;
        }

        System.out.println("Products that need restocking.");

        for (Product product : products) {
            displayProduct(product);
        }

        System.out.println("Total low-stock products: " + products.size());
    }

    public void viewInventoryValue() throws SQLException {

        System.out.println("\n--- INVENTORY VALUE ---");

        BigDecimal totalValue =
                inventoryService.getTotalInventoryValue();

        System.out.println("Total Inventory Value: " + totalValue);
    }
}