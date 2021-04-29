package it.beije.makemake.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private ConnectionPool() {}
	
	private static ConnectionPool pool;
	private int freeConnection=151;
	private List<Connection> connections= new ArrayList<>(); 
	public static ConnectionPool  getInstance() {
		
		if (pool == null) pool = new ConnectionPool();
		
		return pool;
	}

	 //public Connection getConnection() {
		  
		//return;
		 
	// }
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Connection connection =MyConnectionManager.getConnection();
		
	}

}
