/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author admin
 */
public class OTPGenerator {
    public static String generateOTP(int length) {
        String numbers = "0123456789";
        StringBuilder otp = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(rand.nextInt(numbers.length())));
        }
        return otp.toString();
    }

}
