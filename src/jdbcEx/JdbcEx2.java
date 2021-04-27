package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.beije.makemake.rubrica.Contatto;

public class JdbcEx2 {
	
	
	
	public static List<Contatto> select(Connection connection) {
		
	List<Contatto> contatti = new ArrayList<Contatto>();	
	Statement statement = null;
	ResultSet resultSet = null;
	
	try {
		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT * FROM rubrica");
		
		
		
		while (resultSet.next()) {
			Contatto contatto = new Contatto();
			//Salvo tutti i contatti dal DB 
			contatto.setId(resultSet.getInt("id"));
			contatto.setCognome(resultSet.getString("cognome"));
			contatto.setNome(resultSet.getString("nome"));
			contatto.setTelefono(resultSet.getString(4));
			contatto.setEmail(resultSet.getString(5));
			contatti.add(contatto);		
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

	
public static void insertContacts(Connection connection, ArrayList<Contatto> contatti) {
		
		//Statement statement = null;
		PreparedStatement preparedStatement = null;
		
		try {
//			statement = connection.createStatement();
			
			preparedStatement = connection.prepareStatement("INSERT INTO rubrica (id,cognome,nome,telefono,email) VALUES (?,?,?,?,?)");
			
			for (Contatto c : contatti) {
//				String insert = "INSERT INTO rubrica VALUES (null,'" + c.getCognome() + "','" + c.getNome() + "','" + c.getTelefono() + "','" + c.getEmail() +"')";
//				System.out.println(insert);
				//statement.executeUpdate(insert);
				
				preparedStatement.setInt(1, c.getId());
				preparedStatement.setString(2, c.getCognome());
				preparedStatement.setString(3, c.getNome());
				preparedStatement.setString(4, c.getTelefono());
				preparedStatement.setString(5, c.getEmail());
				
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



public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije13");
	//System.out.println(connection.isClosed());
	
	//insertContacts(connection);
	
	
	List<Contatto> contacts = new ArrayList<Contatto>();
	contacts = select(connection);
	connection.close();
	
	for (Contatto c : contacts)
		System.out.println(c.toString());
	
	
}


}
