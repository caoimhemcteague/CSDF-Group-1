package CinemaTester;
import CinemaClasses.*;
import java.util.*;

public class CinemaTester {
	public static void main(String[] args) {
		
		Film blankFilm = new Film();
		Screening blankScreening = new Screening();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Select a film to go see");
		blankFilm.getFilmDB();
		System.out.println("\nEnter Film name");
		String filmName=sc.nextLine();
		
		blankScreening.getFilmScreening(filmName);
		
		System.out.println("\nPlease select a date");
		String filmDate=sc.nextLine();
		System.out.println("\nPlease select a time");
		String filmTime=sc.nextLine();

		int screeningNumber = blankScreening.returnScreeningNum(filmName, filmTime, filmDate);

		
		System.out.println("Please select number of tickets");
		System.out.println("How many Adults");
		int adults=sc.nextInt();
		System.out.println("How many Children");
		int child=sc.nextInt();
		System.out.println("How many Students");
		int student=sc.nextInt();
		
		Booking newBooking = new Booking(adults, child, student, screeningNumber);
		newBooking.addBookingToDB();
		
		System.out.print("Congrats, your booking is complete.\nYou are going to see - " + filmName + 
				"\nTotal Cost comes to - �" + newBooking.getCost());
		
		System.out.print("");
		
		
		

	}
	
}
