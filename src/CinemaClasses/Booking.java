package CinemaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Booking extends JDBCcinema{
	
	public int bookingNum=0; 
	public int numOfAdults = 0;
	public int numOfChildren = 0;
	public int numOfStudents_OAP = 0;
	public int numOfTickets = numOfAdults + numOfChildren + numOfStudents_OAP;
	public int screeningNum;
	public double cost;
	
	
	
	
	public Booking(int numOfAdults, int numOfChildren, int numOfStudents_OAP, int screeningNum)
	{
		this.numOfAdults=numOfAdults;
		this.numOfChildren=numOfChildren;
		this.numOfStudents_OAP=numOfStudents_OAP;
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
	
	public int returnBookingNum() {
		return bookingNum;
	}
	
	public int getNumberOfTickets()
	{
		numOfTickets = numOfAdults + numOfChildren + numOfStudents_OAP;
		return numOfTickets;
	}
	public int getScreeningNum()
	{
		return screeningNum;
	}
		
	public double getCost()
	{
		cost = 0;
		 try{ 
	          createConnection();
	          PreparedStatement statement = conn.prepareStatement("SELECT Cost FROM type WHERE NAME = 'Adult'");
			  ResultSet rs = statement.executeQuery();
	          
			  while(rs.next())
			  {  
				  cost = cost + (rs.getDouble("Cost") * numOfAdults);
				  System.out.println(cost);
				  
			  }
			  
	          closeConnection();
	          }
	  			catch (Exception e){
	 			System.out.println("Failed to assign cost with noOfAdults.\n" + e.getMessage());
	 			}
		 
		 try{ 
	          createConnection();
	          PreparedStatement statement = conn.prepareStatement("SELECT Cost FROM type WHERE NAME = 'Child'");
			  ResultSet rs = statement.executeQuery();
	          
			  while(rs.next())
			  {  
				  cost = cost + (rs.getDouble("Cost") * numOfChildren);
				  System.out.println(cost);
			  }
			  
	          closeConnection();
	          }
	  			catch (Exception e){
	 			System.out.println("Failed to assign cost with noOfChildren.\n" + e.getMessage());
	 			}
		 try{ 
	          createConnection();
	          PreparedStatement statement = conn.prepareStatement("SELECT Cost FROM type WHERE NAME = 'Student/OAP'");
			  ResultSet rs = statement.executeQuery();
	          
			  while(rs.next())
			  {  
				  cost = cost + (rs.getDouble("Cost") * numOfStudents_OAP);
				  System.out.println(cost);
			  }
			  
	          closeConnection();
	          }
	  			catch (Exception e){
	 			System.out.println("Failed to assign cost with noOfChildren.\n" + e.getMessage());
	 			}
		
		 return cost;
	}
	
	public void addBookingToDB()
	{
		getNumberOfTickets();
		getBookingNumber();
		String booking = "INSERT INTO booking VALUES ('" + bookingNum +"', " +
					  "'" + numOfTickets + "' ," +
					  "'" + screeningNum + "' ," +
					  "'" + getCost() + "') "; 
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(booking);
		Ticket ticket = new Ticket();
		
		for(int i =0; i<numOfAdults;  i++) {
			
			ticket.addTicketToDB("Adult", bookingNum, screeningNum);
			
		}
		for(int i =0; i<numOfChildren;  i++) {
			
			ticket.addTicketToDB("Child", bookingNum, screeningNum);	
		}
		for(int i =0; i<numOfStudents_OAP;  i++) {
			
			ticket.addTicketToDB("Student/OAP", bookingNum, screeningNum);	
		}
		
		
	}
	public void getBookingDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("booking");
	}

}
