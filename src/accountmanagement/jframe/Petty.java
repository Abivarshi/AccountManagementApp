/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe;

import accountmanagement.database.DataBaseConnection;

/**
 *
 * @author acer
 */
public class Petty extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    /**
     * Creates new form Till
     */
    public Petty(String shopName) {
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
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(746, 960));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 161, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 38, 110, 20));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setText("0");
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 96, 20));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setText("0");
        add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 96, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Coins");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, 20));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Cash");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 20));

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField12.setText("0");
        add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 96, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Cost Cutter");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 167, 20));

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField13.setText("0");
        add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 96, 20));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Chilled");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 120, 20));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Ambiant");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 130, 20));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton1.setText("Reset");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 90, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 90, 30));

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField22.setText("0");
        add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 96, 20));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("BE IOU PAID");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, 20));

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField24.setText("0");
        add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 96, 20));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Cash Barrow");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 167, 20));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Pay Back");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 130, 20));

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField28.setText("0");
        add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 96, -1));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel32.setText("Purcharse");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 290, 20));

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField29.setText("0");
        add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 96, -1));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Dhamecha");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 20));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Cost Cutter");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 130, 20));

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField30.setText("0");
        add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 96, -1));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Beer in Shop");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 20));

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField31.setText("0");
        add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 96, -1));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Vegetable");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 120, 20));

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField32.setText("0");
        add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 96, -1));

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField33.setText("0");
        add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 96, -1));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Bookers");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 120, 20));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Wannis");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 130, 20));

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField34.setText("0");
        add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 96, -1));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("BestWay");
        add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 120, 20));

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField35.setText("0");
        add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 96, -1));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Beer");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 120, 20));

        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField36.setText("0");
        add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 96, -1));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("DPR");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 120, 20));

        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField38.setText("0");
        add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 96, -1));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel43.setText("Expenditure");
        add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 290, 20));

        jTextField39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField39.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField39.setText("0");
        add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 96, -1));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Diesel");
        add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 120, 30));

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Capital Gains");
        add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 130, 30));

        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField40.setText("0");
        add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 96, -1));

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Shelf");
        add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 120, 20));

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel48.setText("Banking");
        add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 290, 20));

        jTextField44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField44.setText("0");
        add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 96, -1));

        jTextField45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField45.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField45.setText("0");
        add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 96, -1));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("NATWEST");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 130, 20));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("Cash Plus");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 120, 20));

        jTextField46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField46.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField46.setText("0");
        add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 96, 20));

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel53.setText("IOU");
        add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 167, 20));

        jTextField47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField47.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField47.setText("0");
        add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 96, 20));

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setText("Pay Back");
        add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 120, 20));

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField14.setText("0");
        add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 96, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Frozen");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 120, 20));

        jTextField50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField50.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField50.setText("0");
        add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 96, 20));

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel59.setText("C/Card");
        add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 167, 20));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel60.setText("Barrow");
        add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 130, 20));

        jTextField51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField51.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField51.setText("0");
        add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 96, 20));

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel61.setText("C/Card Barrow");
        add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 167, 20));

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel62.setText("Pay Back");
        add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 130, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
