
package com.codewithkanye;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final ExpenseTracker TRACKER = new ExpenseTracker();

    private static final ExpenseFileRepository REPOSITORY =
            new ExpenseFileRepository(
                    Path.of("data", "expenses.csv")
            );

    public static void main(String[] args) {
        loadExpenses();

        boolean running = true;

        while (running) {
            showMenu();

            String choice = SCANNER.nextLine().trim();

            switch (choice) {
                case "1" -> addExpense();
                case "2" -> viewExpenses();
                case "3" -> viewTotal();
                case "4" -> filterByCategory();
                case "5" -> saveExpenses();
                case "6" -> {
                    saveExpenses();
                    running = false;
                    System.out.println("Thank you for using Expense Tracker!");
                }
                default -> System.out.println(
                        "Invalid option. Please enter a number from 1 to 6."
                );
            }

            System.out.println();
        }

        SCANNER.close();
    }

    private static void showMenu() {
        System.out.println("====================================");
        System.out.println("         EXPENSE TRACKER");
        System.out.println("====================================");
        System.out.println("  1. Add expense");
        System.out.println("  2. View all expenses");
        System.out.println("  3. View total spending");
        System.out.println("  4. Filter by category");
        System.out.println("  5. Save expenses");
        System.out.println("  6. Save and exit");
        System.out.println("====================================");
        System.out.print("Choose an option: ");
    }

    private static void addExpense() {
        try {
            String description = readRequiredText("Description: ");
            double amount = readAmount();
            String category = readRequiredText("Category: ");
            LocalDate date = readDate();

            int nextId = TRACKER.getExpenses().stream()
                    .mapToInt(Expense::getId)
                    .max()
                    .orElse(0) + 1;

            Expense expense = new Expense(
                    nextId,
                    description,
                    amount,
                    category,
                    date
            );

            TRACKER.addExpense(expense);

            System.out.println("Expense added successfully.");
            System.out.printf("Expense ID: %d%n", expense.getId());

        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid input: " + exception.getMessage());
        }
    }

    private static String readRequiredText(String prompt) {
        System.out.print(prompt);
        String value = SCANNER.nextLine().trim();

        if (value.isBlank()) {
            throw new IllegalArgumentException(
                    "This field cannot be empty."
            );
        }

        return value;
    }

    private static double readAmount() {
        System.out.print("Amount (NGN): ");
        String input = SCANNER.nextLine().trim();

        try {
            double amount = Double.parseDouble(input);

            if (!Double.isFinite(amount) || amount <= 0) {
                throw new IllegalArgumentException(
                        "Amount must be a finite number greater than zero."
                );
            }

            return amount;

        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Enter a valid number, for example 2500 or 2500.50."
            );
        }
    }

    private static LocalDate readDate() {
        System.out.print("Date (YYYY-MM-DD): ");
        String input = SCANNER.nextLine().trim();

        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException(
                    "Enter a valid date in YYYY-MM-DD format."
            );
        }
    }

    private static void viewExpenses() {
        List<Expense> expenses = TRACKER.getExpenses();

        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("============== YOUR EXPENSES ==============");

        System.out.printf(
                "%-5s %-12s %-24s %-16s %12s%n",
                "ID", "DATE", "DESCRIPTION", "CATEGORY", "AMOUNT (NGN)"
        );

        System.out.println("-".repeat(75));

        for (Expense expense : expenses) {
            System.out.printf(
                    "%-5d %-12s %-24.24s %-16.16s %,12.2f%n",
                    expense.getId(),
                    expense.getDate(),
                    expense.getDescription(),
                    expense.getCategory(),
                    expense.getAmount()
            );
        }

        System.out.println("-".repeat(75));
        System.out.printf(
                "Number of expenses: %d%n",
                expenses.size()
        );
    }

    private static void viewTotal() {
        System.out.println("============== SPENDING SUMMARY ==============");

        System.out.printf(
                "Total spending: NGN %,.2f%n",
                TRACKER.getTotalExpenses()
        );

        System.out.printf(
                "Number of expenses: %d%n",
                TRACKER.getExpenses().size()
        );
    }

    private static void filterByCategory() {
        try {
            String category = readRequiredText("Enter category: ");

            List<Expense> matches =
                    TRACKER.getExpensesByCategory(category);

            if (matches.isEmpty()) {
                System.out.println(
                        "No expenses found for category: " + category
                );
                return;
            }

            System.out.println("Expenses in category: " + category);

            for (Expense expense : matches) {
                System.out.printf(
                        "%s | %s | NGN %,.2f%n",
                        expense.getDate(),
                        expense.getDescription(),
                        expense.getAmount()
                );
            }

            double total = matches.stream()
                    .mapToDouble(Expense::getAmount)
                    .sum();

            System.out.printf("Category total: NGN %,.2f%n", total);

        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid input: " + exception.getMessage());
        }
    }

    private static void saveExpenses() {
        try {
            REPOSITORY.save(TRACKER.getExpenses());
            System.out.println("Expenses saved successfully.");
        } catch (IOException exception) {
            System.out.println(
                    "Could not save expenses: " + exception.getMessage()
            );
        }
    }

    private static void loadExpenses() {
        try {
            List<Expense> savedExpenses = REPOSITORY.load();

            for (Expense expense : savedExpenses) {
                TRACKER.addExpense(expense);
            }

            System.out.printf(
                    "Loaded %d saved expense(s).%n",
                    savedExpenses.size()
            );

        } catch (IOException | IllegalArgumentException exception) {
            System.out.println(
                    "Could not load expense data: " + exception.getMessage()
            );
        }
    }
}
