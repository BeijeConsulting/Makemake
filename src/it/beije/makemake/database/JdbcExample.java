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

	public static List<Contatto> select(Connection connection) {
		List<Contatto> contatti = new ArrayList<Contatto>();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM rubrica");

			while (resultSet.next()) {
				contatti.add(new Contatto(resultSet.getString("nome"), resultSet.getString("cognome"),
						resultSet.getString("telefono"), resultSet.getString("email")));
				System.out.println("id : " + resultSet.getInt("id"));
				System.out.println("cognome : " + resultSet.getString("cognome"));
				System.out.println("nome : " + resultSet.getString("nome"));
				System.out.println("tel : " + resultSet.getString("telefono"));
				System.out.println("email : " + resultSet.getString("email"));

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
		return contatti;
	}

	public static void insert(Connection connection, Contatto c) {

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");

			preparedStatement.setString(1, c.getCognome());
			preparedStatement.setString(2, c.getNome());
			preparedStatement.setString(3, c.getTelefono());
			preparedStatement.setString(4, c.getEmail());

			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
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

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");

			for (Contatto c : contatti) {
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

}
