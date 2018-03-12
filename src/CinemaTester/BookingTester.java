package CinemaTester;

import CinemaClasses.*;

public class BookingTester {
	public static void main(String[] args) {
	
		int noOfAdults = 1;
		int noOfChildren = 2;
		int noOfStudents = 0;
		int screeningNo = 9;
		
		Booking newBooking = new Booking(noOfAdults, noOfChildren, noOfStudents, screeningNo); 
		
	newBooking.addBookingToDB();
	newBooking.getBookingDB();

}
}
