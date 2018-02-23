package CinemaClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCcinema {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String USER_NAME = "root";
	private final String PASSWORD = "password";
	
	
	private Connection conn;
	private Statement stmt;
	
	
	public void createConnection() {

		try {
			//1
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema", USER_NAME, PASSWORD);
		}
		catch (ClassNotFoundException e) {
		System.out.println("Error - catch " + e.getMessage() );	
		}
		catch (SQLException e) {
			System.out.println("Error - catch " + e.getMessage() );	
		}
	}
	
	// createDatabase() - Calls createConnection(), creates a database called facebook with a table called user
/*	   public void createDatabase(){
	      try{
	         // createConnection() to localhost
	         createConnection("jdbc:mysql://localhost/");
	      
	         // Create Statement object        
	         stmt = conn.createStatement();
	         System.out.println("COMPLETE - Statement object created...");
	          
	      
	         stmt.executeUpdate("USE Cinema");
	         //stmt.executeUpdate(createTable);
	         System.out.println("COMPLETE - Update executed and user table added to facebook database...");
	         
	         // closeConnection()
	         //closeConnection();
	      }
	      catch (SQLException e){
	         System.out.println("Problem with SQL.\n" + e.getMessage());
	      }
	   }*/

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
	      try
	      {
	         stmt.executeUpdate(sqlString);
	         System.out.print("Its a miracle!..insertdIntoDatabase !");
	      }
	      
	      catch (SQLException e)
	      {
	         System.out.println("Could not close connection.\n" + e.getMessage());
	      }
	      
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
