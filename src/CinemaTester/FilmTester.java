package CinemaTester;


import CinemaClasses.*;

public class FilmTester {
	public static void main(String[] args) {
		String name = "Alright Film";
		String rating = "15A";
		String genre = "Thriller";
		int duration = 157;
		
		Film newFilm = new Film(name, rating, genre, duration); 
		
	newFilm.addFilmToDB();
	newFilm.getFilmDB();
		
		
		
		
	}

}
