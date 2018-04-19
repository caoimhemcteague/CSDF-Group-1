package CinemaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Screening extends JDBCcinema{
	
	//private static int counter=0;
	public int screeningNum=0; 
	int theatreNum =0; 
	String film = "";
	String date = "";
	String time = "";
	//public Date date; 
	//public time;
	
	public Screening(int theatreNum, String film, String date, String time) {
		//this.screeningNum=screeningNum++;
		this.theatreNum = theatreNum;
		this.film=film;
		this.date=date;
		this.time=time;
	}
	
	public Screening() {
		this.screeningNum=screeningNum++;
	}
	
	public int getScreeningNum()
	{
		return screeningNum;
	}
	
	
		public void addBookingToDB()
		{
		
			String booking = "INSERT INTO screening VALUES ('" + screeningNum +"', " +
						  "'" + theatreNum + "' ," +
						  "'" + date + "' ," +
						  "'" + time + "' ," +
						  "'" + film + "') "; 
			JDBCcinema database = new JDBCcinema();
			database.insertIntoDatabase(booking);
			Ticket ticket = new Ticket();
			
			
			
			
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
