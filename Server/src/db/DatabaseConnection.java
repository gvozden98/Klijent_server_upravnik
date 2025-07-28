/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package db;

import java.sql.*;

/**
 *
 * @author Ognjen
 */
public class DatabaseConnection {

    private Connection connection;

    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/septembar21", "root", "");
            System.out.println("Konekcija sa bazom uspostavljena");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Greska pri konektovanju sa bazom!");
            throw e;
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
