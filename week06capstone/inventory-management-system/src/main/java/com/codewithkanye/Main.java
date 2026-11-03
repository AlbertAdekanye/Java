
package com.codewithkanye;

import com.codewithkanye.config.Database;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Database.initialize();

            System.out.println("Inventory Management System is ready.");

        } catch (IOException | SQLException e) {
            System.out.println("Database initialization failed.");
            e.printStackTrace();
        }
    }
}
