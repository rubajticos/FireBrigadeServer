package com.rubajticos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    private static final String URL = "jdbc:mysql://localhost:3307/fire_brigade_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    //private constructor
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Błąd, nie można się połączyć z bazą danych");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

}
