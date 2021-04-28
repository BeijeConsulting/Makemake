package it.beije.makemake.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactDBManager {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET","root","Beije06");
		
		File file = new File("C:\\Users\\Padawan06\\Desktop\\rubricaDB.csv");
		try {
			importFromDB(connection,file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void importFromDB(Connection connection,File f) throws IOException {
		FileWriter fileWriter = new FileWriter(f,true);
		Statement statement = null;
		ResultSet resultSet = null;
				try {
					statement=connection.createStatement();
					resultSet = statement.executeQuery("SELECT * FROM rubrica");
					while(resultSet.next()) {
						fileWriter.write(resultSet.getInt("id")+";");
						fileWriter.write(resultSet.getString("nome")+";");
						fileWriter.write(resultSet.getString("cognome")+";");
						fileWriter.write(resultSet.getString("telefono")+";");
						fileWriter.write(resultSet.getString("email")+";");
						fileWriter.write("\n");
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						fileWriter.close();
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
		
		fileWriter.close();
	}
	
	
	
}
