package CinemaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Screening extends JDBCcinema{
	
	//private static int counter=0;
	public int screeningNum=0; 
	private Theatre theatre; 
	public Film film;
	private int ticketsBooked;
	//public Date date; 
	//public time;
	
	public Screening(Theatre theatre, Film film) {
		this.film=film;
		this.screeningNum=screeningNum++;
		this.theatre = theatre;
		ticketsBooked=0;
	}
	
	public Screening() {
		this.screeningNum=screeningNum++;
	}
	
	public int getScreeningNum()
	{
		return screeningNum;
	}
	
	public int getTicketsBooked()
	{
		return ticketsBooked;
	}
	
	public void getFilmScreening(String filmName) {
		
		
		   try {
		   createConnection();
		   
		  
		   PreparedStatement statement = conn.prepareStatement("Select FilmName , Date, Time from screening where FilmName = '" + filmName + " ' ");
		   
		   System.out.println("");
			
		   ResultSet result = statement.executeQuery();
		   String data = null;
		 
			while(result.next())
			{	
				
					 data = result.getString(1) + ", " + result.getString(2) + ", " + result.getString(3); 
					 System.out.println(data);
			
			}
		   }
			catch(SQLException e) {
				System.out.println("Failed to print screening.\n" + e.getMessage());
		         String fail = "Failed to get info";
		         System.out.println(fail);

			}
	}
	
	/*public int returnTheatreNum()
	{
		return theatre.returnTheatreNum();
	}*/
	
	public int returnScreeningNum(String filmName, String filmTime, String filmDate)
	{
		int num = 0;
		
		 try {
			   createConnection();
			   
			  
			   PreparedStatement statement = conn.prepareStatement("Select Screening_Num from screening where FilmName = '" + filmName
					   												+ "' AND Time = " + filmTime + " AND Date = '" + filmDate + "'");
			   
			   System.out.println("");
				
			   ResultSet result = statement.executeQuery();
			 
				while(result.next())
				{	
					
					num = result.getInt("Screening_Num");
				
				}
			   }
				catch(SQLException e) {
					System.out.println("Failed to print screening.\n" + e.getMessage());
			         String fail = "Failed to get info";
			         System.out.println(fail);

				}
		 return num;
	}
	
	

}
