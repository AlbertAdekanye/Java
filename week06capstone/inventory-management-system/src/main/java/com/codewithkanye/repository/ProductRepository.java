
package com.codewithkanye.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    // Retrieve all products
    public List<Product> findAll() throws SQLException {

        String sql = """
                SELECT * FROM products
                ORDER BY id ASC
                """;
        
        List<Product> products = new ArrayList<>();

        try (Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
            
                    Product product = new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("sku"),
                        resultSet.getString("name"),
                        new BigDecimal(resultSet.getString("price")),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("low_stock_threshold")
                    );
            
                        products.add(product);
                    }
            }

        return products;
    }

    // Find a product by its ID
    public Optional<Product> findById(long id) throws SQLException {

        String sql = """
                SELECT * FROM products
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Product product = new Product(
                            resultSet.getLong("id"),
                            resultSet.getString("sku"),
                            resultSet.getString("name"),
                            new BigDecimal(resultSet.getString("price")),
                            resultSet.getInt("quantity"),
                            resultSet.getInt("low_stock_threshold")
                    );

                    return Optional.of(product);
                }
            }
        }

        return Optional.empty();
    }

    // Find a product by SKU
    public Optional<Product> findBySku(String sku) throws SQLException {

        String sql = """
                SELECT * FROM products
                WHERE sku = ?
                """;

        try (Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, sku);

                try (ResultSet resultSet = statement.executeQuery()) {

                    if (resultSet.next()) {

                        Product product = new Product(
                            resultSet.getLong("id"),
                            resultSet.getString("sku"),
                            resultSet.getString("name"),
                            new BigDecimal(resultSet.getString("price")),
                            resultSet.getInt("quantity"),
                            resultSet.getInt("low_stock_threshold")
                        );

                        return Optional.of(product);
                }
            }
        }

        return Optional.empty();
    }
 
    // Update product details without changing stock quantity
    public boolean updateProduct(Product product) throws SQLException {

        String sql = """
                UPDATE products
                SET sku = ?,
                    name = ?,
                    price = ?,
                    low_stock_threshold = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, product.sku());
            statement.setString(2, product.name());
            statement.setString(3, product.price().toPlainString());
            statement.setInt(4, product.lowStockThreshold());
            statement.setLong(5, product.id());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        }
    }

    // Delete a product by ID
    public boolean deleteProduct(long id) throws SQLException {

        String sql = """
                DELETE FROM products
                WHERE id = ? 
                """;

        try (Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setLong(1, id);

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
        }
    }

// Update product quantity using an existing database connection
    public boolean updateQuantity(
            Connection connection,
            long productId,
            int newQuantity
    ) throws SQLException {

        String sql = """
                UPDATE products
                SET quantity = ?
                WHERE id = ?
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, newQuantity);
            statement.setLong(2, productId);

            return statement.executeUpdate() > 0;
        }
    }
}
