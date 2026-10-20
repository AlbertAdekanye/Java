
package com.codewithkanye;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
