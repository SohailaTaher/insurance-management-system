
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;



public class ClaimProcess extends javax.swing.JFrame {
   private Connection conn;
   
    public ClaimProcess() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        claimTypeComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        policyNumberTextField = new javax.swing.JTextField();
        incidentDateTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        amountTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        documentsList = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        claimsTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pendingClaimsTable = new javax.swing.JTable();
        statusCombobox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        submitDecision = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        BrowseFiles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Submit New Claim:");

        claimTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"Medical\"", "\"Auto\"", "\"Property\"" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Policy Number:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Incident Date:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Description:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Amount:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Documents:");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Save Draft");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Submit Claim");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        incidentDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidentDateTextFieldActionPerformed(evt);
            }
        });

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        amountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTextFieldActionPerformed(evt);
            }
        });

        documentsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(documentsList);

        jScrollPane3.setViewportView(jScrollPane2);

        jButton4.setText("Browse");
        jScrollPane3.setViewportView(jButton4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(claimTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(policyNumberTextField)
                            .addComponent(incidentDateTextField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(amountTextField)
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton3)
                        .addGap(92, 92, 92)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(claimTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(policyNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(incidentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Claim Submission", jPanel1);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        claimsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Claim ID", "Date", "Type", "Status", "Amount"
            }
        ));
        jScrollPane4.setViewportView(claimsTable);

        jLabel9.setText("Claim Status Tracker");

        refreshButton.setBackground(new java.awt.Color(204, 204, 255));
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(refreshButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(refreshButton)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Claim Status Tracker", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        pendingClaimsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(pendingClaimsTable);

        statusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"Approve\"", "\"Reject\"", "\"Request More Info\"" }));

        jLabel10.setText("Status:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jLabel11.setText("Comment:");

        submitDecision.setBackground(new java.awt.Color(204, 204, 255));
        submitDecision.setText("Submit Decision");
        submitDecision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDecisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(submitDecision)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(submitDecision)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Claim Approval", jPanel4);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setText("Upload Supporting Documents:");

        BrowseFiles.setBackground(new java.awt.Color(204, 204, 255));
        BrowseFiles.setText("Browse Files");
        BrowseFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BrowseFiles)
                    .addComponent(jLabel8))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrowseFiles)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Document Upload", jPanel2);

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setText(" Insurance Claims Processing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                             
    String claimType = claimTypeComboBox.getSelectedItem().toString();
    String policyNumber = policyNumberTextField.getText();
    String incidentDate = incidentDateTextField.getText();
    String description = descriptionTextArea.getText();
    String amount = amountTextField.getText();
    String documents = documentsList.getSelectedValuesList().toString();
    
    // Example saving logic (you can write to file or database)
    System.out.println("Saving draft:");
    System.out.println("Type: " + claimType);
    System.out.println("Policy #: " + policyNumber);
    System.out.println("Incident Date: " + incidentDate);
    System.out.println("Description: " + description);
    System.out.println("Amount: " + amount);
    System.out.println("Documents: " + documents);
    
    JOptionPane.showMessageDialog(this, "Draft saved!");


    }//GEN-LAST:event_jButton2ActionPerformed

    private void incidentDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidentDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incidentDateTextFieldActionPerformed

    private void amountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTextFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String claimType = claimTypeComboBox.getSelectedItem().toString();
    String policyNumber = policyNumberTextField.getText();
    String incidentDate = incidentDateTextField.getText();
    String description = descriptionTextArea.getText();
    String amount = amountTextField.getText();
    String documents = documentsList.getSelectedValuesList().toString();
    
    // Example processing (replace with your backend logic)
    System.out.println("Submitting claim:");
    System.out.println("Type: " + claimType);
    System.out.println("Policy #: " + policyNumber);
    System.out.println("Incident Date: " + incidentDate);
    System.out.println("Description: " + description);
    System.out.println("Amount: " + amount);
    System.out.println("Documents: " + documents);
    
    JOptionPane.showMessageDialog(this, "Claim submitted successfully!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BrowseFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseFilesActionPerformed
       // Create a file chooser dialog
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    
    // Allow multiple file selection
    fileChooser.setMultiSelectionEnabled(true);
    
    // Set file filter to show only document types
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Document Files", "pdf", "doc", "docx", "jpg", "png", "txt"));
    
    // Show the dialog and check if the user selected files
    int result = fileChooser.showOpenDialog(this);
    
    if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
        // Get the selected files
        java.io.File[] selectedFiles = fileChooser.getSelectedFiles();
        
        if (selectedFiles.length > 0) {
            try {
                // Update the UI to show processing state
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                 BrowseFiles.setEnabled(false);
                
                // Process each selected file
                java.util.List<String> uploadedFiles = new java.util.ArrayList<>();
                for (java.io.File file : selectedFiles) {
                    // In a real app, you would upload the file to a server here
                    boolean uploaded = uploadFile(file);
                    
                    if (uploaded) {
                        uploadedFiles.add(file.getName());
                        
                        // Add file to the upload list display (if you have one)
                        updateUploadedFilesList(file.getName());
                    }
                }
                
                // Show success message with list of uploaded files
                if (!uploadedFiles.isEmpty()) {
                    StringBuilder message = new StringBuilder("Successfully uploaded:\n");
                    for (String fileName : uploadedFiles) {
                        message.append("- ").append(fileName).append("\n");
                    }
                    
                    javax.swing.JOptionPane.showMessageDialog(this, 
                            message.toString(), 
                            "Files Uploaded", 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                
                javax.swing.JOptionPane.showMessageDialog(this, 
                        "Error processing files: " + ex.getMessage(), 
                        "Upload Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } finally {
               
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                BrowseFiles.setEnabled(true);
            }
        }
    }
    }//GEN-LAST:event_BrowseFilesActionPerformed

    
    private boolean uploadFile(java.io.File file) {
    try {
        // Simulate file upload with a small delay
        Thread.sleep(300); // Simulate network delay
        
        // In a real app, this would be your file upload code
        System.out.println("Uploading file: " + file.getAbsolutePath());
        
        // Simulate file validation and processing
        if (file.length() > 10 * 1024 * 1024) { // 10MB limit example
            throw new Exception("File size exceeds 10MB limit");
        }
        
        return true;
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return false;
    } catch (Exception e) {
        System.err.println("Error uploading file: " + e.getMessage());
        return false;
    }
}
    
 private void updateUploadedFilesList(String fileName) {
    // This method would update your UI to show the uploaded file
    // Assuming you have a list model or component to display uploaded files
    
    // Example implementation if you have a JList with a DefaultListModel:
    // DefaultListModel<String> listModel = (DefaultListModel<String>) uploadedFilesList.getModel();
    // listModel.addElement(fileName);
    
    // If you don't have a list component yet, this method could be modified later
    // For now, just log the file name
    System.out.println("Added file to upload list: " + fileName);
}   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                               
    policyNumberTextField.setText("");
    incidentDateTextField.setText("");
    descriptionTextArea.setText("");
    amountTextField.setText("");
    documentsList.clearSelection();
    
    JOptionPane.showMessageDialog(this, "Form cleared.");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
            try {
        // Update the UI to show processing state
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        refreshButton.setEnabled(false);
        
        // Clear the existing table data
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) claimsTable.getModel();
        model.setRowCount(0);
        
        // Load the latest data - in a real app, this would come from a database or service
        // Here we're just adding sample data
        loadClaimsData();
        
        // Show success message to the user
        javax.swing.JOptionPane.showMessageDialog(this, 
                "Claims data refreshed successfully.", 
                "Refresh Complete", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        // Handle any errors that occur during refresh
        javax.swing.JOptionPane.showMessageDialog(this, 
                "Error refreshing claims data: " + ex.getMessage(), 
                "Refresh Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        // Reset the UI state
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refreshButton.setEnabled(true);
    }
    }//GEN-LAST:event_refreshButtonActionPerformed

    
    private void loadClaimsData() {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) claimsTable.getModel();
    
    // Add sample data rows - replace with actual data in production
    model.addRow(new Object[]{"CL001", "05/01/2025", "Auto", "Pending", "$1,250.00"});
    model.addRow(new Object[]{"CL002", "05/02/2025", "Home", "Approved", "$3,500.00"});
    model.addRow(new Object[]{"CL003", "05/03/2025", "Health", "In Review", "$750.00"});
    model.addRow(new Object[]{"CL004", "05/04/2025", "Life", "Denied", "$5,000.00"});
    
    // Notify the table that data has changed
    model.fireTableDataChanged();
}

    
    
    
    
    private void submitDecisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDecisionActionPerformed
  try {
        // Check if we have valid input data
        if (statusCombobox.getSelectedItem() == null || 
            jTextArea2.getText().trim().isEmpty()) {
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Please select a status and enter comments before submitting.", 
                    "Validation Error", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the selected claim ID from the table
        int selectedRow = claimsTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Please select a claim from the table first.", 
                    "Selection Required", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the claim details
        String claimId = claimsTable.getValueAt(selectedRow, 0).toString();
        String selectedStatus = statusCombobox.getSelectedItem().toString();
        String comments = jTextArea2.getText().trim();
        
        // Update the UI to show processing state
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        submitDecision.setEnabled(false);
        
        // Submit the decision - in a real app, this would call a service
        boolean success = submitClaimDecision(claimId, selectedStatus, comments);
        
        if (success) {
            // Update the status in the table
            claimsTable.setValueAt(selectedStatus, selectedRow, 3);
            
            // Clear the form fields
            statusCombobox.setSelectedIndex(0);
            jTextArea2.setText("");
            
            // Show success message
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Decision for claim " + claimId + " has been submitted successfully.", 
                    "Submission Complete", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception ex) {
        // Handle any errors that occur during submission
        javax.swing.JOptionPane.showMessageDialog(this, 
                "Error submitting decision: " + ex.getMessage(), 
                "Submission Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        // Reset the UI state
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        submitDecision.setEnabled(true);
    }
    }//GEN-LAST:event_submitDecisionActionPerformed

private boolean submitClaimDecision(String claimId, String status, String comments) {
    // Simulate a service call with a small delay
    try {
        // In a real app, this would be a call to your business logic or service layer
        Thread.sleep(500); // Simulate network/processing delay
        
        // Log the decision (replace with actual persistence in production)
        System.out.println("Decision submitted for claim " + claimId + 
                ": Status = " + status + ", Comments = " + comments);
        
        return true;
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return false;
    }
}
 

// Helper method to validate form inputs
private boolean validateClaimForm() {
    // Validate policy number
    if (policyNumberTextField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please enter a valid policy number",
            "Validation Error", 
            JOptionPane.WARNING_MESSAGE);
        policyNumberTextField.requestFocus();
        return false;
    }
    
    // Validate incident date
    if (incidentDateTextField == null) {
        JOptionPane.showMessageDialog(this, 
            "Please select a valid incident date",
            "Validation Error", 
            JOptionPane.WARNING_MESSAGE);
        incidentDateTextField.requestFocus();
        return false;
    }
    
    // Validate description
    if (descriptionTextArea.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please enter a claim description",
            "Validation Error", 
            JOptionPane.WARNING_MESSAGE);
        descriptionTextArea.requestFocus();
        return false;
    }
    
    // Validate amount
    try {
        double amount = Double.parseDouble(amountTextField.getText());
        if (amount <= 0) {
            throw new NumberFormatException();
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, 
            "Please enter a valid positive amount",
            "Validation Error", 
            JOptionPane.WARNING_MESSAGE);
        amountTextField.requestFocus();
        return false;
    }
    
    return true;
}




    
    
    
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
            java.util.logging.Logger.getLogger(ClaimProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClaimProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClaimProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClaimProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClaimProcess().setVisible(true);
            }
        });
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseFiles;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JComboBox<String> claimTypeComboBox;
    private javax.swing.JTable claimsTable;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JList<String> documentsList;
    private javax.swing.JTextField incidentDateTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable pendingClaimsTable;
    private javax.swing.JTextField policyNumberTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JComboBox<String> statusCombobox;
    private javax.swing.JButton submitDecision;
    // End of variables declaration//GEN-END:variables
}
