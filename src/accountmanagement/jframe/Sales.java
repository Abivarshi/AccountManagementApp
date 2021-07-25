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
public class Sales extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private static final HashMap<List<String>, JTextField> listOfTextFields = new HashMap<>();

    /**
     * Creates new form Till
     *
     * @param shopName
     */
    public Sales(String shopName) {
        this.shopName = shopName;
        initComponents();
        populateSales();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        warningLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 860));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
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

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(960, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        warningLabel.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(558, Short.MAX_VALUE)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 687, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        warningLabel.setForeground(Color.red);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateChooser1.getDate() != null) {
            try {
                float bookoutTotal = 0;

                HashMap<String, Float> salesValues = new HashMap();
                for (List<String> list : listOfTextFields.keySet()) {
                    if (!list.get(1).equalsIgnoreCase("CustomerCount")) {
                        bookoutTotal = bookoutTotal + Float.parseFloat(listOfTextFields.get(list).getText());
                    }
                    JTextField text = listOfTextFields.get(list);
                    salesValues.put(list.get(1), Float.parseFloat(text.getText()));
                }
                salesValues.put("Total", bookoutTotal);

                System.out.println(salesValues.toString());
                db.insertValuesTabTable(shopName, "Sales", sdf.format(jDateChooser1.getDate()), salesValues);
                warningLabel.setText("Sales added successfully..");
                warningLabel.setForeground(Color.green);
                resetText();
            } catch (java.lang.NumberFormatException e) {
                warningLabel.setText("**All Values are mandatory and should be decimal");
            }
        } else {
            warningLabel.setText("**Date should be selected");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resetText() {
        for (List<String> list : listOfTextFields.keySet()) {
            JTextField text = listOfTextFields.get(list);
            text.setText("");
        }
    }

    private void populateSales() {

        ResultSet res = db.getDeatilTableValue(shopName, "SalesDetail");
        List<List<String>> bankIn = new ArrayList();

        try {
            while (res.next()) {
                String item = res.getString("Item");
                String name = res.getString("Name");
                List<String> bankVal = new ArrayList();
                bankVal.add(item);
                bankVal.add(name);
                bankIn.add(bankVal);
            }

            int i = 1;

            JLabel labelCus = new JLabel("Customer Count Day");
            labelCus.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
            labelCus.setBounds(30, 30 * i, 300, 20);
            jPanel1.add(labelCus);

            JTextField jTextCus = new JTextField();
            jTextCus.setFont(new java.awt.Font("Tahoma", 0, 12));
            jTextCus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            jTextCus.setText("");
            jTextCus.setBounds(220, 30 * i, 96, 25);
            jPanel1.add(jTextCus);
            i = i + 1;

            listOfTextFields.put(Arrays.asList("Customer Count Day", "CustomerCount"), jTextCus);

            JLabel label = new JLabel("Book Out List(As Purchase Price)");
            label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
            label.setBounds(30, 20+30 * i, 300, 20);
            jPanel1.add(label);
            i = i + 1;
            for (List<String> val : bankIn) {
                JLabel jLabel = new JLabel(val.get(0));
                jLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
                jLabel.setBounds(50, 20+30 * i, 130, 20);

                JTextField jText = new JTextField();
                jText.setFont(new java.awt.Font("Tahoma", 0, 12));
                jText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                jText.setText("");
                jText.setBounds(220, 20+30 * i, 96, 25);
                i = i + 1;

                listOfTextFields.put(val, jText);

                jPanel1.add(jLabel);
                jPanel1.add(jText);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
