/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author christophermclaughlin
 */
public class AdminLogIn extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogIn
     */
    public AdminLogIn() {
    	getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 39));
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

        jLabel1 = new javax.swing.JLabel();
        TextUserName = new javax.swing.JTextField();
        TextUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
        TextPassword = new javax.swing.JPasswordField();
        TextPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
        closeJButton = new javax.swing.JButton();
        loginJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jLabel1.setText("Admin Log In");
        jLabel1.setFont(new Font("SansSerif", Font.BOLD, 32));
        jLabel1.setForeground(Color.PINK);
        
        jLabel2.setText("Username:");
        jLabel2.setFont(new Font("SansSerif", Font.BOLD, 39));
        jLabel2.setForeground(Color.PINK);
        
        jLabel3.setText("Password:");
        jLabel3.setFont(new Font("SansSerif", Font.BOLD, 39));
        jLabel3.setForeground(Color.PINK);

        TextUserName.setText("");
        TextUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextUserNameActionPerformed(evt);
            }
        });

        TextPassword.setText("");

        closeJButton.setText("Close");
        closeJButton.setBackground(Color.RED);
        closeJButton.setFont(new Font("SansSerif", Font.BOLD, 36));
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        loginJButton.setText("Log In");
        loginJButton.setBackground(Color.GREEN);
        loginJButton.setFont(new Font("SansSerif", Font.BOLD, 36));
        loginJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(966, Short.MAX_VALUE)
        			.addComponent(closeJButton)
        			.addGap(29))
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(loginJButton))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(40)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel2)
        						.addComponent(jLabel3))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(TextUserName, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        						.addComponent(TextPassword, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))))
        			.addGap(210))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(499)
        			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        			.addGap(500))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(18)
        			.addComponent(jLabel1)
        			.addGap(31)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(TextUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(86)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(TextPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addGap(28)
        			.addComponent(loginJButton)
        			.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
        			.addComponent(closeJButton)
        			.addGap(36))
        );
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.GRAY);
        

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JComponent comp = (JComponent) evt.getSource();
         Window win = SwingUtilities.getWindowAncestor(comp);
         win.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextUserNameActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      String usertxter = "user";
      String passtxter = "pass";
      String punamer = TextUserName.getText();
      String ppaswder = TextPassword.getText();
        
        if(punamer.equals(usertxter) && ppaswder.equals(passtxter))
       { 
       AdminPage page = new AdminPage();
        page.setVisible(true);
       }

    }//GEN-LAST:event_jButton2MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	AdminLogIn frame = new AdminLogIn();
                
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                
                frame.setVisible(true);    
            	
            	
            	
            	
           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JTextField TextUserName;
    private javax.swing.JButton closeJButton;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
