// 
package com.codewithkanye.repository;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.codewithkanye.config.Database;
import com.codewithkanye.model.Product;

class ProductRepositoryTest {

    @TempDir
    Path tempDir;

    private ProductRepository repository;
    private String originalDatabaseUrl;

    @BeforeEach
    void setUp() throws Exception {

        originalDatabaseUrl =
                System.getProperty("inventory.db.url");

        String testDatabaseUrl =
                "jdbc:sqlite:" +
                tempDir.resolve("inventory-test.db").toAbsolutePath();

        System.setProperty("inventory.db.url", testDatabaseUrl);

        Database.initialize();

        repository = new ProductRepository();
    }

    @AfterEach
    void tearDown() {

        if (originalDatabaseUrl == null) {
            System.clearProperty("inventory.db.url");
        } else {
            System.setProperty(
                    "inventory.db.url",
                    originalDatabaseUrl
            );
        }
    }

    private Product createProduct() {

        return new Product(
                0,
                "LAP-001",
                "Dell Latitude",
                new BigDecimal("850000.00"),
                10,
                3
        );
    }

    @Test
    void shouldAddProduct() throws SQLException {

        Product saved = repository.addProduct(createProduct());

        assertTrue(saved.id() > 0);
        assertEquals("LAP-001", saved.sku());
        assertEquals("Dell Latitude", saved.name());
    }

    @Test
    void shouldFindAllProducts() throws SQLException {

        repository.addProduct(createProduct());

        Product secondProduct = new Product(
                0,
                "PHN-001",
                "Samsung Phone",
                new BigDecimal("500000.00"),
                15,
                5
        );

        repository.addProduct(secondProduct);

        assertEquals(2, repository.findAll().size());
    }

    @Test
    void shouldFindProductById() throws SQLException {

        Product saved = repository.addProduct(createProduct());

        var result = repository.findById(saved.id());

        assertTrue(result.isPresent());
        assertEquals("LAP-001", result.get().sku());
    }

    @Test
    void shouldFindProductBySku() throws SQLException {

        repository.addProduct(createProduct());

        var result = repository.findBySku("LAP-001");

        assertTrue(result.isPresent());
        assertEquals("Dell Latitude", result.get().name());
    }

    @Test
    void shouldUpdateProduct() throws SQLException {

        Product saved = repository.addProduct(createProduct());

        Product updated = new Product(
                saved.id(),
                saved.sku(),
                "Dell Latitude Updated",
                new BigDecimal("900000.00"),
                999,
                5
        );

        boolean result = repository.updateProduct(updated);

        assertTrue(result);

        Product actual = repository.findById(saved.id()).orElseThrow();

        assertEquals("Dell Latitude Updated", actual.name());
        assertEquals(
                new BigDecimal("900000.00"),
                actual.price()
        );

        // Updating product details must not change stock quantity.
        assertEquals(10, actual.quantity());
    }
    
    @Test
    void shouldDeleteProductWithoutMovementHistory()
            throws SQLException {

        Product saved = repository.addProduct(createProduct());

        boolean result = repository.deleteProduct(saved.id());

        assertTrue(result);
        assertTrue(repository.findById(saved.id()).isEmpty());
    }

    @Test
    void shouldRejectDuplicateSku() throws SQLException {

        repository.addProduct(createProduct());

        Product duplicate = new Product(
                0,
                "LAP-001",
                "Another Laptop",
                new BigDecimal("700000.00"),
                5,
                2
        );

        assertThrows(
                SQLException.class,
                () -> repository.addProduct(duplicate)
        );
    }

    @Test
    void shouldPreventDeletingProductWithMovementHistory()
            throws SQLException {

        Product saved = repository.addProduct(createProduct());

        String sql = """
                INSERT INTO stock_movements
                (product_id, movement_type, quantity, created_at)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setLong(1, saved.id());
            statement.setString(2, "IN");
            statement.setInt(3, 10);
            statement.setString(4, LocalDateTime.now().toString());

            statement.executeUpdate();
        }

        assertThrows(
                SQLException.class,
                () -> repository.deleteProduct(saved.id())
        );

        assertTrue(repository.findById(saved.id()).isPresent());
    }
}
