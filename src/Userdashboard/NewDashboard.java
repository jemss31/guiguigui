package Userdashboard;

import admin.LogInForm;
import config.dbConnector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler.ChartTheme;

public class NewDashboard extends JFrame {
    private JPanel jPanel4; // Pie chart panel
    private JPanel jPanel5; // Real-time chart panel
    private XYChart lineChart;
    private List<Double> dataX;
    private List<Double> dataY;
    private int time = 0;

    public NewDashboard() {
        initComponents();
        showPieChart();         // Shows pie chart
        setupRealTimeChart();   // Prepares the live chart as histogram
        startRealTimeUpdates(); // Starts the timer for updates
    }

    private void inittComponents() {
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();

        setLayout(new GridLayout(2, 1)); // Two panels vertically
        add(jPanel4);
        add(jPanel5);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void showPieChart() {
        PieChart chart = new PieChartBuilder()
                .width(800)
                .height(300)
                .title("Cost Distribution")
                .theme(ChartTheme.Matlab)
                .build();

        dbConnector connector = new dbConnector();
        Map<String, Double> costMap = new HashMap<>();

        String sql = "SELECT haircut_id, cost FROM appointments";
        try (ResultSet rs = connector.getData(sql)) {
            while (rs.next()) {
                String haircutId = rs.getString("haircut_id");
                double cost = rs.getDouble("cost");
                costMap.put(haircutId, costMap.getOrDefault(haircutId, 0.0) + cost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            connector.closeConnection();
        }

        for (Map.Entry<String, Double> entry : costMap.entrySet()) {
            chart.addSeries("ID " + entry.getKey(), entry.getValue());
        }

        XChartPanel<PieChart> xchartPanel = new XChartPanel<>(chart);
        gwapo.setLayout(new BorderLayout());
        gwapo.add(xchartPanel, BorderLayout.CENTER);
        gwapo.revalidate();
        gwapo.repaint();
    }

    private void setupRealTimeChart() {
        dataX = new ArrayList<>();
        dataY = new ArrayList<>();

        lineChart = new XYChartBuilder()
                .width(800)
                .height(300)
                .title("Real-Time Time-Based Histogram")
                .xAxisTitle("Time")
                .yAxisTitle("Value")
                .theme(ChartTheme.Matlab)
                .build();

        // Configure x-axis to show formatted dates
        lineChart.getStyler().setDatePattern("HH:mm:ss");
        lineChart.getStyler().setXAxisLabelRotation(45);

        // Set chart series render style to Bar for histogram effect
        lineChart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        Date now = new Date();
        dataX.add((double) now.getTime());  // Store timestamp as milliseconds
        dataY.add(getValueByTime(now));

        lineChart.addSeries("Time Value", dataX, dataY);

        XChartPanel<XYChart> xchartPanel = new XChartPanel<>(lineChart);
        TAE.setLayout(new BorderLayout());
        TAE.add(xchartPanel, BorderLayout.CENTER);
        TAE.revalidate();
        TAE.repaint();
    }

    private void startRealTimeUpdates() {
        Timer timer = new Timer(1000, e -> updateChart()); // Every second
        timer.start();
    }

    private void updateChart() {
        Date now = new Date();
        double timestamp = (double) now.getTime();

        double value = getValueByTime(now);

        dataX.add(timestamp);
        dataY.add(value);

        if (dataX.size() > 30) {
            dataX.remove(0);
            dataY.remove(0);
        }

        lineChart.updateXYSeries("Time Value", dataX, dataY, null);

        // Scroll x-axis range to latest values
        lineChart.getStyler().setXAxisMin(dataX.get(0));
        lineChart.getStyler().setXAxisMax(dataX.get(dataX.size() - 1));

        TAE.revalidate();
        TAE.repaint();
    }

    // Returns value based on time of day, smooth change using minutes and seconds
    private double getValueByTime(Date date) {
        int hour = date.getHours();
        int minute = date.getMinutes();
        int second = date.getSeconds();

        // Calculate progress in current hour as fraction from 0.0 to 1.0
        double progress = (minute * 60 + second) / 3600.0;

        if (hour >= 6 && hour < 12) {
            // Morning: value smoothly rises from 0 to 100 over 6 hours
            return ((hour - 6) + progress) * (100.0 / 6);
        } else if (hour >= 12 && hour < 22) {
            // Afternoon/Evening: value smoothly falls from 100 to 0 over 10 hours
            return 100 - ((hour - 12) + progress) * (100.0 / 10);
        } else {
            // Night: value is 0
            return 0;
        }
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        acc = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gwapo = new javax.swing.JPanel();
        TAE = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 245, 179));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(114, 240, 194));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel2.setText("Dashboard");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addContainerGap(853, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 120));

        jButton3.setText("Log In");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 760, 80, 30));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Logout");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 120, 40));

        acc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        acc.setText("Account");
        acc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        acc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accMouseExited(evt);
            }
        });
        jPanel2.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 100, 40));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Your Appointments");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Set Appointment");
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/unnamed (3).png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/unnamed (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/unnamed (2).png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 40, 50));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("Dashboard");
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 100, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictires/unnamed (3).png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 580));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel6.setText("Occupied Date And Time:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 470, 30));

        javax.swing.GroupLayout gwapoLayout = new javax.swing.GroupLayout(gwapo);
        gwapo.setLayout(gwapoLayout);
        gwapoLayout.setHorizontalGroup(
            gwapoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        gwapoLayout.setVerticalGroup(
            gwapoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel1.add(gwapo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 310, 260));

        javax.swing.GroupLayout TAELayout = new javax.swing.GroupLayout(TAE);
        TAE.setLayout(TAELayout);
        TAELayout.setHorizontalGroup(
            TAELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        TAELayout.setVerticalGroup(
            TAELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jPanel1.add(TAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 390, 470));

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "You have successfully logged out!", "Logout", JOptionPane.INFORMATION_MESSAGE);

            LogInForm li = new LogInForm();
            li.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(new java.awt.Color(114,240,194));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MouseExited

    private void accMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseClicked
        userAccounts uc = new userAccounts();
        uc.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_accMouseClicked

    private void accMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseEntered
        acc.setForeground(new java.awt.Color(114,240,194));
    }//GEN-LAST:event_accMouseEntered

    private void accMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMouseExited
                acc.setForeground(Color.BLACK);
    }//GEN-LAST:event_accMouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        userdashboard ud = new userdashboard();
        ud.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setForeground(new java.awt.Color(114,240,194));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       userAppointment ua = new userAppointment();
       ua.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(NewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TAE;
    private javax.swing.JLabel acc;
    public javax.swing.JPanel gwapo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
