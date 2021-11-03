/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report.difference;

import accountmanagement.database.DataBaseConnection;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author acer
 */
public class DifferenceReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form Administrator
     *
     * @param shopName
     */
    public DifferenceReport(String shopName) {
        this.shopName = shopName;
        initComponents();
        populateDifferenceReport();
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
        pettyButton = new javax.swing.JButton();
        bankButton = new javax.swing.JButton();
        staffButton = new javax.swing.JButton();
        salesButton1 = new javax.swing.JButton();
        salesButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.CardLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jScrollPane1, "card2");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        sheet2Button.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button.setText("Cash Plus");
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

        tillButton.setBackground(new java.awt.Color(0, 0, 51));
        tillButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        tillButton.setText("NATWEST");
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

        expenditureButton.setBackground(new java.awt.Color(0, 0, 51));
        expenditureButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        expenditureButton.setText("Pay Zone");
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

        purcharseButton.setBackground(new java.awt.Color(0, 0, 51));
        purcharseButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        purcharseButton.setText("Eleven Card");
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

        pettyButton.setBackground(new java.awt.Color(0, 0, 51));
        pettyButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        pettyButton.setText("Oyster");
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

        bankButton.setBackground(new java.awt.Color(0, 0, 51));
        bankButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        bankButton.setText("Cash & Coin");
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

        staffButton.setBackground(new java.awt.Color(0, 0, 51));
        staffButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        staffButton.setText("Milk");
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

        salesButton1.setBackground(new java.awt.Color(0, 0, 51));
        salesButton1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        salesButton1.setText("CAMLOT");
        salesButton1.setBorder(null);
        salesButton1.setBorderPainted(false);
        salesButton1.setContentAreaFilled(false);
        salesButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesButton1.setFocusPainted(false);
        salesButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesButton1MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesButton1MouseHoverOut(evt);
            }
        });
        salesButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButton1ActionPerformed(evt);
            }
        });

        salesButton5.setBackground(new java.awt.Color(0, 0, 51));
        salesButton5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        salesButton5.setText("Pay Point");
        salesButton5.setBorder(null);
        salesButton5.setBorderPainted(false);
        salesButton5.setContentAreaFilled(false);
        salesButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesButton5.setFocusPainted(false);
        salesButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesButton5MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesButton5MouseHoverOut(evt);
            }
        });
        salesButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sheet2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(purcharseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(salesButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(expenditureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pettyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(salesButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(staffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tillButton)
                .addGap(10, 10, 10)
                .addComponent(sheet2Button)
                .addGap(10, 10, 10)
                .addComponent(purcharseButton)
                .addGap(10, 10, 10)
                .addComponent(salesButton5)
                .addGap(10, 10, 10)
                .addComponent(expenditureButton)
                .addGap(10, 10, 10)
                .addComponent(pettyButton)
                .addGap(10, 10, 10)
                .addComponent(salesButton1)
                .addGap(10, 10, 10)
                .addComponent(bankButton)
                .addGap(10, 10, 10)
                .addComponent(staffButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
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
        sheet2Button.setForeground(Color.black);
    }//GEN-LAST:event_sheet2ButtonMouseHoverOut

    private void sheet2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2ButtonActionPerformed
        jPanel1.add(new TwoColReport(shopName, "Cash Plus", "Bank", "FB_CashPlus", "Petty", "B_CashPlus"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_sheet2ButtonActionPerformed

    private void tillButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillButtonMouseHover
        tillButton.setForeground(Color.red);
    }//GEN-LAST:event_tillButtonMouseHover

    private void tillButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillButtonMouseHoverOut
        tillButton.setForeground(Color.black);
    }//GEN-LAST:event_tillButtonMouseHoverOut

    private void tillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillButtonActionPerformed
        jPanel1.add(new TwoColReport(shopName, "NATWEST", "Bank", "FB_NATWEST", "Petty", "B_NATWEST"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_tillButtonActionPerformed

    private void expenditureButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHover
        expenditureButton.setForeground(Color.red);
    }//GEN-LAST:event_expenditureButtonMouseHover

    private void expenditureButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHoverOut
        expenditureButton.setForeground(Color.black);
    }//GEN-LAST:event_expenditureButtonMouseHoverOut

    private void expenditureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenditureButtonActionPerformed
        jPanel1.add(new TwoColReport(shopName, "PayZone", "Bank", "SMO_PayZone", "Till", "R_PayZone"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_expenditureButtonActionPerformed

    private void purcharseButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purcharseButtonMouseHover
        purcharseButton.setForeground(Color.red);
    }//GEN-LAST:event_purcharseButtonMouseHover

    private void purcharseButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purcharseButtonMouseHoverOut
        purcharseButton.setForeground(Color.black);
    }//GEN-LAST:event_purcharseButtonMouseHoverOut

    private void purcharseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purcharseButtonActionPerformed
        jPanel1.add(new TwoColReport(shopName,"ElevenCard", "Bank", "FB_ElevenCard", "Till", "R_Card"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_purcharseButtonActionPerformed

    private void pettyButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHover
        pettyButton.setForeground(Color.red);
    }//GEN-LAST:event_pettyButtonMouseHover

    private void pettyButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHoverOut
        pettyButton.setForeground(Color.black);
    }//GEN-LAST:event_pettyButtonMouseHoverOut

    private void pettyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pettyButtonActionPerformed
        jPanel1.add(new TwoColReportWithDD(shopName, "Oyster", "Bank", "SMO_Oyster", "Till", "Oyster"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);    
    }//GEN-LAST:event_pettyButtonActionPerformed

    private void bankButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHover
        bankButton.setForeground(Color.red);
    }//GEN-LAST:event_bankButtonMouseHover

    private void bankButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHoverOut
        bankButton.setForeground(Color.black);
    }//GEN-LAST:event_bankButtonMouseHoverOut

    private void bankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankButtonActionPerformed

        
        
        
    }//GEN-LAST:event_bankButtonActionPerformed

    private void staffButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffButtonMouseHover
        staffButton.setForeground(Color.red);
    }//GEN-LAST:event_staffButtonMouseHover

    private void staffButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffButtonMouseHoverOut
        staffButton.setForeground(Color.black);
    }//GEN-LAST:event_staffButtonMouseHoverOut

    private void staffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffButtonActionPerformed
        jPanel1.add(new TwoColReport(shopName, "Milk", "Bank", "FB_MilkVouture", "Till", "R_VoucherMilk"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_staffButtonActionPerformed

    private void salesButton1MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButton1MouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_salesButton1MouseHover

    private void salesButton1MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButton1MouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_salesButton1MouseHoverOut

    private void salesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButton1ActionPerformed
        jPanel1.add(new TwoColReportWithDD(shopName, "CAMLOT", "Bank", "SMO_Camlot", "Till", "CAMLOT"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_salesButton1ActionPerformed

    private void salesButton5MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButton5MouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_salesButton5MouseHover

    private void salesButton5MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButton5MouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_salesButton5MouseHoverOut

    private void salesButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButton5ActionPerformed
        jPanel1.add(new TwoColReportWithDD(shopName, "PayPoint", "Bank", "SMO_PayPoint", "Till", "PayPoint"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_salesButton5ActionPerformed

    private void populateDifferenceReport() {
        ResultSet res = db.getDeatilTableValue(shopName, "Staff");
        try {
            int i = 1;
            while (res.next()) {
                String staffName = res.getString("StaffName");
                String staffColName = res.getString("StaffColName");

                JButton button = new JButton();
                button.setBackground(new java.awt.Color(0, 0, 51));
                button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
                button.setText(staffName);
                button.setBorder(null);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                button.setFocusPainted(false);
                button.setBounds(0, 250 + i * 30, 130, 20);
                button.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        button.setForeground(Color.red);
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        button.setForeground(Color.black);
                    }
                });
                button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jPanel1.add("report", new StaffDiffReport(shopName, staffName, staffColName));
                        CardLayout layout = (CardLayout) jPanel1.getLayout();
                        layout.next(jPanel1);
                    }
                });

                jPanel2.add(button);
                i = i + 1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DifferenceReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bankButton;
    private javax.swing.JButton expenditureButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pettyButton;
    private javax.swing.JButton purcharseButton;
    private javax.swing.JButton salesButton1;
    private javax.swing.JButton salesButton5;
    private javax.swing.JButton sheet2Button;
    private javax.swing.JButton staffButton;
    private javax.swing.JButton tillButton;
    // End of variables declaration//GEN-END:variables
}
