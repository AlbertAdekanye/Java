
package com.codewithkanye.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codewithkanye.config.Database;
import com.codewithkanye.model.Product;

public class ProductRepository {

    // Add a product to the database
    public Product addProduct(Product product) throws SQLException {

        String sql = """
                INSERT INTO products (sku, name, price, quantity, low_stock_threshold)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.sku());
            statement.setString(2, product.name());
            statement.setString(3, product.price().toPlainString());
            statement.setInt(4, product.quantity());
            statement.setInt(5, product.lowStockThreshold());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {

                if (generatedKeys.next()) {

                    long id = generatedKeys.getLong(1);

                    return new Product(
                            id,
                            product.sku(),
                            product.name(),
                            product.price(),
                            product.quantity(),
                            product.lowStockThreshold()
                    );
                }
            }
        }

        throw new SQLException("Creating product failed. No ID returned.");
    }
}
