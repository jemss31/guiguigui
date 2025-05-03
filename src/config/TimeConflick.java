package config;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to handle various time and scheduling-related functions,
 * such as retrieving the haircut ID, cost, duration, and checking for time conflicts.
 * 
 * @author admin
 */
public class TimeConflick {

    /**
     * Retrieves the ID of a haircut based on its name.
     *
     * @param haircutName the name of the haircut
     * @param conn the database connection
     * @return the ID of the haircut
     * @throws SQLException if a database error occurs
     */
    public int getHaircutId(String haircutName, Connection conn) throws SQLException {
        String query = "SELECT id FROM haircuts WHERE name = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, haircutName);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    throw new SQLException("Haircut not found: " + haircutName);
                }
            }
        }
    }

    /**
     * Retrieves the cost of a haircut based on its name.
     *
     * @param haircutName the name of the haircut
     * @param conn the database connection
     * @return the cost of the haircut
     * @throws SQLException if a database error occurs
     */
    public BigDecimal getHaircutCost(String haircutName, Connection conn) throws SQLException {
        String query = "SELECT cost FROM haircuts WHERE name = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, haircutName);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getBigDecimal("cost");
                } else {
                    throw new SQLException("Haircut not found: " + haircutName);
                }
            }
        }
    }

    /**
     * Retrieves the duration of a haircut based on its ID.
     * If the duration is NULL in the database, a default duration of 30 minutes is returned.
     *
     * @param haircutId the ID of the haircut
     * @param conn the database connection
     * @return the duration in minutes of the haircut
     * @throws SQLException if a database error occurs
     */
    public int getHaircutDuration(int haircutId, Connection conn) throws SQLException {
        String query = "SELECT duration FROM haircuts WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, haircutId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int duration = rs.getInt("duration");
                    // If duration is NULL, return the default duration (30 minutes)
                    if (rs.wasNull()) {
                        return 30; // Default to 30 minutes if NULL
                    }
                    return duration;
                } else {
                    throw new SQLException("Haircut duration not found for ID: " + haircutId);
                }
            }
        }
    }

    /**
     * Checks if the selected time slot is available by comparing with existing appointments.
     *
     * @param conn the database connection
     * @param selectedDate the date of the appointment
     * @param startTime the start time of the appointment
     * @param durationMinutes the duration of the haircut in minutes
     * @return true if the time slot is available, false if there is a conflict
     * @throws SQLException if a database error occurs
     * @throws ParseException if there is an issue parsing the time
     */
    public boolean isTimeSlotAvailable(Connection conn, String selectedDate, String startTime, int durationMinutes)
            throws SQLException, ParseException {
        String query = "SELECT time, haircut_id FROM appointments WHERE date = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, selectedDate);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String existingTime = rs.getString("time");
                    int existingHaircutId = rs.getInt("haircut_id");

                    // Parse the start time and existing appointment times
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date newStart = timeFormat.parse(startTime);
                    Date newEnd = new Date(newStart.getTime() + durationMinutes * 60 * 1000);

                    Date existingStart = timeFormat.parse(existingTime);
                    int existingDuration = getHaircutDuration(existingHaircutId, conn);
                    Date existingEnd = new Date(existingStart.getTime() + existingDuration * 60 * 1000);

                    // Check if the new time overlaps with an existing appointment
                    if (newStart.before(existingEnd) && existingStart.before(newEnd)) {
                        return false; // Time conflict detected
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Log the exception
            throw new SQLException("Error parsing time format", e); // Rethrow as SQLException
        }
        return true; // No conflict
    }
}
