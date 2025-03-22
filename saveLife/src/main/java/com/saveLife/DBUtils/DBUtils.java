package com.saveLife.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/savelife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";

    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

   
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
