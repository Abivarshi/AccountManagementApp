/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe;

import accountmanagement.database.DataBaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class Bank extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private static final HashMap<List<String>, JTextField> listOfTextFields = new HashMap<>();
    private boolean isUpdate = false;

    /**
     * Creates new form Till
     *
     * @param shopName
     */
    public Bank(String shopName) {
        this.shopName = shopName;
        initComponents();
        populateBank();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        warningLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 860));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 38, 161, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 38, 167, 20));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 90, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 90, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 1200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        warningLabel.setForeground(new java.awt.Color(153, 0, 0));
        add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 350, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        warningLabel.setForeground(Color.red);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateChooser1.getDate() != null) {
            try {
                float expTotal = 0;
                float purTotal = 0;
                float balance = 0;
                HashMap<String, Float> bankValues = new HashMap();
                for (List<String> list : listOfTextFields.keySet()) {
                    System.out.println(list + listOfTextFields.get(list).getText());
                    if (list.get(2).equalsIgnoreCase("Expenditure Money Out (Monthly)") || list.get(2).equalsIgnoreCase("Expenditure Money Out (Yearly)")
                            || list.get(2).equalsIgnoreCase("Expenditure/ Bank Charge")) {
                        System.out.println(list + listOfTextFields.get(list).getText());
                        expTotal = expTotal + Float.parseFloat(listOfTextFields.get(list).getText());
                    } else if (list.get(2).equalsIgnoreCase("Purchase")) {
                        purTotal = purTotal + Float.parseFloat(listOfTextFields.get(list).getText());
                    } else if (list.get(2).equalsIgnoreCase("From Bank") || list.get(2).equalsIgnoreCase("Money In (Commission)")) {
                        balance = balance + Float.parseFloat(listOfTextFields.get(list).getText());
                    } else if (list.get(2).equalsIgnoreCase("Service Money Out") || list.get(2).equalsIgnoreCase("Pay Back")) {
                        balance = balance - Float.parseFloat(listOfTextFields.get(list).getText());
                    }
                    JTextField text = listOfTextFields.get(list);
                    bankValues.put(list.get(1), Float.parseFloat(text.getText()));
                }
                balance = balance - expTotal - purTotal;
                bankValues.put("SubPurchase", purTotal);
                bankValues.put("SubExpenditure", expTotal);
                bankValues.put("Balance", balance);

                System.out.println(bankValues.toString());

                if (!isUpdate) {
                    db.insertValuesTabTable(shopName, "Bank", sdf.format(jDateChooser1.getDate()), bankValues);

                    warningLabel.setText("Bank added successfully..");
                    warningLabel.setForeground(Color.green);
                    resetText();
                } else {
                    db.updateValuesTabTable(shopName, "Bank", sdf.format(jDateChooser1.getDate()), bankValues);

                    warningLabel.setText("Bank Updated Successfuly..");
                    warningLabel.setForeground(Color.green);
                    resetText();
                }
            } catch (java.lang.NumberFormatException e) {
                warningLabel.setText("**All Values are mandatory and should be decimal");
            } catch (Exception e) {
                warningLabel.setText("**Error in updating Bank");
            }

        } else {
            warningLabel.setText("**Date should be selected");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        getValues();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void getValues() {
        if (jDateChooser1.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (db.isDateExist(shopName, "Bank", sdf.format(jDateChooser1.getDate()))) {
                isUpdate = true;
                try {
                    ResultSet res = db.getExistingValueTabTable(shopName, "Bank", sdf.format(jDateChooser1.getDate()));

                    for (List<String> list : listOfTextFields.keySet()) {
                        JTextField text = listOfTextFields.get(list);
                        text.setText(res.getString(list.get(1)));
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Till.class.getName()).log(Level.SEVERE, null, ex);
                    warningLabel.setText("**Error getting Bank Detail");
                }

            }
        }
    }
    
    private void resetText() {
        for (List<String> list : listOfTextFields.keySet()) {
            JTextField text = listOfTextFields.get(list);
            text.setText("");
        }
    }

    private void populateBank() {

        ResultSet res = db.getDeatilTableValue(shopName, "BankDetail");
        List<List<String>> bankIn = new ArrayList();

        try {
            while (res.next()) {
                String item = res.getString("Item");
                String name = res.getString("Name");
                String type = res.getString("Type");
                List<String> bankVal = new ArrayList();
                bankVal.add(item);
                bankVal.add(name);
                bankVal.add(type);
                bankIn.add(bankVal);
            }

            int i = 1;
            int j = 0;

            for (String type : Arrays.asList("From Bank", "Money In (Commission)", "Service Money Out", "Purchase", "Pay Back",
                    "Expenditure/ Bank Charge", "Expenditure Money Out (Monthly)", "Expenditure Money Out (Yearly)")) {

                if ("Expenditure Money Out (Monthly)".equals(type)) {
                    j = 420;
                    i = 1;
                }

                JLabel label = new JLabel(type);
                label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
                label.setBounds(20 + j, 80 + 30 * i, 300, 20);
                jPanel1.add(label);
                i = i + 1;
                for (List<String> val : bankIn) {

                    if (type.equals(val.get(2))) {

                        JLabel jLabel = new JLabel(val.get(0));
                        jLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
                        jLabel.setBounds(40 + j, 80 + 30 * i, 130, 20);

                        JTextField jText = new JTextField();
                        jText.setFont(new java.awt.Font("Tahoma", 0, 12));
                        jText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                        jText.setText("");
                        jText.setBounds(220 + j, 80 + 30 * i, 96, 25);
                        i = i + 1;

                        listOfTextFields.put(val, jText);

                        jPanel1.add(jLabel);
                        jPanel1.add(jText);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Purcharse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
