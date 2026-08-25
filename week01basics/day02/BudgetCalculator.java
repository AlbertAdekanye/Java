package week01basics.day02;

import java.util.Scanner;

public class BudgetCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== MONTHLY BUDGET CALCULATOR =====");
        System.out.println();

        // Collect user information
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();

        System.out.print("Enter your monthly rent: ");
        double rent = scanner.nextDouble();

        System.out.print("Enter your food expenses: ");
        double foodExpenses = scanner.nextDouble();

        System.out.print("Enter your transport expenses: ");
        double transportExpenses = scanner.nextDouble();

        System.out.print("Enter your other expenses: ");
        double otherExpenses = scanner.nextDouble();

        // Perform calculations
        double totalExpenses =
                rent + foodExpenses + transportExpenses + otherExpenses;

        double remainingBalance = income - totalExpenses;

        double savingsPercentage =
                (remainingBalance / income) * 100;

        // Display results
        System.out.println();
        System.out.println("===== BUDGET SUMMARY =====");
        System.out.println("Name: " + name);
        System.out.println("Monthly income: " + income);
        System.out.println("Total expenses: " + totalExpenses);
        System.out.println("Remaining balance: " + remainingBalance);
        System.out.println("Savings percentage: " + savingsPercentage + "%");
        System.out.println("==========================");

        scanner.close();
    }
}