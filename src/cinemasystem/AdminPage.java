/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.proteanit.sql.DbUtils;

/**
 *
 * @author christophermclaughlin
 */
public class AdminPage extends javax.swing.JFrame {
	
	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
    Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form AdminPage
     */
    public AdminPage() {
        initComponents();
        fetch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        removeJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addFilmJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        closeJButton = new javax.swing.JButton();
        editFilmJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        removeJButton.setText("Remove");
        removeJButton.setBackground(Color.CYAN);
        removeJButton.setFont(new Font("sansserif", Font.BOLD, 16));
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	removeJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Administrator");
        jLabel1.setFont(new Font("sansserif", Font.BOLD, 24));
        jLabel1.setForeground(Color.PINK);

        jLabel2.setText("Please select a film to remove ");
        jLabel2.setFont(new Font("sansserif", Font.BOLD, 18));
        jLabel2.setForeground(Color.YELLOW);

        addFilmJButton.setText("Add New Film");
        addFilmJButton.setBackground(Color.CYAN);
        addFilmJButton.setFont(new Font("sansserif", Font.BOLD, 16));
        

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        
        jScrollPane1.setViewportView(table);

        closeJButton.setText("Close");
        closeJButton.setBackground(Color.RED);
        closeJButton.setFont(new Font("sansserif", Font.BOLD, 16));
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        editFilmJButton.setText("Edit Film");
        editFilmJButton.setBackground(Color.CYAN);
        editFilmJButton.setFont(new Font("sansserif", Font.BOLD, 16));
        
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] {"Select Film"}));

        try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false", USER_NAME, PASSWORD);
			st = conn.createStatement();
			String s = "Select Name from film";
			rs = st.executeQuery(s);
			while(rs.next()) {
				jComboBox1.addItem(rs.getString(1));
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
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.GRAY);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addFilmJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editFilmJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeJButton)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFilmJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editFilmJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeJButton)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fetch() {
      	 
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
 			st = conn.createStatement();
 			String s = "Select Name, PG_Rating, Genre, Duration from film;";
 			rs = st.executeQuery(s);
 			
 			table.setModel(DbUtils.resultSetToTableModel(rs));
 			//while(rs.next()) {
 			//	dateBox.addItem(rs.getString(1));
 			//}
 		}
 		catch (Exception a) {
 		JOptionPane.showMessageDialog(null,  "Error");
 		}finally {
 			try {
 				st.close();
 				rs.close();
 				conn.close();
 				
 			}catch(Exception a) {
 	    		JOptionPane.showMessageDialog(null,  "Error Close");

 			}
 		}
    	
    	jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] {"Select Film"}));

        try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false", USER_NAME, PASSWORD);
			st = conn.createStatement();
			String s = "Select Name from film";
			rs = st.executeQuery(s);
			while(rs.next()) {
				jComboBox1.addItem(rs.getString(1));
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
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         JComponent comp = (JComponent) evt.getSource();
         Window win = SwingUtilities.getWindowAncestor(comp);
         win.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	String filmName = jComboBox1.getSelectedItem().toString();
    	
    	try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
			st = conn.createStatement();
			String s = "Delete from film where Name = '" + filmName+ "'";
			st.executeUpdate(s);
			fetch();
			
		}
		catch (Exception a) {
			System.out.println("\n" + a);
			JOptionPane.showMessageDialog(null,  "Error here");
			System.out.println("\n" + a);
		}finally {
			try {
				st.close();
				rs.close();
				conn.close();
				
			}catch(Exception a) {
	    		JOptionPane.showMessageDialog(null,  "Error Close");

			}
		}
    }
    
    

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton addFilmJButton;
    private javax.swing.JButton closeJButton;
    private javax.swing.JButton editFilmJButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
