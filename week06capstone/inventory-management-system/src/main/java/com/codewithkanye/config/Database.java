
package com.codewithkanye.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:data/inventory.db";

    // Open a connection to SQLite
    public static Connection connect() throws SQLException {

        Connection connection = DriverManager.getConnection(URL);

        // Enable foreign-key enforcement for this connection
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
            return connection;
        } catch (SQLException e) {
            connection.close();
            throw e;
        }
    }

    // Create the database and its tables
    public static void initialize() throws IOException, SQLException {

        // Create the data directory if it does not exist
        Files.createDirectories(Path.of("data"));

        String createProductsTable = """
                CREATE TABLE IF NOT EXISTS products (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    sku TEXT NOT NULL UNIQUE,
                    name TEXT NOT NULL,
                    price TEXT NOT NULL,
                    quantity INTEGER NOT NULL DEFAULT 0,
                    low_stock_threshold INTEGER NOT NULL DEFAULT 5,

                    CHECK (length(trim(sku)) > 0),
                    CHECK (length(trim(name)) > 0),
                    CHECK (quantity >= 0),
                    CHECK (low_stock_threshold >= 0)
                );
                """;

        String createStockMovementsTable = """
                CREATE TABLE IF NOT EXISTS stock_movements (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    product_id INTEGER NOT NULL,
                    movement_type TEXT NOT NULL,
                    quantity INTEGER NOT NULL,
                    created_at TEXT NOT NULL,

                    FOREIGN KEY (product_id)
                        REFERENCES products(id)
                        ON DELETE RESTRICT,

                    CHECK (movement_type IN ('IN', 'OUT')),
                    CHECK (quantity > 0)
                );
                """;

        String createMovementIndex = """
                CREATE INDEX IF NOT EXISTS idx_stock_movements_product_id
                ON stock_movements(product_id);
                """;

        // Execute the SQL statements
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(createProductsTable);
            statement.execute(createStockMovementsTable);
            statement.execute(createMovementIndex);

        }

        System.out.println("Database initialized successfully.");
    }
}
