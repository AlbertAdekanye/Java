
package com.codewithkanye.model;

import java.math.BigDecimal;

public record Product(
        long id,
        String sku,
        String name,
        BigDecimal price,
        int quantity,
        int lowStockThreshold
) {

    public Product {
        if (id < 0) {
            throw new IllegalArgumentException(
                    "Product ID cannot be negative.");
        }

        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException(
                    "SKU cannot be empty.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty.");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative or null.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative.");
        }

        if (lowStockThreshold < 0) {
            throw new IllegalArgumentException(
                    "Low-stock threshold cannot be negative.");
        }

        sku = sku.trim();
        name = name.trim();
    }

    public boolean isLowStock() {
        return quantity <= lowStockThreshold;
    }

    public BigDecimal getInventoryValue() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
