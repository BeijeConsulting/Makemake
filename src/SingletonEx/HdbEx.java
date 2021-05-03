package SingletonEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.Contatto;
import SingletonEx.Database;


public class HdbEx {
public static void main(String[] args) {
	final boolean flag = true;
	final int MAX_COUNT = 150;
	ArrayList <Database> sessions = new ArrayList <Database>();

	try {
		if(sessions.size() < MAX_COUNT) {
			Database db1 = Database.getInstance();
			sessions.add(db1);			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}