package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectionPool {
	private final static ArrayList <Connection> connections = new ArrayList <Connection>();
	private final static Integer MAX_AMOUNT = 250;
	private static Integer givenconnection = 0;
	
	public static void init() throws Exception {
		
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije13");
			connections.add(connection);	
			givenconnection++;
		}
	}
	
	public static boolean closing(ArrayList<Connection> connections, int idx) throws SQLException {
		boolean flag=false;
		Connection x_close = connections.remove(idx);
		x_close.close();
		if(x_close.isClosed()) {	
			flag = true;
		givenconnection--;
		}
		return flag;
		
	}
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		
	try {
		 while(givenconnection < MAX_AMOUNT) {
			init();	
		}
	}catch(Exception e) {	
		e.printStackTrace();
	}
	finally {
		System.out.println("Inserisci una connessione da chiudere: ");
		Scanner x = new Scanner(System.in);
		int cnt = x.nextInt();
		boolean f = closing(connections, cnt);
		
		System.out.println(connections.size());
	}
	}

}
