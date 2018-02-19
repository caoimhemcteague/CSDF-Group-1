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
	
	public double getCost()
	{
		return cost;
	}

}
