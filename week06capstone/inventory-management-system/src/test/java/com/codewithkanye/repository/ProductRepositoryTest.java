package com.codewithkanye.repository;

import com.codewithkanye.config.Database;
import com.codewithkanye.model.Product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  
  @TempDir
  Path tempDir;

  private ProductRepository repository;
  private String originalDatabaseUrl;

  @BeforeEach
  void setUp() throws Exception {

    originalDatabaseUrl = 
        System.getProperty("inventory.db.url");
  }
}
