package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionManager {
	
	private ConnectionManager() {}
	
	private static Connection connection;
	private static ArrayList<Connection> connectionList = new ArrayList<>();
	private static int givenConnection = 0;
	private final static int MAX = 150;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		for(int i=1; i<300; i++) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake", "root", "beije03");
			System.out.print(i + " ");
		}
		return connection;
	}
	
	public static Connection chooseConnection() throws ClassNotFoundException, SQLException {
		if(givenConnection <= MAX) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake", "root", "beije03");
			connectionList.add(connection);
			givenConnection++;
		}
		else {
			System.out.println("Maximum number of connection achieved.");
		}
		return connection;
	}
	
	public static boolean connIsClosed(Connection conn) {
		if(connectionList.contains(conn)) {
			connectionList.remove(conn);
			givenConnection--;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void printGivenConn() {
		System.out.println(givenConnection);
	}
}
