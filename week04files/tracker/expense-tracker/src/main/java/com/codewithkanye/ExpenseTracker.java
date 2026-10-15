package com.codewithkanye;

import java.util.ArrayList;
import java.util.List;
public class ExpenseTracker {
  
  private final List<Expense> expenses = new ArrayList<>();

  public void addExpense(Expense expense) {
    if (expense == null) {
      throw new IllegalArgumentException(
        "Expense cannot be null"
      );
    }

    expenses.add(expense);
  }

  public List<Expense> getExpenses() {
    return List.copyOf(expenses);
  }

  public double getTotalExpenses() {
    return expenses.stream()
            .mapToDouble(Expense::getAmount)
            .sum();
  }

  public List<Expense> getExpensesByCategory(String category) {
    return expenses.stream()
            .filter(expense -> 
              expense.getCategory().equalsIgnoreCase(category))
            .toList();
  }
}
