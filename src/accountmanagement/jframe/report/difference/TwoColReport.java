/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report.difference;

import accountmanagement.jframe.report.*;
import accountmanagement.database.DataBaseConnection;
import java.awt.CardLayout;
import java.io.InputStream;
import java.sql.ResultSet;
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
public class TwoColReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    private String name1;
    private String name2;
    private String table1;
    private String table2;

    /**
     * Creates new form Till
     *
     * @param shopName
     * @param name1
     * @param name2
     * @param table1
     * @param table2
     */
    public TwoColReport(String shopName, String name1, String name2, String table1, String table2) {
        this.shopName = shopName;
        this.name1=name1;
        this.name2=name2;
        this.table1=table1;
        this.table2=table2;
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
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

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
            List<Map<String, String>> data = new ArrayList();
            ResultSet res1 = db.getOneColValueTabTable(shopName, table1, name1, fromDate, toDate);
            ResultSet res2 = db.getOneColValueTabTable(shopName, table2, name2, fromDate, toDate);
            
            String description = "Date: " + fromDate + " - " + toDate;
            try {
                while (res1.next()) {
                    Map<String, String> dataValue = new HashMap();
                    dataValue.put("Date", res1.getString("Date"));
                    dataValue.put(name1, res1.getString(name1));
                    dataValue.put(name2, res2.getString(name2));
                    System.out.println(res2.getString(name2));
                    dataValue.put("Difference", String.valueOf(Float.parseFloat(res1.getString(name1))-Float.parseFloat(res2.getString(name2))));
                    dataValue.put("description", description);
//                    dataValue.put("title", title);

                    System.out.println(dataValue.toString());

                }
                if (!data.isEmpty()) {
                    JRDataSource dataSource = new JRBeanCollectionDataSource(data);
                    InputStream sourceName = getClass().getResourceAsStream("/accountmanagement/jframe/report/till/TwoColReport.jrxml");

                    JasperReport jasperReport = JasperCompileManager.compileReport(sourceName);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                    JRViewer viewer = new JRViewer(jasperPrint);
                    jPanel1.add(viewer);
                    CardLayout layout = (CardLayout) jPanel1.getLayout();
                    layout.next(jPanel1);
                } else {
                    warningLabel1.setText("No record available within date " + fromDate + " - " + toDate);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BankReport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(TwoColReport.class.getName()).log(Level.SEVERE, null, ex);
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
