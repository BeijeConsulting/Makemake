package it.beije.makemake.JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

public class JDBCmetods {
	static List<Contatto> contatti = new ArrayList<Contatto>();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException , Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije02");
		//select(connection);
		
		insertFromFile("C:\\Users\\Padawan02\\Desktop\\temp\\rubrica1.csv");
		
		insert(connection);
		connection.close();
		
		for(Contatto c : contatti)
			System.out.println(c.toString());
	}

	
	
	public static void select (Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM rubrica");
			
			while (resultSet.next()) {
				Contatto c = new Contatto();
				c.setId(resultSet.getInt("id"));
				c.setCognome(resultSet.getString("cognome"));
				c.setNome(resultSet.getString("nome"));
				c.setTelefono(resultSet.getString("telefono"));
				c.setEmail(resultSet.getString("email"));
				contatti.add(c);
				/*
				 Stampa elementi presi dalla SELECT 
				System.out.println("id : " + resultSet.getInt("id"));
				System.out.println("cognome : " + resultSet.getString("cognome"));
				System.out.println("nome : " + resultSet.getString("nome"));
				System.out.println("tel : " + resultSet.getString(4));
				System.out.println("email : " + resultSet.getString(5));
				
				System.out.println("\n-------------\n");
				*/
			}
		}catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insert(Connection connection) {
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");
			
			for(Contatto c : contatti) {
				
				preparedStatement.setString(1, c.getCognome());
				preparedStatement.setString(2, c.getNome());
				preparedStatement.setString(3, c.getTelefono());
				preparedStatement.setString(4, c.getEmail());
				
				preparedStatement.executeUpdate();
			}
		}catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
			
		}finally {
			
			try {
				preparedStatement.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertFromFile(String pathFile) throws Exception {
	BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
		
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			//System.out.println(row);
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[0]);
			contatto.setCognome(rowParts[1]);
			contatto.setTelefono(rowParts[2]);
			if (rowParts.length == 4)
				contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
		}
		
		//for(Contatto c : contatti) {
			//System.out.println(c.toString());
		//}
		
		bufferedReader.close();
	}
}
