/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String USER_NAME = "root";
	private final static String PASSWORD = "password";
	
	
	private static Connection conn;
	private Statement stmt;
	
	public Connector() {
		
	}

	public static void createConnection(){
		try {
			//1
			Class.forName(JDBC_DRIVER);
			System.out.println("Step 1 Complete - Driver Registered ...");
			
			//2
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Cinema", USER_NAME, PASSWORD);
			System.out.print("Step 2 Complete - Connection obtained");
		}
		catch (ClassNotFoundException e) {
		System.out.println("Could not load driver. \n " + e.getMessage() );	
		}
		catch (SQLException e) {
			System.out.println("Problem with SQL. \n " + e.getMessage() );	
		}
	}

	   // closeConnection() - Closes the connection
	   public void closeConnection(){   
	      try{
	         if(conn != null){
	            conn.close();
	            System.out.println("COMPLETE - Connection closed.");           
	         }
	      }
	      catch (SQLException e){
	         System.out.println("Could not close connection.\n" + e.getMessage());
	      }
	   }
}