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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class StaffTime extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private static final List<List> listOfTextFields = new ArrayList<>();

    /**
     * Creates new form Till
     *
     * @param shopName
     */
    public StaffTime(String shopName) {
        this.shopName = shopName;
        initComponents();
        populateStaffTime();
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
                .addGap(0, 1187, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        warningLabel.setForeground(Color.red);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateChooser1.getDate() != null) {
            try {
                for (List list : listOfTextFields) {

                    JTextField startText = (JTextField) list.get(2);
                    JTextField endText = (JTextField) list.get(3);
                    Float startTime = Float.parseFloat(startText.getText());
                    Float endTime = Float.parseFloat(endText.getText());
                    Float hours = endTime - startTime;

                    db.insertStaffTime(shopName, sdf.format(jDateChooser1.getDate()), list.get(0).toString(), list.get(1).toString(),
                            startTime, endTime, hours);
                }
                warningLabel.setForeground(Color.green);
                warningLabel.setText("**Staff time saved successfully..");
                resetText();
            } catch (java.lang.NumberFormatException e) {
                warningLabel.setText("**Values should be decimal");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(StaffTime.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            warningLabel.setText("**Date should be selected");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resetText() {
        for (List list : listOfTextFields) {
            JTextField startText = (JTextField) list.get(2);
            JTextField endText = (JTextField) list.get(3);
            startText.setText("");
            endText.setText("");
        }
    }

    private void populateStaffTime() {

        ResultSet res = db.getStaff(shopName);
        try {
            int i = 1;
            while (res.next()) {
                String staffName = res.getString("StaffName");
                String staffColName = res.getString("StaffColName");
                JLabel label = new JLabel(staffName);
                label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
                label.setBounds(20, 80 + 30 * i, 130, 20);
                i = i + 1;

                if (res.getString("Till").equals("1")) {
                    i = insertTime("Till", i, staffColName);
                }
                if (res.getString("Floor").equals("1")) {
                    i = insertTime("Floor", i, staffColName);
                }
                if (res.getString("CashCarry").equals("1")) {
                    i = insertTime("CashCarry", i, staffColName);
                }
                if (res.getString("Management").equals("1")) {
                    i = insertTime("Management", i, staffColName);
                }

                jPanel1.add(label);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purcharse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int insertTime(String timeType, int i, String staffName) {

        List staffTimeList = new ArrayList();

        JLabel label1 = new JLabel(timeType + " Hours");
        label1.setFont(new java.awt.Font("Tahoma", 0, 12));
        label1.setBounds(50, 80 + 30 * i, 130, 20);
        i = i + 1;

        JLabel start1 = new JLabel("Start Time");
        start1.setFont(new java.awt.Font("Tahoma", 0, 12));
        start1.setBounds(70, 80 + 30 * i, 130, 20);

        JTextField startText1 = new JTextField();
        startText1.setFont(new java.awt.Font("Tahoma", 0, 12));
        startText1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        startText1.setText("0");
        startText1.setBounds(220, 80 + 30 * i, 96, 25);
        i = i + 1;

        JLabel end1 = new JLabel("End Time");
        end1.setFont(new java.awt.Font("Tahoma", 0, 12));
        end1.setBounds(70, 80 + 30 * i, 130, 20);

        JTextField endText1 = new JTextField();
        endText1.setFont(new java.awt.Font("Tahoma", 0, 12));
        endText1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        endText1.setText("0");
        endText1.setBounds(220, 80 + 30 * i, 96, 25);
        i = i + 1;

        jPanel1.add(label1);
        jPanel1.add(start1);
        jPanel1.add(end1);
        jPanel1.add(startText1);
        jPanel1.add(endText1);

        staffTimeList.add(0, staffName);
        staffTimeList.add(1, timeType);
        staffTimeList.add(2, startText1);
        staffTimeList.add(3, endText1);
        listOfTextFields.add(staffTimeList);
        return i;
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
