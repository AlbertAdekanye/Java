
package com.codewithkanye;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        
        try (Connection connection = Database.connect()) {
            System.out.println("Connected to SQLite successfully!");
            System.out.println("Database: " + connection.getMetaData().getURL());
        } catch (SQLException exception) {
            System.out.println("Database connection failed.");
            exception.printStackTrace();
        }

        
    }
}
