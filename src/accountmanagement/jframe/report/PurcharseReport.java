/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report;

import accountmanagement.jframe.*;
import accountmanagement.database.DataBaseConnection;

/**
 *
 * @author acer
 */
public class PurcharseReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    /**
     * Creates new form Till
     */
    public PurcharseReport(String shopName) {
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 161, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("From Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 38, 80, 20));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 90, 30));

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 161, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("To Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 80, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
