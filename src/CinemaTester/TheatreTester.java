package CinemaTester;

import CinemaClasses.*;

public class TheatreTester {
	public static void main(String[] args) {
		
		int capacity = 9;
		
		Theatre newTheatre = new Theatre(capacity); 
		
	newTheatre.addTheatreToDB();
	newTheatre.getTheatreDB();

}
}
