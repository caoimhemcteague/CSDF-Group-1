package CinemaClasses;

public class Ticket {

	String type = null;
	int bookingNum=0;
	int screeningNum=0;
	//Type type = new Type("");

	
	
	public Ticket(String type, int bookingNum, int screeningNum) {
		
		this.type=type;
		this.bookingNum=bookingNum;
		this.screeningNum=screeningNum;
		//Type type = new Type(name);
	}
	
	
	
	public Ticket() {
		
	}
	
	public void addTicketToDB(String type, int bookingNum, int screeningNum)
	{
		
		String ticket = "INSERT INTO ticket VALUES ('" + type +"', " +
					  "'" + bookingNum + "' ," +
					  "'" + screeningNum + "') "; 
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(ticket);
	}
}
