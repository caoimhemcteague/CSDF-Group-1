package CinemaClasses;

public class Booking {
	
	
	public int bookingNum=1; 
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
		return bookingNum;
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
		String booking = "INSERT INTO booking VALUES ('" + bookingNum +"', " +
					  "'" + numOfTickets + "' ," +
					  "'" + screeningNum + "' ," +
					  "'" + getCost() + "') " +
					  "ON DUPLICATE KEY UPDATE Booking_Number='" + bookingNum + "', " +
					  "Number_of_Tickets=' " + numOfTickets + "', " +
					  "Screening_Number=' " + screeningNum + "', " +
					  "Cost=' " + getCost() + "'";
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(booking);
	}
	public void getBookingDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("booking");
	}

}
