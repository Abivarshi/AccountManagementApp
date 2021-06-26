/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.administrator;

import accountmanagement.database.DataBaseConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author COMPAQ
 */
public class User extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form User
     */
    public User(String shopName) {
        this.shopName = shopName;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        userTypeCombo = new javax.swing.JComboBox();
        userType = new javax.swing.JLabel();
        userType1 = new javax.swing.JLabel();
        userType2 = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        passwordTextField = new javax.swing.JPasswordField();
        userType3 = new javax.swing.JLabel();
        confirmPasswordTextField = new javax.swing.JPasswordField();
        successLabel = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Supervisor", "User", " " }));
        add(userTypeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 94, -1));

        userType.setText("User Type");
        userType.setToolTipText("");
        add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 86, 20));

        userType1.setText("User Name");
        userType1.setToolTipText("");
        add(userType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 86, 20));

        userType2.setText("Password");
        userType2.setToolTipText("");
        add(userType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 86, 20));
        add(userNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 90, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, 30));
        add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 90, -1));

        userType3.setText("Confirm Password");
        userType3.setToolTipText("");
        add(userType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 130, 20));
        add(confirmPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 90, -1));

        successLabel.setForeground(new java.awt.Color(51, 204, 0));
        add(successLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 270, 20));

        warningLabel.setForeground(new java.awt.Color(204, 0, 0));
        add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 270, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String pass = new String(passwordTextField.getPassword());
        String conPass = new String(confirmPasswordTextField.getPassword());
        String userName = userNameTextField.getText();
        if (!userName.isEmpty() && passwordTextField.getPassword().length != 0 && confirmPasswordTextField.getPassword().length != 0) {
            if (pass.equals(conPass)) {
                System.out.println(userName);
                System.out.println(pass);
                System.out.println(db.getUserType(shopName, userName, pass));
                if (db.getUserType(shopName, userName, pass).isEmpty()) {
                    try {
                        db.addUser(shopName, userName, pass, userTypeCombo.getSelectedItem().toString());
                        successLabel.setText("User added successfully..");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    successLabel.setText("**This user name password already exist");
                    passwordTextField.setText("");
                    confirmPasswordTextField.setText("");
                    userNameTextField.setText("");
                }
            } else {
                successLabel.setText("**Password mismatch");
                passwordTextField.setText("");
                confirmPasswordTextField.setText("");
                userNameTextField.setText("");
            }
        } else {
            successLabel.setText("**All are mandatory fields");
            passwordTextField.setText("");
            confirmPasswordTextField.setText("");
            userNameTextField.setText("");
        }
        System.out.println(pass);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel successLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel userType;
    private javax.swing.JLabel userType1;
    private javax.swing.JLabel userType2;
    private javax.swing.JLabel userType3;
    private javax.swing.JComboBox userTypeCombo;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
