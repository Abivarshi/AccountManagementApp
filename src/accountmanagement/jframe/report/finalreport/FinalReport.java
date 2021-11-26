/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report.finalreport;

import accountmanagement.database.DataBaseConnection;
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
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author acer
 */
public class FinalReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form Till
     *
     * @param shopName
     */
    public FinalReport(String shopName) {
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
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFrom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 161, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("FINAL REPORT");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 20));

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

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("From Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 38, 80, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        System.out.println("In Final Report");

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
            List<Map<String, Object>> data = new ArrayList();

            System.out.println("In Final Report");
            String description = "Date: " + fromDate + " - " + toDate;
            Float subPurchaseTill = db.getSumOneColValueTabTable(shopName, "Till", "R_Purchase", fromDate, toDate);
            Float subPurchaseBank = db.getSumOneColValueTabTable(shopName, "Bank", "SubPurchase", fromDate, toDate);
            Float subPurchasePetty = db.getSumOneColValueTabTable(shopName, "Petty", "SubPurchase", fromDate, toDate);
            Float totalPurchase = subPurchaseTill + subPurchaseBank + subPurchasePetty;

            Float subExpenPetty = db.getSumOneColValueTabTable(shopName, "Petty", "SubExpenditure", fromDate, toDate);
            Float subExpenTill = db.getSumOneColValueTabTable(shopName, "Till", "R_Expenditure", fromDate, toDate);
            Float subExpenBank = db.getSumOneColValueTabTable(shopName, "Bank", "SubExpenditure", fromDate, toDate);

            Float SalesBookOut = db.getSumOneColValueTabTable(shopName, "Sales", "Total", fromDate, toDate);
            Float TotalSales = db.getSumOneColValueTabTable(shopName, "Till", "SalesSubTotal", fromDate, toDate);
            Float TotalGrossProfit = TotalSales - totalPurchase;
            Float TotalAccountCredit = db.getSumOneColValueTabTable(shopName, "Till", "R_AccountCredit", fromDate, toDate);
            Float TotalAccPay = db.getSumOneColValueTabTable(shopName, "Till", "R_AccPay", fromDate, toDate);

            Float bmPetty = db.getSumOneColValueTabTable(shopName, "Petty", "BO_Cash", fromDate, toDate);
            Float bmPettyCC = db.getSumOneColValueTabTable(shopName, "Petty", "BO_CCard", fromDate, toDate);
            Float BMPettyIOU = db.getSumOneColValueTabTable(shopName, "Petty", "BO_IOU", fromDate, toDate);

            Float ExpenditureCapitalGain = db.getSumOneColValueTabTable(shopName, "Expenditure", "CapitalGains", fromDate, toDate);
            Float PettyCapitalGain = db.getSumOneColValueTabTable(shopName, "Petty", "E_CapitalGains", fromDate, toDate);
            Float BankCapitalGain = db.getSumOneColValueTabTable(shopName, "Bank", "EM_CapitalGains", fromDate, toDate);

            Float PBCash = db.getSumOneColValueTabTable(shopName, "Petty", "PB_Cash", fromDate, toDate);
            Float PBCCard = db.getSumOneColValueTabTable(shopName, "Petty", "PB_CCard", fromDate, toDate);
            Float PBIOU = db.getSumOneColValueTabTable(shopName, "Petty", "PB_IOU", fromDate, toDate);
            Float PBBank = db.getSumOneColValueTabTable(shopName, "Bank", "PB_BorrowMoney", fromDate, toDate);

            System.out.println("In Final Report");
            Float PettyBalance = db.getSumOneColValueTabTable(shopName, "Petty", "PettyBalance", fromDate, toDate);
            Float BankBalance = db.getSumOneColValueTabTable(shopName, "Bank", "Balance", fromDate, toDate);

            Float DiffMilk = diffMilk(fromDate, toDate);
            Float DiffPayPoint = diffPayPoint(fromDate, toDate);
            Float DiffPayZone = diffPayZone(fromDate, toDate);
            Float DiffOyster = diffOyster(fromDate, toDate);
            Float DiffCamlot = diffCamlot(fromDate, toDate);
            Float DiffStaff = diffStaff(fromDate, toDate);
            Float DiffElevenCard = diffElevenCard(fromDate, toDate);

            Float AssumedPurchase = db.getSumOneColValueTabTable(shopName, "Till", "AssumePurchase", fromDate, toDate);
            Float AssumedProfit = db.getSumOneColValueTabTable(shopName, "Till", "AssumeNetProfit", fromDate, toDate);
            Float AssumedExpenditure = db.getSumOneColValueTabTable(shopName, "Till", "AssumeExpenditure", fromDate, toDate);

            System.out.println("In Final Report");
            Float TotalPurchase = subPurchaseTill + subPurchaseBank + subPurchasePetty;
            Float TotalExpenditure = subExpenPetty + subExpenTill + subExpenBank;
            Float TotalCapitalGain = ExpenditureCapitalGain + PettyCapitalGain + BankCapitalGain;

            Float NetProfitAccount = TotalGrossProfit + TotalAccountCredit + TotalCapitalGain - TotalAccPay - TotalExpenditure;
            Float BalanceMoneyToPay = bmPetty + bmPettyCC + BMPettyIOU - PBCash - PBCCard - PBIOU - PBBank;
            Float BalanceMoneyInHand = PettyBalance + BankBalance + DiffMilk + DiffPayPoint + DiffPayZone
                    + DiffOyster + DiffCamlot + DiffStaff + DiffElevenCard - BalanceMoneyToPay;

            try {

                Map<String, Object> map = new HashMap();
                map.put("description", description);
                map.put("PettyPurchase", subPurchasePetty);
                map.put("BankPurchase", subPurchaseBank);
                map.put("TillPurchase", subPurchaseTill);
                map.put("BMPetty", bmPetty);
                map.put("PettyExpenditure", subExpenPetty);
                map.put("BankExpenditure", subExpenBank);
                map.put("TillExpenditure", subExpenTill);
                map.put("BMPettyCC", bmPettyCC);
                map.put("SalesBookOut", SalesBookOut);
                map.put("TotalSales", TotalSales);
                map.put("TotalGrossProfit", TotalGrossProfit);
                map.put("TotalAccountCredit", TotalAccountCredit);
                map.put("TotalAccPay", TotalAccPay);
                map.put("BMPettyIOU", BMPettyIOU);
                map.put("ExpenditureCapitalGain", ExpenditureCapitalGain);
                map.put("PettyCapitalGain", PettyCapitalGain);
                map.put("BankCapitalGain", BankCapitalGain);
                map.put("PBCash", PBCash);
                map.put("PBCCard", PBCCard);
                map.put("PBIOU", PBIOU);
                map.put("PBBank", PBBank);
                map.put("PettyBalance", PettyBalance);
                map.put("BankBalance", BankBalance);
                map.put("DiffMilk", DiffMilk);
                map.put("DiffPayPoint", DiffPayPoint);
                map.put("DiffPayZone", DiffPayZone);
                map.put("DiffOyster", DiffOyster);
                map.put("DiffCamlot", DiffCamlot);
                map.put("DiffStaff", DiffStaff);
                map.put("DiffElevenCard", DiffElevenCard);
                map.put("AssumedPurchase", AssumedPurchase);
                map.put("AssumedProfit", AssumedProfit);
                map.put("AssumedExpenditure", AssumedExpenditure);
                map.put("NetProfitAccount", NetProfitAccount);
                map.put("BalanceMoneyToPay", BalanceMoneyToPay);
                map.put("BalanceMoneyInHand", BalanceMoneyInHand);
                map.put("SOPurchase", AssumedPurchase - TotalPurchase);
                map.put("SOExpenditure", AssumedExpenditure);
                map.put("SONetProfit", AssumedProfit - TotalCapitalGain);
                map.put("TotalPurchase", TotalPurchase);
                map.put("TotalExpenditure", TotalExpenditure);
                map.put("TotalCapitalGain", TotalCapitalGain);
                map.put("ExtraMoneyOut", AssumedPurchase + AssumedProfit - TotalCapitalGain - TotalPurchase);
                data.add(map);

                if (!data.isEmpty()) {
                    JRDataSource dataSource = new JRBeanCollectionDataSource(data);
                    InputStream sourceName = getClass().getResourceAsStream("/accountmanagement/jframe/report/finalreport/FinalReport.jrxml");

                    JasperReport jasperReport = JasperCompileManager.compileReport(sourceName);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                    JasperViewer.viewReport(jasperPrint, false);
                } else {
                    warningLabel1.setText("No record available within date " + fromDate + " - " + toDate);
                }
            } catch (JRException ex) {
                Logger.getLogger(FinalReport.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            warningLabel1.setText("From Date should be earlier date");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private Float diffMilk(String fromDate, String toDate) {
        return db.getSumOneColValueTabTable(shopName, "Bank", "FB_MilkVouture", fromDate, toDate)
                - db.getSumOneColValueTabTable(shopName, "Till", "R_VoucherMilk", fromDate, toDate);
    }

    private Float diffPayPoint(String fromDate, String toDate) {
        Float val = db.getSumOneColValueTabTable(shopName, "Till", "R_PayPoint", fromDate, toDate);
        Float val1 = db.getSumOneColValueTabTable(shopName, "Till", "R_VoucherPayPoint", fromDate, toDate);
        Float val2 = db.getSumOneColValueTabTable(shopName, "Sheet2", "CommisionPayPoint", fromDate, toDate);
        Float val3 = db.getSumOneColValueTabTable(shopName, "Sheet2", "SC_PayPoint", fromDate, toDate);
        return val - val1 - val2 + val3;
    }

    private Float diffPayZone(String fromDate, String toDate) {
        return db.getSumOneColValueTabTable(shopName, "Bank", "SMO_PayZone", fromDate, toDate)
                - db.getSumOneColValueTabTable(shopName, "Till", "R_PayZone", fromDate, toDate);
    }

    private Float diffOyster(String fromDate, String toDate) {
        Float val = db.getSumOneColValueTabTable(shopName, "Till", "R_Oyster", fromDate, toDate);
        Float val1 = db.getSumOneColValueTabTable(shopName, "Sheet2", "CommisionOyster", fromDate, toDate);
        return val - val1;
    }

    private Float diffCamlot(String fromDate, String toDate) {
        Float val = db.getSumOneColValueTabTable(shopName, "Till", "R_Lottary", fromDate, toDate);
        Float val1 = db.getSumOneColValueTabTable(shopName, "Till", "R_InsLottary", fromDate, toDate);
        Float val2 = db.getSumOneColValueTabTable(shopName, "Till", "R_LottaryPayOut", fromDate, toDate);
        Float val3 = db.getSumOneColValueTabTable(shopName, "Till", "R_InstantPayOut", fromDate, toDate);
        Float val4 = db.getSumOneColValueTabTable(shopName, "Sheet2", "SC_Lottary", fromDate, toDate);
        Float val5 = db.getSumOneColValueTabTable(shopName, "Sheet2", "CommisionLottary", fromDate, toDate);
        return val + val1 - val2 - val3 + val4 - val5;
    }

    private Float diffStaff(String fromDate, String toDate) {
        Float returnVal = 0f;

        ResultSet res = db.getDeatilTableValue(shopName, "Staff");
        try {
            List<String> staffNames = new ArrayList();
            while (res.next()) {
                String staffColName = res.getString("StaffColName");
                staffNames.add(staffColName);
            }

            for (String staffName : staffNames) {
                Float val = db.getSumSalaryStaff(shopName, staffName, fromDate, toDate);
                Float val1 = db.getSumOneColValueTabTable(shopName, "Bank", "EM_" + staffName, fromDate, toDate);
                Float val2 = db.getSumOneColValueTabTable(shopName, "Expenditure", staffName, fromDate, toDate);
                returnVal = returnVal + val - val1 - val2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FinalReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnVal;
    }

    private Float diffElevenCard(String fromDate, String toDate) {
        return db.getSumOneColValueTabTable(shopName, "Till", "R_Card", fromDate, toDate)
                - db.getSumOneColValueTabTable(shopName, "Bank", "FB_ElevenCard", fromDate, toDate);
    }

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

}
