
package com.codewithkanye;

import java.sql.SQLException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Database.initialize();
        } catch (IOException | SQLException e) {
            System.out.println("Could not initialize database: "
                    + e.getMessage());
            return;
        }

        TaskManager manager = new TaskManager();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n=== JAVA TASK MANAGER ===");
                System.out.println("1. Add task");
                System.out.println("2. View tasks");
                System.out.println("3. Complete task");
                System.out.println("4. Delete task");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                try {
                    switch (choice) {
                        case "1" -> {
                            System.out.print("Task title: ");
                            String title = scanner.nextLine().trim();

                            if (title.isEmpty()) {
                                System.out.println(
                                        "Title cannot be empty.");
                                break;
                            }

                            System.out.print("Description: ");
                            String description = scanner.nextLine();

                            manager.addTask(title, description);
                        }

                        case "2" -> manager.listTasks();

                        case "3" -> {
                            System.out.print("Task ID: ");
                            int id = Integer.parseInt(
                                    scanner.nextLine().trim());
                            manager.completeTask(id);
                        }

                        case "4" -> {
                            System.out.print("Task ID: ");
                            int id = Integer.parseInt(
                                    scanner.nextLine().trim());
                            manager.deleteTask(id);
                        }

                        case "0" -> {
                            running = false;
                            System.out.println("Goodbye!");
                        }

                        default ->
                                System.out.println("Invalid option.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid task ID.");
                } catch (SQLException e) {
                    System.out.println("Database error: "
                            + e.getMessage());
                }
            }
        }
    }
}
