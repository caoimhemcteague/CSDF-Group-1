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

}
