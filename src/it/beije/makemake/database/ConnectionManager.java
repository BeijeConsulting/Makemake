package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionManager {
	
	private final static ArrayList<Connection> connectionPool = new ArrayList<>();
	private final static Integer MAX_AMOUNT = 152; 
	private static Integer givenConnection = 0;
	
	private ConnectionManager() {
		
	}
	
	private static Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake", "root", "Beije11");
		connectionPool.add(connection);
		givenConnection++;
		
		return connection;
	}
	
	public static Connection getConnection() throws MaxConnectionException, ClassNotFoundException, SQLException{
		
		if(givenConnection < MAX_AMOUNT) {
			return init();
		}else {
			throw new MaxConnectionException();
			
		}
		
	}

	public static boolean closeConnection(Connection connection) throws SQLException {
		if(connectionPool.contains(connection)) {
			givenConnection--;
			connection.close();
			return connectionPool.remove(connection);
		}
		
		return false;
	}
}
