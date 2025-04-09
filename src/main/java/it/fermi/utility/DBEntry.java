package it.fermi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBEntry{
    public static Connection conn;
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql://10.0.9.240:3306/mandich", "mandich", "man3193jhg");
            }
        } catch (SQLException e) {
            conn = null;
            throw new RuntimeException(e);
        }
        return conn;
    }
}