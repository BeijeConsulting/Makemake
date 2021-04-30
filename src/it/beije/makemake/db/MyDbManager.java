package it.beije.makemake.db;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.ContattiManager;
import it.beije.makemake.rubrica.ContattoRubrica;

public class MyDbManager { //gestione db con metodi e query

	public static void select(Connection connection) {

		Statement statement = null;
		ResultSet resultSet = null;

		try { // uso lo statemenet per eseguire query
			statement = connection.createStatement();
//			resultSet = statement.executeQuery("SELECT nome as name,cognome,id FROM rubrica");
			resultSet = statement.executeQuery("SELECT * FROM rubrica"); // assegno a resultset cio che torna dalla quer
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

	public static List<ContattoRubrica> selectList(Connection connection) { // prende dal db e mette in una lista
		List<ContattoRubrica> contatti = new ArrayList<ContattoRubrica>();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM rubrica");

			while (resultSet.next()) {
				contatti.add(new ContattoRubrica(resultSet.getString("nome"), resultSet.getString("cognome"),
						resultSet.getString("telefono"), resultSet.getString("email")));
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

	public static void insert(Connection connection) {

		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO rubrica VALUES (null,'Cristiano','Ronaldo','77777777','sium@email.it')");

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

	public static void insert(Connection connection, ContattoRubrica contatto) throws SQLException { // insert che aggiunge un
																								// contatto
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection
					.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");
			preparedStatement.setString(1, contatto.getCognome());
			preparedStatement.setString(2, contatto.getNome());
			preparedStatement.setString(3, contatto.getTelefono());
			preparedStatement.setString(4, contatto.getEmail());

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

	public static void insert(Connection connection, List<ContattoRubrica> contatti) throws SQLException { // insert che
																									// aggiunge un
																									// contatto
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection
					.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");

			for (ContattoRubrica contatto : contatti) {
				preparedStatement.setString(1, contatto.getCognome());
				preparedStatement.setString(2, contatto.getNome());
				preparedStatement.setString(3, contatto.getTelefono());
				preparedStatement.setString(4, contatto.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();

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

	public static void insertFromDBtoCSV(Connection connection) throws Exception {
		File f=new File("C:\\Users\\Padawan09\\git\\Makemake\\src\\it\\beije\\makemake\\rubrica\\fileCsv\\rubrica2.csv");
		try {
			
		ContattiManager.writeList(selectList(connection), f);
		}catch (SQLException sqlException) {
		sqlException.printStackTrace();
	}
	}

	public static void update(Connection connection) {

		Statement statement = null;

		try {
			statement = connection.createStatement();
			int r = statement.executeUpdate("UPDATE rubrica set cognome = 'Ronaldo' WHERE cognome = 'Cristiano'");
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

	public static void update(Connection connection, String filter, String oldvalues, String newvalues) {

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE rubrica set " + filter + "='" + newvalues + "'  WHERE " + filter + "='" + oldvalues + "'");
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

	public static void insertContacts(Connection connection) {

		ContattoRubrica c1 = new ContattoRubrica();
		c1.setCognome("Nesta");
		c1.setNome("Alessandro");
		c1.setTelefono("9237693284");
		c1.setEmail("milan@email.it");
		ContattoRubrica c2 = new ContattoRubrica();
		c2.setCognome("Pirlo");
		c2.setNome("Andrea");
		c2.setTelefono("53245234");
		c2.setEmail("milanjuve@email.it");
		List<ContattoRubrica> contatti = new ArrayList<ContattoRubrica>();
		contatti.add(c1);
		contatti.add(c2);

		// Statement statement = null;
		PreparedStatement preparedStatement = null;

		try {
//			statement = connection.createStatement();

			preparedStatement = connection
					.prepareStatement("INSERT INTO rubrica (cognome,nome,telefono,email) VALUES (?,?,?,?)");

			for (ContattoRubrica c : contatti) {
//				String insert = "INSERT INTO rubrica VALUES (null,'" + c.getCognome() + "','" + c.getNome() + "','" + c.getTelefono() + "','" + c.getEmail() +"')";
//				System.out.println(insert);
				// statement.executeUpdate(insert);

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

	public static void searchCognome(Connection connection, String cognome) {

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

	public static List<ContattoRubrica> searchBy(Connection connection, String filter, String value) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<ContattoRubrica> contatti = new ArrayList<ContattoRubrica>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rubrica WHERE " + filter + " = ?");
			preparedStatement.setString(1, value);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				contatti.add(new ContattoRubrica(resultSet.getString("nome"), resultSet.getString("cognome"),
						resultSet.getString("telefono"), resultSet.getString("email")));
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
		return contatti;
	}

	public static void delete(Connection connection, String filter, String value) {

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("DELETE  FROM rubrica WHERE " + filter + " = ?");
			preparedStatement.setString(1, value);
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

	public static void clear(Connection connection) {

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("DELETE  FROM rubrica");
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

	public static void main(String[] args) throws Exception {


//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET",
//				"root", "Beije09");
		
		Connection connection =MyConnectionManager.getConnection();
		// System.out.println(connection.isClosed());

		// insert(connection);
		// update(connection);
		// insertContacts(connection);
		// select(connection);
		// searchCognome(connection, "Ronaldo");
		// System.out.println(searchBy(connection, "nome", "Cristiano"));
		// insert(connection, ContattiManager.getContactList(new File(ContattiManager.rubricaDir)));
		// File(ContattiManager.rubricaDir)));
		// File(ContattiManager.rubricaDir)));
		// delete(connection, "cognome", "nesta");
		// clear(connection);
		// update(connection, "nome", "alessandro", "giuseppe");
		//System.out.println((selectList(connection)));
		//insertFromDBtoCSV(connection);
		connection.close();
	}

}
