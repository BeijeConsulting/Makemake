package it.beije.makemake.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class TestConnessioni {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		boolean controllo=true;
		Connection connection;
		List<Connection> connectionList=new ArrayList<Connection>();
		while(controllo) {
			try {
				
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET",
					"root", "Beije09");
		 connectionList.add(connection);

			}catch(SQLTimeoutException | SQLNonTransientConnectionException  e ){
				controllo=false;
				
			}
		}
		System.out.println(connectionList.size());
	}
	
}
