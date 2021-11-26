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
public class StaffTime extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private static final List<List> listOfTextFields = new ArrayList<>();
    private static final HashMap<String, Float> listOfStaffDetail = new HashMap<>();
    private boolean isUpdate = false;

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
        warningLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

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

        warningLabel.setForeground(new java.awt.Color(153, 0, 0));
        add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 270, 20));

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(960, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 1700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1700, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        warningLabel.setForeground(Color.red);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateChooser1.getDate() != null) {
            String date = sdf.format(jDateChooser1.getDate());
            try {
                for (List list : listOfTextFields) {

                    JTextField startText = (JTextField) list.get(2);
                    JTextField endText = (JTextField) list.get(3);
                    Float startTime = Float.parseFloat(startText.getText());
                    Float endTime = Float.parseFloat(endText.getText());
                    Float hours = endTime - startTime;

                    if (!isUpdate) {
                        System.out.println("Add" + list.get(0).toString() + " " + list.get(1).toString());
                        db.insertStaffTime(shopName, date, list.get(0).toString(), list.get(1).toString(),
                                startTime, endTime, hours);
                    } else {
                        System.out.println("Update" + list.get(0).toString() + " " + list.get(1).toString());
                        db.updateStaffTime(shopName, date, list.get(0).toString(), list.get(1).toString(),
                                startTime, endTime, hours);
                    }
                }

                for (String staffName : listOfStaffDetail.keySet()) {
                    ResultSet staffTimeRes = db.getStaffTime(shopName, staffName, date, date);
                    try {
                        float totalHours = 0;
                        while (staffTimeRes.next()) {
                            totalHours = totalHours + staffTimeRes.getFloat("Hours");
                        }
                        if (!isUpdate) {
                            db.insertStaffSummary(shopName, date, staffName, totalHours, totalHours * listOfStaffDetail.get(staffName));
                            warningLabel.setForeground(Color.green);
                            warningLabel.setText("**Staff time saved successfully..");
                            resetText();
                        } else {
                            db.updateStaffSummaryTime(shopName, date, staffName, totalHours, totalHours * listOfStaffDetail.get(staffName));
                            warningLabel.setForeground(Color.green);
                            warningLabel.setText("**Staff time updated successfully..");
                            resetText();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StaffTime.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
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

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        warningLabel.setText("");
        resetText();
        getValues();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void getValues() {
        if (jDateChooser1.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (db.isDateExist(shopName, "StaffTime", sdf.format(jDateChooser1.getDate()))) {
                isUpdate = true;
                resetText();
                try {
                    ResultSet res = db.getExistingValueTabTable(shopName, "StaffTime", sdf.format(jDateChooser1.getDate()));

                    while (res.next()) {
                        for (List list : listOfTextFields) {
                            if (res.getString("StaffName").equalsIgnoreCase(list.get(0).toString())
                                    && res.getString("Type").equalsIgnoreCase(list.get(1).toString())) {
                                JTextField startText = (JTextField) list.get(2);
                                JTextField endText = (JTextField) list.get(3);
                                startText.setText(res.getString("StartTime"));
                                endText.setText(res.getString("EndTime"));
                            }
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Till.class.getName()).log(Level.SEVERE, null, ex);
                    warningLabel.setText("**Error getting Staff Detail");
                }

            }
        }
    }

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
                Float salaryPercent = res.getFloat("SalaryPercentage");
                listOfStaffDetail.put(staffColName, salaryPercent);
                JLabel label = new JLabel(staffName);
                label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
                label.setBounds(20, 30 * i, 130, 20);
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
        label1.setBounds(50, 30 * i, 130, 20);
        i = i + 1;

        JLabel start1 = new JLabel("Start Time");
        start1.setFont(new java.awt.Font("Tahoma", 0, 12));
        start1.setBounds(70, 30 * i, 130, 20);

        JTextField startText1 = new JTextField();
        startText1.setFont(new java.awt.Font("Tahoma", 0, 12));
        startText1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        startText1.setText("");
        startText1.setBounds(220, 30 * i, 96, 25);
        i = i + 1;

        JLabel end1 = new JLabel("End Time");
        end1.setFont(new java.awt.Font("Tahoma", 0, 12));
        end1.setBounds(70, 30 * i, 130, 20);

        JTextField endText1 = new JTextField();
        endText1.setFont(new java.awt.Font("Tahoma", 0, 12));
        endText1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        endText1.setText("");
        endText1.setBounds(220, 30 * i, 96, 25);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
