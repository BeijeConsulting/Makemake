package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.beije.makemake.file.rubrica.Contatto;

public class DataBaseManager {	public static void main(String arg[]) {
		Connection connection= null;
		ArrayList<Contatto> result = null;
		try {
			
			//connection = openConnection();
			//usiamo il ConnectionManager ossia un esempio di Singleton
			connection = ConnectionManager.getConnection();
			result = selectAll(connection);
			System.out.println(result);
			updateSurnameByName(connection, "Chisalè", "Edo");
			System.out.println(result);
			System.out.println(searchByName(connection,"Edo"));
			
			while(true) {
				ConnectionManager.getConnection();
			}
			
		}catch(MaxConnectionException e) {
			System.out.println("Tutte le connessioni sono al momento occupate!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				System.out.println(ConnectionManager.closeConnection(connection));
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
	
	public static ArrayList<Contatto> selectAll(Connection connection) {
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
		//se tutto va a buon fine ritorna un array con i contatti altrimenti un array vuoto.
		return contactList;
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
	
	public static void updateSurnameByName(Connection connection, String valueAttr, String condValue) {
		PreparedStatement prepStat = null;
		
		try {
			prepStat = connection.prepareStatement("UPDATE rubrica SET cognome=? WHERE nome=?");
			


			prepStat.setString(1, valueAttr);

			prepStat.setString(2, condValue);

			
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

	public static ArrayList<Contatto> searchByName(Connection connection,String valueAttr) {
		PreparedStatement prepStat = null;
		ResultSet resultSet = null;
		ArrayList<Contatto> searchedContact = new ArrayList<Contatto>();
		
		try {
			prepStat = connection.prepareStatement("SELECT * FROM rubrica WHERE nome = ?");
			

			prepStat.setString(1, valueAttr);
			
			resultSet = prepStat.executeQuery();
			
			while(resultSet.next()) {
				searchedContact.add(new Contatto(
										resultSet.getInt("id"),
										resultSet.getString("nome"),
										resultSet.getString("cognome"),
										resultSet.getString("telefono"),
										resultSet.getString("email")
											)
								);
			}
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultSet.close();
				prepStat.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//se tutto va a buon fine ritorna un array con i contatti altrimenti un array vuoto.
		return searchedContact;
	}

}
