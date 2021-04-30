package it.beije.makemake.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private ConnectionManager() {}
	private static Connection connection;
	public static Connection getInstance() throws SQLException, ClassNotFoundException {
		if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET","root","Beije06");
		}
		return connection;
	}
	
	
}
