/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe;

import accountmanagement.database.DataBaseConnection;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author acer
 */
public class Dashboard extends javax.swing.JFrame {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;

    /**
     * Creates new form Dashboard
     *
     * @param shopName
     */
    public Dashboard(String shopName) {
        this.shopName = shopName;
        initComponents();
//        getTabList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        administratorButton = new javax.swing.JButton();
        tillButton = new javax.swing.JButton();
        purchaseButton = new javax.swing.JButton();
        expenditureButton = new javax.swing.JButton();
        bankButton = new javax.swing.JButton();
        sheet2Button = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        pettyButton = new javax.swing.JButton();
        staffTimeButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 1100));

        leftPanel.setBackground(new java.awt.Color(0, 0, 102));
        leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftPanel.setForeground(new java.awt.Color(255, 255, 255));

        administratorButton.setBackground(new java.awt.Color(0, 0, 51));
        administratorButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        administratorButton.setForeground(new java.awt.Color(255, 255, 255));
        administratorButton.setText("Administrator");
        administratorButton.setBorder(null);
        administratorButton.setBorderPainted(false);
        administratorButton.setContentAreaFilled(false);
        administratorButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        administratorButton.setFocusPainted(false);
        administratorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseHoverOut(evt);
            }
        });
        administratorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorButtonActionPerformed(evt);
            }
        });

        tillButton.setBackground(new java.awt.Color(204, 204, 255));
        tillButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tillButton.setForeground(new java.awt.Color(255, 255, 255));
        tillButton.setText("Till");
        tillButton.setBorderPainted(false);
        tillButton.setContentAreaFilled(false);
        tillButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tillButton.setFocusPainted(false);
        tillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillButtonActionPerformed(evt);
            }
        });

        purchaseButton.setBackground(new java.awt.Color(0, 0, 51));
        purchaseButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        purchaseButton.setForeground(new java.awt.Color(255, 255, 255));
        purchaseButton.setText("Purchase");
        purchaseButton.setBorder(null);
        purchaseButton.setBorderPainted(false);
        purchaseButton.setContentAreaFilled(false);
        purchaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseButton.setFocusPainted(false);
        purchaseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purchaseButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purchaseButtonMouseHoverOut(evt);
            }
        });
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        expenditureButton.setBackground(new java.awt.Color(0, 0, 51));
        expenditureButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        expenditureButton.setForeground(new java.awt.Color(255, 255, 255));
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

        bankButton.setBackground(new java.awt.Color(0, 0, 51));
        bankButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        bankButton.setForeground(new java.awt.Color(255, 255, 255));
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

        sheet2Button.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        sheet2Button.setForeground(new java.awt.Color(255, 255, 255));
        sheet2Button.setText("Sheet 2");
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

        salesButton.setBackground(new java.awt.Color(0, 0, 51));
        salesButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        salesButton.setForeground(new java.awt.Color(255, 255, 255));
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

        pettyButton.setBackground(new java.awt.Color(0, 0, 51));
        pettyButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        pettyButton.setForeground(new java.awt.Color(255, 255, 255));
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

        staffTimeButton.setBackground(new java.awt.Color(0, 0, 51));
        staffTimeButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        staffTimeButton.setForeground(new java.awt.Color(255, 255, 255));
        staffTimeButton.setText("Staff Time");
        staffTimeButton.setBorder(null);
        staffTimeButton.setBorderPainted(false);
        staffTimeButton.setContentAreaFilled(false);
        staffTimeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        staffTimeButton.setFocusPainted(false);
        staffTimeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                staffTimeButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                staffTimeButtonMouseHoverOut(evt);
            }
        });
        staffTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffTimeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(administratorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tillButton, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expenditureButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bankButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sheet2Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pettyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffTimeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administratorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sheet2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expenditureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pettyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffTimeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightPanel.setMaximumSize(new java.awt.Dimension(1900, 1000));
        rightPanel.setPreferredSize(new java.awt.Dimension(1500, 960));
        rightPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administratorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorButtonActionPerformed
        rightPanel.add("Administrator", new Administrator(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_administratorButtonActionPerformed

    private void tillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillButtonActionPerformed
        rightPanel.add("Till", new Till(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_tillButtonActionPerformed

    private void MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseHover
        administratorButton.setForeground(Color.red);
    }//GEN-LAST:event_MouseHover

    private void MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseHoverOut
        administratorButton.setForeground(Color.white);
    }//GEN-LAST:event_MouseHoverOut

    private void purchaseButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseButtonMouseHover
        purchaseButton.setForeground(Color.red);
    }//GEN-LAST:event_purchaseButtonMouseHover

    private void purchaseButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseButtonMouseHoverOut
        purchaseButton.setForeground(Color.white);
    }//GEN-LAST:event_purchaseButtonMouseHoverOut

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed
//        rightPanel.add("Purchase", new Purchase(shopName));
//        CardLayout layout = (CardLayout) rightPanel.getLayout();
//        layout.next(rightPanel);
    }//GEN-LAST:event_purchaseButtonActionPerformed

    private void expenditureButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_expenditureButtonMouseHover

    private void expenditureButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_expenditureButtonMouseHoverOut

    private void expenditureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenditureButtonActionPerformed
//        rightPanel.add("Expenditure", new Expenditure(shopName));
//        CardLayout layout = (CardLayout) rightPanel.getLayout();
//        layout.next(rightPanel);
    }//GEN-LAST:event_expenditureButtonActionPerformed

    private void bankButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_bankButtonMouseHover

    private void bankButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_bankButtonMouseHoverOut

    private void bankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankButtonActionPerformed
        rightPanel.add("Bank", new Bank(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_bankButtonActionPerformed

    private void sheet2ButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_sheet2ButtonMouseHover

    private void sheet2ButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_sheet2ButtonMouseHoverOut

    private void sheet2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2ButtonActionPerformed
        rightPanel.add("Sheet2", new Sheet2(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_sheet2ButtonActionPerformed

    private void salesButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_salesButtonMouseHover

    private void salesButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_salesButtonMouseHoverOut

    private void salesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButtonActionPerformed
//        rightPanel.add("Sales", new Sales(shopName));
//        CardLayout layout = (CardLayout) rightPanel.getLayout();
//        layout.next(rightPanel);
    }//GEN-LAST:event_salesButtonActionPerformed

    private void pettyButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_pettyButtonMouseHover

    private void pettyButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_pettyButtonMouseHoverOut

    private void pettyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pettyButtonActionPerformed
//        rightPanel.add("Petty", new Petty(shopName));
//        CardLayout layout = (CardLayout) rightPanel.getLayout();
//        layout.next(rightPanel);
    }//GEN-LAST:event_pettyButtonActionPerformed

    private void staffTimeButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTimeButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_staffTimeButtonMouseHover

    private void staffTimeButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTimeButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_staffTimeButtonMouseHoverOut

    private void staffTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffTimeButtonActionPerformed
//        rightPanel.add("StaffTime", new StaffTime(shopName));
//        CardLayout layout = (CardLayout) rightPanel.getLayout();
//        layout.next(rightPanel);
    }//GEN-LAST:event_staffTimeButtonActionPerformed

    private void getTabList() {
        ResultSet res = db.getTabDetail(shopName);
        try {
            int i = 1;
            while (res.next()) {
                String tabName = res.getString("TabName");
                JButton button = new JButton(tabName);
                button.setBounds(0, 110 + 60 * (i-1), 218, 42);
                button.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
                button.setText(tabName);
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.addActionListener(populateTabPanel(tabName));
                leftPanel.add(tabName, button);
                i = i + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TillJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ActionListener populateTabPanel(String tabName) {
        return (ActionEvent e) -> {
            rightPanel.add("Items", new Items(shopName, tabName));
            CardLayout layout = (CardLayout) rightPanel.getLayout();
            layout.next(rightPanel);
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administratorButton;
    private javax.swing.JButton bankButton;
    private javax.swing.JButton expenditureButton;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton pettyButton;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton sheet2Button;
    private javax.swing.JButton staffTimeButton;
    private javax.swing.JButton tillButton;
    // End of variables declaration//GEN-END:variables
}
