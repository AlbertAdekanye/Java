
package com.codewithkanye;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskManager {

    // 1. Add a new task
    public void addTask(String title, String description)
            throws SQLException {

        String sql = """
                INSERT INTO tasks (title, description)
                VALUES (?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement ps =
                     connection.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, description);

            int rows = ps.executeUpdate();

            System.out.println(rows + " task added.");
        }
    }

    // 2. Display all tasks
    public void listTasks() throws SQLException {

        String sql = """
                SELECT id, title, description, completed
                FROM tasks
                ORDER BY id ASC
                """;

        try (Connection connection = Database.connect();
             PreparedStatement ps =
                     connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("\nID: "
                        + rs.getInt("id"));
                System.out.println("Title: "
                        + rs.getString("title"));
                System.out.println("Description: "
                        + rs.getString("description"));

                String status =
                        rs.getInt("completed") == 1
                                ? "Completed"
                                : "Pending";

                System.out.println("Status: " + status);
            }

            if (!found) {
                System.out.println("No tasks found.");
            }
        }
    }

    // 3. Mark a task as completed
    public void completeTask(int id) throws SQLException {

        String sql = """
                UPDATE tasks
                SET completed = 1
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement ps =
                     connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 1) {
                System.out.println(
                        "Task marked as completed.");
            } else {
                System.out.println("Task ID not found.");
            }
        }
    }

    // 4. Delete a task
    public void deleteTask(int id) throws SQLException {

        String sql = """
                DELETE FROM tasks
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement ps =
                     connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 1) {
                System.out.println(
                        "Task deleted successfully.");
            } else {
                System.out.println("Task ID not found.");
            }
        }
    }
}
