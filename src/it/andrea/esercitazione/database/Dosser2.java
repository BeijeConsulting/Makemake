package it.andrea.esercitazione.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLTimeoutException;

public class Dosser2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int cont = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		boolean controllo = true;
		while (controllo) {
			try {

//				DriverManager.setLoginTimeout(1);
				Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije10");

				System.out.println("connection  " + connection.isClosed());
				if (connection.isClosed())
					controllo = false;

			} catch (SQLTimeoutException | SQLNonTransientConnectionException e) {
				controllo = false;

			}
			cont++;
		}
		System.out.println(cont - 1);
	}
}
