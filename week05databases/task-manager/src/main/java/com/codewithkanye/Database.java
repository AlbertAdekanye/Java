
package com.codewithkanye;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:data/tasks.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() throws IOException, SQLException {
        Files.createDirectories(Path.of("data"));

        String sql = """
                CREATE TABLE IF NOT EXISTS tasks (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    description TEXT,
                    completed INTEGER NOT NULL DEFAULT 0
                )
                """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
        }
    }
}
