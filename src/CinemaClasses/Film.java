package CinemaClasses;

public class Film {
	
	public String name;
	public String pgRating; 
	public String genre;
	public int duration; 
	//Trailer
	//Descritpion
	//Release Date
	
	public Film(String name, String pgRating, String genre, int duration)
	{
		this.name=name;
		this.pgRating=pgRating;
		this.genre=genre;
		this.duration=duration;
	}

}
