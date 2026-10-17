
package com.codewithkanye;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseTrackerTest {

    private ExpenseTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new ExpenseTracker();

        tracker.addExpense(new Expense(
                1, "Lunch", 2500, "Food",
                LocalDate.of(2026, 10, 17)
        ));

        tracker.addExpense(new Expense(
                2, "Bus fare", 1000, "Transport",
                LocalDate.of(2026, 10, 17)
        ));

        tracker.addExpense(new Expense(
                3, "Dinner", 3500, "Food",
                LocalDate.of(2026, 10, 17)
        ));
    }

    @Test
    void shouldAddExpenses() {
        assertEquals(3, tracker.getExpenses().size());
    }

    @Test
    void shouldCalculateTotalExpenses() {
        assertEquals(7000.00, tracker.getTotalExpenses());
    }

    @Test
    void shouldFilterExpensesByCategory() {
        List<Expense> foodExpenses =
                tracker.getExpensesByCategory("Food");

        assertEquals(2, foodExpenses.size());
        assertEquals(6000.00,
                foodExpenses.stream()
                        .mapToDouble(Expense::getAmount)
                        .sum());
    }

    @Test
    void shouldMatchCategoryWithoutCaseSensitivity() {
        assertEquals(
                2,
                tracker.getExpensesByCategory("food").size()
        );
    }

    @Test
    void shouldRejectNullExpense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> tracker.addExpense(null)
        );
    }

    @Test
    void shouldReturnReadOnlyExpenseList() {
        List<Expense> expenses = tracker.getExpenses();

        assertThrows(
                UnsupportedOperationException.class,
                () -> expenses.add(new Expense(
                        4, "Books", 5000, "Education",
                        LocalDate.now()
                ))
        );
    }
}
