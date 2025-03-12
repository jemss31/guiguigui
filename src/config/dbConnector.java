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
    public int insertUser(String fname, String lname, String email, String type, String username, String cont, String password) {
        int result = 0;
        // Fixed the SQL query - removed the extra `?` and added `?` for status column at the end
        String sql = "INSERT INTO users (u_fname, u_lname, u_email, type, u_username, u_pass, cont, status) VALUES (?, ?, ?, ?, ?, ?, ?, 'Pending')"; 

        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            // Set the parameters in the correct order as in the SQL query
            pst.setString(1, fname);  
            pst.setString(2, lname);  
            pst.setString(3, email);  
            pst.setString(4, type);  
            pst.setString(5, username);  
            pst.setString(6, password);  
            pst.setString(7, cont);  // Set the contact number last

            System.out.println("Executing Insert: " + pst.toString()); // Debugging statement

            result = pst.executeUpdate(); // Execute the update

        } catch (SQLException ex) {
            System.out.println("Insert Error: " + ex.getMessage());
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

    // Function to save data
    public int insertData(String sql) {
        int result;
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            pst.close();
            result = 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            result = 0;
        }
        return result;
    }

    // Check if an email already exists in the database
    public boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE u_email = ?";
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;  // Email exists
            }
        } catch (SQLException ex) {
            System.err.println("Error checking email existence: " + ex.getMessage());
        }
        return false;  // Email doesn't exist
    }
        public boolean isContactExists(String contactNumber) {  // Only one parameter
    String query = "SELECT COUNT(*) FROM users WHERE cont = ?";
    try (PreparedStatement pst = connect.prepareStatement(query)) {
        pst.setString(1, contactNumber);
        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            return true;  // Contact number already exists
        }
    } catch (SQLException ex) {
        System.err.println("Error checking contact number existence: " + ex.getMessage());
    }
    return false;
}
}
