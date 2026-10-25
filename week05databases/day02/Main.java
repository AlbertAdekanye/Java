package com.codewithkanye;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  
  public static void main(String[] args) {
      
    String url = "jdbc:sqlite:tasks.db";

    String createTableSql = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                description TEXT,
                completed INTEGER NOT NULL DEFAULT 0
            );
            """;

    String insertSql = """
            INSERT INTO task (title, description) 
            VALUES (? ?)
            """;

    try (Connection connection = DriverManager.getConnection(url)) {

      // Create the table if it does'nt exist
      try (Statement statement = connection.createStatement()) {
        statement.execute(createTableSql);
      }

      // prepare the INSERT query
      try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
        
        preparedStatement.setString(1, "Learn Java");
        preparedStatement.setString(2, "Practice JDBC ");

        int rowsInserted = preparedStatement.executeUpdate();

        System.out.println("Rows inserted: " + rowsInserted);
      }

    } catch (SQLException e) {
      System.out.println("DataBase error: " + e.getMessage());
    }
    
  }
}
