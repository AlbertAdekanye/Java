package com.codewithkanye.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

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

  // Update product details
  public boolean updateProduct(Product product) throws SQLException {

      if (product == null) {
          throw new IllegalArgumentException("Product cannot be null.");
      }

      if (product.id() <= 0) {
          throw new IllegalArgumentException("Product ID must be positive.");
      }

      if (product.sku() == null || product.sku().isBlank()) {
          throw new IllegalArgumentException("SKU cannot be empty.");
      }

      if (product.name() == null || product.name().isBlank()) {
          throw new IllegalArgumentException("Product name cannot be empty.");
      }

      if (product.price() == null || product.price().signum() < 0) {
          throw new IllegalArgumentException("Price cannot be negative or null.");
      }

      if (product.lowStockThreshold() < 0) {
          throw new IllegalArgumentException("Low-stock threshold cannot be negative.");
      }

      // Confirm that the product exists
      Optional<Product> existingProduct =
              productRepository.findById(product.id());

      if (existingProduct.isEmpty()) {
          return false;
      }

      // Check whether another product is already using this SKU
      Optional<Product> productWithSku =
              productRepository.findBySku(product.sku());

      if (productWithSku.isPresent()
              && productWithSku.get().id() != product.id()) {
          throw new IllegalArgumentException(
                  "Another product is already using this SKU."
          );
      }

      // Preserve the existing stock quantity
      Product updatedProduct = new Product(
              product.id(),
              product.sku(),
              product.name(),
              product.price(),
              existingProduct.get().quantity(),
              product.lowStockThreshold()
      );

      return productRepository.updateProduct(updatedProduct);
  }

  // Delete product
  public boolean deleteProduct(long id) throws SQLException {

    if (id <= 0) {
        throw new IllegalArgumentException(
                "Product ID must be positive."
        );
    }
  
    Optional<Product> existingProduct =
            productRepository.findById(id);
  
    if (existingProduct.isEmpty()) {
        return false;
    }
  
    return productRepository.deleteProduct(id);
  }

    // Get low-stock products
  public List<Product> getLowStockProducts() throws SQLException {
  
      return productRepository.findAll()
              .stream()
              .filter(Product::isLowStock)
              .toList();
  }
  
  // Calculate total inventory value
  public BigDecimal getTotalInventoryValue() throws SQLException {
  
      return productRepository.findAll()
              .stream()
              .map(Product::getInventoryValue)
              .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
