package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaxNumberDbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET","root","Beije06");
	
	}

}
