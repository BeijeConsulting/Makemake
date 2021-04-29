package it.beije.makemake.esercizi.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MultySessionManager {
	
	private MultySessionManager() {}
	
	private static final int MAX= 10;
	private static List<Session> sessions = new ArrayList<Session>();
	public static Session  getMultySession() throws ClassNotFoundException, SQLException {
		
		if (sessions == null || !sessions.isOpen() ) {
		
			Configuration configuration = new Configuration().configure();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			System.out.println(session.isOpen());
			
	
			return session;
		}
		
		return null;
	}
	

}