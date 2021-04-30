package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestoreConnessioni {

private GestoreConnessioni() {}
	
	final static int DIMENSIONE = 11;
	
	private static Connection[] connesioni= new Connection[DIMENSIONE];
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		int pos= 11;
		
		boolean settata = false;
		for (int i = 0; i < connesioni.length-1 && !settata; i++) {
			
			if (connesioni[i] == null || connesioni[i].isClosed() ) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connesioni[i] = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije05");
				pos=i;
				settata = true;
				System.out.println("creata nuova connesione posizione:"+ pos);
			}
		}
		
		
		return connesioni[pos];
		
	}

}
