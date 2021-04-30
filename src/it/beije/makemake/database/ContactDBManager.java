package it.beije.makemake.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactDBManager {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET",
				"root", "Beije06");

		File file = new File("C:\\Users\\Padawan06\\Desktop\\rubricaDB.csv");
		try {

			exportToDB(connection, file);
			importFromDB(connection, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void importFromDB(Connection connection, File f) throws IOException {
		FileWriter fileWriter = new FileWriter(f);
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM rubrica");
			while (resultSet.next()) {
				fileWriter.write(resultSet.getString("cognome") + ";");
				fileWriter.write(resultSet.getString("nome") + ";");
				fileWriter.write(resultSet.getString("telefono") + ";");
				if(!resultSet.getString("email").equals(null)) {
					fileWriter.write(resultSet.getString("email") + ";");
				}
				fileWriter.write("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		fileWriter.close();
	}

	public static void exportToDB(Connection connection, File f) throws FileNotFoundException {
		FileReader fileReader = new FileReader(f);
		BufferedReader buffReader = new BufferedReader(fileReader);
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO rubrica(cognome,nome,telefono,email)VALUES (?,?,?,?)");

			while (buffReader.ready()) {
				String[] line = buffReader.readLine().split(";");

				preparedStatement.setString(1, line[0]);
				preparedStatement.setString(2, line[1]);
				preparedStatement.setString(3, line[2]);
				if (line.length<4) {
					preparedStatement.setString(4, null);
				}else {
					preparedStatement.setString(4, line[3]);
				}
				preparedStatement.executeUpdate();

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffReader.close();
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
