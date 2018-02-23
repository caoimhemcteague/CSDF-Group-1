package CinemaClasses;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class jdbcTester {
	
	public static void main(String[] args) throws Exception{
		
		//reading from database
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema", "root", "password");
		
		PreparedStatement statement = con.prepareStatement("select * from Film");
		
		ResultSet result = statement.executeQuery();
		
		while(result.next())
		{
			System.out.println(result.getString(1) + ", " + result.getString(2) + ", " + result.getString(3) + ", " + result.getString(4));
		}
		
		
		//inserting into database
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Statement myStmt = con.createStatement(); 
		
		String sql = "insert into film "
				   + "(Name, PG_Rating, Genre, Duration)"
				   + "values ('Good Film', 'U', 'Drama', '145')";
		
		myStmt.executeUpdate(sql);
		
		System.out.println("Insert complete");
		
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
