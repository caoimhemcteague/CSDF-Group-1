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
					  "'" + duration + "') " +
					  "ON DUPLICATE KEY UPDATE Name='" + name + "', " +
					  "PG_Rating=' " + pgRating + "', " +
					  "Genre=' " + genre + "', " +
					  "Duration=' " + duration + "'";
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(film);
	}
	public void getFilmDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("film");
	}
	
	

}
