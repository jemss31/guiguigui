package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.time.LocalDateTime;

public class Logins {
    private Connection connection;

    public Logins(Connection connection) {
        this.connection = connection;
    }

public void logAdd(int uId, String logAction) {
    String query = "INSERT INTO logs (id, log_action, log_date) VALUES (?, ?, ?)";
    try (PreparedStatement pst = connection.prepareStatement(query)) {
        pst.setInt(1, uId); 
        pst.setString(2, logAction);
        pst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now())); 
        pst.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error logging ADD operation: " + e.getMessage());
    }
}
  
}