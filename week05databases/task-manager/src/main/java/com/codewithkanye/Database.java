
package com.codewithkanye;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Database {

    private static final String DATABASE_URL =
            "jdbc:sqlite:data/tasks.db";

    public static Connection connect() throws SQLException {
        try {
            Files.createDirectories(Path.of("data"));
        } catch (java.io.IOException exception) {
            throw new SQLException(
                    "Could not create the database directory.",
                    exception
            );
        }

        return DriverManager.getConnection(DATABASE_URL);
    }

    // Create the tasks table if it doesn't exist
    public static void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS tasks (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    description TEXT,
                    completed INTEGER NOT NULL DEFAULT 0,
                    created_at TEXT NOT NULL
                )
                """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Tasks table is ready!");
        }
    }

    // Insert a new task into the database
    public static void insertTask(
            String title,
            String description
    ) throws SQLException {

        String sql = """
                INSERT INTO tasks (title, description, created_at)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, LocalDateTime.now().toString());

            statement.executeUpdate();

            System.out.println("Task created successfully!");
        }
    }
}
