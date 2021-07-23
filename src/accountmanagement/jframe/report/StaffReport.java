/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report;

import accountmanagement.jframe.*;
import accountmanagement.database.DataBaseConnection;
import accountmanagement.util.LineWrapCellRenderer;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author acer
 */
public class StaffReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private static final List<List> listOfStaff = new ArrayList<>();

    /**
     * Creates new form Till
     */
    public StaffReport(String shopName) {
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

        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFrom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 161, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("From Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 38, 80, 20));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 90, 30));

        jDateChooserTo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 161, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("To Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 80, 20));

        warningLabel.setForeground(new java.awt.Color(153, 0, 0));
        add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 240, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 800, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateChooserFrom.getDate() == null) {
            jDateChooserFrom.setDate(currentDate);
        }
        if (jDateChooserTo.getDate() == null) {
            jDateChooserTo.setDate(currentDate);
        }
        String fromDate = sdf.format(jDateChooserFrom.getDate());
        String toDate = sdf.format(jDateChooserTo.getDate());
        if (fromDate.compareTo(toDate) < 0 || fromDate.compareTo(toDate) == 0) {
            ResultSet res = db.getValuesTabTable(shopName, "StaffTime", sdf.format(jDateChooserFrom.getDate()), sdf.format(jDateChooserTo.getDate()));
            ResultSet staffList = db.getStaff(shopName);

//            ResultSetMetaData metadata = db.getTabColumns(shopName, "Expenditure");
            try {
                List<String[]> data = new ArrayList();
                List<String> column = new ArrayList();
                column.add("Date");
                column.add("Till");
                column.add("Floor");
                column.add("Cash Carry");
                column.add("Management");

                while (staffList.next()) {
                    String staffName = res.getString("StaffName");
                    Float salaryPercentage = res.getFloat("SalaryPercentage");
                    listOfStaff.add(Arrays.asList(staffName, salaryPercentage));
                    column.add(staffName);
                }

                while (res.next()) {
//                    String dateCol = metadata.getColumnName(2);
                    String date = res.getString("Date ");
                    List<String> values = new ArrayList();
                    values.add(date);
                    float expenditure = 10;
                    float totalExpenditure = 0;
//                    for (int i = 3; i <= metadata.getColumnCount(); i++) {
//                        String columnName = metadata.getColumnName(i);
//                        Float value = res.getFloat(columnName);
//                        values.add(value.toString());
//                        totalExpenditure = totalExpenditure + value;
//                    }
                    values.add(String.valueOf(totalExpenditure));
                    values.add(String.valueOf(expenditure));
                    values.add(String.valueOf(expenditure - totalExpenditure));
                    data.add(values.toArray(new String[0]));

                }

                JTable jt = new JTable(data.toArray(new String[0][0]), column.toArray());
                jt.setBounds(30, 40, 1500, 300);
                jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jt.setPreferredSize(new java.awt.Dimension(800, 64));
//                jt.setDefaultRenderer(String.class, new LineWrapCellRenderer());

                JScrollPane sp = new JScrollPane(jt);
                sp.setBounds(10, 20, 775, 500);
                sp.setBackground(Color.white);
                jPanel1.add(sp);

            } catch (SQLException ex) {
                Logger.getLogger(BankReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            warningLabel.setText("From Date should be earlier date");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
