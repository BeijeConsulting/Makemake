package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.beije.makemake.file.rubrica.Contatto;

public class DataBaseManager {

	public static void main(String arg[]) {
		Connection connection= null;
		
		try {
			connection = openConnection();
			insert(connection, new Contatto(1, "Antony", "Shenouda", "12", "@"));
			insert(connection, new Contatto(1, "Antony", "Shenouda", "12", "@"));
			select(connection);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake", "root", "Beije11");
		
		return connection;
	}
	
	public static void select(Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Contatto> contactList = new ArrayList<>();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM rubrica");
			
			while(resultSet.next()) {
				contactList.add(new Contatto(
										resultSet.getInt("id"),
										resultSet.getString("nome"),
										resultSet.getString("cognome"),
										resultSet.getString("telefono"),
										resultSet.getString("email")
											)
								);
			}
			
			for(Contatto cont : contactList) {
				System.err.println(cont);
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insert(Connection connection,  Contatto cont) {
		PreparedStatement prepStat = null;
		
		try {
			prepStat = connection.prepareStatement("INSERT INTO rubrica(nome, cognome, telefono, email) VALUES(?,?,?,?)");
			
			prepStat.setString(1, cont.getNome());
			prepStat.setString(2, cont.getCognome());
			prepStat.setString(3, cont.getTelefono());
			prepStat.setString(4, cont.getEmail());

			
			prepStat.executeUpdate();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				prepStat.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void update(Connection connection, String attribute, String value, String condAttr, String condValue) {
		PreparedStatement prepStat = null;
		
		try {
			prepStat = connection.prepareStatement("UPDATE rubrica SET ?=? WHERE ?=?");
			
			prepStat.setString(1, attribute);
			prepStat.setString(2, value);
			prepStat.setString(3, condAttr);
			prepStat.setString(4, condValue);

			
			prepStat.executeUpdate();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				prepStat.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


}
