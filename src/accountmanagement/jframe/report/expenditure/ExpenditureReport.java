/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report.expenditure;

import accountmanagement.jframe.report.SingleReport;
import accountmanagement.database.DataBaseConnection;
import accountmanagement.jframe.Expenditure;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author acer
 */
public class ExpenditureReport extends javax.swing.JPanel {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private Map<String, String> expenditureList = new HashMap();

    /**
     * Creates new form Administrator
     *
     * @param shopName
     */
    public ExpenditureReport(String shopName) {
        this.shopName = shopName;
        initComponents();
        populateExpenditureReport();
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

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.CardLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jScrollPane1, "card2");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        sheet2Button.setBackground(new java.awt.Color(0, 0, 51));
        sheet2Button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        sheet2Button.setText("Detail");
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
        tillButton.setText("Summary");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sheet2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tillButton)
                .addGap(10, 10, 10)
                .addComponent(sheet2Button))
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
        jPanel1.add("detail", new ExpenditureTotalReport(shopName, "Expenditure - Detail Report", "Expenditure", "Till", expenditureList, "R_Expenditure"));
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
        jPanel1.add(new Summary(shopName, "Expenditure", "Expenditure"));
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
    }//GEN-LAST:event_tillButtonActionPerformed

    private void populateExpenditureReport() {
        ResultSet res = db.getDeatilTableValue(shopName, "ExpenditureDetail");
        try {
            int i = 1;
            while (res.next()) {
                String item = res.getString("Item");
                String name = res.getString("Name");
                
                if(!name.equalsIgnoreCase("Total"))
                    expenditureList.put(name, item);
                String title = "EXPENDITURE - " + item.toUpperCase() + " REPORT";
                
                JButton button = new JButton();
                button.setBackground(new java.awt.Color(0, 0, 51));
                button.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
                button.setText("<html><center>"+item+"</center></html>");
                button.setBorder(null);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                button.setFocusPainted(false);
                button.setBounds(0, 40 + i * 30, 130, 20);
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
                        jPanel1.add("report", new SingleReport(shopName, title, name, "Expenditure"));
                        CardLayout layout = (CardLayout) jPanel1.getLayout();
                        layout.next(jPanel1);
                    }
                });

                jPanel2.add(button);
                i = i + 1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Expenditure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sheet2Button;
    private javax.swing.JButton tillButton;
    // End of variables declaration//GEN-END:variables
}
