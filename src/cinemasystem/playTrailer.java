package cinemasystem;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class playTrailer {
	
	static String link ="";
	static String filmName="";
	private final static String USER_NAME = "root";
	private final static String PASSWORD = "password";
    static Connection conn;
    static Statement st;
    static ResultSet rs;
	
	public playTrailer(String filmName) {
		this.filmName = filmName; 
	}
	
	public static void startTrailer() {

		NativeInterface.open();
		

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				try {

				JFrame frame = new JFrame("Youtube");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(getBrowser(), BorderLayout.CENTER);
				frame.setSize(400, 300);
				 
				frame.setVisible(true);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}	
        	
        });
		
		

        NativeInterface.runEventPump();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        	@Override
        	public void run() {

        		NativeInterface.close();

        		
        	}
        }));
    	
	
		}
	


	public static void main(String []args) {
		
    	
		startTrailer();
	
		}
	
	private static String getLink() {
		
		 try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false", USER_NAME, PASSWORD);
				st = conn.createStatement();
				String s = "Select trailer from film where Name = '" + filmName + "'";
				rs = st.executeQuery(s);
				while(rs.next()) {
					link=rs.getString(1);
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
		return "";
	}
	
    public static JPanel getBrowser() {
  	JPanel wbPanel = new JPanel(new BorderLayout());
  	JWebBrowser wb = new JWebBrowser();
  	wbPanel.add(wb, BorderLayout.CENTER);
  	wb.setBarsVisible(false);
  	getLink();
  	wb.navigate(link);
  	
  	return wbPanel;
  }
   
}

