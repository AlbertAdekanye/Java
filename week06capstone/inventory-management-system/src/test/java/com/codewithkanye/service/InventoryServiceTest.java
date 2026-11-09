package com.codewithkanye.service;

import com.codewithkanye.config.Database;
import com.codewithkanye.model.Product;
import com.codewithkanye.model.StockMovement;
import com.codewithkanye.model.MovementType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    @TempDir
    Path tempDir;

    private InventoryService service;
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

        service = new InventoryService();
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

    private Product createProduct() throws SQLException {

        Product product = new Product(
                0,
                "LAP-001",
                "Dell Latitude",
                new BigDecimal("850000.00"),
                10,
                3
        );

        return service.addProduct(product);
    }

    @Test
    void shouldReceiveStock() throws SQLException {

        Product saved = createProduct();

        service.receiveStock(saved.id(), 5);

        Product updated = service.getProductById(saved.id())
                .orElseThrow();

        assertEquals(15, updated.quantity());

        List<StockMovement> history =
                service.getStockHistory(saved.id());

        assertEquals(1, history.size());
        assertEquals(MovementType.IN, history.get(0).type());
        assertEquals(5, history.get(0).quantity());
    }

    @Test
    void shouldRemoveStock() throws SQLException {

        Product saved = createProduct();

        service.removeStock(saved.id(), 4);

        Product updated = service.getProductById(saved.id())
                .orElseThrow();

        assertEquals(6, updated.quantity());

        List<StockMovement> history =
                service.getStockHistory(saved.id());

        assertEquals(1, history.size());
        assertEquals(MovementType.OUT, history.get(0).type());
        assertEquals(4, history.get(0).quantity());
    }

    @Test
    void shouldRejectRemovingMoreStockThanAvailable()
            throws SQLException {

        Product saved = createProduct();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.removeStock(saved.id(), 15)
        );

        Product unchanged = service.getProductById(saved.id())
                .orElseThrow();

        assertEquals(10, unchanged.quantity());

        assertTrue(service.getStockHistory(saved.id()).isEmpty());
    }

    @Test
    void shouldRejectZeroStockMovement() throws SQLException {

        Product saved = createProduct();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.receiveStock(saved.id(), 0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.removeStock(saved.id(), 0)
        );

        Product unchanged = service.getProductById(saved.id())
                .orElseThrow();

        assertEquals(10, unchanged.quantity());
        assertTrue(service.getStockHistory(saved.id()).isEmpty());
    }

    @Test
    void shouldRejectStockMovementForMissingProduct() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.receiveStock(999, 5)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.removeStock(999, 5)
        );
    }
}