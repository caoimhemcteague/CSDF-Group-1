/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

/**
 *
 * @author christophermclaughlin
 */
public class ViewTrailers extends javax.swing.JFrame {

	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
    Connection conn;
    Statement st;
    ResultSet rs;
    
    /**
     * Creates new form ViewTrailers
     */
    public ViewTrailers() {
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
        closeButton = new javax.swing.JButton();
        filmName = new javax.swing.JComboBox<>();
        Border line2 = BorderFactory.createLineBorder(Color.black, 3);
        jLabel1.setBorder(line2);



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Film Trailers");
        jLabel1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 50));
        jLabel1.setForeground(Color.cyan);
        

        closeButton.setText("Close");
        closeButton.setBackground(Color.RED);
        closeButton.setFont(new Font("sansserif", Font.BOLD, 16));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        
        
        filmName.setModel(new DefaultComboBoxModel<>(new String[] {"Select Film"}));
        filmName.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        
        filmName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		filmNameActionPerformed(e);
        
        	}
        });
        

        try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false", USER_NAME, PASSWORD);
			st = conn.createStatement();
			String s = "Select Name from film";
			rs = st.executeQuery(s);
			while(rs.next()) {
				filmName.addItem(rs.getString(1));
			}
		}
		catch (Exception b) {
		JOptionPane.showMessageDialog(null,  "Error");
		}finally {
			try {
				st.close();
				rs.close();
				conn.close();
				
			}catch(Exception b) {
	    		JOptionPane.showMessageDialog(null,  "Error Close");

			}
		}

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(163, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(closeButton)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(filmName, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(159, 159, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(filmName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        			.addComponent(closeButton))
        );
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.WHITE);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void filmNameActionPerformed(ActionEvent e) {
    
    String value=(String)filmName.getSelectedItem();

   	 if(value.equals("Select Film")) {
   		 //Do Nothing
   	 }
   	 else {
   		JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
   		 
     playTrailer trailer = new playTrailer(value);	
	 
     
     Thread t = new Thread(new Runnable() {
    	 public void run() {
    		  trailer.startTrailer();
    		  
    		  
    	 }
     });
     t.start();
      
	 
   	 }
    }


    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JComponent comp = (JComponent) evt.getSource();
         Window win = SwingUtilities.getWindowAncestor(comp);
         win.dispose();
                        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewTrailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTrailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTrailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTrailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	ViewTrailers frame = new ViewTrailers();
                
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                
                frame.setVisible(true);      
            	
            	
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> filmName;
    // End of variables declaration//GEN-END:variables
}
