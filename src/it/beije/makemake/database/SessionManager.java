package it.beije.makemake.database;

import java.sql.DriverManager;
import java.sql.SQLException;

import it.beije.makemake.Singleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

	private SessionManager() {}
			
	private static Session session;
			
	public static Session getSession() throws  ClassNotFoundException, SQLException {
		
		if (session == null || !session.isOpen()) {
			Configuration configuration = new Configuration().configure();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			System.out.println(session.isOpen());
			return session;
		}
	
		return null;
	
	}
	
		
}
		


