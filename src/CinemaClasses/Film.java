package CinemaClasses;

import java.io.InputStream;

import com.mysql.jdbc.Blob;

public class Film {
	
	public String name;
	public String pgRating; 
	public String genre;
	public String actor, director, trailer, synopsis;
	public int duration;
	public InputStream poster;
	//Trailer
	//Descritpion
	//Release Date
	
	public Film(String name, String pgRating, String genre, int duration, String actor, String director, String trailer, InputStream poster, String synopsis)
	{
		this.name=name;
		this.pgRating=pgRating;
		this.genre=genre;
		this.duration=duration;
		this.actor=actor;
		this.director=director;
		this.trailer=trailer;
		this.poster=poster;
		this.synopsis=synopsis;
	}
	
	public Film()
	{
		
	}
	
	public String getFilmName()
	{
		return name;
	
	}
	
	public String getRating()
	{
		return pgRating;
	}
	
	public String getGenre()
	{
		return genre;
	}
	public int getDuration()
	{
		return duration;
	}
	
	public void addFilmToDB()
	{
		String film = "INSERT INTO film VALUES ('" + name +"', " +
					  "'" + pgRating + "' ," +
					  "'" + genre + "' ," +
					  "'" + duration + "' ," +
					  "'" + actor + "' ," +
					  "'" + director + "' ," +
					  "'" + trailer + "' ," +
					  "'" + poster + "' ," +
					  "'" + synopsis + "') " +
					  "ON DUPLICATE KEY UPDATE Name='" + name + "', " +
					  "PG_Rating=' " + pgRating + "', " +
					  "Genre=' " + genre + "', " +
					  "Duration=' " + duration + "', " +
					  "Actor=' " + actor + "', " +
					  "Director=' " + director + "', " +
					  "trailer=' " + trailer + "', " +
					  "poster=' " + poster + "', " +
					  "synopsis=' " + synopsis + "'";
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(film);
	}
	public void getFilmDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("film");
	}
	
	

}
