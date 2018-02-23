package CinemaTester;

import CinemaClasses.*;

public class BookingTester {
	public static void main(String[] args) {
	
		int noOfTickets = 6;
		int screeningNo = 9;
		
		Booking newBooking = new Booking(noOfTickets, screeningNo); 
		
	newBooking.addBookingToDB();
	newBooking.getBookingDB();

}
}
