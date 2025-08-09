
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class PolicyManagement extends javax.swing.JFrame {

    // Database connection
    private Connection conn;
    // To store current user info
    private String currentUser;
    private boolean isMfaEnabled = false;
    private int userId = -1;
    
    
    public PolicyManagement() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Search: ");

        jTextField1.setText("[                                                 ]");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Policy ID", "Type", "Customer", "Status", "Premium"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Premium");
        }

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Add Policy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setText("Renew");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setText("Export");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(204, 204, 255));
        jButton13.setText("Print");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(jButton2)
                            .addGap(40, 40, 40)
                            .addComponent(jButton3)
                            .addGap(40, 40, 40)
                            .addComponent(jButton4)
                            .addGap(40, 40, 40)
                            .addComponent(jButton5)
                            .addGap(40, 40, 40)
                            .addComponent(jButton6)
                            .addGap(40, 40, 40)
                            .addComponent(jButton13))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton13))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Policies", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText("Search: ");

        jTextField2.setText("[                                                                 ]");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer ID", "Name", "Phone", " Policies"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jButton9.setBackground(new java.awt.Color(204, 204, 255));
        jButton9.setText("View Details");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 204, 255));
        jButton10.setText("Edit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(204, 204, 255));
        jButton11.setText("Add Policy");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(204, 204, 255));
        jButton12.setText("Send Notification");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton9)
                        .addGap(66, 66, 66)
                        .addComponent(jButton10)
                        .addGap(66, 66, 66)
                        .addComponent(jButton11)
                        .addGap(66, 66, 66)
                        .addComponent(jButton12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customers", jPanel4);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setText("REPORT TYPE:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("DATE RANGE:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("REPORT PREVIEW (PDF/Chart)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(204, 204, 255));
        jButton14.setText("Export PDF");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(204, 204, 255));
        jButton15.setText("Export Excel");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(204, 204, 255));
        jButton16.setText("Email Report");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel7.setText("to");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(34, 34, 34)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(50, 50, 50)
                        .addComponent(jButton14)
                        .addGap(50, 50, 50)
                        .addComponent(jButton15)
                        .addGap(50, 50, 50)
                        .addComponent(jButton16)))
                .addGap(100, 100, 100))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(74, 74, 74)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton14)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addGap(100, 100, 100))
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        jLabel3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel3.setText(" Policy Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a policy to renew", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String currentStatus = model.getValueAt(selectedRow, 3).toString();
    
    if (!"Active".equals(currentStatus) ){
        JOptionPane.showMessageDialog(this, "Only active policies can be renewed", 
            "Renewal Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Get current premium
    String premiumStr = model.getValueAt(selectedRow, 4).toString().replace("$", "");
    double currentPremium = Double.parseDouble(premiumStr);
    
    // Calculate renewal with 5% increase
    double newPremium = currentPremium * 1.05;
    
    int confirm = JOptionPane.showConfirmDialog(this, 
        String.format("Renew policy with new premium of $%.2f (5%% increase)?", newPremium),
        "Confirm Renewal", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Update premium and set status to Active (in case it was about to expire)
        model.setValueAt("Active", selectedRow, 3);
        model.setValueAt(String.format("$%.2f", newPremium), selectedRow, 4);
        
        JOptionPane.showMessageDialog(this, "Policy renewed successfully!");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         // Create a dialog to collect policy details
    JPanel panel = new JPanel(new GridLayout(0, 2));
    JTextField policyIdField = new JTextField();
    JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Auto", "Home", "Life", "Health"});
    JTextField customerField = new JTextField();
    JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Active", "Pending", "Cancelled", "Expired"});
    JTextField premiumField = new JTextField();
    
    panel.add(new JLabel("Policy ID:"));
    panel.add(policyIdField);
    panel.add(new JLabel("Type:"));
    panel.add(typeCombo);
    panel.add(new JLabel("Customer:"));
    panel.add(customerField);
    panel.add(new JLabel("Status:"));
    panel.add(statusCombo);
    panel.add(new JLabel("Premium:"));
    panel.add(premiumField);
    
    int result = JOptionPane.showConfirmDialog(this, panel, "Add New Policy", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Validate inputs
            if (policyIdField.getText().trim().isEmpty() || customerField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Policy ID and Customer are required fields");
            }
            
            double premium = Double.parseDouble(premiumField.getText());
            
            // Add to table
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{
                policyIdField.getText(),
                typeCombo.getSelectedItem(),
                customerField.getText(),
                statusCombo.getSelectedItem(),
                String.format("$%.2f", premium)
            });
            
            JOptionPane.showMessageDialog(this, "Policy added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid premium amount", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
int selectedRow = jTable2.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a customer", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel customerModel = (DefaultTableModel) jTable2.getModel();
    String customerId = customerModel.getValueAt(selectedRow, 0).toString();
    String customerName = customerModel.getValueAt(selectedRow, 1).toString();
    
    // Create policy dialog pre-populated with customer info
    JPanel panel = new JPanel(new GridLayout(0, 2));
    JTextField policyIdField = new JTextField();
    JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Auto", "Home", "Life", "Health"});
    JTextField customerIdField = new JTextField(customerId);
    customerIdField.setEditable(false);
    JTextField customerNameField = new JTextField(customerName);
    customerNameField.setEditable(false);
    JTextField premiumField = new JTextField();
    
    panel.add(new JLabel("Policy ID:"));
    panel.add(policyIdField);
    panel.add(new JLabel("Type:"));
    panel.add(typeCombo);
    panel.add(new JLabel("Customer ID:"));
    panel.add(customerIdField);
    panel.add(new JLabel("Customer Name:"));
    panel.add(customerNameField);
    panel.add(new JLabel("Premium:"));
    panel.add(premiumField);
    
    int result = JOptionPane.showConfirmDialog(this, panel, "Add Policy for Customer", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Validate inputs
            if (policyIdField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Policy ID is required");
            }
            
            double premium = Double.parseDouble(premiumField.getText());
            
            // Add to policies table
            DefaultTableModel policyModel = (DefaultTableModel) jTable1.getModel();
            policyModel.addRow(new Object[]{
                policyIdField.getText(),
                typeCombo.getSelectedItem(),
                customerName,
                "Active",  // Default status for new policies
                String.format("$%.2f", premium)
            });
            
            // Update customer's policy count
            String currentPolicies = customerModel.getValueAt(selectedRow, 3).toString();
            if (currentPolicies.isEmpty() || currentPolicies.equals("0")) {
                customerModel.setValueAt("1", selectedRow, 3);
            } else {
                try {
                    int count = Integer.parseInt(currentPolicies);
                    customerModel.setValueAt(String.valueOf(count + 1), selectedRow, 3);
                } catch (NumberFormatException e) {
                    customerModel.setValueAt(currentPolicies + ", +1", selectedRow, 3);
                }
            }
            
            JOptionPane.showMessageDialog(this, "Policy added successfully for customer!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid premium amount", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a customer", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    String customerName = model.getValueAt(selectedRow, 1).toString();
    String phone = model.getValueAt(selectedRow, 2).toString();
    
    // Create notification dialog
    JPanel panel = new JPanel(new BorderLayout());
    
    JPanel infoPanel = new JPanel(new GridLayout(3, 1));
    infoPanel.add(new JLabel("Customer: " + customerName));
    infoPanel.add(new JLabel("Phone: " + phone));
    infoPanel.add(new JLabel(" ")); // spacer
    
    JTextArea messageArea = new JTextArea(5, 30);
    messageArea.setLineWrap(true);
    messageArea.setWrapStyleWord(true);
    
    panel.add(infoPanel, BorderLayout.NORTH);
    panel.add(new JLabel("Notification Message:"), BorderLayout.CENTER);
    panel.add(new JScrollPane(messageArea), BorderLayout.SOUTH);
    
    int result = JOptionPane.showConfirmDialog(this, panel, "Send Notification", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
    if (result == JOptionPane.OK_OPTION && !messageArea.getText().trim().isEmpty()) {
        // In a real application, this would connect to an SMS/email service
        JOptionPane.showMessageDialog(this, 
            "Notification sent to customer:\n" + messageArea.getText(),
            "Notification Sent", JOptionPane.INFORMATION_MESSAGE);
    }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
try {
        MessageFormat header = new MessageFormat("Policy Management - Policy List");
        MessageFormat footer = new MessageFormat("Page {0}");
        
        jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        JOptionPane.showMessageDialog(this, "Printing complete");
    } catch (PrinterException e) {
        JOptionPane.showMessageDialog(this, 
            "Printing failed: " + e.getMessage(),
            "Print Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton13ActionPerformed

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    //Search Button
    
    String searchTerm = jTextField1.getText().trim();
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term", "Search Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    boolean found = false;
    
    // Clear previous selections
    jTable1.clearSelection();
    
    // Search through all rows and columns
    for (int row = 0; row < model.getRowCount(); row++) {
        for (int col = 0; col < model.getColumnCount(); col++) {
            Object value = model.getValueAt(row, col);
            if (value != null && value.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
                // Select the matching row
                jTable1.addRowSelectionInterval(row, row);
                // Scroll to the row
                jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true));
                found = true;
            }
        }
    }
    
    if (!found) {
        JOptionPane.showMessageDialog(this, "No policies found matching: " + searchTerm, 
            "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a policy to edit", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Create a dialog with current values
    JPanel panel = new JPanel(new GridLayout(0, 2));
    JTextField policyIdField = new JTextField(model.getValueAt(selectedRow, 0).toString());
    JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Auto", "Home", "Life", "Health"});
    typeCombo.setSelectedItem(model.getValueAt(selectedRow, 1));
    JTextField customerField = new JTextField(model.getValueAt(selectedRow, 2).toString());
    JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Active", "Pending", "Cancelled", "Expired"});
    statusCombo.setSelectedItem(model.getValueAt(selectedRow, 3));
    
    // Remove $ sign from premium for editing
    String premiumStr = model.getValueAt(selectedRow, 4).toString().replace("$", "");
    JTextField premiumField = new JTextField(premiumStr);
    
    panel.add(new JLabel("Policy ID:"));
    panel.add(policyIdField);
    panel.add(new JLabel("Type:"));
    panel.add(typeCombo);
    panel.add(new JLabel("Customer:"));
    panel.add(customerField);
    panel.add(new JLabel("Status:"));
    panel.add(statusCombo);
    panel.add(new JLabel("Premium:"));
    panel.add(premiumField);
    
    int result = JOptionPane.showConfirmDialog(this, panel, "Edit Policy", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Validate inputs
            if (policyIdField.getText().trim().isEmpty() || customerField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Policy ID and Customer are required fields");
            }
            
            double premium = Double.parseDouble(premiumField.getText());
            
            // Update table row
            model.setValueAt(policyIdField.getText(), selectedRow, 0);
            model.setValueAt(typeCombo.getSelectedItem(), selectedRow, 1);
            model.setValueAt(customerField.getText(), selectedRow, 2);
            model.setValueAt(statusCombo.getSelectedItem(), selectedRow, 3);
            model.setValueAt(String.format("$%.2f", premium), selectedRow, 4);
            
            JOptionPane.showMessageDialog(this, "Policy updated successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid premium amount", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
               int selectedRow = jTable1.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a policy to cancel", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String currentStatus = model.getValueAt(selectedRow, 3).toString();
    
    if ("Cancelled".equals(currentStatus)) {
        JOptionPane.showMessageDialog(this, "Policy is already cancelled", 
            "Cancellation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to cancel this policy?\nThis action cannot be undone.",
        "Confirm Cancellation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    
    if (confirm == JOptionPane.YES_OPTION) {
        model.setValueAt("Cancelled", selectedRow, 3);
        JOptionPane.showMessageDialog(this, "Policy cancelled successfully");
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Export Policies");
    fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files (*.csv)", "csv"));
    
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        // Ensure .csv extension
        if (!file.getName().toLowerCase().endsWith(".csv")) {
            file = new File(file.getParentFile(), file.getName() + ".csv");
        }
        
        try (PrintWriter writer = new PrintWriter(file)) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            // Write headers
            for (int col = 0; col < model.getColumnCount(); col++) {
                writer.print(model.getColumnName(col));
                if (col < model.getColumnCount() - 1) {
                    writer.print(",");
                }
            }
            writer.println();
            
            // Write data
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    writer.print(value != null ? value.toString().replace(",", "") : "");
                    if (col < model.getColumnCount() - 1) {
                        writer.print(",");
                    }
                }
                writer.println();
            }
            
            JOptionPane.showMessageDialog(this, 
                "Policies exported successfully to:\n" + file.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error exporting policies: " + e.getMessage(),
                "Export Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
     int selectedRow = jTable2.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a customer", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    
    // Create a detailed view dialog
    JTextArea detailsArea = new JTextArea(10, 30);
    detailsArea.setEditable(false);
    detailsArea.append("CUSTOMER DETAILS\n\n");
    detailsArea.append("Customer ID: " + model.getValueAt(selectedRow, 0) + "\n");
    detailsArea.append("Name: " + model.getValueAt(selectedRow, 1) + "\n");
    detailsArea.append("Phone: " + model.getValueAt(selectedRow, 2) + "\n");
    detailsArea.append("Policies: " + model.getValueAt(selectedRow, 3) + "\n\n");
    
    // Add some mock policy details
    detailsArea.append("POLICY DETAILS:\n");
    detailsArea.append(" - Auto Policy #A12345 (Active)\n");
    detailsArea.append(" - Home Policy #H67890 (Active)\n");
    
    JOptionPane.showMessageDialog(this, new JScrollPane(detailsArea), 
        "Customer Details", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       int selectedRow = jTable2.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a customer to edit", 
            "Selection Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    
    // Create edit dialog
    JPanel panel = new JPanel(new GridLayout(0, 2));
    JTextField idField = new JTextField(model.getValueAt(selectedRow, 0).toString());
    idField.setEditable(false); // Typically don't allow editing ID
    JTextField nameField = new JTextField(model.getValueAt(selectedRow, 1).toString());
    JTextField phoneField = new JTextField(model.getValueAt(selectedRow, 2).toString());
    
    panel.add(new JLabel("Customer ID:"));
    panel.add(idField);
    panel.add(new JLabel("Name:"));
    panel.add(nameField);
    panel.add(new JLabel("Phone:"));
    panel.add(phoneField);
    
    int result = JOptionPane.showConfirmDialog(this, panel, "Edit Customer", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
    if (result == JOptionPane.OK_OPTION) {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Update customer details
        model.setValueAt(nameField.getText(), selectedRow, 1);
        model.setValueAt(phoneField.getText(), selectedRow, 2);
        
        JOptionPane.showMessageDialog(this, "Customer updated successfully!");
    }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         String reportType = (String) jComboBox1.getSelectedItem();
    String dateFrom = (String) jComboBox2.getSelectedItem();
    String dateTo = (String) jComboBox3.getSelectedItem();
    
    // Generate report content based on selections
    StringBuilder reportContent = new StringBuilder();
    reportContent.append("Policy Management Report\n\n");
    reportContent.append("Report Type: ").append(reportType).append("\n");
    reportContent.append("Date Range: ").append(dateFrom).append(" to ").append(dateTo).append("\n\n");
    
    // Add some mock data
    reportContent.append("Summary:\n");
    reportContent.append("- Total Policies: 42\n");
    reportContent.append("- Active Policies: 35\n");
    reportContent.append("- Premiums This Period: $12,450.00\n\n");
    reportContent.append("Top Customers:\n");
    reportContent.append("1. John Smith (5 policies)\n");
    reportContent.append("2. Sarah Johnson (3 policies)\n");
    reportContent.append("3. Michael Brown (3 policies)\n");
    
    // Display printable dialog
    JTextArea textArea = new JTextArea(reportContent.toString());
    textArea.setEditable(false);
    
    try {
        textArea.print(); // Simple print of the text area
        JOptionPane.showMessageDialog(this, "Report printed successfully");
    } catch (PrinterException e) {
        JOptionPane.showMessageDialog(this, 
            "Error printing report: " + e.getMessage(),
            "Print Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Export Report as PDF");
    fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf"));
    
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        // Ensure .pdf extension
        if (!file.getName().toLowerCase().endsWith(".pdf")) {
            file = new File(file.getParentFile(), file.getName() + ".pdf");
        }
        
        // In a real application, you would use a PDF library like iText
        // This is just a simulation
        try {
            // Simulate PDF generation
            Thread.sleep(1000);
            
            JOptionPane.showMessageDialog(this, 
                "Report exported as PDF to:\n" + file.getAbsolutePath(),
                "Export Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error exporting PDF: " + e.getMessage(),
                "Export Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Export Report as Excel");
    fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
    
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        // Ensure .xlsx extension
        if (!file.getName().toLowerCase().endsWith(".xlsx")) {
            file = new File(file.getParentFile(), file.getName() + ".xlsx");
        }
        
        // In a real application, you would use a library like Apache POI
        // This is just a simulation
        try {
            // Simulate Excel export
            Thread.sleep(1000);
            
            JOptionPane.showMessageDialog(this, 
                "Report exported as Excel to:\n" + file.getAbsolutePath(),
                "Export Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error exporting Excel: " + e.getMessage(),
                "Export Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
    // Get email input
    String email = JOptionPane.showInputDialog(this, 
        "Enter recipient email address:", 
        "Email Report", JOptionPane.QUESTION_MESSAGE);
    
    if (email != null && !email.trim().isEmpty()) {
        // Simple email validation
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid email address",
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // In a real application, this would connect to an email service
        // Simulate sending with a delay
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate network delay
                
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, 
                        "Report sent successfully to:\n" + email,
                        "Email Sent", JOptionPane.INFORMATION_MESSAGE);
                });
            } catch (InterruptedException e) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, 
                        "Error sending email: " + e.getMessage(),
                        "Email Error", JOptionPane.ERROR_MESSAGE);
                });
            }
        }).start();
        
        JOptionPane.showMessageDialog(this, 
            "Sending report to " + email + "...",
            "Sending Email", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String searchTerm = jTextField2.getText().trim();
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term", "Search Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    boolean found = false;
    
    // Clear previous selections
    jTable2.clearSelection();
    
    // Search through all rows and columns
    for (int row = 0; row < model.getRowCount(); row++) {
        for (int col = 0; col < model.getColumnCount(); col++) {
            Object value = model.getValueAt(row, col);
            if (value != null && value.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
                // Select the matching row
                jTable2.addRowSelectionInterval(row, row);
                // Scroll to the row
                jTable2.scrollRectToVisible(jTable2.getCellRect(row, 0, true));
                found = true;
            }
        }
    }
    
    if (!found) {
        JOptionPane.showMessageDialog(this, "No customers found matching: " + searchTerm, 
            "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jButton8ActionPerformed



    
    
    
    
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
            java.util.logging.Logger.getLogger(PolicyManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PolicyManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PolicyManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PolicyManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PolicyManagement().setVisible(true);
}
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
