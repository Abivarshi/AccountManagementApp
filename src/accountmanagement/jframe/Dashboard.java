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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class Dashboard extends javax.swing.JFrame {

    DataBaseConnection db = new DataBaseConnection();
    private final String shopName;
    private final String role;
    private final String userName;

    /**
     * Creates new form Dashboard
     *
     * @param shopName
     * @param role
     * @param userName
     */
    public Dashboard(String shopName, String role, String userName) {
        this.shopName = shopName;
        this.role = role;
        this.userName = userName;
        initComponents();
        if (role.equals("admin")) {
            administratorButton.setVisible(true);
            logoutButton.setVisible(true);
            backUpButton.setVisible(true);
        } else {
            if (role.equals("user")) {
                backUpButton.setVisible(false);
            }
        }
        userNameLabal.setText(userName);
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

        jPanel1 = new javax.swing.JPanel();
        userNameLabal = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        backUpButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        administratorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        leftPanel = new javax.swing.JPanel();
        tillButton = new javax.swing.JButton();
        purchaseButton = new javax.swing.JButton();
        expenditureButton = new javax.swing.JButton();
        bankButton = new javax.swing.JButton();
        sheet2Button = new javax.swing.JButton();
        pettyButton = new javax.swing.JButton();
        staffTimeButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        summaryButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Account Management");
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 42));

        userNameLabal.setBackground(new java.awt.Color(0, 0, 51));
        userNameLabal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        userNameLabal.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabal.setBorder(null);
        userNameLabal.setBorderPainted(false);
        userNameLabal.setContentAreaFilled(false);
        userNameLabal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userNameLabal.setFocusPainted(false);
        userNameLabal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userNameLabal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseHoverOut(evt);
            }
        });
        userNameLabal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameLabalActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(0, 0, 51));
        logoutButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.setBorder(null);
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.setFocusPainted(false);
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseHoverOut(evt);
            }
        });
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        backUpButton.setBackground(new java.awt.Color(0, 0, 51));
        backUpButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        backUpButton.setForeground(new java.awt.Color(255, 255, 255));
        backUpButton.setText("BackUp");
        backUpButton.setBorder(null);
        backUpButton.setBorderPainted(false);
        backUpButton.setContentAreaFilled(false);
        backUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backUpButton.setFocusPainted(false);
        backUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backUpButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backUpButtonMouseHoverOut(evt);
            }
        });
        backUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userNameLabal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLabal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

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
                administratorButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                administratorButtonMouseHoverOut(evt);
            }
        });
        administratorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administratorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administratorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(225, 900));

        leftPanel.setBackground(new java.awt.Color(0, 0, 102));
        leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        leftPanel.setForeground(new java.awt.Color(255, 255, 255));
        leftPanel.setMaximumSize(new java.awt.Dimension(222, 1001));
        leftPanel.setPreferredSize(new java.awt.Dimension(222, 900));

        tillButton.setBackground(new java.awt.Color(204, 204, 255));
        tillButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tillButton.setForeground(new java.awt.Color(255, 255, 255));
        tillButton.setText("Till");
        tillButton.setBorderPainted(false);
        tillButton.setContentAreaFilled(false);
        tillButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tillButton.setFocusPainted(false);
        tillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tillButtonHover(evt);
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
        sheet2Button.setText("Commision & Service Charge");
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

        reportButton.setBackground(new java.awt.Color(0, 0, 51));
        reportButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reportButton.setForeground(new java.awt.Color(255, 255, 255));
        reportButton.setText("Report");
        reportButton.setBorder(null);
        reportButton.setBorderPainted(false);
        reportButton.setContentAreaFilled(false);
        reportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportButton.setFocusPainted(false);
        reportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportButtonMouseHoverOut(evt);
            }
        });
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        summaryButton.setBackground(new java.awt.Color(0, 0, 51));
        summaryButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        summaryButton.setForeground(new java.awt.Color(255, 255, 255));
        summaryButton.setText("Sales");
        summaryButton.setBorder(null);
        summaryButton.setBorderPainted(false);
        summaryButton.setContentAreaFilled(false);
        summaryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        summaryButton.setFocusPainted(false);
        summaryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                summaryButtonMouseHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                summaryButtonMouseHoverOut(evt);
            }
        });
        summaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expenditureButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(bankButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sheet2Button, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(pettyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffTimeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(summaryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sheet2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expenditureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pettyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffTimeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(leftPanel);

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setMaximumSize(new java.awt.Dimension(3000, 9000));
        rightPanel.setPreferredSize(new java.awt.Dimension(1000, 860));
        rightPanel.setLayout(new java.awt.CardLayout());
        jScrollPane2.setViewportView(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void summaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryButtonActionPerformed
        rightPanel.add("Sales", new Sales(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_summaryButtonActionPerformed

    private void summaryButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summaryButtonMouseHoverOut
        summaryButton.setForeground(Color.white);
    }//GEN-LAST:event_summaryButtonMouseHoverOut

    private void summaryButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summaryButtonMouseHover
        summaryButton.setForeground(Color.red);
    }//GEN-LAST:event_summaryButtonMouseHover

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        rightPanel.add("Report", new Report(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_reportButtonActionPerformed

    private void reportButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseHoverOut
        reportButton.setForeground(Color.white);
    }//GEN-LAST:event_reportButtonMouseHoverOut

    private void reportButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseHover
        reportButton.setForeground(Color.red);
    }//GEN-LAST:event_reportButtonMouseHover

    private void staffTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffTimeButtonActionPerformed
        rightPanel.add("StaffTime", new StaffTime(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_staffTimeButtonActionPerformed

    private void staffTimeButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTimeButtonMouseHoverOut
        staffTimeButton.setForeground(Color.white);
    }//GEN-LAST:event_staffTimeButtonMouseHoverOut

    private void staffTimeButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTimeButtonMouseHover
        staffTimeButton.setForeground(Color.red);
    }//GEN-LAST:event_staffTimeButtonMouseHover

    private void pettyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pettyButtonActionPerformed
        rightPanel.add("Petty", new Petty(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_pettyButtonActionPerformed

    private void pettyButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHoverOut
        pettyButton.setForeground(Color.white);
    }//GEN-LAST:event_pettyButtonMouseHoverOut

    private void pettyButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pettyButtonMouseHover
        pettyButton.setForeground(Color.red);
    }//GEN-LAST:event_pettyButtonMouseHover

    private void sheet2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheet2ButtonActionPerformed
        rightPanel.add("CommissionAndService", new CommissionAndService(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_sheet2ButtonActionPerformed

    private void sheet2ButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHoverOut
        sheet2Button.setForeground(Color.white);
    }//GEN-LAST:event_sheet2ButtonMouseHoverOut

    private void sheet2ButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sheet2ButtonMouseHover
        sheet2Button.setForeground(Color.red);
    }//GEN-LAST:event_sheet2ButtonMouseHover

    private void bankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankButtonActionPerformed
        rightPanel.add("Bank", new Bank(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_bankButtonActionPerformed

    private void bankButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHoverOut
        bankButton.setForeground(Color.white);
    }//GEN-LAST:event_bankButtonMouseHoverOut

    private void bankButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankButtonMouseHover
        bankButton.setForeground(Color.red);
    }//GEN-LAST:event_bankButtonMouseHover

    private void expenditureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenditureButtonActionPerformed
        rightPanel.add("Expenditure", new Expenditure(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_expenditureButtonActionPerformed

    private void expenditureButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHoverOut
        expenditureButton.setForeground(Color.white);
    }//GEN-LAST:event_expenditureButtonMouseHoverOut

    private void expenditureButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenditureButtonMouseHover
        expenditureButton.setForeground(Color.red);
    }//GEN-LAST:event_expenditureButtonMouseHover

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed
        rightPanel.add("Purcharse", new Purcharse(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_purchaseButtonActionPerformed

    private void purchaseButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseButtonMouseHoverOut
        purchaseButton.setForeground(Color.white);
    }//GEN-LAST:event_purchaseButtonMouseHoverOut

    private void purchaseButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseButtonMouseHover
        purchaseButton.setForeground(Color.red);
    }//GEN-LAST:event_purchaseButtonMouseHover

    private void tillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillButtonActionPerformed
        rightPanel.add("Till", new Till(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_tillButtonActionPerformed

    private void tillButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillButtonMouseHoverOut
        tillButton.setForeground(Color.white);
    }//GEN-LAST:event_tillButtonMouseHoverOut

    private void tillButtonHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillButtonHover
        tillButton.setForeground(Color.red);
    }//GEN-LAST:event_tillButtonHover

    private void userNameLabalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameLabalActionPerformed

    }//GEN-LAST:event_userNameLabalActionPerformed

    private void MouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseHoverOut

    }//GEN-LAST:event_MouseHoverOut

    private void MouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseHover

    }//GEN-LAST:event_MouseHover

    private void administratorButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administratorButtonMouseHover
        administratorButton.setForeground(Color.red);
    }//GEN-LAST:event_administratorButtonMouseHover

    private void administratorButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administratorButtonMouseHoverOut
        administratorButton.setForeground(Color.white);
    }//GEN-LAST:event_administratorButtonMouseHoverOut

    private void administratorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorButtonActionPerformed
        rightPanel.add("Administrator", new Administrator(shopName));
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_administratorButtonActionPerformed

    private void logoutButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseHover
        logoutButton.setForeground(Color.red);
    }//GEN-LAST:event_logoutButtonMouseHover

    private void logoutButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseHoverOut
        logoutButton.setForeground(Color.white);
    }//GEN-LAST:event_logoutButtonMouseHoverOut

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try {
            db.logout();
            setVisible(false);
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void backUpButtonMouseHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backUpButtonMouseHover
        // TODO add your handling code here:
    }//GEN-LAST:event_backUpButtonMouseHover

    private void backUpButtonMouseHoverOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backUpButtonMouseHoverOut
        // TODO add your handling code here:
    }//GEN-LAST:event_backUpButtonMouseHoverOut

    private void backUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backUpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backUpButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administratorButton;
    private javax.swing.JButton backUpButton;
    private javax.swing.JButton bankButton;
    private javax.swing.JButton expenditureButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton pettyButton;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton sheet2Button;
    private javax.swing.JButton staffTimeButton;
    private javax.swing.JButton summaryButton;
    private javax.swing.JButton tillButton;
    private javax.swing.JButton userNameLabal;
    // End of variables declaration//GEN-END:variables
}
