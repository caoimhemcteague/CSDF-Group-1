/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.JTableHeader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import net.proteanit.sql.DbUtils;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

/**
 *
 * @author christophermclaughlin
 */
public class ViewSchedule extends javax.swing.JFrame {

	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
    Connection conn;
    Statement st;
    ResultSet rs;
    int count = 0;
    String minDate = "";
    String maxDate = "";
    String dateForChecking = "";
        
        
        
    

    /**
     * Creates new form ViewSchedule
     */
    public ViewSchedule() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        previousBT = new javax.swing.JButton();
        followingBT = new javax.swing.JButton();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Border line2 = BorderFactory.createLineBorder(Color.black, 3);

        jLabel1.setText("Film Schedule");
        jLabel1.setBorder(line2);
        jLabel1.setFont(new Font("Lucida Grande", Font.BOLD, 39));
        jLabel1.setForeground(new Color(51, 204, 204));

        closeButton.setText("close");
        closeButton.setBackground(new Color(204, 51, 51));
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        
        
        Border line = BorderFactory.createLineBorder(Color.black, 1);
        table.setBorder(line);
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.setRowHeight(30);
        table.setRowMargin(5);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.black);
        header.setForeground(Color.black);
        header.setFont(new Font("Arial", Font.BOLD, 20));
          
        
        jScrollPane1.setViewportView(table);
        jScrollPane1.setBorder(line2);
        
        previousBT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PerviousBTActionPerformed(e);
        	}
        });
        previousBT.setText("Pervious Day");
        previousBT.setFont(new Font("SansSerif", Font.BOLD, 24));
        previousBT.setBackground(new Color(102, 204, 0));
        
        followingBT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		followingBTActionPerformed(e);
        	}
        });
        
        followingBT.setText("Following Day");
        followingBT.setFont(new Font("SansSerif", Font.BOLD, 24));
        followingBT.setBackground(new Color(102, 204, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(546)
        			.addComponent(jLabel1)
        			.addContainerGap(35, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(92)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(previousBT)
        					.addGap(27)
        					.addComponent(followingBT)
        					.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
        					.addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        					.addGap(27))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        					.addGap(67))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(39)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        				.addComponent(previousBT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        				.addComponent(followingBT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        			.addGap(19))
        );
        getContentPane().setLayout(layout);
        getContentPane().setBackground(new Color(153, 0, 0));
        

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void fetch() {
   	 
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
 			st = conn.createStatement();
 			String s = "Select MIN(Date) AS Date, FilmName, Time from screening Group by Time ORDER BY FilmName, Time;";
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
    }
    
    private void fetch(String query) {
    	
    	table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
      	 
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
 			st = conn.createStatement();
 			String s = query;
 			rs = st.executeQuery(s);
 			
 			table.setModel(DbUtils.resultSetToTableModel(rs));
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
    }
    	

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        // ViewSchedule().setVisible(false);
        JComponent comp = (JComponent) evt.getSource();
         Window win = SwingUtilities.getWindowAncestor(comp);
         win.dispose();
           
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    	JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void PerviousBTActionPerformed(ActionEvent e) {
    	getMinDate();
    	getMaxDate();
    	count--;
    	getDateForChecking();
    	if(checkDate(dateForChecking, maxDate, minDate) == true) {
    	String query = "Select date_add(\"" + minDate + "\", INTERVAL "+ count +" DAY) AS Date, FilmName, Time from screening Group by Time ORDER BY FilmName, Time";
    	fetch(query);
    	}
    	else
    		count++;
    }

    
    public void followingBTActionPerformed(ActionEvent e) {
    	getMinDate();
    	getMaxDate();
    	count++;
    	getDateForChecking();
    	if(checkDate(dateForChecking, maxDate, minDate) == true) {
    	String query = "Select date_add(\"" + minDate + "\", INTERVAL "+ count +" DAY) AS Date, FilmName, Time from screening Group by Time ORDER BY FilmName, Time";
    	fetch(query);
    	}
    	else
    		count--;
    }
    
    public String getDateForChecking() {
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
 			st = conn.createStatement();
 			String s = "Select date_add(\""+minDate+"\", INTERVAL "+count+" DAY);";
 			rs = st.executeQuery(s);
 			
 			while(rs.next()) {
 				dateForChecking = rs.getString(1);
 			}
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
    	
    	return dateForChecking;
    }
    
    
    public String getMinDate()
    {
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
 			st = conn.createStatement();
 			String s = "Select MIN(Date) from screening;";
 			rs = st.executeQuery(s);
 			
 			while(rs.next()) {
 				minDate = rs.getString(1);
 			}
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
    	
    	return minDate;
    }
    
    public String getMaxDate(){
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
 			st = conn.createStatement();
 			String s = "Select MAX(Date) from screening;";
 			rs = st.executeQuery(s);
 			
 			while(rs.next()) {
 				maxDate = rs.getString(1);
 			}
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
    	
    	return maxDate;
    }
    
    public Boolean checkDate(String date, String date2, String date3) {
    	String dayString = "00", monthString = "00", yearString = "00";
    	char dayChar1 = '0', dayChar2 = '0', monthChar1 = '0', monthChar2 = '0', yearChar1 = '0', yearChar2 = '0';
    	int day = 00, month = 00, year = 00;
    	String day2String = "00", month2String = "00", year2String = "00";
    	char day2Char1 = '0', day2Char2 = '0', month2Char1 = '0', month2Char2 = '0', year2Char1 = '0', year2Char2 = '0';
    	int day2 = 00, month2 = 00, year2 = 00;
    	
    	String day3String = "00", month3String = "00", year3String = "00";
    	char day3Char1 = '0', day3Char2 = '0', month3Char1 = '0', month3Char2 = '0', year3Char1 = '0', year3Char2 = '0';
    	int day3 = 00, month3 = 00, year3 = 00;
    	
    	try {
    		dayChar1 = date.charAt(8);
			dayChar2 = date.charAt(9);
			monthChar1 = date.charAt(5);
			monthChar2 = date.charAt(6);
			yearChar1 = date.charAt(2);
			yearChar2 = date.charAt(3);
			dayString = ""+dayChar1+""+dayChar2;
		   	monthString = ""+monthChar1+""+monthChar2;
			yearString = ""+yearChar1+""+yearChar2;
			day=	Integer.parseInt(dayString);
		    month = Integer.parseInt(monthString);
			year = Integer.parseInt(yearString);
			
			day2Char1 = date2.charAt(8);
			day2Char2 = date2.charAt(9);
			month2Char1 = date2.charAt(5);
			month2Char2 = date2.charAt(6);
			year2Char1 = date2.charAt(2);
			year2Char2 = date2.charAt(3);
			day2String = ""+day2Char1+""+day2Char2;
		   	month2String = ""+month2Char1+""+month2Char2;
			year2String = ""+year2Char1+""+year2Char2;
			day2=	Integer.parseInt(day2String);
		    month2 = Integer.parseInt(month2String);
			year2 = Integer.parseInt(year2String);
			
			day3Char1 = date3.charAt(8);
			day3Char2 = date3.charAt(9);
			month3Char1 = date3.charAt(5);
			month3Char2 = date3.charAt(6);
			year3Char1 = date3.charAt(2);
			year3Char2 = date3.charAt(3);
			day3String = ""+day3Char1+""+day3Char2;
		   	month3String = ""+month3Char1+""+month3Char2;
			year3String = ""+year3Char1+""+year3Char2;
			day3=	Integer.parseInt(day3String);
		    month3 = Integer.parseInt(month3String);
			year3 = Integer.parseInt(year3String);
    	}
    	catch(Exception e) {
	    		JOptionPane.showMessageDialog(null,  "Error With Input");

    	}
    	//Is the date smaller than the max date in the DB?
    	if(day <= day2 && month <= month2 && year <=year2) {
    		//IS the date larger than the max date in the DB?
    		if(day >= day3 && month >= month2 && year >= year2) {
    			return true;
    		}
    		else
    			return false;
    	}
    	else {
    	return false;
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
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            		ViewSchedule frame = new ViewSchedule();
                
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.fetch();
                
                frame.setVisible(true);   
            	
            	
                      }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private JButton followingBT;
    private JButton previousBT;
}
