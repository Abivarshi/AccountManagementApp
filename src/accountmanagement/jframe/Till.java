/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe;

import accountmanagement.database.DataBaseConnection;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 *
 * @author acer
 */
public class Till extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form Till
     */
    public Till(String shopName) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        yesterdayTillCount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        todayTillCount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        coin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        card = new javax.swing.JTextField();
        voucherMilk = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        voucherPayPoint = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        refundAccountCredit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        purchase = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        expenditure = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        accPay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        refundGoods = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        refundServices = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cashBack = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        instantPayOut = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lottaryPayOut = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        insLottary = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lottary = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        oyster = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        payPoint = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        payZone = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        alcohol = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        groceries = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        tabacco = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        boInstLottary = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        boLottary = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        boOyster = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        boPayPoint = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        boPayZone = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        boAccPay = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        boInstPO = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        boLottaryPO = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        boCash = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        boCard = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        boAccount = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        boCashBack = new javax.swing.JTextField();
        boMilk = new javax.swing.JTextField();
        boVaucherPayPoint = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 161, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Yesterday Till Count");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 167, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 167, 20));

        yesterdayTillCount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yesterdayTillCount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        yesterdayTillCount.setText("0");
        add(yesterdayTillCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 96, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Today Till Count");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 167, 20));

        todayTillCount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        todayTillCount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        todayTillCount.setText("0");
        add(todayTillCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 96, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cash");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 167, 20));

        cash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cash.setText("0");
        add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 96, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Coin");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 167, 20));

        coin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        coin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        coin.setText("0");
        add(coin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 96, 20));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Card");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 167, 20));

        card.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        card.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        card.setText("0");
        add(card, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 96, 20));

        voucherMilk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        voucherMilk.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        voucherMilk.setText("0");
        add(voucherMilk, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 96, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Voucher");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 167, 20));

        voucherPayPoint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        voucherPayPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        voucherPayPoint.setText("0");
        add(voucherPayPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 96, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("PayPoint");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 120, 20));

        refundAccountCredit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refundAccountCredit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        refundAccountCredit.setText("0");
        add(refundAccountCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 96, 20));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Account Credit");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 167, 20));

        purchase.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        purchase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        purchase.setText("0");
        add(purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 96, 20));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Purchase");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 167, 20));

        expenditure.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        expenditure.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        expenditure.setText("0");
        add(expenditure, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 96, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Expenditure");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 167, 20));

        accPay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        accPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        accPay.setText("0");
        add(accPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 96, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Acc Pay");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 167, 20));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Milk");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 130, 20));

        refundGoods.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refundGoods.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        refundGoods.setText("0");
        add(refundGoods, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 96, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("FROM BACK OFFICE");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 120, 20));

        refundServices.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refundServices.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        refundServices.setText("0");
        add(refundServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 96, 20));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Services");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 120, 20));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Goods");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 130, 20));

        cashBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cashBack.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cashBack.setText("0");
        add(cashBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 96, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Cash Back");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 167, 20));

        instantPayOut.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        instantPayOut.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        instantPayOut.setText("0");
        add(instantPayOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 96, 20));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Instant PayOut");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 167, 20));

        lottaryPayOut.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lottaryPayOut.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lottaryPayOut.setText("0");
        add(lottaryPayOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 96, 20));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Lottary PayOut");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 167, 20));

        insLottary.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        insLottary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        insLottary.setText("0");
        add(insLottary, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 670, 96, 20));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Ins Lottary");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 167, 20));

        lottary.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lottary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lottary.setText("0");
        add(lottary, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, 96, 20));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Lottary");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 167, 20));

        oyster.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        oyster.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        oyster.setText("0");
        add(oyster, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 730, 96, 20));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Oyster");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, 167, 20));

        payPoint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        payPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        payPoint.setText("0");
        add(payPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 760, 96, 20));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Pay Point");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 760, 167, 20));

        payZone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        payZone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        payZone.setText("0");
        add(payZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 790, 96, 20));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("PayZone");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 790, 167, 20));

        resetButton.setBackground(new java.awt.Color(255, 102, 102));
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 90, 30));

        saveButton.setBackground(new java.awt.Color(0, 0, 102));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 90, 30));

        warningLabel.setForeground(new java.awt.Color(153, 0, 0));
        add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 230, 20));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setText("Refund");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 167, 20));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("FROM REPORT");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 167, 20));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Alcohol");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 167, 20));

        alcohol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        alcohol.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        alcohol.setText("0");
        add(alcohol, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 96, 20));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Groceries");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 167, 20));

        groceries.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        groceries.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        groceries.setText("0");
        add(groceries, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 96, 20));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Tabacco");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 167, 20));

        tabacco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabacco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tabacco.setText("0");
        add(tabacco, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 96, 20));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Inst. Lottary");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 167, 20));

        boInstLottary.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boInstLottary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boInstLottary.setText("0");
        add(boInstLottary, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 96, 20));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Lottary");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 167, 20));

        boLottary.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boLottary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boLottary.setText("0");
        add(boLottary, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 96, 20));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Oyster");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 167, 20));

        boOyster.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boOyster.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boOyster.setText("0");
        add(boOyster, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 96, 20));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("PayPoint");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 167, 20));

        boPayPoint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boPayPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boPayPoint.setText("0");
        add(boPayPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 96, 20));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("PayZone");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 167, 20));

        boPayZone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boPayZone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boPayZone.setText("0");
        add(boPayZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 96, 20));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Acc Pay");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 167, 20));

        boAccPay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boAccPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boAccPay.setText("0");
        add(boAccPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 96, 20));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Inst PO");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 167, 20));

        boInstPO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boInstPO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boInstPO.setText("0");
        add(boInstPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 96, 20));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Lottary PO");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 167, 20));

        boLottaryPO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boLottaryPO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boLottaryPO.setText("0");
        add(boLottaryPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 96, 20));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Cash");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 167, 20));

        boCash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boCash.setText("0");
        add(boCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, 96, 20));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("Card");
        add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 167, 20));

        boCard.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boCard.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boCard.setText("0");
        add(boCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 96, 20));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Account");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 167, 20));

        boAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boAccount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boAccount.setText("0");
        add(boAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 96, 20));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Cash Back");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 167, 20));

        boCashBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boCashBack.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boCashBack.setText("0");
        add(boCashBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 96, 20));

        boMilk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boMilk.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boMilk.setText("0");
        add(boMilk, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 650, 96, 20));

        boVaucherPayPoint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boVaucherPayPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boVaucherPayPoint.setText("0");
        add(boVaucherPayPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 680, 96, 20));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("PayPoint");
        add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 680, 120, 20));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Milk");
        add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 650, 130, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        yesterdayTillCount.setText("0");
        expenditure.setText("0");
        accPay.setText("0");
        refundGoods.setText("0");
        refundServices.setText("0");
        cashBack.setText("0");
        instantPayOut.setText("0");
        lottaryPayOut.setText("0");
        insLottary.setText("0");
        lottary.setText("0");
        oyster.setText("0");
        todayTillCount.setText("0");
        payPoint.setText("0");
        payZone.setText("0");
        cash.setText("0");
        coin.setText("0");
        card.setText("0");
        voucherMilk.setText("0");
        voucherPayPoint.setText("0");
        refundAccountCredit.setText("0");
        purchase.setText("0");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        warningLabel.setText("");
        if (jDateChooser1.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (!db.isDateExist(shopName, "Till", sdf.format(jDateChooser1.getDate()))) {
                try {
                    HashMap<String, Float> tillValues = new HashMap();
                    tillValues.put("R_YesterdayTillCount", Float.parseFloat(yesterdayTillCount.getText()));
                    tillValues.put("R_TodayTillCount", Float.parseFloat(todayTillCount.getText()));
                    tillValues.put("R_Cash", Float.parseFloat(cash.getText()));
                    tillValues.put("R_Coin", Float.parseFloat(coin.getText()));
                    tillValues.put("R_Card", Float.parseFloat(card.getText()));
                    tillValues.put("R_VoucherMilk", Float.parseFloat(voucherMilk.getText()));
                    tillValues.put("R_VoucherPayPoint", Float.parseFloat(voucherPayPoint.getText()));
                    tillValues.put("R_RefundGoods", Float.parseFloat(refundGoods.getText()));
                    tillValues.put("R_RefundServices", Float.parseFloat(refundServices.getText()));
                    tillValues.put("R_RefundAccountCredit", Float.parseFloat(refundAccountCredit.getText()));
                    tillValues.put("R_Purchase", Float.parseFloat(purchase.getText()));
                    tillValues.put("R_Expenditure", Float.parseFloat(expenditure.getText()));
                    tillValues.put("R_AccPay", Float.parseFloat(accPay.getText()));
                    tillValues.put("R_CashBack", Float.parseFloat(cashBack.getText()));
                    tillValues.put("R_InstantPayOut", Float.parseFloat(instantPayOut.getText()));
                    tillValues.put("R_LottaryPayOut", Float.parseFloat(lottaryPayOut.getText()));
                    tillValues.put("R_InsLottary", Float.parseFloat(insLottary.getText()));
                    tillValues.put("R_Lottary", Float.parseFloat(lottary.getText()));
                    tillValues.put("R_Oyster", Float.parseFloat(oyster.getText()));
                    tillValues.put("R_PayPoint", Float.parseFloat(payPoint.getText()));
                    tillValues.put("R_PayZone", Float.parseFloat(payZone.getText()));
                    
                    tillValues.put("Alcohol", Float.parseFloat(alcohol.getText()));
                    tillValues.put("Groceries", Float.parseFloat(groceries.getText()));
                    tillValues.put("Tobacco", Float.parseFloat(tabacco.getText()));
                    tillValues.put("BO_InsLottary", Float.parseFloat(boInstLottary.getText()));
                    tillValues.put("BO_Lottary", Float.parseFloat(boLottary.getText()));
                    tillValues.put("BO_Oyster", Float.parseFloat(boOyster.getText()));
                    tillValues.put("BO_PayPoint", Float.parseFloat(boPayPoint.getText()));
                    tillValues.put("BO_PayZone", Float.parseFloat(boPayZone.getText()));
                    tillValues.put("BO_AccPay", Float.parseFloat(boAccPay.getText()));
                    tillValues.put("BO_InstantPayOut", Float.parseFloat(boInstPO.getText()));
                    tillValues.put("BO_LottaryPayOut", Float.parseFloat(boLottaryPO.getText()));
                    tillValues.put("BO_Cash", Float.parseFloat(boCash.getText()));
                    tillValues.put("BO_Card", Float.parseFloat(boCard.getText()));
                    tillValues.put("BO_AccountCredit", Float.parseFloat(boAccount.getText()));
                    tillValues.put("BO_CashBack", Float.parseFloat(boCashBack.getText()));
                    tillValues.put("BO_VoucherMilk", Float.parseFloat(boMilk.getText()));
                    tillValues.put("BO_VoucherPayPoint", Float.parseFloat(boVaucherPayPoint.getText()));
    
//                    tillValues.put("SO_InsLottary", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_Lottary", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_Oyster", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_PayPoint", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_PayZone", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_AccPay", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_InstantPayOut", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_LottaryPayOut", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_Cash", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_Card", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_CashBack", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_VoucherMilk", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_VoucherPayPoint", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_AccountCredit", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_Till", Float.parseFloat(payZone.getText()));
//                    tillValues.put("SO_Pay", Float.parseFloat(payZone.getText()));
                    
                    db.insertValuesTabTable(shopName, "Till", sdf.format(jDateChooser1.getDate()), tillValues);

                    warningLabel.setText("Expenditure added successfully..");
                    warningLabel.setForeground(Color.green);
                    resetButtonActionPerformed(evt);
                } catch (java.lang.NumberFormatException e) {
                    warningLabel.setText("**Values should be decimal");
                }
            } else {
                warningLabel.setText("**Date already exist");
            }
        } else {
            warningLabel.setText("**Date should be selected");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accPay;
    private javax.swing.JTextField alcohol;
    private javax.swing.JTextField boAccPay;
    private javax.swing.JTextField boAccount;
    private javax.swing.JTextField boCard;
    private javax.swing.JTextField boCash;
    private javax.swing.JTextField boCashBack;
    private javax.swing.JTextField boInstLottary;
    private javax.swing.JTextField boInstPO;
    private javax.swing.JTextField boLottary;
    private javax.swing.JTextField boLottaryPO;
    private javax.swing.JTextField boMilk;
    private javax.swing.JTextField boOyster;
    private javax.swing.JTextField boPayPoint;
    private javax.swing.JTextField boPayZone;
    private javax.swing.JTextField boVaucherPayPoint;
    private javax.swing.JTextField card;
    private javax.swing.JTextField cash;
    private javax.swing.JTextField cashBack;
    private javax.swing.JTextField coin;
    private javax.swing.JTextField expenditure;
    private javax.swing.JTextField groceries;
    private javax.swing.JTextField insLottary;
    private javax.swing.JTextField instantPayOut;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lottary;
    private javax.swing.JTextField lottaryPayOut;
    private javax.swing.JTextField oyster;
    private javax.swing.JTextField payPoint;
    private javax.swing.JTextField payZone;
    private javax.swing.JTextField purchase;
    private javax.swing.JTextField refundAccountCredit;
    private javax.swing.JTextField refundGoods;
    private javax.swing.JTextField refundServices;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField tabacco;
    private javax.swing.JTextField todayTillCount;
    private javax.swing.JTextField voucherMilk;
    private javax.swing.JTextField voucherPayPoint;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JTextField yesterdayTillCount;
    // End of variables declaration//GEN-END:variables
}
