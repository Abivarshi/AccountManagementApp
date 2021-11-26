/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report.commission;

import accountmanagement.jframe.report.SingleReport;
import accountmanagement.database.DataBaseConnection;
import accountmanagement.jframe.Expenditure;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author acer
 */
public class CommissionReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private Map<String, String> commissionList = new HashMap();
    private Map<String, String> serviceChargeList = new HashMap();
    private Map<String, String> bankCommissionList = new HashMap();
    private Map<String, String> bankServiceChargeList = new HashMap();

    /**
     * Creates new form Administrator
     *
     * @param shopName
     */
    public CommissionReport(String shopName) {
        this.shopName = shopName;
        initComponents();
        populateCommissionReport();
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
        sheet2Button1 = new javax.swing.JButton();
        sheet2Button2 = new javax.swing.JButton();
        sheet2Button3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.CardLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jScrollPane1, "card2");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(130, 960));

        sheet2Button.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button.setText("Total Commission");
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
        tillButton.setText("Commission");
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

        sheet2Button1.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button1.setText("DD");
        sheet2Button1.setBorder(null);
        sheet2Button1.setBorderPainted(false);
        sheet2Button1.setContentAreaFilled(false);
        sheet2Button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sheet2Button1.setFocusPainted(false);
        sheet2Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sheet2Button1MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sheet2Button1MouseHoverOut(evt);
            }
        });
        sheet2Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheet2Button1ActionPerformed(evt);
            }
        });

        sheet2Button2.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button2.setText("Service Charge");
        sheet2Button2.setBorder(null);
        sheet2Button2.setBorderPainted(false);
        sheet2Button2.setContentAreaFilled(false);
        sheet2Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sheet2Button2.setFocusPainted(false);
        sheet2Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sheet2Button2MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sheet2Button2MouseHoverOut(evt);
            }
        });
        sheet2Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheet2Button2ActionPerformed(evt);
            }
        });

        sheet2Button3.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button3.setText("Total Service Charge");
        sheet2Button3.setBorder(null);
        sheet2Button3.setBorderPainted(false);
        sheet2Button3.setContentAreaFilled(false);
        sheet2Button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sheet2Button3.setFocusPainted(false);
        sheet2Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sheet2Button3MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sheet2Button3MouseHoverOut(evt);
            }
        });
        sheet2Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheet2Button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sheet2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sheet2Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sheet2Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sheet2Button3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tillButton)
                .addGap(10, 10, 10)
                .addComponent(sheet2Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sheet2Button2)
                .addGap(14, 14, 14)
                .addComponent(sheet2Button3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sheet2Button1)
                .addContainerGap(800, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sheet2ButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHover
        sheet2Button.setForeground(Color.red);
    }//GEN-LAST:event_sheet2ButtonMouseHover

    private void sheet2ButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHoverOut
        sheet2Button.setForeground(Color.black);
    }//GEN-LAST:event_sheet2ButtonMouseHoverOut

    private void sheet2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2ButtonActionPerformed
        jPanel1.add(new CommissionTotalReport(shopName, "Commission - Total Report", "Sheet2", "Bank", commissionList, bankCommissionList));
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
        jPanel1.add(new CommissionDetailReport(shopName, "Sheet2", "Commission - Report", commissionList));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_tillButtonActionPerformed

    private void sheet2Button1MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2Button1MouseHover
        sheet2Button1.setForeground(Color.red);
    }//GEN-LAST:event_sheet2Button1MouseHover

    private void sheet2Button1MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2Button1MouseHoverOut
        sheet2Button1.setForeground(Color.black);
    }//GEN-LAST:event_sheet2Button1MouseHoverOut

    private void sheet2Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sheet2Button1ActionPerformed

    private void sheet2Button2MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2Button2MouseHover
        sheet2Button2.setForeground(Color.red);
    }//GEN-LAST:event_sheet2Button2MouseHover

    private void sheet2Button2MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2Button2MouseHoverOut
        sheet2Button2.setForeground(Color.black);
    }//GEN-LAST:event_sheet2Button2MouseHoverOut

    private void sheet2Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2Button2ActionPerformed
        jPanel1.add(new CommissionDetailReport(shopName, "Sheet2", "Service Charge - Report", serviceChargeList));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_sheet2Button2ActionPerformed

    private void sheet2Button3MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2Button3MouseHover
        sheet2Button3.setForeground(Color.red);
    }//GEN-LAST:event_sheet2Button3MouseHover

    private void sheet2Button3MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2Button3MouseHoverOut
        sheet2Button3.setForeground(Color.black);
    }//GEN-LAST:event_sheet2Button3MouseHoverOut

    private void sheet2Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2Button3ActionPerformed
        jPanel1.add(new CommissionTotalReport(shopName, "Service Charge - Total Report", "Sheet2", "Bank", serviceChargeList, bankServiceChargeList));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_sheet2Button3ActionPerformed

    private void populateCommissionReport() {
        ResultSet res = db.getDeatilTableValue(shopName, "Sheet2Detail");
        try {
            int i = 1;
            while (res.next()) {
                String item = res.getString("Item");
                String name = res.getString("Name");
                String type = res.getString("Type");

                if (!type.equalsIgnoreCase("Summary")) {
                    if (type.equalsIgnoreCase("Commision")) {
                        commissionList.put(name, item);
                    } else if (type.equalsIgnoreCase("Service Charge")) {
                        serviceChargeList.put(name, item);
                    }
                    String title = type.toUpperCase() + " - " + item.toUpperCase() + " REPORT";

                    JButton button = new JButton();
                    button.setBackground(new java.awt.Color(0, 0, 51));
                    button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
                    button.setText("<html><center>" + item + " " + type + "</center></html>");
                    button.setBorder(null);
                    button.setBorderPainted(false);
                    button.setContentAreaFilled(false);
                    button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    button.setFocusPainted(false);
                    button.setBounds(0, 120 + i * 40, 130, 40);
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
                            jPanel1.add("report", new SingleReport(shopName, title, name, "Sheet2"));
                            CardLayout layout = (CardLayout) jPanel1.getLayout();
                            layout.next(jPanel1);
                        }
                    });

                    jPanel2.add(button);
                    i = i + 1;
                }
            }
            getBankDetail();
        } catch (Exception ex) {
            Logger.getLogger(Expenditure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getBankDetail() {
        ResultSet res = db.getDeatilTableValue(shopName, "BankDetail");
        try {
            while (res.next()) {
                String item = res.getString("Item");
                String name = res.getString("Name");
                String type = res.getString("Type");

                if (type.equalsIgnoreCase("Money In (Commission)")) {
                    bankCommissionList.put(name, item);
                } else if (name.equalsIgnoreCase("EB_PayZoneRental")) {
                    bankServiceChargeList.put(name, item);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(Expenditure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sheet2Button;
    private javax.swing.JButton sheet2Button1;
    private javax.swing.JButton sheet2Button2;
    private javax.swing.JButton sheet2Button3;
    private javax.swing.JButton tillButton;
    // End of variables declaration//GEN-END:variables
}
