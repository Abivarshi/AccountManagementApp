/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report;

import java.awt.CardLayout;
import javax.swing.JLabel;


/**
 *
 * @author acer
 */
public class Loading extends javax.swing.JPanel {


    /**
     * Creates new form Till
     *
     */
    public Loading() {
        initComponents();
        JLabel jLabel4 = loader();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        warningLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warningLabel1.setForeground(new java.awt.Color(153, 0, 0));
        add(warningLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 400, 10));

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(960, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(getSize());
        jPanel1.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jLabel1.setText("Loading...");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private JLabel loader() {
        JLabel jLabel4 = new JLabel();
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accountmanagement/image/loading.gif"))); // NOI18N

        jLabel4.setVisible(false);
        jLabel4.setBounds(100, 100, 20, 20);
        jPanel1.add(jLabel4);
        CardLayout layout = (CardLayout) jPanel1.getLayout();
        layout.next(jPanel1);
        return jLabel4;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warningLabel1;
    // End of variables declaration//GEN-END:variables
}
