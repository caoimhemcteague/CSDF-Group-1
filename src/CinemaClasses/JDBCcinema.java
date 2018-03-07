package CinemaClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class JDBCcinema implements JDBCDB{

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
	private int length = 0;
	
	
	private Connection conn;
	private Statement stmt;
	
	public JDBCcinema() {
		
	}

	public void createConnection(){
		try {
			//1
			Class.forName(JDBC_DRIVER);
			System.out.println("Step 1 Complete - Driver Registered ...");
			
			//2
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", USER_NAME, PASSWORD);
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
	   
	   
	   public void insertIntoDatabase(String sqlString)
	   {
		   createConnection();
	      try
	      {
	    	 java.sql.Statement myStmt = conn.createStatement();
	         myStmt.executeUpdate(sqlString);
	         System.out.println("Its a miracle!..insertdIntoDatabase !");
	      }
	      
	      catch (SQLException e)
	      {
	         System.out.println("Could not close connection.\n" + e.getMessage());
	      }
	      
	   }
	   
	   public void getInfoFromDB(String tableName)
	   {
		   if(tableName.equals("theatre") || tableName.equals("type"))
			   length = 2;
		   else
			   length = 4;
		   try {
		   createConnection();
		   
		  
		   PreparedStatement statement = conn.prepareStatement("select * from " + tableName);
		   
		   System.out.println("");
			
		   ResultSet result = statement.executeQuery();
		   String data = null;
		 
			while(result.next())
			{	
				if(length ==1) {
					 data = result.getString(1);
						System.out.println(data);
				}
				else if(length ==2) {
					 data = result.getString(1) + ", " + result.getString(2);
						System.out.println(data);
				}
				else if(length ==3) {
					 data = result.getString(1) + ", " + result.getString(2) + ", " + result.getString(3); 
					 	System.out.println(data);
				}
					 else {
					data = result.getString(1) + ", " + result.getString(2) + ", " + result.getString(3) + ", " + result.getInt(4);
					System.out.println(data);
					 }
				
			}
		   }
			catch(SQLException e) {
				System.out.println("Failed.\n" + e.getMessage());
		         String fail = "Failed to get info";
		         System.out.println(fail);

			}
		   System.out.println("length ====" + length);
	   }

	   
	   /*public String getUserPasswordFromDatabase(String eMail)
	   {
	      try 
	      {
	         String password = "";
	         String query ="SELECT password FROM user WHERE emailaddress =  '"+eMail+" '";
	         ResultSet rs = stmt.executeQuery(query);
	         
	         if (rs.next())
	         {
	            password = rs.getString("password");
	         }
	         closeConnection();
	         
	         return password;
	         
	      }
	      catch (SQLException e)
	      {
	         return "Email address error";
	      
	      }
	   
	   }*/

}
