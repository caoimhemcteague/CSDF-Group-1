package CinemaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Type extends JDBCcinema{
	
	private String name = "";
	private double price = 0.0;
	
	public Type(String name) {
		
		
		this.name=name;
		
		if(this.name.equals("Adult")) {
			try{ 
		          createConnection();
		          PreparedStatement statement = conn.prepareStatement("SELECT Cost FROM type WHERE NAME = 'Adult'");
				  ResultSet rs = statement.executeQuery();
		          
				  while(rs.next())
				  {  
					  price = price + rs.getDouble("Cost");
					  System.out.println(price);
					  
				  }
				  
		          closeConnection();
		          }
		  			catch (Exception e){
		 			System.out.println("Failed to assign cost with adult.\n" + e.getMessage());
		 			}
			 
		}
		if(this.name.equals("Student")) {
			try{ 
		          createConnection();
		          PreparedStatement statement = conn.prepareStatement("SELECT Cost FROM type WHERE NAME = 'Student'");
				  ResultSet rs = statement.executeQuery();
		          
				  while(rs.next())
				  {  
					  price = price + rs.getDouble("Cost");
					  System.out.println(price);
					  
				  }
				  
		          closeConnection();
		          }
		  			catch (Exception e){
		 			System.out.println("Failed to assign cost with adult.\n" + e.getMessage());
		 			}	
		}
		if(this.name.equals("Child")) {
			try{ 
		          createConnection();
		          PreparedStatement statement = conn.prepareStatement("SELECT Cost FROM type WHERE NAME = 'Child'");
				  ResultSet rs = statement.executeQuery();
		          
				  while(rs.next())
				  {  
					  price = price + rs.getDouble("Cost");
					  System.out.println(price);
					  
				  }
				  
		          closeConnection();
		          }
		  			catch (Exception e){
		 			System.out.println("Failed to assign cost with Child.\n" + e.getMessage());
		 			}	
		}		}
			
	}
	


