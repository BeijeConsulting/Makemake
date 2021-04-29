package it.beije.makemake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionManager {
	
	private static Connection connection;
	private static int cont;
	private static int maxConnessioni = 141;
	private static ArrayList<Connection> lista = new ArrayList<Connection>();
	
	private ConnectionManager() {}
	
	private static Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije07");
		lista.add(connection);
		cont++;
		return connection;
	}
	
	public static Connection getConnection() throws Exception {
		if (cont < maxConnessioni) {
			return init();
			}else {
				throw new Exception("Le connessioni sono tutte occupate");
			}
	}
	public static void closeConnection(Connection c) throws SQLException {
		if(lista.contains(c)) {
			cont--;
			c.close();
			lista.remove(c);
		}
	}
	}
