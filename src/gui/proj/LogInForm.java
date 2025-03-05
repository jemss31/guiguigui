/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.proj;

import Userdashboard.userdashboard;
import admin.adminDashboard;
import config.Session;
import config.dbConnector;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class LogInForm extends javax.swing.JFrame {

    /**
     * Creates new form LogInForm
     */
    public LogInForm() {
        initComponents();
        password.setText("Enter Password");
    }
    
   public static Boolean loginAcc(String username, String password) {
            dbConnector connector = new dbConnector();
    String query = "SELECT id, u_fname, u_lname, u_email, u_username, u_pass, status, type FROM users WHERE u_username = ?";

    try (Connection connect = connector.getConnection();
         PreparedStatement pst = connect.prepareStatement(query)) {

        pst.setString(1, username);
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            String storedHashedPassword = resultSet.getString("u_pass");
            String status = resultSet.getString("status");
            String type = resultSet.getString("type");

            String hashedPasswordInput = hashPassword(password);
            if (hashedPasswordInput == null) {
                JOptionPane.showMessageDialog(null, "Error hashing password!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Verify password
            if (!hashedPasswordInput.equals(storedHashedPassword)) {
                JOptionPane.showMessageDialog(null, "Invalid password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Successful login
            Session sess = Session.getInstance();
            sess.setId(resultSet.getInt("id")); // Set the session ID
            sess.setU_fname(resultSet.getString("u_fname"));
            sess.setU_lname(resultSet.getString("u_lname"));
            sess.setU_email(resultSet.getString("u_email"));
            sess.setU_username(resultSet.getString("u_username"));
            sess.setType(type);
            sess.setStatus(status);

            // Check account status
            if ("Pending".equalsIgnoreCase(status)) {
                JOptionPane.showMessageDialog(null, "Your account is pending approval.", "Access Denied", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            JOptionPane.showMessageDialog(null, "Welcome " + username + "! You are logged in as " + type);
            return true; // Login successful
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return false; // Username not found
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
   }
   
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ User Registration (Fixed Table Name)
    public static Boolean insertUser(String fname, String lname, String email, String type, String username, String password) {
        dbConnector connector = new dbConnector();
        String query = "INSERT INTO tbl_pets (u_fname, u_lname, u_email, type, u_username, u_pass, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connector.getConnection().prepareStatement(query)) {
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, email);
            pst.setString(4, type);
            pst.setString(5, username);
            pst.setString(6, hashPassword(password)); // ✅ Hash before storing
            pst.setString(7, "Pending"); // Default status is "Pending"
            
            int rowsInserted = pst.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkbox1 = new java.awt.Checkbox();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        regis = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        checkbox1.setLabel("checkbox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 245, 179));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(114, 240, 194));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel2.setText("Welcome to Pet Grooming System!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel2)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 120));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Password:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 220, 60));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 220, 60));

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 260, 50));

        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 260, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/nenpo.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 100, 860, 210));

        jButton1.setText("Exit");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 80, 30));

        jButton2.setText("Log In");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 80, 30));

        regis.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        regis.setText("New User? Click Here to Register!");
        regis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regisMouseClicked(evt);
            }
        });
        jPanel1.add(regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 220, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/gwapo.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 420, 860, 280));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String usernameInput = username.getText().trim();
    String passwordInput = new String(password.getPassword()).trim();

    
    if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username and Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    String hashedPasswordInput = hashPassword(passwordInput);

    
    String sql = "SELECT u_pass, status, type FROM users WHERE u_username = ?";

    try (Connection connect = new dbConnector().getConnection(); 
         PreparedStatement pst = connect.prepareStatement(sql)) {
        
        pst.setString(1, usernameInput);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String dbPassword = rs.getString("u_pass"); 
            String status = rs.getString("status");
            String type = rs.getString("type"); 

           
            if (status.equalsIgnoreCase("Pending")) {
                JOptionPane.showMessageDialog(this, "Your account is pending approval. Please wait for admin approval.", "Access Denied", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            if (hashedPasswordInput.equals(dbPassword)) {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                
                switch (type.toLowerCase()) {
                    case "admin":
                        new adminDashboard().setVisible(true);
                        break;
                    case "customer":
                        new userdashboard().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Invalid User Type!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void regisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regisMouseClicked
        RegisForm rf = new RegisForm();
        rf.setVisible(true);
        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_regisMouseClicked

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        password.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_passwordFocusGained

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
if (jCheckBox1.isSelected()) {
            password.setEchoChar((char) 0);
        } else {
            password.setEchoChar('*');
        } 

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel regis;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
