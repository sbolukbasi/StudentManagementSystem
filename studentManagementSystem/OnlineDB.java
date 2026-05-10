package studentManagementSystem;

import java.sql.*;
public class OnlineDB {
    private static final String URL = "jdbc:mysql://193.203.166.109:3306/u997807830_SE204Project?autoReconnect=true";
    private static final String USER = "u997807830_SE204SoftConst";
    private static final String PASSWORD = "SE204sf2026";
    

    public static Connection connectOnlineDB() {

        Connection connection = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected");

            return connection;
            
        } catch (Exception e) {
            System.out.println("Not connected");
            return null;
        }
    }

}

