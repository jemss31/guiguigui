/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class UserRecoveryOption extends javax.swing.JFrame {
public UserRecoveryOption() {
         
        setUndecorated(true);
        
        initComponents();
        
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                
            }
        });
        addMouseMotionListener(new java.awt.event.MouseAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                
            }
        });
         
     
    }
    
    
private void customizeButton(JButton button) {
   button.setOpaque(true);
   button.setBorderPainted(false);
   button.setFocusPainted(false);
   button.setBackground(new Color(51, 51, 255)); 
   button.setForeground(Color.WHITE);


   
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(102, 153, 255)); 
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(51, 51, 255)); 
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        po = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ch = new javax.swing.JCheckBox();
        s = new javax.swing.JCheckBox();
        d = new javax.swing.JCheckBox();
        f = new javax.swing.JCheckBox();
        ep = new javax.swing.JLabel();
        sec = new javax.swing.JLabel();
        pin = new javax.swing.JLabel();
        mn = new javax.swing.JLabel();
        con = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel2.setText("Recovery Option");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 320, 116));

        jButton2.setText("LOGIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 180, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 120));

        po.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/gwapo.gif"))); // NOI18N
        jPanel1.add(po, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 420, 700, 280));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("How do you want to reset your password?");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 570, 77));

        ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActionPerformed(evt);
            }
        });
        jPanel2.add(ch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 20, 20));

        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });
        jPanel2.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 20, 20));

        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });
        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 20, 20));

        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });
        jPanel2.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 20, 20));

        ep.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        ep.setText("Enter Password");
        ep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                epMouseClicked(evt);
            }
        });
        jPanel2.add(ep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 280, 40));

        sec.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        sec.setText("Security Question");
        sec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                secMouseClicked(evt);
            }
        });
        jPanel2.add(sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 280, 40));

        pin.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        pin.setText("PIN");
        pin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pinMouseClicked(evt);
            }
        });
        jPanel2.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 280, 40));

        mn.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        mn.setText("Email");
        mn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnMouseClicked(evt);
            }
        });
        jPanel2.add(mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 280, 40));

        con.setText("CONTINUE");
        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });
        jPanel2.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 620, 360));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setText("Reset your password ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/logs-removebg-preview.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 350, 230));

        name.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 170, 60));

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

    private void chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chActionPerformed

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fActionPerformed

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
        if (!ch.isSelected() && !s.isSelected() && !d.isSelected() && !f.isSelected()) {
        JOptionPane.showMessageDialog(this, "Please select an option before continuing.");
        return; // Exit the method early if none are selected
    }

    // Proceed based on the selection
    if (ch.isSelected()) {
        SecurityQuestion sqFrame = new SecurityQuestion();
        sqFrame.setVisible(true);
        this.dispose();

    } else if (s.isSelected()) {
        UserRecoveryPIN pinFrame = new UserRecoveryPIN();
        pinFrame.setVisible(true);
        this.dispose();

    } else if (d.isSelected()) {
        MobileNumber mnFrame = new MobileNumber();
        mnFrame.setVisible(true);
        this.dispose();

    } else if (f.isSelected()) {
        LogInForm epFrame = new LogInForm();
        epFrame.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_conActionPerformed

    private void secMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secMouseClicked
       ch.setSelected(true);
    s.setSelected(false);
    d.setSelected(false);
    f.setSelected(false);
        
    }//GEN-LAST:event_secMouseClicked

    private void pinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinMouseClicked
        ch.setSelected(false);
    s.setSelected(true);
    d.setSelected(false);
    f.setSelected(false);
    }//GEN-LAST:event_pinMouseClicked

    private void mnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnMouseClicked
    ch.setSelected(false);
    s.setSelected(false);
    d.setSelected(true);
    f.setSelected(false);
    }//GEN-LAST:event_mnMouseClicked

    private void epMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_epMouseClicked
        ch.setSelected(false);
    s.setSelected(false);
    d.setSelected(false);
    f.setSelected(true);
    }//GEN-LAST:event_epMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Are you sure you wanna discard this recovery process?", "Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();

            LogInForm loginPage = new LogInForm();
            loginPage.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();

    
    if (sess.getU_username()== null) {
        JOptionPane.showMessageDialog(null, "No account found, find your account first!");
        ForgotPassword ufp = new ForgotPassword();
        ufp.setVisible(true);
        this.dispose();
    } else {
        
        name.setText(sess.getU_username());
    
    }
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
            java.util.logging.Logger.getLogger(UserRecoveryOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRecoveryOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRecoveryOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRecoveryOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRecoveryOption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ch;
    private javax.swing.JButton con;
    private javax.swing.JCheckBox d;
    private javax.swing.JLabel ep;
    private javax.swing.JCheckBox f;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel mn;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pin;
    private javax.swing.JLabel po;
    private javax.swing.JCheckBox s;
    private javax.swing.JLabel sec;
    // End of variables declaration//GEN-END:variables
}
