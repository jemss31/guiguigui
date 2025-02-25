package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnector {
    
    private Connection connect;

    // Constructor to connect to the database
    public dbConnector() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pets", "root", "");
            System.out.println("Database connected successfully!");
        } catch (SQLException ex) {
            System.err.println("Can't connect to database: " + ex.getMessage());
        }
    }
public Connection getConnection() {
        return connect;
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    // Insert user data into the database
    public int insertUser(String fname, String lname, String email, String userType, String username, String password) {
        int result = 0; 
        String sql = "INSERT INTO users (u_fname, u_lname, u_email, type, u_username, u_pass) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, email);
            pst.setString(4, userType);
            pst.setString(5, username);
            pst.setString(6, password); // Ensure to hash the password before storing

            result = pst.executeUpdate();
            System.out.println("User inserted successfully!");
        } catch (SQLException ex) {
            System.err.println("Insert Error: " + ex.getMessage());
        }
        return result;
    }

    // Close the database connection
    public void closeConnection() {
        if (connect != null) {
            try {
                connect.close();
                System.out.println("Database connection closed.");
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
    
}
