
package com.codewithkanye;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseFileRepository {

    private final Path filePath;

    public ExpenseFileRepository(Path filePath) {
        this.filePath = filePath;
    }

    public void save(List<Expense> expenses) throws IOException {
        List<String> lines = new ArrayList<>();

        lines.add("id,description,amount,category,date");

        for (Expense expense : expenses) {
            String line = expense.getId() + ","
                    + escape(expense.getDescription()) + ","
                    + expense.getAmount() + ","
                    + escape(expense.getCategory()) + ","
                    + expense.getDate();

            lines.add(line);
        }

        Path parent = filePath.getParent();

        if (parent != null) {
            Files.createDirectories(parent);
        }

        Files.write(filePath, lines);
    }

    public List<Expense> load() throws IOException {
        List<Expense> expenses = new ArrayList<>();

        if (Files.notExists(filePath)) {
            return expenses;
        }

        List<String> lines = Files.readAllLines(filePath);

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.isBlank()) {
                continue;
            }

            List<String> fields = parseCsvLine(line);

            if (fields.size() != 5) {
                throw new IOException(
                        "Invalid CSV data on line " + (i + 1)
                );
            }

            try {
                int id = Integer.parseInt(fields.get(0));
                String description = fields.get(1);
                double amount = Double.parseDouble(fields.get(2));
                String category = fields.get(3);
                LocalDate date = LocalDate.parse(fields.get(4));

                expenses.add(new Expense(
                        id, description, amount, category, date
                ));
            } catch (IllegalArgumentException exception) {
                throw new IOException(
                        "Invalid expense data on line " + (i + 1),
                        exception
                );
            }
        }

        return expenses;
    }

    private String escape(String value) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }

    private List<String> parseCsvLine(String line)
            throws IOException {

        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);

            if (current == '"') {
                if (insideQuotes
                        && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {
                    field.append('"');
                    i++;
                } else {
                    insideQuotes = !insideQuotes;
                }
            } else if (current == ',' && !insideQuotes) {
                fields.add(field.toString());
                field.setLength(0);
            } else {
                field.append(current);
            }
        }

        if (insideQuotes) {
            throw new IOException("Unclosed quote in CSV line");
        }

        fields.add(field.toString());
        return fields;
    }
}
