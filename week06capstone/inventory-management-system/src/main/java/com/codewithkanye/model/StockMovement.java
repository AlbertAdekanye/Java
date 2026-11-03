
package com.codewithkanye.model;

import java.time.LocalDateTime;

public record StockMovement(
        long id,
        long productId,
        MovementType type,
        int quantity,
        LocalDateTime createdAt
) {

    public StockMovement {
        if (id < 0) {
            throw new IllegalArgumentException(
                    "Movement ID cannot be negative.");
        }

        if (productId <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be positive.");
        }

        if (type == null) {
            throw new IllegalArgumentException(
                    "Movement type cannot be null.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Movement quantity must be positive.");
        }

        if (createdAt == null) {
            throw new IllegalArgumentException(
                    "Movement date cannot be null.");
        }
    }
}
