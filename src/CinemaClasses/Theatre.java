package CinemaClasses;

public class Theatre {
	
	public int theatreNum=1;
	public int capacity;
	
	public Theatre(int capacity)
	{
		this.capacity=capacity;
		theatreNum++;
	}
	
	public int getTheatreNum()
	{
		return theatreNum;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public void addTheatreToDB()
	{
		String theatre = "INSERT INTO theatre VALUES ('" + theatreNum +"', " +
					  "'" + capacity + "') " +
					  "ON DUPLICATE KEY UPDATE Theatre_Num='" + theatreNum + "', " +
					  "Capacity=' " + capacity +"'";
		JDBCcinema database = new JDBCcinema();
		database.insertIntoDatabase(theatre);
	}
	public void getTheatreDB() {
		JDBCcinema database = new JDBCcinema();
		//System.out.println("\n" + database.getFromDB("film"));
		database.getInfoFromDB("theatre");
	
	}
}
