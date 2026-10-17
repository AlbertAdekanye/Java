package com.codewithkanye;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExpenseTest {
  
  @Test
  void shouldCreateExpenseWithValidDate() {
    Expense expense = new Expense(
      1, 
      "Lunch", 
      2500.00, 
      "Food", 
      LocalDate.of(2026, 10, 17)
    );

    assertEquals(1, expense.getId());
    assertEquals("Lunch", expense.getDescription());
    assertEquals(2500.00, expense.getAmount());
    assertEquals("Food", expense.getCategory());
    assertEquals(
      LocalDate.of(2026, 10, 17), 
      expense.getDate()
    );
  }

  @Test
  void shouldRejectEmptyDescription() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Expense(
        1, " ", 2500.00, "Food",
        LocalDate.now()
      )
    );
  }

  @Test
  void shouldRejectZeroOrNegativeAmount() {
    assertThrows(IllegalArgumentException.class, 
      () -> new Expense(
        1, "Lunch", 0, "Food",
        LocalDate.now()
      )
    );

    assertThrows(
      IllegalArgumentException.class,
      () -> new Expense(
        2, "Transport", -500, "Transport",
        LocalDate.now()
      )
    );
  }

  @Test
  void shouldRejectEmptyCategory() {
    assertThrows(IllegalArgumentException.class, 
      () -> new Expense(
        1, "Lunch", 2500.00, " ",
        LocalDate.now()
      )
    );
  }

  @Test
  void shouldRejectNullDate() {
    assertThrows(IllegalArgumentException.class,
      () -> new Expense(
        1, "Lunch", 2500.00, "Food", null
      )
    );
  }
 
}
