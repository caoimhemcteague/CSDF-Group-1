package CinemaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Booking extends JDBCcinema{
	
	public int bookingNum=0; 
	public int numOfTickets; 
	public int screeningNum;
	public double cost;
	
	
	
	
	public Booking(int numOfTickets, int screeningNum)
	{
		this.numOfTickets=numOfTickets;
		this.screeningNum=screeningNum;
		bookingNum++;
	}
	
	public int getBookingNumber()
	{
 			 try{ 
          createConnection();
          PreparedStatement statement = conn.prepareStatement("SELECT MAX(Booking_Number) FROM booking");
		  ResultSet rs = statement.executeQuery();
          
		  while(rs.next())
		  {  
			  bookingNum = rs.getInt("MAX(Booking_Number)");
		  }
			  bookingNum++;
          closeConnection();
      //    System.out.println(bookingNum);
          
          return bookingNum;
          
          }
  			catch (Exception e){
 			System.out.println("Failed to return booking Number.\n" + e.getMessage());
       
         return bookingNum;
 			}

		   
		 
	}
	
	public int getNumberOfTickets()
	{
		return numOfTickets;
	}
	public int getScreeningNum()
	{
		return screeningNum;
	}
		
	public double getCost()
	{
		cost = numOfTickets * 4.50;
		return cost;
	}
	
	public void addBookingToDB()
	{
		getBookingNumber();
		String booking = "INSERT INTO booking VALUES ('" + bookingNum +"', " +
					  "'" + numOfTickets + "' ," +
					  "'" + screeningNum + "' ," +
					  "'" + getCost() + "') "; 
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(booking);
	}
	public void getBookingDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("booking");
	}

}
