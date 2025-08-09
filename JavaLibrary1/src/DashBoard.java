import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Map;


public class DashBoard extends javax.swing.JFrame {

    // Database connection
    private Connection conn;
    private String currentPerson;
    private boolean isMfaEnabled = false;
    private int person_id = -1;
    
    
    public DashBoard() {
        initComponents();
         setupDatabaseConnection();
    }

     private void setupDatabaseConnection() {
        try {

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Insurance DB", "bue", "bue");

            System.out.println("Database connection successful");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage(),
                                        "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("SQL Error: " + e.getMessage());
        } 
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Notifications = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ProfileManagement = new javax.swing.JButton();
        CertificateManagement = new javax.swing.JButton();
        PolicyManagement = new javax.swing.JButton();
        Claims = new javax.swing.JButton();
        Payments = new javax.swing.JButton();
        Support = new javax.swing.JButton();
        Reports = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setText(" Insurance MAnagement system");

        Notifications.setBackground(new java.awt.Color(204, 204, 255));
        Notifications.setText("Notifications");
        Notifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationsActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(204, 204, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(374, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(Notifications)
                .addGap(18, 18, 18)
                .addComponent(Logout)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Notifications)
                    .addComponent(Logout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ProfileManagement.setBackground(new java.awt.Color(204, 204, 255));
        ProfileManagement.setText("Profile Management");
        ProfileManagement.setPreferredSize(new java.awt.Dimension(200, 50));
        ProfileManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileManagementActionPerformed(evt);
            }
        });

        CertificateManagement.setBackground(new java.awt.Color(204, 204, 255));
        CertificateManagement.setText("Certificate Management");
        CertificateManagement.setPreferredSize(new java.awt.Dimension(200, 50));
        CertificateManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CertificateManagementActionPerformed(evt);
            }
        });

        PolicyManagement.setBackground(new java.awt.Color(204, 204, 255));
        PolicyManagement.setText("Policy Management");
        PolicyManagement.setPreferredSize(new java.awt.Dimension(200, 50));
        PolicyManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PolicyManagementActionPerformed(evt);
            }
        });

        Claims.setBackground(new java.awt.Color(204, 204, 255));
        Claims.setText("Claims");
        Claims.setPreferredSize(new java.awt.Dimension(200, 50));
        Claims.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaimsActionPerformed(evt);
            }
        });

        Payments.setBackground(new java.awt.Color(204, 204, 255));
        Payments.setText("Payments");
        Payments.setPreferredSize(new java.awt.Dimension(200, 50));
        Payments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentsActionPerformed(evt);
            }
        });

        Support.setBackground(new java.awt.Color(204, 204, 255));
        Support.setText("Support");
        Support.setPreferredSize(new java.awt.Dimension(200, 50));
        Support.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupportActionPerformed(evt);
            }
        });

        Reports.setBackground(new java.awt.Color(204, 204, 255));
        Reports.setText("Reports");
        Reports.setPreferredSize(new java.awt.Dimension(200, 50));
        Reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProfileManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Claims, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(CertificateManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Payments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PolicyManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Support, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ProfileManagement, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Support, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CertificateManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PolicyManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Claims, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Payments, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
    
    private void NotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificationsActionPerformed
// Implement notification display
        JOptionPane.showMessageDialog(this, 
            "Notification feature will be implemented here",
            "Notifications", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_NotificationsActionPerformed

    private void ProfileManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileManagementActionPerformed
           // Open ProfileManagement GUI
    ProfileManagement profileFrame = new ProfileManagement();
    profileFrame.setVisible(true);


    }//GEN-LAST:event_ProfileManagementActionPerformed

    private void PaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentsActionPerformed
           Payment_BillingManagement paymentBillingGUI = new Payment_BillingManagement();
    paymentBillingGUI.setVisible(true);
    }//GEN-LAST:event_PaymentsActionPerformed

    private void PolicyManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PolicyManagementActionPerformed
    PolicyManagement policyManagement = new PolicyManagement();
    policyManagement.setVisible(true);
    this.dispose(); // closes the current window
    }//GEN-LAST:event_PolicyManagementActionPerformed

    private void SupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupportActionPerformed
    CustomerSupport customerSupport = new CustomerSupport();
    customerSupport.setVisible(true);
    }//GEN-LAST:event_SupportActionPerformed

    private void CertificateManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CertificateManagementActionPerformed
      // Open CertificateManagement GUI
    CertificateManagement certificateFrame = new CertificateManagement();
    certificateFrame.setVisible(true);
    }//GEN-LAST:event_CertificateManagementActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

         // Open ProfileManagement GUI
    ProfileManagement profileFrame = new ProfileManagement();
    profileFrame.setVisible(true);

    // Optionally close or hide the dashboard
    this.dispose(); // closes the DashBoard window
    
    }//GEN-LAST:event_LogoutActionPerformed

    

    
    private void ReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsActionPerformed
    PolicyManagement policyManagement = new PolicyManagement();
    policyManagement.setVisible(true);
    this.dispose(); // closes the current window
    }//GEN-LAST:event_ReportsActionPerformed

    private void ClaimsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaimsActionPerformed
    ClaimProcess claimProcess = new ClaimProcess();
    claimProcess.setVisible(true);
    }//GEN-LAST:event_ClaimsActionPerformed

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public  void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CertificateManagement;
    private javax.swing.JButton Claims;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Notifications;
    private javax.swing.JButton Payments;
    private javax.swing.JButton PolicyManagement;
    private javax.swing.JButton ProfileManagement;
    private javax.swing.JButton Reports;
    private javax.swing.JButton Support;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
