package CinemaClasses;

public interface JDBCDB {
	public abstract void createConnection();
//	public abstract void createDatabase();
	public abstract void closeConnection();
	public abstract void insertIntoDatabase(String sqlString);

}
