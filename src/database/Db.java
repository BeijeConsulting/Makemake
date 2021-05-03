package database;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

import java.sql.*;

public class Db {
	public void creatConnection() {
		Connection connection;
		Statement statement;
		ResultSet rs;
		List<Contatto> list=new ArrayList<Contatto>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root",
					"Beije01");
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM rubrica");
			while (rs.next()) {
				Contatto contatto =new Contatto();
				contatto.setId(rs.getInt("id"));
				contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
				contatto.setTelefono(rs.getString("telefono"));
				contatto.setEmail(rs.getString("email"));
				
				list.add(contatto);

			}
			for(Contatto contatto :list) {
				System.out.println(contatto.toString());
			}

			System.out.println(!connection.isClosed());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
