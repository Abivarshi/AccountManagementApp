/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report.expenditure;

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
import javax.swing.JLabel;
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
public class Summary extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private final String title;
    private final String tableName;

    /**
     * Creates new form Till
     *
     * @param shopName
     * @param title
     * @param tableName
     */
    public Summary(String shopName, String title, String tableName) {
        this.shopName = shopName;
        this.title = title;
        this.tableName = tableName;
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
        jLabel4 = new javax.swing.JLabel();

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
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 960));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("SUMMARY - REPORT");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 560, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        JLabel jLabel4 = loader();
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
            List<Object[]> dataVal = new ArrayList();

            String description = "Date: " + fromDate + " - " + toDate;
            ResultSet resExp = db.getOneColValueTabTable(shopName, "Till", "R_"+tableName, fromDate, toDate);
            ResultSet resBank = db.getOneColValueTabTable(shopName, "Bank", "Sub"+tableName, fromDate, toDate);
            ResultSet resPetty = db.getOneColValueTabTable(shopName, "Petty", "Sub"+tableName, fromDate, toDate);
            try {
                while (resExp.next()) {
                    dataVal.add(new Object[]{resExp.getString("Date"), resExp.getFloat("R_"+tableName), 0, 0, resExp.getFloat("R_"+tableName)});
                }

                while (resBank.next()) {
                    Float value = resBank.getFloat("Sub"+tableName);
                    String date = resBank.getString("Date");
                    boolean valueAdded = false;
                    for (Object[] val : dataVal) {
                        if (val[0].toString().equals(date)) {
                            val[2] = value;
                            val[4] = Float.parseFloat(val[4].toString()) + value;
                            valueAdded = true;
                            break;
                        }
                    }
                    if (!valueAdded) {
                        dataVal.add(new Object[]{date, 0, value, 0, value});
                    }
                }

                while (resPetty.next()) {
                    Float value = resPetty.getFloat("Sub"+tableName);
                    String date = resPetty.getString("Date");
                    boolean valueAdded = false;
                    for (Object[] val : dataVal) {
                        if (val[0].toString().equals(date)) {
                            val[3] = value;
                            val[4] = Float.parseFloat(val[4].toString()) + value;
                            valueAdded = true;
                            break;
                        }
                    }
                    if (!valueAdded) {
                        dataVal.add(new Object[]{date, 0, 0, value, value});
                    }
                }

                for (Object[] val : dataVal) {
                    Map<String, String> map = new HashMap();
                    map.put("Date", val[0].toString());
                    map.put("Till", val[1].toString());
                    map.put("Bank", val[2].toString());
                    map.put("Petty", val[3].toString());
                    map.put("Total", val[4].toString());
                    map.put("Title", title);
                    map.put("description", description);
                    data.add(map);
                }
                if (!data.isEmpty()) {
                    JRDataSource dataSource = new JRBeanCollectionDataSource(data);
                    InputStream sourceName = getClass().getResourceAsStream("/accountmanagement/jframe/report/expenditure/"+tableName+"Summary.jrxml");

                    JasperReport jasperReport = JasperCompileManager.compileReport(sourceName);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                    JRViewer viewer = new JRViewer(jasperPrint);
                    jPanel1.add(viewer);
                    CardLayout layout = (CardLayout) jPanel1.getLayout();
                    layout.next(jPanel1);
                } else {
                    warningLabel1.setText("No record available within date " + fromDate + " - " + toDate);
                }
            } catch (SQLException | JRException ex) {
                Logger.getLogger(Summary.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel warningLabel1;
    // End of variables declaration//GEN-END:variables

    private JLabel loader() {
        JLabel jLabel4 = new JLabel();
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accountmanagement/image/loading.gif"))); // NOI18N

        jLabel4.setVisible(false);
        jLabel4.setBounds(100, 100, 20, 20);
        jPanel1.add(jLabel4);
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
        return jLabel4;
    }
}
