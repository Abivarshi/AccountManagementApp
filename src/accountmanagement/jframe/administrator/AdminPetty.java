/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.administrator;

import accountmanagement.database.DataBaseConnection;
import accountmanagement.jframe.Purcharse;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author COMPAQ
 */
public class AdminPetty extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form User
     */
    public AdminPetty(String shopName) {
        this.shopName = shopName;
        getPettyList();
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
        typeCombo = new javax.swing.JComboBox();
        userType = new javax.swing.JLabel();
        userType1 = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        successLabel = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cost Cutter", "Borrow & Pay Back", "Purchase", "Expenditure", "Banking", " " }));
        add(typeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 170, -1));

        userType.setText("Value");
        userType.setToolTipText("");
        add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 86, 20));

        userType1.setText("Type");
        userType1.setToolTipText("");
        add(userType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 86, 20));
        add(valueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 170, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 90, 30));

        successLabel.setForeground(new java.awt.Color(51, 204, 0));
        add(successLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 270, 20));

        warningLabel.setForeground(new java.awt.Color(204, 0, 0));
        add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 270, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        successLabel.setText("");
        warningLabel.setText("");
        String type = typeCombo.getSelectedItem().toString();
        String value = valueTextField.getText();
        String valueEdited = null;
        String valueEdited1 = null;

        value = value.replaceAll("\\s+", "");

        switch (type) {
            case "Cost Cutter":
                valueEdited = "CC_" + value;
                break;
            case "Borrow & Pay Back":
                valueEdited = "BO_" + value;
                valueEdited1 = "PB_" + value;
                break;
            case "Purchase":
                valueEdited = "P_" + value;
                break;
            case "Expenditure":
                valueEdited = "E_" + value;
                break;
            case "Banking":
                valueEdited = "B_" + value;
                break;
            default:
                System.out.println("no match");
        }
        if (!db.isColumnExist(shopName, "Petty", valueEdited)) {
            if (valueEdited1 != null) {
                db.alterTabTable(shopName, "Petty", valueEdited1);
                db.insertDetailTable(shopName, valueTextField.getText(), valueEdited1, "Pay Back", "PettyDetail");
                db.alterTabTable(shopName, "Petty", valueEdited);
                db.insertDetailTable(shopName, valueTextField.getText(), valueEdited, "Borrow", "PettyDetail");
            } else {
                db.alterTabTable(shopName, "Petty", valueEdited);
                db.insertDetailTable(shopName, valueTextField.getText(), valueEdited, type, "PettyDetail");
            }
            valueTextField.setText("");
            successLabel.setText("Petty added Successfully..");
        } else {
            valueTextField.setText("");
            warningLabel.setText("**Petty already exist.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void getPettyList() {

        ResultSet res = db.getDeatilTableValue(shopName, "PettyDetail");
        List<List<String>> bankIn = new ArrayList();

        try {
            while (res.next()) {
                String item = res.getString("Item");
                String type = res.getString("Type");
                List<String> bankVal = new ArrayList();
                bankVal.add(item);
                bankVal.add(type);
                bankIn.add(bankVal);
            }

            int i = 1;
            int j = 0;

            for (String type : Arrays.asList("Cost Cutter", "BE IOU", "Borrow", "Pay Back", "Banking",
                    "Purchase", "Expenditure")) {

                if ("Purchase".equals(type)) {
                    j = 420;
                    i = 1;
                }

                    if (!"BE IOU".equals(type)) {
                        JLabel label = new JLabel(type);
                        label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
                        label.setBounds(20 + j, 200 + 30 * i, 300, 20);
                        add(label);
                        i = i + 1;
                    }
                

                for (List<String> val : bankIn) {
                    if (type.equals(val.get(1))) {

                        JLabel jLabel = new JLabel(val.get(0));
                        jLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
                        jLabel.setBounds(40 + j, 200 + 30 * i, 130, 20);
                        i = i + 1;
                        add(jLabel);
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Purcharse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel successLabel;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JLabel userType;
    private javax.swing.JLabel userType1;
    private javax.swing.JTextField valueTextField;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
