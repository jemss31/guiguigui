/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userdashboard;

import admin.AccountAdmin;
import admin.AdminAccountControl;
import config.Logins;
import config.Session;
import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class UpdateUser extends javax.swing.JFrame {

    /**
     * Creates new form UpdateUser
     */
    public UpdateUser() {
        initComponents();
    }
     public String destination;
   File selectedFile;
   public String oldpath;
   public String path;

public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/Profiles", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
            
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!"+ex);
        }
        
        return -1;  
    }
    private String userId; 

    public void setUserId(String id) {
        this.userId = id; 
    }
    public void setFirstName(String firstName) {
    this.fn.setText(firstName);
}

 public boolean duplicateCheck() {
    dbConnector dbc = new dbConnector();
    try {
        String query = "SELECT * FROM users WHERE u_username = '" + uss1.getText() + "' OR u_email = '" + Email.getText() + "'";
        ResultSet resultSet = dbc.getData(query);

        if (resultSet.next()) {
            String email = resultSet.getString("u_email"); 
            if (email.equals(Email.getText())) {
                JOptionPane.showMessageDialog(null, "Email is Already Used!");
                Email.setText(""); 
            }

            String username = resultSet.getString("u_username"); 
            if (username.equals(uss1.getText())) {
                JOptionPane.showMessageDialog(null, "Username is Already Used!");
                uss1.setText(""); 
            }
            return true;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
        return false;
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        uss1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ln1 = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        utype = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        stat = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        contactnum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Picture = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        remove1 = new javax.swing.JButton();
        Update1 = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();

        Update.setText("UPDATE");
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        cancel.setText("CANCEL");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(240, 245, 179));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(114, 240, 194));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel2.setText("Update Your Profile!");

        ID.setText("ID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 120));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("First Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 220, 60));

        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 80, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 220, 60));

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 260, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("User Type:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 220, 60));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 260, 50));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, -1, -1));

        uss1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uss1ActionPerformed(evt);
            }
        });
        jPanel1.add(uss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 260, 50));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Username:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 220, 60));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setText("Last Name:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 220, 60));

        ln1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1ActionPerformed(evt);
            }
        });
        jPanel1.add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 260, 50));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 260, 50));

        utype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Customer" }));
        utype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utypeActionPerformed(evt);
            }
        });
        jPanel1.add(utype, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 260, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setText("User Status:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 220, 60));

        stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprroved", "Pending" }));
        stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statActionPerformed(evt);
            }
        });
        jPanel1.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 260, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setText("Email:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, 60));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("Phone:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 60));

        contactnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactnumActionPerformed(evt);
            }
        });
        jPanel1.add(contactnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 260, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/nenpo.png"))); // NOI18N
        jLabel10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel10KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 40, 950, 370));
        jPanel1.add(Picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 270, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 310, 280));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/asdasdasd.gif"))); // NOI18N
        jLabel8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel8KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 330, 530, 260));

        remove1.setText("REMOVE");
        remove1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                remove1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                remove1MouseExited(evt);
            }
        });
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });
        jPanel1.add(remove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 80, 30));

        Update1.setText("UPDATE");
        Update1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Update1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Update1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Update1MouseExited(evt);
            }
        });
        Update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update1ActionPerformed(evt);
            }
        });
        jPanel1.add(Update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, 80, 30));

        cancel1.setText("CANCEL");
        cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel1MouseExited(evt);
            }
        });
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        jPanel1.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 80, 30));

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

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        select.setBackground(new java.awt.Color(114,240,194));
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        select.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_selectMouseExited

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
   JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/profileImages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            Picture.setIcon(ResizeImage(path, null, Picture));
                            select.setEnabled(false);
                            cancel.setEnabled(true);
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!"+ex);
                    }
                }     
    }//GEN-LAST:event_selectActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(new java.awt.Color(114,240,194));
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    AccountAdmin ua = new AccountAdmin();
        ua.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_cancelActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        String name = fn.getText();
        String regex = "^[a-zA-Z]+$";
        if (!name.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Name should not contain numbers or special characters.");
        } else {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        String password = new String(pass.getPassword());

        if (!password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d).{8,}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Password! Must be at least 8 characters long, contain one uppercase letter, one special character, and one number.", "Error", JOptionPane.ERROR_MESSAGE);
            pass.setText("");
        }
    }//GEN-LAST:event_passActionPerformed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passKeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            pass.setEchoChar((char) 0);
        } else {
            pass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void uss1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uss1ActionPerformed
       
    }//GEN-LAST:event_uss1ActionPerformed

    private void ln1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_ln1ActionPerformed

    private void jLabel8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8KeyPressed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void utypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utypeActionPerformed

    private void statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statActionPerformed

    private void jLabel10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10KeyPressed

    private void contactnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnumActionPerformed
      
    }//GEN-LAST:event_contactnumActionPerformed

    private void remove1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_remove1MouseClicked

    private void remove1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_remove1MouseEntered

    private void remove1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_remove1MouseExited

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
          remove1.setEnabled(false);
       select.setEnabled(true);
       Picture.setIcon(null);
       destination = "";
       path = "";
    }//GEN-LAST:event_remove1ActionPerformed

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseClicked

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseEntered

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseExited

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
      
     String newFname = fn.getText().trim();
    String newLname = ln1.getText().trim();
    String newContact = contactnum.getText().trim();
    String newEmail = Email.getText().trim();
    String newUsername = uss1.getText().trim();
    String newUserType = utype.getSelectedItem().toString();
    String newUserStatus = stat.getSelectedItem().toString();

    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    if (newFname.isEmpty() || newLname.isEmpty() || newEmail.isEmpty() || newUsername.isEmpty() || newUserType.isEmpty() || newUserStatus.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newFname.matches("[a-zA-Z ]+") || !newLname.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Only letters are allowed for First and Last Name.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newContact.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid contact number! Only numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newEmail.matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid Email! Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newUsername.matches("[a-zA-Z0-9_]{5,}")) {
        JOptionPane.showMessageDialog(this, "Invalid Username! Must be at least 5 characters and contain only letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    dbConnector dbc = new dbConnector();

    if (this.userId == null || this.userId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: User ID is missing.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String checkQuery = "SELECT COUNT(*) FROM users WHERE (u_username = ? OR u_email = ?) AND id != ?";
    
    try (Connection conn = dbc.getConnection();
         PreparedStatement pst = conn.prepareStatement(checkQuery)) {

        pst.setString(1, newUsername);
        pst.setString(2, newEmail);
        pst.setString(3, this.userId);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Username or Email already exists! Please use different credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String updateQuery = "UPDATE users SET u_fname = ?, u_lname = ?, u_email = ?, u_username = ?, type = ?, status = ?";
        if (path != null && !path.isEmpty()) {
            updateQuery += ", image = ?"; 
        }
        updateQuery += " WHERE id = ?";

        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS)) {
            updatePst.setString(1, newFname);
            updatePst.setString(2, newLname);
            updatePst.setString(3, newEmail);
            updatePst.setString(4, newUsername);
            updatePst.setString(5, newUserType);
            updatePst.setString(6, newUserStatus);
            
            if (path != null && !path.isEmpty()) {
                updatePst.setString(7, destination);
                updatePst.setString(8, this.userId);
            } else {
                updatePst.setString(7, this.userId); 
            }

            int updated = updatePst.executeUpdate();
            if (updated > 0) {
    
    Logins logger = new Logins(conn); 
    int adminId = Integer.parseInt(ID.getText()); 
    String logMessage = "Admin updated user info: " + newUsername + " (User ID: " + this.userId + ")";
    
    try {
        logger.logAdd(adminId, logMessage);
    } catch (Exception logEx) {
        JOptionPane.showMessageDialog(this, "Error logging the update: " + logEx.getMessage(), "Log Error", JOptionPane.ERROR_MESSAGE);
    }

                
                if (destination == null || destination.isEmpty()) {
                    
                    if (oldpath != null) {
                        File existingFile = new File(oldpath); 
                        if (existingFile.exists()) { 
                            existingFile.delete(); 
                        }
                    }

                    
                    String updateImageQuery = "UPDATE users SET image = NULL WHERE u_id = ?";
                    try (PreparedStatement updateImagePst = conn.prepareStatement(updateImageQuery)) {
                        updateImagePst.setString(1, this.userId);
                        updateImagePst.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error updating image in database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else { 
                    if (oldpath != null && !oldpath.equals(path)) { 
                        imageUpdater(oldpath, path); 
                    } 
                }

                
                if (selectedFile != null && destination != null) {
                    try {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error copying the image file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "User data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new AccountAdmin().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_UpdateActionPerformed

    private void Update1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Update1MouseClicked

    private void Update1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Update1MouseEntered

    private void Update1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Update1MouseExited

    private void Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update1ActionPerformed
        
     String newFname = fn.getText().trim();
    String newLname = ln1.getText().trim();
    String newContact = contactnum.getText().trim();
    String newEmail = Email.getText().trim();
    String newUsername = uss1.getText().trim();
    String newUserType = utype.getSelectedItem().toString();
    String newUserStatus = stat.getSelectedItem().toString();

    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    if (newFname.isEmpty() || newLname.isEmpty() || newEmail.isEmpty() || newUsername.isEmpty() || newUserType.isEmpty() || newUserStatus.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newFname.matches("[a-zA-Z ]+") || !newLname.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Only letters are allowed for First and Last Name.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newContact.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid contact number! Only numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newEmail.matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid Email! Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newUsername.matches("[a-zA-Z0-9_]{5,}")) {
        JOptionPane.showMessageDialog(this, "Invalid Username! Must be at least 5 characters and contain only letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    dbConnector dbc = new dbConnector();

    if (this.userId == null || this.userId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: User ID is missing.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String checkQuery = "SELECT COUNT(*) FROM users WHERE (u_username = ? OR u_email = ?) AND id != ?";
    
    try (Connection conn = dbc.getConnection();
         PreparedStatement pst = conn.prepareStatement(checkQuery)) {

        pst.setString(1, newUsername);
        pst.setString(2, newEmail);
        pst.setString(3, this.userId);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Username or Email already exists! Please use different credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String updateQuery = "UPDATE users SET u_fname = ?, u_lname = ?, u_email = ?, u_username = ?, type = ?, status = ?";
        if (path != null && !path.isEmpty()) {
            updateQuery += ", image = ?"; 
        }
        updateQuery += " WHERE id = ?";

        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS)) {
            updatePst.setString(1, newFname);
            updatePst.setString(2, newLname);
            updatePst.setString(3, newEmail);
            updatePst.setString(4, newUsername);
            updatePst.setString(5, newUserType);
            updatePst.setString(6, newUserStatus);
            
            if (path != null && !path.isEmpty()) {
                updatePst.setString(7, destination);
                updatePst.setString(8, this.userId);
            } else {
                updatePst.setString(7, this.userId); 
            }

            int updated = updatePst.executeUpdate();
            if (updated > 0) {
    
    Logins logger = new Logins(conn); 
    int adminId = Integer.parseInt(ID.getText()); 
    String logMessage = "Admin updated user info: " + newUsername + " (User ID: " + this.userId + ")";
    
    try {
        logger.logAdd(adminId, logMessage);
    } catch (Exception logEx) {
        JOptionPane.showMessageDialog(this, "Error logging the update: " + logEx.getMessage(), "Log Error", JOptionPane.ERROR_MESSAGE);
    }

                
                if (destination == null || destination.isEmpty()) {
                    
                    if (oldpath != null) {
                        File existingFile = new File(oldpath); 
                        if (existingFile.exists()) { 
                            existingFile.delete(); 
                        }
                    }

                    
                    String updateImageQuery = "UPDATE users SET image = NULL WHERE id = ?";
                    try (PreparedStatement updateImagePst = conn.prepareStatement(updateImageQuery)) {
                        updateImagePst.setString(1, this.userId);
                        updateImagePst.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error updating image in database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else { 
                    if (oldpath != null && !oldpath.equals(path)) { 
                        imageUpdater(oldpath, path); 
                    } 
                }

                
                if (selectedFile != null && destination != null) {
                    try {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error copying the image file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "User data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new AccountAdmin().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_Update1ActionPerformed

    private void cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseClicked

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseExited

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
       AccountAdmin ua = new AccountAdmin();
        ua.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_cancel1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
    
   
    ID.setText(String.valueOf(sess.getId()));
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Email;
    private javax.swing.JLabel ID;
    public javax.swing.JLabel Picture;
    public javax.swing.JButton Update;
    public javax.swing.JButton Update1;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel1;
    public javax.swing.JTextField contactnum;
    public javax.swing.JTextField fn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField ln1;
    public javax.swing.JPasswordField pass;
    public javax.swing.JButton remove1;
    public javax.swing.JButton select;
    public javax.swing.JComboBox<String> stat;
    public javax.swing.JTextField uss1;
    public javax.swing.JComboBox<String> utype;
    // End of variables declaration//GEN-END:variables
}
