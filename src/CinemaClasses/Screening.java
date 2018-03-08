package CinemaClasses;

public class Screening {
	
	public int screeningNum; 
	private Theatre theatre; 
	public Film film; 
	//public Date date; 
	//public time;
	
	public Screening(int screeningNum, Theatre theatre, Film film) {
		this.film=film;
		this.screeningNum = screeningNum;
		this.theatre = theatre;
		
	}
	
	public int returnTheatreNum()
	{
		return theatre.returnTheatreNum();
	}
	
	

}
