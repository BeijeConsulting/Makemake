package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import it.beije.makemake.rubrica.Contatto;

public class JdbcExample {
	
	public static void select(Connection connection) {
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
//			resultSet = statement.executeQuery("SELECT nome as name,cognome,id FROM rubrica");
			resultSet = statement.executeQuery("SELECT * FROM rubrica");
//			statement.execute("SELECT nome as name,cognome,id FROM rubrica");
//			ResultSet resultSet = statement.getResultSet();
			
			while (resultSet.next()) {
				System.out.println("id : " + resultSet.getInt("id"));
				System.out.println("cognome : " + resultSet.getString("cognome"));
				System.out.println("nome : " + resultSet.getString("nome"));
				System.out.println("tel : " + resultSet.getString(4));
				System.out.println("email : " + resultSet.getString(5));
				
				System.out.println("\n-------------\n");
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void insert(Connection connection) {
		
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO rubrica VALUES (null,'Zippo','Andrea','789569879','mia@email.it')");
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(Connection connection) {
		
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			int r = statement.executeUpdate("UPDATE rubrica set cognome = 'Di Bella' WHERE cognome = 'Rossi'");
			System.out.println("record modificati: " + r);
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public static void insertContacts(Connection connection) {
		
		Contatto c1 = new Contatto();
		c1.setCognome("Rossi");
		c1.setNome("Mario");
		c1.setTelefono("532452");
		Contatto c2 = new Contatto();
		c2.setCognome("Bianchi");
		c2.setNome("Marco");
		c2.setTelefono("53245234");
		List<Contatto> contatti = new ArrayList<Contatto>();
		contatti.add(c1);
		contatti.add(c2);
		
		
		//Statement statement = null;
		PreparedStatement preparedStatement = null;
		
		try {
//			statement = connection.createStatement();
			
			preparedStatement = connection.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");
			
			for (Contatto c : contatti) {
//				String insert = "INSERT INTO rubrica VALUES (null,'" + c.getCognome() + "','" + c.getNome() + "','" + c.getTelefono() + "','" + c.getEmail() +"')";
//				System.out.println(insert);
				//statement.executeUpdate(insert);
				
				preparedStatement.setString(1, c.getCognome());
				preparedStatement.setString(2, c.getNome());
				preparedStatement.setString(3, c.getTelefono());
				preparedStatement.setString(4, c.getEmail());
				
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
//				statement.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void search(Connection connection, String cognome) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rubrica WHERE cognome = ?");
			preparedStatement.setString(1, cognome);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("id : " + resultSet.getInt("id"));
				System.out.println("cognome : " + resultSet.getString("cognome"));
				System.out.println("nome : " + resultSet.getString("nome"));
				System.out.println("tel : " + resultSet.getString(4));
				System.out.println("email : " + resultSet.getString(5));
				
				System.out.println("\n-------------\n");
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "beije");
		
		Connection connection = ConnectionManager.getConnection();
		//System.out.println(connection.isClosed());
		
		//insert(connection);
		//update(connection);
		//insertContacts(connection);
		//select(connection);
		search(connection, "Di Bella");
		
		connection.close();
	}

}
