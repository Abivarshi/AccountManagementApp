/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report;

import accountmanagement.database.DataBaseConnection;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author acer
 */
public class ExpenditureReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form Till
     *
     * @param shopName
     */
    public ExpenditureReport(String shopName) {
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
        searchButton = new javax.swing.JButton();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        warningLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFrom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 161, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("From Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 38, 80, 20));

        searchButton.setBackground(new java.awt.Color(0, 0, 102));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 90, 30));

        jDateChooserTo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 161, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("To Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 80, 20));

        warningLabel1.setForeground(new java.awt.Color(153, 0, 0));
        add(warningLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 230, 10));

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(960, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 800));
        jPanel1.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //        if (jDateChooserFrom.getDate() == null) {
            //            jDateChooserFrom.setDate(currentDate);
            //        }
        //        if (jDateChooserTo.getDate() == null) {
            //            jDateChooserTo.setDate(currentDate);
            //        }
        //        String fromDate = sdf.format(jDateChooserFrom.getDate());
        //        String toDate = sdf.format(jDateChooserTo.getDate());
        String fromDate = "2021-06-01";
        String toDate = "2021-07-30";
        if (fromDate.compareTo(toDate) < 0 || fromDate.compareTo(toDate) == 0) {
            //            ResultSet res = db.getValuesTabTable(shopName, "Expenditure", sdf.format(jDateChooserFrom.getDate()), sdf.format(jDateChooserTo.getDate()));
            ResultSet res = db.getValuesTabTable(shopName, "Expenditure", fromDate, toDate);

            ResultSetMetaData metadata = db.getTabColumns(shopName, "Expenditure");
            try {
                List<Map<String, String>> data = new ArrayList();
                while (res.next()) {
                    Map<String, String> dataValue = new HashMap();
                    dataValue.put("Date", res.getString(metadata.getColumnName(2)));
                    float expenditure = 10;
                    float totalExpenditure = 0;
                    for (int i = 3; i <= metadata.getColumnCount(); i++) {
                        String columnName = metadata.getColumnName(i);
                        Float value = res.getFloat(columnName);
                        dataValue.put(columnName, value.toString());
                        totalExpenditure = totalExpenditure + value;
                    }
                    dataValue.put("TotalExpenditure", String.valueOf(totalExpenditure));
                    dataValue.put("Expenditure", String.valueOf(expenditure));
                    dataValue.put("Different", String.valueOf(expenditure - totalExpenditure));
                    System.out.println(dataValue.toString());
                    data.add(dataValue);
                }

                JRDataSource dataSource = new JRBeanCollectionDataSource(data);
                String sourceName = new File("").getAbsolutePath()+ "/src/accountmanagement/jframe/report/ExpenditureReport.jrxml";

                JasperReport jasperReport = JasperCompileManager.compileReport(sourceName);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                JRViewer viewer =new JRViewer(jasperPrint);
                viewer.setBounds(20, 20, 800, 1200);
                jPanel1.add(viewer);

            } catch (SQLException ex) {
                Logger.getLogger(BankReport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ExpenditureReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            warningLabel1.setText("From Date should be earlier date");
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel warningLabel1;
    // End of variables declaration//GEN-END:variables
}
