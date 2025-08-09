//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import java.util.regex.Pattern;


public class ProfileManagement extends javax.swing.JFrame {

    // Database connection
    private Connection conn;
    // To store current user info
    private String currentUser;
    private boolean isMfaEnabled = false;
    private int userId = -1;
    
    
    public ProfileManagement() {
        initComponents();
        setupDatabaseConnection();
        setupRadioButtons();
        setupForgotPasswordLink();
        setupTabChangeListener();
        connectActionListeners();
            initComponents();
    try {
        conn = DriverManager.getConnection("jdbc:derby:myDB");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
    }
       
    }

    
    private boolean userExists(String username, String email) throws SQLException {
    String sql = "SELECT 1 FROM USERS WHERE USERNAME = ? OR EMAIL = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, username);
        pstmt.setString(2, email);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next();
        }
    }
}

private String hashPassword(String password) {
    // Implement proper password hashing (e.g., BCrypt)
    return password; // Replace with real hashing
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
 

    
    private void connectActionListeners() {
        // Connect buttons to their actions
        registerButton.addActionListener(e -> registerUser());
        loginButton.addActionListener(e -> loginUser());
        sendCodeButton.addActionListener(e -> sendVerificationCode());
        resetPasswordButton.addActionListener(e -> resetPassword());
        updateButton.addActionListener(e -> updateUserInfo());
        mfaToggleButton.addActionListener(e -> toggleMfa());
        verifyMfaButton.addActionListener(e -> verifyMfa());
        
        // Notification preferences
        ActionListener notificationListener = e -> updateNotificationPreferences();
        emailNotificationsCheckbox.addActionListener(notificationListener);
        smsNotificationsCheckbox.addActionListener(notificationListener);
        inAppNotificationsCheckbox.addActionListener(notificationListener);
        thirtyDaysRadio.addActionListener(notificationListener);
        fifteenDaysRadio.addActionListener(notificationListener);
        sevenDaysRadio.addActionListener(notificationListener);
        threeDaysRadio.addActionListener(notificationListener);
        oneDayRadio.addActionListener(notificationListener);
    }
     
     
    private void setupRadioButtons() {
        // Group radio buttons in password reset tab
        ButtonGroup resetMethodGroup = new ButtonGroup();
        resetMethodGroup.add(emailRadioButton);
        resetMethodGroup.add(smsRadioButton);
        emailRadioButton.setSelected(true);
        
        // Group radio buttons in notifications tab
        ButtonGroup notificationGroup = new ButtonGroup();
        notificationGroup.add(thirtyDaysRadio);
        notificationGroup.add(fifteenDaysRadio);
        notificationGroup.add(sevenDaysRadio);
        notificationGroup.add(threeDaysRadio);
        notificationGroup.add(oneDayRadio);
        thirtyDaysRadio.setSelected(true);
    }
    
     private void setupForgotPasswordLink() {
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.setSelectedIndex(2); // Switch to Password Reset tab
            }
        });
    }
    
      
     
      
       private void setupTabChangeListener() {
        jTabbedPane1.addChangeListener(e -> {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            
//            // Reset fields when switching to registration tab
//            if (selectedIndex == 0) {
//                clearRegistrationFields();
//            }
            
            // Reset login fields when switching to login tab
            if (selectedIndex == 1) {
                usernameField.setText("");
                loginPasswordField.setText("");
                rememberMeCheckbox.setSelected(false);
            }
            
            // Reset password reset fields when switching to password reset tab
            if (selectedIndex == 2) {
                contactField.setText("");
                verificationCodeField.setText("");
                newPasswordField.setText("");
                confirmNewPasswordField.setText("");
            }
            
            // Disable access to tabs that require login when not logged in
            if (userId == -1 && (selectedIndex == 3 || selectedIndex == 4 || selectedIndex == 5)) {
                JOptionPane.showMessageDialog(this, 
                    "Please login before accessing this section.", 
                    "Authentication Required", 
                    JOptionPane.INFORMATION_MESSAGE);
                jTabbedPane1.setSelectedIndex(1); // Switch to login tab
            }
        });
    }
     
       
       
//       private void clearRegistrationFields() {
//        fullNameField.setText("");
//        phoneField.setText("");
//        emailField.setText("");
//        passwordField.setText("");
//        confirmPasswordField.setText("");
//        policyNumberField.setText("");
//        policyTypeCombo.setSelectedIndex(0);
//    }
    
    private boolean validateRegistrationInput() {
        // Validate full name
        if (fullNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your full name", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate phone number (simple validation)
        String phone = phoneField.getText().trim();
        if (phone.isEmpty() || !phone.matches("\\d{10,15}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number (10-15 digits)", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate email address
        String email = emailField.getText().trim();
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email.isEmpty() || !Pattern.matches(emailPattern, email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate password
        char[] password = passwordField.getPassword();
        if (password.length < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate password confirmation
        char[] confirmPass = confirmPasswordField.getPassword();
        if (!Arrays.equals(password, confirmPass)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate policy number
        String policyNum = policyNumberField.getText().trim();
        if (policyNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your policy number", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean validateLoginInput() {
        // Validate username/email
        if (usernameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your username or email", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate password
        if (loginPasswordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please enter your password", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean validateResetPasswordInput() {
        // Check verification method selection
        if (!emailRadioButton.isSelected() && !smsRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a verification method", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate contact info
        if (contactField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your contact information", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate verification code
        if (verificationCodeField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the verification code", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate new password
        char[] newPass = newPasswordField.getPassword();
        if (newPass.length < 8) {
            JOptionPane.showMessageDialog(this, "New password must be at least 8 characters long", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate confirm new password
        char[] confirmNewPass = confirmNewPasswordField.getPassword();
        if (!Arrays.equals(newPass, confirmNewPass)) {
            JOptionPane.showMessageDialog(this, "New passwords do not match", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean validateUpdateInfoInput() {
        // Validate current password
        if (currentPasswordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please enter your current password", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Check if at least one field is being updated
        if (addressField.getText().trim().isEmpty() 
            && updatePhoneField.getText().trim().isEmpty() 
            && emergencyContactField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill at least one field to update", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate phone format if provided
        String phone = updatePhoneField.getText().trim();
        if (!phone.isEmpty() && !phone.matches("\\d{10,15}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number (10-15 digits)", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void registerUser() {
        if (!validateRegistrationInput()) {
            return;
        }
        
        String fullName = fullNameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String passwordStr = new String(passwordField.getPassword());
        String policyNum = policyNumberField.getText().trim();
        String policyType = policyTypeCombo.getSelectedItem().toString();
        
        try {
            // Check if user already exists
            PreparedStatement checkStmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM users WHERE email = ?"
            );
            checkStmt.setString(1, email);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            
            if (checkResult.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "A user with this email already exists", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Insert new user
            PreparedStatement insertStmt = conn.prepareStatement(
                "INSERT INTO users (full_name, phone, email, password, policy_number, policy_type) " +
                "VALUES (?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            
            insertStmt.setString(1, fullName);
            insertStmt.setString(2, phone);
            insertStmt.setString(3, email);
            insertStmt.setString(4, passwordStr); // In real app, use hashing
            insertStmt.setString(5, policyNum);
            insertStmt.setString(6, policyType);
            
            int rowsAffected = insertStmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                clearRegistrationFields();
                // Switch to login tab
                jTabbedPane1.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Registration error: " + e.getMessage());
        }
    }
    
    private void loginUser() {
        if (!validateLoginInput()) {
            return;
        }
        
        String username = usernameField.getText().trim();
        String password = new String(loginPasswordField.getPassword());
        
        try {
            // Check if username is email or username
            PreparedStatement loginStmt = conn.prepareStatement(
                "SELECT id, full_name, email, mfa_enabled FROM users WHERE email = ? AND password = ?"
            );
            
            loginStmt.setString(1, username);
            loginStmt.setString(2, password); // In real app, use proper authentication
            
            ResultSet rs = loginStmt.executeQuery();
            
            if (rs.next()) {
                // Login successful
                userId = rs.getInt("id");
                currentUser = rs.getString("full_name");
                String email = rs.getString("email");
                isMfaEnabled = rs.getBoolean("mfa_enabled");
                
                JOptionPane.showMessageDialog(this, "Welcome back, " + currentUser + "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                
                // Update MFA toggle button state
                mfaToggleButton.setText(isMfaEnabled ? "Enabled" : "Disabled");
                
                // Remember login if checked
                if (rememberMeCheckbox.isSelected()) {
                    // In a real application, we would implement secure credential storage
                    System.out.println("Remember me selected for user: " + email);
                }
                
                // Switch to update info tab
                jTabbedPane1.setSelectedIndex(3);
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Login error: " + e.getMessage());
        }
    }
    
    private void sendVerificationCode() {
        String contact = contactField.getText().trim();
        if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email or phone number", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean isEmail = emailRadioButton.isSelected();
        
        try {
            // Check if the contact exists in the database
            String query = isEmail ? 
                "SELECT COUNT(*) FROM users WHERE email = ?" :
                "SELECT COUNT(*) FROM users WHERE phone = ?";
            
            PreparedStatement checkStmt = conn.prepareStatement(query);
            checkStmt.setString(1, contact);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            
            if (checkResult.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, 
                    isEmail ? "Email not found!" : "Phone number not found!", 
                    "Verification Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Generate a random 6-digit verification code
            String verificationCode = String.format("%06d", (int)(Math.random() * 1000000));
            
            // In a real application, we would send this code via email or SMS
            // For demonstration, we'll just show it in a message
            JOptionPane.showMessageDialog(this, 
                "Verification code sent to " + (isEmail ? "email" : "phone") + ": " + verificationCode, 
                "Code Sent", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Store the code in session or database with expiration time
            // For this demo, we'll just use a hardcoded value
            verificationCodeField.setText(verificationCode);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Verification error: " + e.getMessage());
        }
    }
    
    private void resetPassword() {
        if (!validateResetPasswordInput()) {
            return;
        }
        
        String contact = contactField.getText().trim();
        String verificationCode = verificationCodeField.getText().trim();
        String newPassword = new String(newPasswordField.getPassword());
        boolean isEmail = emailRadioButton.isSelected();
        
        // In a real application, we would validate the verification code against what was sent
        // For this demo, we'll assume the code is valid if it matches what's in the field
        
        try {
            // Update the password
            String query = isEmail ? 
                "UPDATE users SET password = ? WHERE email = ?" :
                "UPDATE users SET password = ? WHERE phone = ?";
            
            PreparedStatement updateStmt = conn.prepareStatement(query);
            updateStmt.setString(1, newPassword); // In real app, use hashing
            updateStmt.setString(2, contact);
            
            int rowsAffected = updateStmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Password reset successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Clear the fields
                contactField.setText("");
                verificationCodeField.setText("");
                newPasswordField.setText("");
                confirmNewPasswordField.setText("");
                
                // Switch to login tab
                jTabbedPane1.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(this, "Password reset failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Password reset error: " + e.getMessage());
        }
    }
    
    private void updateUserInfo() {
        if (!validateUpdateInfoInput() || userId == -1) {
            return;
        }
        
        String currentPassword = new String(currentPasswordField.getPassword());
        String address = addressField.getText().trim();
        String phone = updatePhoneField.getText().trim();
        String emergencyContact = emergencyContactField.getText().trim();
        
        try {
            // Verify current password
            PreparedStatement verifyStmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM users WHERE id = ? AND password = ?"
            );
            verifyStmt.setInt(1, userId);
            verifyStmt.setString(2, currentPassword);
            
            ResultSet verifyResult = verifyStmt.executeQuery();
            verifyResult.next();
            
            if (verifyResult.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "Current password is incorrect", "Authentication Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Update user information
            StringBuilder updateQuery = new StringBuilder("UPDATE users SET ");
            boolean needComma = false;
            
            if (!address.isEmpty()) {
                updateQuery.append("address = ?");
                needComma = true;
            }
            
            if (!phone.isEmpty()) {
                if (needComma) {
                    updateQuery.append(", ");
                }
                updateQuery.append("phone = ?");
                needComma = true;
            }
            
            if (!emergencyContact.isEmpty()) {
                if (needComma) {
                    updateQuery.append(", ");
                }
                updateQuery.append("emergency_contact = ?");
            }
            
            updateQuery.append(" WHERE id = ?");
            
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery.toString());
            
            int paramIndex = 1;
            if (!address.isEmpty()) {
                updateStmt.setString(paramIndex++, address);
            }
            
            if (!phone.isEmpty()) {
                updateStmt.setString(paramIndex++, phone);
            }
            
            if (!emergencyContact.isEmpty()) {
                updateStmt.setString(paramIndex++, emergencyContact);
            }
            
            updateStmt.setInt(paramIndex, userId);
            
            int rowsAffected = updateStmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Information updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Clear fields
                currentPasswordField.setText("");
                addressField.setText("");
                updatePhoneField.setText("");
                emergencyContactField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Update failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Update error: " + e.getMessage());
        }
    }
    
    private void toggleMfa() {
        if (userId == -1) {
            JOptionPane.showMessageDialog(this, "Please login first", "Authentication Required", JOptionPane.INFORMATION_MESSAGE);
            jTabbedPane1.setSelectedIndex(1);
            return;
        }
        
        isMfaEnabled = !isMfaEnabled;
        mfaToggleButton.setText(isMfaEnabled ? "Enabled" : "Disabled");
        
        try {
            // Update MFA status in database
            PreparedStatement updateStmt = conn.prepareStatement(
                "UPDATE users SET mfa_enabled = ? WHERE id = ?"
            );
            updateStmt.setBoolean(1, isMfaEnabled);
            updateStmt.setInt(2, userId);
            
            int rowsAffected = updateStmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, 
                    "Multi-Factor Authentication is now " + (isMfaEnabled ? "enabled" : "disabled"), 
                    "MFA Status Updated", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                // If MFA is enabled, show verification options
                smsVerificationCheckbox.setEnabled(isMfaEnabled);
                emailVerificationCheckbox.setEnabled(isMfaEnabled);
                mfaCodeField.setEnabled(isMfaEnabled);
                verifyMfaButton.setEnabled(isMfaEnabled);
                
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update MFA status", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("MFA update error: " + e.getMessage());
        }
    }
    
    private void verifyMfa() {
        if (!smsVerificationCheckbox.isSelected() && !emailVerificationCheckbox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select at least one verification method", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String mfaCode = mfaCodeField.getText().trim();
        if (mfaCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the verification code", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // In a real application, we would validate the MFA code
        // For this demo, we'll just show a success message
        JOptionPane.showMessageDialog(this, "MFA verification successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        try {
            // Update MFA methods in database
            PreparedStatement updateStmt = conn.prepareStatement(
                "UPDATE users SET sms_verification = ?, email_verification = ? WHERE id = ?"
            );
            updateStmt.setBoolean(1, smsVerificationCheckbox.isSelected());
            updateStmt.setBoolean(2, emailVerificationCheckbox.isSelected());
            updateStmt.setInt(3, userId);
            
            updateStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("MFA method update error: " + e.getMessage());
        }
    }
    
    private void updateNotificationPreferences() {
        if (userId == -1) {
            JOptionPane.showMessageDialog(this, "Please login first", "Authentication Required", JOptionPane.INFORMATION_MESSAGE);
            jTabbedPane1.setSelectedIndex(1);
            return;
        }
        
        try {
            // Get notification preferences
            boolean emailNotif = emailNotificationsCheckbox.isSelected();
            boolean smsNotif = smsNotificationsCheckbox.isSelected();
            boolean inAppNotif = inAppNotificationsCheckbox.isSelected();
            
            // Get notification frequency
            int days = 30; // Default
            if (fifteenDaysRadio.isSelected()) days = 15;
            else if (sevenDaysRadio.isSelected()) days = 7;
            else if (threeDaysRadio.isSelected()) days = 3;
            else if (oneDayRadio.isSelected()) days = 1;
            
            // Update preferences in database
            PreparedStatement updateStmt = conn.prepareStatement(
                "UPDATE user_preferences SET " +
                "email_notifications = ?, sms_notifications = ?, " +
                "in_app_notifications = ?, notification_days = ? " +
                "WHERE user_id = ?"
            );
            
            updateStmt.setBoolean(1, emailNotif);
            updateStmt.setBoolean(2, smsNotif);
            updateStmt.setBoolean(3, inAppNotif);
            updateStmt.setInt(4, days);
            updateStmt.setInt(5, userId);
            
            int rowsAffected = updateStmt.executeUpdate();
            
            if (rowsAffected == 0) {
                // No existing preferences, insert new row
                PreparedStatement insertStmt = conn.prepareStatement(
                    "INSERT INTO user_preferences " +
                    "(user_id, email_notifications, sms_notifications, in_app_notifications, notification_days) " +
                    "VALUES (?, ?, ?, ?, ?)"
                );
                
                insertStmt.setInt(1, userId);
                insertStmt.setBoolean(2, emailNotif);
                insertStmt.setBoolean(3, smsNotif);
                insertStmt.setBoolean(4, inAppNotif);
                insertStmt.setInt(5, days);
                
                insertStmt.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(this, "Notification preferences updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Notification preferences update error: " + e.getMessage());
        }
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        policyNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        policyTypeCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        loginPasswordField = new javax.swing.JPasswordField();
        forgotPasswordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        rememberMeCheckbox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        emailRadioButton = new javax.swing.JRadioButton();
        smsRadioButton = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        contactField = new javax.swing.JTextField();
        sendCodeButton = new javax.swing.JButton();
        verificationCodeField = new javax.swing.JTextField();
        newPasswordField = new javax.swing.JPasswordField();
        confirmNewPasswordField = new javax.swing.JPasswordField();
        resetPasswordButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        currentPasswordField = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        updatePhoneField = new javax.swing.JTextField();
        emergencyContactField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        mfaToggleButton = new javax.swing.JToggleButton();
        jLabel15 = new javax.swing.JLabel();
        smsVerificationCheckbox = new javax.swing.JCheckBox();
        emailVerificationCheckbox = new javax.swing.JCheckBox();
        verifyMfaButton = new javax.swing.JButton();
        mfaCodeField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        emailNotificationsCheckbox = new javax.swing.JCheckBox();
        smsNotificationsCheckbox = new javax.swing.JCheckBox();
        inAppNotificationsCheckbox = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        renewalsList = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        thirtyDaysRadio = new javax.swing.JRadioButton();
        fifteenDaysRadio = new javax.swing.JRadioButton();
        sevenDaysRadio = new javax.swing.JRadioButton();
        threeDaysRadio = new javax.swing.JRadioButton();
        oneDayRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setText("Profile Management Dashboard");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Personal Information:");

        fullNameField.setText("Full Name");
        fullNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameFieldActionPerformed(evt);
            }
        });

        phoneField.setText("Phone");

        emailField.setText("Email");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        policyNumberField.setText("Policy Number");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Policy Information: ");

        registerButton.setBackground(new java.awt.Color(204, 204, 255));
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        policyTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Health", "Auto", "Life", "Travel", "Home" }));
        policyTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                policyTypeComboActionPerformed(evt);
            }
        });

        jLabel4.setText("Policy Type: ");

        passwordField.setText("000000000000");
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        confirmPasswordField.setText("jPasswordField2");

        jLabel5.setText("Password:");

        jLabel6.setText("Confirm Password:");

        jLabel7.setText("Full Name:");

        jLabel19.setText("Phone:");

        jLabel20.setText("Email:");

        jLabel21.setText("Policy Number:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(policyTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(policyNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(phoneField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel21))))
                        .addGap(769, 769, 769))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(registerButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(fullNameField))
                .addGap(9, 9, 9)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(policyNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(policyTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(registerButton)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registration", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        usernameField.setText("Username/Email");

        loginPasswordField.setText("jPasswordField3");

        forgotPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        forgotPasswordLabel.setText("<html><u>Forgot Password?</u></html>");
        forgotPasswordLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        loginButton.setBackground(new java.awt.Color(204, 204, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        rememberMeCheckbox.setText("Remember Me");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Password:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Username/Email");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(forgotPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rememberMeCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton))
                .addContainerGap(816, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rememberMeCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forgotPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(loginButton)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        emailRadioButton.setText("Email");

        smsRadioButton.setText("SMS");
        smsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smsRadioButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText(" Select Verification Method: ");

        contactField.setText("Email/Phone   ");

        sendCodeButton.setText("Send Verification Code Button");

        verificationCodeField.setText("Verification Code");

        newPasswordField.setText("jPasswordField4");

        confirmNewPasswordField.setText("jPasswordField5");
        confirmNewPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmNewPasswordFieldActionPerformed(evt);
            }
        });

        resetPasswordButton.setBackground(new java.awt.Color(204, 204, 255));
        resetPasswordButton.setText("Reset Password");
        resetPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText(" New Password:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Confirm New Password:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Email/Phone :   ");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Send Verification Code :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Verification Code :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verificationCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(emailRadioButton)
                                .addGap(36, 36, 36)
                                .addComponent(smsRadioButton))
                            .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(765, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(resetPasswordButton)
                            .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailRadioButton)
                    .addComponent(smsRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(5, 5, 5)
                .addComponent(verificationCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(resetPasswordButton)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Password Reset  ", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        currentPasswordField.setText("jPasswordField6");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Current Password:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Personal Information to Update: ");

        addressField.setText("Address ");

        updatePhoneField.setText("Phone");
        updatePhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePhoneFieldActionPerformed(evt);
            }
        });

        emergencyContactField.setText("Emergency Contact ");
        emergencyContactField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergencyContactFieldActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(204, 204, 255));
        updateButton.setText("Update");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyContactField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addContainerGap(660, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updatePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emergencyContactField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(updateButton)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update Info  ", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Multi-Factor Authentication Status:");

        mfaToggleButton.setBackground(new java.awt.Color(153, 153, 255));
        mfaToggleButton.setText("Enabled/Disabled");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Setup Options: ");

        smsVerificationCheckbox.setText("SMS Verification");
        smsVerificationCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smsVerificationCheckboxActionPerformed(evt);
            }
        });

        emailVerificationCheckbox.setText("Email Verification");

        verifyMfaButton.setBackground(new java.awt.Color(204, 204, 255));
        verifyMfaButton.setText("Verify");

        mfaCodeField.setText("Verification Code ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mfaToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(emailVerificationCheckbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(smsVerificationCheckbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(verifyMfaButton)
                        .addComponent(mfaCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(735, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(mfaToggleButton)
                .addGap(43, 43, 43)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(smsVerificationCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailVerificationCheckbox)
                .addGap(18, 18, 18)
                .addComponent(mfaCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(verifyMfaButton)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MFA", jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText(" Notification Preferences: ");

        emailNotificationsCheckbox.setText("Email Notifications");
        emailNotificationsCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailNotificationsCheckboxActionPerformed(evt);
            }
        });

        smsNotificationsCheckbox.setText("SMS Notifications ");

        inAppNotificationsCheckbox.setText("In-App Notifications  ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Upcoming Renewals: ");

        renewalsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Policy #12345 - Expires 12/15/23 ", "Policy #67890 - Expires 01/20/24", "Policy #12367 - Expires 12/15/24", "Policy #67990 - Expires 01/20/23" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(renewalsList);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Notification Frequency:");

        thirtyDaysRadio.setText("30 days before");
        thirtyDaysRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirtyDaysRadioActionPerformed(evt);
            }
        });

        fifteenDaysRadio.setText("15 days");
        fifteenDaysRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fifteenDaysRadioActionPerformed(evt);
            }
        });

        sevenDaysRadio.setText("7 days");

        threeDaysRadio.setText("3 days");
        threeDaysRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeDaysRadioActionPerformed(evt);
            }
        });

        oneDayRadio.setText("1 day");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeDaysRadio)
                    .addComponent(fifteenDaysRadio)
                    .addComponent(thirtyDaysRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(smsNotificationsCheckbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailNotificationsCheckbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(inAppNotificationsCheckbox)
                    .addComponent(sevenDaysRadio)
                    .addComponent(oneDayRadio))
                .addContainerGap(559, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailNotificationsCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(smsNotificationsCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inAppNotificationsCheckbox)
                .addGap(49, 49, 49)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thirtyDaysRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fifteenDaysRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevenDaysRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(threeDaysRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oneDayRadio)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Notifications", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fullNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameFieldActionPerformed
           // Validate and format the full name
    String fullName = fullNameField.getText().trim();
    if (fullName.isEmpty()) {
        showMessage("Please enter your full name");
    } else {
        // Update profile with the new name
        updateProfileName(fullName);
    }
    }//GEN-LAST:event_fullNameFieldActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
          // Validate registration information                                               
    if (!validateRegistrationInput()) {
        return;
    }
    
    String name = fullNameField.getText().trim();
    String phone = phoneField.getText().trim();
    String email = emailField.getText().trim();
    String password = new String(passwordField.getPassword());
    // Note: Address isn't collected in your current form - you may need to add a field
    String address = ""; // Default empty or get from a new address field
    
    try {
        // First check if user already exists
        PreparedStatement checkStmt = conn.prepareStatement(
            "SELECT COUNT(*) FROM PERSON WHERE EMAIL = ? OR PHONE = ?"
        );
        checkStmt.setString(1, email);
        checkStmt.setString(2, phone);
        ResultSet checkResult = checkStmt.executeQuery();
        checkResult.next();
        
        if (checkResult.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, 
                "A user with this email or phone already exists", 
                "Registration Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Insert new person
        PreparedStatement insertStmt = conn.prepareStatement(
            "INSERT INTO PERSON (PERSON_ID, NAME, EMAIL, PHONE, ADDRESS, PASSWORD) " +
            "VALUES (NEXT VALUE FOR PERSON_SEQ, ?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );
        
        // Note: Using a sequence for PERSON_ID (common practice)
        // Adjust if your database uses auto-increment or another ID generation method
        insertStmt.setString(1, name);
        insertStmt.setString(2, email);
        insertStmt.setString(3, phone);
        insertStmt.setString(4, address);
        // In production, hash the password before storing!
        insertStmt.setString(5, password);
        
        int rowsAffected = insertStmt.executeUpdate();
        
        if (rowsAffected > 0) {
            // Get the generated PERSON_ID
            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1);
            }
            
            JOptionPane.showMessageDialog(this, 
                "Registration successful! Welcome " + name, 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Clear sensitive fields
            passwordField.setText("");
            confirmPasswordField.setText("");
            
            // Switch to login tab
            jTabbedPane1.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Registration failed. Please try again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Database error: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        System.err.println("Registration error: " + e.getMessage());
        e.printStackTrace();
    }





    }//GEN-LAST:event_registerButtonActionPerformed



    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
            // Password field action - typically triggered on Enter key
    // Check password strength when user completes entry
    String password = new String(passwordField.getPassword());
    int strength = checkPasswordStrength(password);
    updatePasswordStrengthIndicator(strength);
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void smsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smsRadioButtonActionPerformed
       // Enable SMS notification option
    boolean selected = smsRadioButton.isSelected();
    updatePhoneField.setEnabled(selected);
    // Update user preferences for notification method
    updateNotificationPreferences("sms", selected);
    }//GEN-LAST:event_smsRadioButtonActionPerformed

    private void confirmNewPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmNewPasswordFieldActionPerformed
           // Check if passwords match when user completes confirmation field
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmNewPasswordField.getPassword());
    
    if (!password.equals(confirmPassword)) {
        showMessage("Passwords do not match");
    } else {
        showMessage("Passwords match");
    }
    }//GEN-LAST:event_confirmNewPasswordFieldActionPerformed

    private void resetPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordButtonActionPerformed
            // Validate password reset fields
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmNewPasswordField.getPassword());
    
    if (password.isEmpty() || confirmPassword.isEmpty()) {
        showMessage("Please enter new password and confirmation");
    } else if (!password.equals(confirmPassword)) {
        showMessage("Passwords do not match");
    } else if (checkPasswordStrength(password) < 3) {
        showMessage("Password is too weak. Use at least 8 characters with numbers and symbols.");
    } else {
        // Reset the password
        resetUserPassword(password);
        showMessage("Password has been reset successfully");
    }
    }//GEN-LAST:event_resetPasswordButtonActionPerformed

    private void emergencyContactFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergencyContactFieldActionPerformed
         // Validate emergency contact information
    String contact = emergencyContactField.getText().trim();
    if (isValidPhoneNumber(contact) || isValidEmail(contact)) {
        updateEmergencyContact(contact);
        showMessage("Emergency contact updated");
    } else {
        showMessage("Please enter a valid phone number or email address");
    }
    }//GEN-LAST:event_emergencyContactFieldActionPerformed

    private void updatePhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePhoneFieldActionPerformed
           // Validate and update phone number
    String phone = updatePhoneField.getText().trim();
    if (isValidPhoneNumber(phone)) {
        updateUserPhone(phone);
        showMessage("Phone number updated successfully");
    } else {
        showMessage("Please enter a valid phone number");
    }
    }//GEN-LAST:event_updatePhoneFieldActionPerformed

    private void smsVerificationCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smsVerificationCheckboxActionPerformed
         // Toggle SMS verification option
    boolean enableSmsVerification = smsVerificationCheckbox.isSelected();
    // Update user preferences for verification method
    updateSecurityPreferences("smsVerification", enableSmsVerification);
    
    // If enabled, make sure we have a valid phone number
    if (enableSmsVerification && (updatePhoneField.getText().trim().isEmpty() || !isValidPhoneNumber(updatePhoneField.getText().trim()))) {
        showMessage("A valid phone number is required for SMS verification");
        updatePhoneField.requestFocus();
    }
    }//GEN-LAST:event_smsVerificationCheckboxActionPerformed

    private void emailNotificationsCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailNotificationsCheckboxActionPerformed
       // Toggle email notifications option
    boolean enableEmailNotifications = emailNotificationsCheckbox.isSelected();
    // Update user preferences for notification method
    updateNotificationPreferences("email", enableEmailNotifications);
    }//GEN-LAST:event_emailNotificationsCheckboxActionPerformed

    private void thirtyDaysRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirtyDaysRadioActionPerformed
           // Set password expiration to 30 days
    if (thirtyDaysRadio.isSelected()) {
        updatePasswordExpirationSetting(30);
        fifteenDaysRadio.setSelected(false);
        threeDaysRadio.setSelected(false);
    }
    }//GEN-LAST:event_thirtyDaysRadioActionPerformed

    private void fifteenDaysRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fifteenDaysRadioActionPerformed
        // Set password expiration to 15 days
    if (fifteenDaysRadio.isSelected()) {
        updatePasswordExpirationSetting(15);
        thirtyDaysRadio.setSelected(false);
        threeDaysRadio.setSelected(false);
    }
    }//GEN-LAST:event_fifteenDaysRadioActionPerformed

    private void threeDaysRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeDaysRadioActionPerformed
          // Set password expiration to 3 days
    if (threeDaysRadio.isSelected()) {
        updatePasswordExpirationSetting(3);
        thirtyDaysRadio.setSelected(false);
        fifteenDaysRadio.setSelected(false);
    }
    }//GEN-LAST:event_threeDaysRadioActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void policyTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_policyTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_policyTypeComboActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
       if (validateLoginCredentials()) {
        showMessage("Login successful! Welcome back.");
        loadDashboard();
    } else {
        showMessage("Invalid username or password. Please try again.");
    }
    }//GEN-LAST:event_loginButtonActionPerformed

    private boolean validateLoginCredentials() {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword()); // for JPasswordField

    if (username.isEmpty() || password.isEmpty()) {
        showMessage("Please enter both username and password.");
        return false;
    }

    // OPTIONAL: hardcoded check (for demo purposes)
    if (username.equals("admin") && password.equals("1234")) {
        return true; // valid login
    } else {
        showMessage("Invalid username or password.");
        return false;
    }
}

    
    
    private void showMessage(String message) {
    javax.swing.JOptionPane.showMessageDialog(this, message);
}

private boolean validateRegistrationFields() {
    // Validate all registration fields
    String fullName = fullNameField.getText().trim();
    String password = new String(passwordField.getPassword());
    String confirmPassword = new String(confirmNewPasswordField.getPassword());
    
    if (fullName.isEmpty()) {
        showMessage("Please enter your full name");
        return false;
    }
    
    if (password.isEmpty()) {
        showMessage("Please enter a password");
        return false;
    }
    
    if (!password.equals(confirmPassword)) {
        showMessage("Passwords do not match");
        return false;
    }
    
    if (checkPasswordStrength(password) < 3) {
        showMessage("Password is too weak. Use at least 8 characters with numbers and symbols.");
        return false;
    }
    
    return true;
}

private void createUserAccount() {
    // Code to create new user account in the database
    // This is a placeholder for the actual implementation
    String fullName = fullNameField.getText().trim();
    String password = new String(passwordField.getPassword());
    
    // Database operations would go here
    System.out.println("Creating account for: " + fullName);
    
    // Clear sensitive fields
    passwordField.setText("");
    confirmNewPasswordField.setText("");
}

private int checkPasswordStrength(String password) {
    // Simple password strength checker
    // Returns a score from 0-5 where 5 is strongest
    int score = 0;
    
    if (password.length() >= 8) score++;
    if (password.length() >= 12) score++;
    if (password.matches(".*\\d.*")) score++; // Contains digits
    if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) score++; // Contains both lowercase and uppercase
    if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) score++; // Contains special characters
    
    return score;
}

private void updatePasswordStrengthIndicator(int strength) {
    // Update a visual indicator of password strength
    // This is a placeholder for the actual implementation
    String[] strengthLabels = {"Very Weak", "Weak", "Moderate", "Strong", "Very Strong", "Excellent"};
    System.out.println("Password strength: " + strengthLabels[strength]);
    
    // Actual implementation would update a progress bar or label
    // passwordStrengthLabel.setText(strengthLabels[strength]);
}

private void updateNotificationPreferences(String method, boolean enabled) {
    // Update user notification preferences in the system
    System.out.println("Setting " + method + " notifications to: " + enabled);
    
    // Database operations would go here
}

private void resetUserPassword(String newPassword) {
    // Reset the user's password in the system
    System.out.println("Resetting password");
    
    // Database operations would go here
    
    // Clear password fields for security
    passwordField.setText("");
    confirmNewPasswordField.setText("");
}

private boolean isValidEmail(String email) {
    // Simple email validation
    return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
}

private boolean isValidPhoneNumber(String phone) {
    // Simple phone number validation - adjust for your region
    return phone.matches("^[0-9]{10,15}$");
}

private void updateEmergencyContact(String contact) {
    // Update emergency contact in the system
    System.out.println("Setting emergency contact to: " + contact);
    
    // Database operations would go here
}

private void updateUserPhone(String phone) {
    // Update user's phone number in the system
    System.out.println("Updating phone number to: " + phone);
    
    // Database operations would go here
}

private void updateSecurityPreferences(String option, boolean enabled) {
    // Update security preferences in the system
    System.out.println("Setting security option " + option + " to: " + enabled);
    
    // Database operations would go here
}

private void updatePasswordExpirationSetting(int days) {
    // Update password expiration setting in the system
    System.out.println("Setting password expiration to " + days + " days");
    
    // Database operations would go here
}

private void updateProfileName(String fullName) {
    // Update user profile name in the system
    System.out.println("Updating profile name to: " + fullName);
    
    // Database operations would go here
}

private void loadDashboard() {
    DashBoard dashboard = new DashBoard();
    dashboard.setVisible(true);
    this.dispose(); // Close the registration/login window
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
            java.util.logging.Logger.getLogger(ProfileManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField confirmNewPasswordField;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField contactField;
    private javax.swing.JPasswordField currentPasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JCheckBox emailNotificationsCheckbox;
    private javax.swing.JRadioButton emailRadioButton;
    private javax.swing.JCheckBox emailVerificationCheckbox;
    private javax.swing.JTextField emergencyContactField;
    private javax.swing.JRadioButton fifteenDaysRadio;
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JCheckBox inAppNotificationsCheckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JTextField mfaCodeField;
    private javax.swing.JToggleButton mfaToggleButton;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JRadioButton oneDayRadio;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField policyNumberField;
    private javax.swing.JComboBox<String> policyTypeCombo;
    private javax.swing.JButton registerButton;
    private javax.swing.JCheckBox rememberMeCheckbox;
    private javax.swing.JList<String> renewalsList;
    private javax.swing.JButton resetPasswordButton;
    private javax.swing.JButton sendCodeButton;
    private javax.swing.JRadioButton sevenDaysRadio;
    private javax.swing.JCheckBox smsNotificationsCheckbox;
    private javax.swing.JRadioButton smsRadioButton;
    private javax.swing.JCheckBox smsVerificationCheckbox;
    private javax.swing.JRadioButton thirtyDaysRadio;
    private javax.swing.JRadioButton threeDaysRadio;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField updatePhoneField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField verificationCodeField;
    private javax.swing.JButton verifyMfaButton;
    // End of variables declaration//GEN-END:variables
}
