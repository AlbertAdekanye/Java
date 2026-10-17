
package com.codewithkanye;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseFileRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldSaveAndLoadExpenses() throws IOException {
        Path file = tempDir.resolve("expenses.csv");
        ExpenseFileRepository repository =
                new ExpenseFileRepository(file);

        List<Expense> original = List.of(
                new Expense(
                        1, "Lunch", 2500, "Food",
                        LocalDate.of(2026, 10, 17)
                ),
                new Expense(
                        2, "Bus fare", 1000, "Transport",
                        LocalDate.of(2026, 10, 17)
                )
        );

        repository.save(original);

        List<Expense> loaded = repository.load();

        assertEquals(2, loaded.size());
        assertEquals(original.get(0).getDescription(),
                loaded.get(0).getDescription());
        assertEquals(original.get(0).getAmount(),
                loaded.get(0).getAmount());
        assertEquals(original.get(1).getCategory(),
                loaded.get(1).getCategory());
        assertEquals(original.get(1).getDate(),
                loaded.get(1).getDate());
    }

    @Test
    void shouldHandleCommasAndQuotesInText() throws IOException {
        Path file = tempDir.resolve("special-expenses.csv");
        ExpenseFileRepository repository =
                new ExpenseFileRepository(file);

        Expense original = new Expense(
                1,
                "Lunch, with \"extra\" juice",
                3500,
                "Food, Drinks",
                LocalDate.of(2026, 10, 17)
        );

        repository.save(List.of(original));

        Expense loaded = repository.load().get(0);

        assertEquals(original.getDescription(),
                loaded.getDescription());
        assertEquals(original.getCategory(),
                loaded.getCategory());
    }

    @Test
    void shouldReturnEmptyListWhenFileDoesNotExist()
            throws IOException {
        Path file = tempDir.resolve("missing.csv");
        ExpenseFileRepository repository =
                new ExpenseFileRepository(file);

        assertTrue(repository.load().isEmpty());
    }

    @Test
    void shouldCreateParentDirectoriesWhenSaving()
            throws IOException {
        Path file = tempDir.resolve(
                "data/expenses/expenses.csv"
        );

        ExpenseFileRepository repository =
                new ExpenseFileRepository(file);

        repository.save(List.of(
                new Expense(
                        1, "Books", 5000, "Education",
                        LocalDate.of(2026, 10, 17)
                )
        ));

        assertTrue(java.nio.file.Files.exists(file));
        assertEquals(1, repository.load().size());
    }
}
