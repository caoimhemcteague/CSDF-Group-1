package CinemaClasses;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class jdbcTester {
	
	public static void main(String[] args) throws Exception{
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema", "root", "password");
		
		PreparedStatement statement = con.prepareStatement("select * from Film");
		
		ResultSet result = statement.executeQuery();
		
		while(result.next())
		{
			System.out.println(result.getString(1) + " " + result.getString(2));
		}
		
	//tonight	JDBCcinema database= new JDBCcinema();
		
	//tonight	database.createDatabase();
	//tonight	Statement stmt = null;
		
	/*tonight	
		
		   //try 
		      //{
		         //String password = "";
		         String query ="SELECT Name FROM Film"; //WHERE emailaddress =  '"+eMail+" '";
		         try {
					ResultSet rs = stmt.executeQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		     //    if (rs.next())
		       //  {
		         //   password = rs.getString("password");
		         //}
		         //closeConnection();
		         
		         //return password;
		         
		      //}
		      //catch (SQLException e)
		      //{
		        // return "Email address error";
		      
		      //}
		   
		   
		
		
		//database.insertIntoDatabase(sql);
		
		*/
		
	}

}
