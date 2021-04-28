package jdbcEx;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

	public static void writeOnFile(Connection connection, ArrayList<Contatto> contatti, File f) throws Exception{
		
		if (f.toString().substring(f.toString().length()-4) != "csv") {			
			for (Contatto cont : contatti) {
				appendInRubricaCsv(cont, f);
			}
		}
		else if(f.toString().substring(f.toString().length()-4) != "xml") {
				 appendInRubricaXml(contatti, f);		 
		}
		
	}
	
	public static void appendInRubricaXml( List<Contatto> contatti, File f) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
		Document document1 = builder.parse(f);
		
		
		Element root = document1.createElement("contatti");

		for(Contatto cont: contatti) {
			Element contatto = document1.createElement("contatto");
			Element id = document1.createElement("id");
			id.setTextContent(Integer.valueOf(cont.getId()).toString());
			Element nome = document1.createElement("nome");
			nome.setTextContent(cont.getNome());
			Element cognome = document1.createElement("cognome");
			cognome.setTextContent(cont.getCognome());
			Element telefono = document1.createElement("telefono");
			telefono.setTextContent(cont.getTelefono());
			Element email = document1.createElement("email");
			email.setTextContent(cont.getEmail());
			
			contatto.appendChild(id);
			contatto.appendChild(nome);
			contatto.appendChild(cognome);
			contatto.appendChild(telefono);
			contatto.appendChild(email);

			root.appendChild(contatto);
		}
			document1.appendChild(root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document1);

			StreamResult result = new StreamResult(f);
			
			// Output to console for testing
			StreamResult syso = new StreamResult(System.out);

			transformer.transform(source, result);
			transformer.transform(source, syso);

			System.out.println("File saved!");						
	}
	
	public static void appendInRubricaCsv(Contatto contatto, File pathFile) throws Exception {
		FileWriter writer = new FileWriter(pathFile, true);
		writer.write(contatto.getId());
		writer.write(';');
		writer.write(contatto.getCognome());
		writer.write(';');
		writer.write(contatto.getNome());
		writer.write(';');
		writer.write(contatto.getTelefono());
		writer.write(';');
		writer.write(contatto.getEmail());
		writer.write('\n');

		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception, ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije13");
	
	List<Contatto> contacts = new ArrayList<Contatto>();
	contacts = select(connection);
	connection.close();
	
	for (Contatto c : contacts)
		System.out.println(c.toString());
	
	File f = new File("C:\\Users\\Padawan13\\Desktop\\rubrica.xml");
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();	
    // Load the input XML document, parse it and return an instance of the Document class.
	appendInRubricaXml(contacts, f);
}

}
