package com.hrudzinskyi.persistent;

import java.sql.*;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/lab1db";
    private static final String user = "myuser";
    private static final String password = "230902";

    private static Connection connection = null;

    private ConnectionManager() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException exception) {
                System.out.println("SQLException: " + exception.getMessage());
                System.out.println("SQLState: " + exception.getSQLState());
                System.out.println("VendorError: " + exception.getErrorCode());
            }
        }
        return connection;
    }
}