/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe;

import accountmanagement.database.DataBaseConnection;
import accountmanagement.jframe.administrator.AdminExpenditure;
import accountmanagement.jframe.administrator.AdminPurcharse;
import accountmanagement.jframe.administrator.Staff;
import accountmanagement.jframe.administrator.User;
import accountmanagement.jframe.report.BankReport;
import accountmanagement.jframe.report.DifferenceReport;
import accountmanagement.jframe.report.ExpenditureReport;
import accountmanagement.jframe.report.PettyReport;
import accountmanagement.jframe.report.PurcharseReport;
import accountmanagement.jframe.report.SalesReport;
import accountmanagement.jframe.report.Sheet2Report;
import accountmanagement.jframe.report.StaffReport;
import accountmanagement.jframe.report.TillReport;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class Report extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form Administrator
     * @param shopName
     */
    public Report(String shopName) {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        sheet2Button = new javax.swing.JButton();
        tillButton = new javax.swing.JButton();
        expenditureButton = new javax.swing.JButton();
        purcharseButton = new javax.swing.JButton();
        differenceButton = new javax.swing.JButton();
        pettyButton = new javax.swing.JButton();
        bankButton = new javax.swing.JButton();
        staffButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());
        jPanel1.add(jScrollPane1, "card2");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sheet2Button.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button.setText("Sheet2");
        sheet2Button.setBorder(null);
        sheet2Button.setBorderPainted(false);
        sheet2Button.setContentAreaFilled(false);
        sheet2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sheet2Button.setFocusPainted(false);
        sheet2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sheet2ButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sheet2ButtonMouseHoverOut(evt);
            }
        });
        sheet2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheet2ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(sheet2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, 130, 33));

        tillButton.setBackground(new java.awt.Color(0, 0, 51));
        tillButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        tillButton.setText("Till");
        tillButton.setBorder(null);
        tillButton.setBorderPainted(false);
        tillButton.setContentAreaFilled(false);
        tillButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tillButton.setFocusPainted(false);
        tillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tillButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tillButtonMouseHoverOut(evt);
            }
        });
        tillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillButtonActionPerformed(evt);
            }
        });
        jPanel2.add(tillButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 130, 31));

        expenditureButton.setBackground(new java.awt.Color(0, 0, 51));
        expenditureButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        expenditureButton.setText("Expenditure");
        expenditureButton.setBorder(null);
        expenditureButton.setBorderPainted(false);
        expenditureButton.setContentAreaFilled(false);
        expenditureButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        expenditureButton.setFocusPainted(false);
        expenditureButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expenditureButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                expenditureButtonMouseHoverOut(evt);
            }
        });
        expenditureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenditureButtonActionPerformed(evt);
            }
        });
        jPanel2.add(expenditureButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 162, 130, 33));

        purcharseButton.setBackground(new java.awt.Color(0, 0, 51));
        purcharseButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        purcharseButton.setText("Purcharse");
        purcharseButton.setBorder(null);
        purcharseButton.setBorderPainted(false);
        purcharseButton.setContentAreaFilled(false);
        purcharseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purcharseButton.setFocusPainted(false);
        purcharseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purcharseButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purcharseButtonMouseHoverOut(evt);
            }
        });
        purcharseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purcharseButtonActionPerformed(evt);
            }
        });
        jPanel2.add(purcharseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 111, 130, 33));

        differenceButton.setBackground(new java.awt.Color(0, 0, 51));
        differenceButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        differenceButton.setText("Difference");
        differenceButton.setBorder(null);
        differenceButton.setBorderPainted(false);
        differenceButton.setContentAreaFilled(false);
        differenceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        differenceButton.setFocusPainted(false);
        differenceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                differenceButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                differenceButtonMouseHoverOut(evt);
            }
        });
        differenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                differenceButtonActionPerformed(evt);
            }
        });
        jPanel2.add(differenceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 406, 130, 33));

        pettyButton.setBackground(new java.awt.Color(0, 0, 51));
        pettyButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        pettyButton.setText("Petty");
        pettyButton.setBorder(null);
        pettyButton.setBorderPainted(false);
        pettyButton.setContentAreaFilled(false);
        pettyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pettyButton.setFocusPainted(false);
        pettyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pettyButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pettyButtonMouseHoverOut(evt);
            }
        });
        pettyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pettyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(pettyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 211, 130, 33));

        bankButton.setBackground(new java.awt.Color(0, 0, 51));
        bankButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        bankButton.setText("Bank");
        bankButton.setBorder(null);
        bankButton.setBorderPainted(false);
        bankButton.setContentAreaFilled(false);
        bankButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bankButton.setFocusPainted(false);
        bankButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bankButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bankButtonMouseHoverOut(evt);
            }
        });
        bankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankButtonActionPerformed(evt);
            }
        });
        jPanel2.add(bankButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 256, 130, 33));

        staffButton.setBackground(new java.awt.Color(0, 0, 51));
        staffButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        staffButton.setText("Staff");
        staffButton.setBorder(null);
        staffButton.setBorderPainted(false);
        staffButton.setContentAreaFilled(false);
        staffButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        staffButton.setFocusPainted(false);
        staffButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                staffButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                staffButtonMouseHoverOut(evt);
            }
        });
        staffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffButtonActionPerformed(evt);
            }
        });
        jPanel2.add(staffButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 307, 130, 33));

        salesButton.setBackground(new java.awt.Color(0, 0, 51));
        salesButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        salesButton.setText("Sales");
        salesButton.setBorder(null);
        salesButton.setBorderPainted(false);
        salesButton.setContentAreaFilled(false);
        salesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesButton.setFocusPainted(false);
        salesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesButtonMouseHoverOut(evt);
            }
        });
        salesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButtonActionPerformed(evt);
            }
        });
        jPanel2.add(salesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 355, 130, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sheet2ButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHover
        sheet2Button.setForeground(Color.red);
    }//GEN-LAST:event_sheet2ButtonMouseHover

    private void sheet2ButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHoverOut
        sheet2Button.setForeground(Color.white);
    }//GEN-LAST:event_sheet2ButtonMouseHoverOut

    private void sheet2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2ButtonActionPerformed
        jPanel1.add("sheet2Report",new Sheet2Report(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_sheet2ButtonActionPerformed

    private void tillButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillButtonMouseHover
        tillButton.setForeground(Color.red);
    }//GEN-LAST:event_tillButtonMouseHover

    private void tillButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillButtonMouseHoverOut
        tillButton.setForeground(Color.white);
    }//GEN-LAST:event_tillButtonMouseHoverOut

    private void tillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillButtonActionPerformed
        jPanel1.add("TillReport",new TillReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_tillButtonActionPerformed

    private void expenditureButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHover
        expenditureButton.setForeground(Color.red);
    }//GEN-LAST:event_expenditureButtonMouseHover

    private void expenditureButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHoverOut
        expenditureButton.setForeground(Color.white);
    }//GEN-LAST:event_expenditureButtonMouseHoverOut

    private void expenditureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenditureButtonActionPerformed
        jPanel1.add("ExpenditureReport",new ExpenditureReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_expenditureButtonActionPerformed

    private void purcharseButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purcharseButtonMouseHover
        purcharseButton.setForeground(Color.red);
    }//GEN-LAST:event_purcharseButtonMouseHover

    private void purcharseButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purcharseButtonMouseHoverOut
        purcharseButton.setForeground(Color.white);
    }//GEN-LAST:event_purcharseButtonMouseHoverOut

    private void purcharseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purcharseButtonActionPerformed
        jPanel1.add("PurcharseReport",new PurcharseReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_purcharseButtonActionPerformed

    private void differenceButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_differenceButtonMouseHover
        differenceButton.setForeground(Color.red);
    }//GEN-LAST:event_differenceButtonMouseHover

    private void differenceButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_differenceButtonMouseHoverOut
       differenceButton.setForeground(Color.white);
    }//GEN-LAST:event_differenceButtonMouseHoverOut

    private void differenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_differenceButtonActionPerformed
        jPanel1.add("DifferenceReport",new DifferenceReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_differenceButtonActionPerformed

    private void pettyButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHover
        pettyButton.setForeground(Color.red);
    }//GEN-LAST:event_pettyButtonMouseHover

    private void pettyButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHoverOut
        pettyButton.setForeground(Color.white);
    }//GEN-LAST:event_pettyButtonMouseHoverOut

    private void pettyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pettyButtonActionPerformed
        jPanel1.add("PettyReport",new PettyReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_pettyButtonActionPerformed

    private void bankButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHover
        bankButton.setForeground(Color.red);
    }//GEN-LAST:event_bankButtonMouseHover

    private void bankButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHoverOut
        bankButton.setForeground(Color.white);
    }//GEN-LAST:event_bankButtonMouseHoverOut

    private void bankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankButtonActionPerformed
        jPanel1.add("BankReport", new BankReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_bankButtonActionPerformed

    private void staffButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffButtonMouseHover
        staffButton.setForeground(Color.red);
    }//GEN-LAST:event_staffButtonMouseHover

    private void staffButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffButtonMouseHoverOut
        staffButton.setForeground(Color.white);
    }//GEN-LAST:event_staffButtonMouseHoverOut

    private void staffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffButtonActionPerformed
        jPanel1.add("StaffReport", new StaffReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_staffButtonActionPerformed

    private void salesButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseHover
        salesButton.setForeground(Color.red);
    }//GEN-LAST:event_salesButtonMouseHover

    private void salesButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseHoverOut
        salesButton.setForeground(Color.white);
    }//GEN-LAST:event_salesButtonMouseHoverOut

    private void salesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButtonActionPerformed
        jPanel1.add("SalesReport", new SalesReport(shopName));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_salesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bankButton;
    private javax.swing.JButton differenceButton;
    private javax.swing.JButton expenditureButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pettyButton;
    private javax.swing.JButton purcharseButton;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton sheet2Button;
    private javax.swing.JButton staffButton;
    private javax.swing.JButton tillButton;
    // End of variables declaration//GEN-END:variables
}
