package com.codewithkanye;

import java.io.IOException;
import java.sql.SQLException;

import com.codewithkanye.config.Database;
import com.codewithkanye.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        try {

            Database.initialize();

            ConsoleUI consoleUI = new ConsoleUI();

            consoleUI.start();

        } catch (IOException | SQLException e) {

            System.out.println("Application startup failed.");
            e.printStackTrace();
        }
    }
}