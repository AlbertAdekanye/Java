package com.codewithkanye.repository;

import com.codewithkanye.config.Database;
import com.codewithkanye.model.MovementType;
import com.codewithkanye.model.StockMovement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StockMovementRepository {

    // Save a stock movement using an existing database connection
    public StockMovement addMovement(
            Connection connection,
            StockMovement movement
    ) throws SQLException {

        String sql = """
                INSERT INTO stock_movements
                (product_id, movement_type, quantity, created_at)
                VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement statement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, movement.productId());
            statement.setString(2, movement.type().name());
            statement.setInt(3, movement.quantity());
            statement.setString(4, movement.createdAt().toString());

            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {

                if (keys.next()) {
                    return new StockMovement(
                            keys.getLong(1),
                            movement.productId(),
                            movement.type(),
                            movement.quantity(),
                            movement.createdAt()
                    );
                }

                throw new SQLException("Creating stock movement failed.");
            }
        }
    }

    // Retrieve stock movement history for a product
    public List<StockMovement> findByProductId(long productId)
            throws SQLException {

        String sql = """
                SELECT id, product_id, movement_type, quantity, created_at
                FROM stock_movements
                WHERE product_id = ?
                ORDER BY id DESC
                """;

        List<StockMovement> movements = new ArrayList<>();

        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, productId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    StockMovement movement = new StockMovement(
                            resultSet.getLong("id"),
                            resultSet.getLong("product_id"),
                            MovementType.valueOf(
                                    resultSet.getString("movement_type")
                            ),
                            resultSet.getInt("quantity"),
                            LocalDateTime.parse(
                                    resultSet.getString("created_at")
                            )
                    );

                    movements.add(movement);
                }
            }
        }

        return movements;
    }
}