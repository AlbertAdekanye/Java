package com.codewithkanye;

import java.time.LocalDate;

public class Expense {
  
  private final int id;
  private final String description;
  private final double amount;
  private final String category;
  private final LocalDate date;

  public Expense(
    int id, 
    String description, 
    double amount, 
    String category, 
    LocalDate date
  ) {

    if (description == null || description.isBlank()) {
      throw new IllegalArgumentException(
        "Description cannot be empty"
      );
    }

    if (amount <= 0 || !Double.isFinite(amount)) {
      throw new IllegalArgumentException(
        "Amount must be greater than zero"
      );
    }

    if (category == null || category.isBlank()) {
      throw new IllegalArgumentException(
        "Category cannot be empty"
      );
    }

    if (date == null) {
      throw new IllegalArgumentException(
        "Date cannot be null"
      );
    }

    this.id = id;
    this.description = description;
    this.amount = amount;
    this.category = category;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public double getAmount() {
    return amount;
  }

  public String getCategory() {
    return category;
  }

  public LocalDate getDate() {
    return date;
  }

  @Override 
  public String toString() {
    return "Expense{id=" + id 
            + ", description='" + description + '\'' 
            + ", amount=" + amount 
            + ", category='" + category + '\'' 
            + ", date=" + date + '}';
  }
}
