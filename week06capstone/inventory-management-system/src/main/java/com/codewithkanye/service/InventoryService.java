package com.codewithkanye.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.codewithkanye.model.Product;
import com.codewithkanye.repository.ProductRepository;

public class InventoryService {
  
  private final ProductRepository productRepository;

  public InventoryService() {
    this.productRepository = new ProductRepository();
  }

  // Add product
  public Product addProduct(Product product) throws SQLException {

    // Validate product details
    if (product.sku() == null || product.sku().isBlank()) {
      throw new IllegalArgumentException("SKU cannot be empty");
    }

    if (product.name() == null || product.name().isBlank()) {
      throw new IllegalArgumentException("Product name cannot be empty");
    }

    if (product.price().signum() < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }

    if (product.quantity() < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }

    // Check whether SKU already exists
    Optional<Product> existingProduct = productRepository.findBySku(product.sku());

    if (existingProduct.isPresent()) {
      throw new IllegalArgumentException("A product with this SKU already exists.");
    }

    return productRepository.addProduct(product);
  }

  // Get all products
  public List<Product> getAllProducts() throws SQLException {
    return productRepository.findAll();
  }

  // Find product by ID
  public Optional<Product> getProductById(long id) throws SQLException {

    if (id <= 0) {
      throw new IllegalArgumentException("Product ID must be positive");
    }

    return productRepository.findById(id);
  }

  // Find product by SKU
  public Optional<Product> getProductBySku(String sku) throws SQLException {

    if (sku == null || sku.isBlank()) {
      throw new IllegalArgumentException("SKU cannot be empty");
    }

    return productRepository.findBySku(sku.trim());
  }
}
