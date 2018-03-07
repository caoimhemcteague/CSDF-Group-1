package CinemaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Theatre extends JDBCcinema{
	
	public int theatreNum=0;
	public int capacity;
	
	public Theatre(int capacity)
	{
		this.capacity=capacity;
		theatreNum++;
	}
	
	public int getTheatreNum()
	{
		 try{ 
	          createConnection();
	          PreparedStatement statement = conn.prepareStatement("SELECT MAX(Theatre_Num) FROM theatre");
			  ResultSet rs = statement.executeQuery();
	          
			  while(rs.next())
			  {  
				  theatreNum = rs.getInt("MAX(Theatre_Num)");
			  }
			  theatreNum++;
	          closeConnection();
	      //    System.out.println(bookingNum);
	          
	          return theatreNum;
	          
	          }
	  			catch (Exception e){
	 			System.out.println("Failed to return booking Number.\n" + e.getMessage());
	       
	         return theatreNum;
	 			}
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public void addTheatreToDB()
	{
		getTheatreNum();
		String theatre = "INSERT INTO theatre VALUES ('" + theatreNum +"', " +
					  "'" + capacity + "') " +
					  "ON DUPLICATE KEY UPDATE Theatre_Num='" + theatreNum + "', " +
					  "Capacity=' " + capacity +"'";
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(theatre);
	}
	public void getTheatreDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("theatre");
	
	}
}
