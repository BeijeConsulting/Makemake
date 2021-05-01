package it.beije.makemake.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.ContattoRubrica;

public class MultiSessionManager {
	

	private static final int MAX = 5;
	private static List<Session> sessions = new ArrayList<Session>();
	 
      private MultiSessionManager() {
	}
	
	
	public static Session getSession() throws TooManySessionsException {
		if (sessions.size() < MAX) {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(ContattoRubrica.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			sessions.add(session);
			return session;
		}
		throw new TooManySessionsException();
	}
	
	public static void closeSession(Session session) {
		session.close();
		sessions.remove(session);
		System.out.println("sessione chiusa");
	}


}
