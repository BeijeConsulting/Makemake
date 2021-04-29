package it.beije.makemake.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MultiSessionManager {
	

	private static final int MAX = 10;
	private static List<Session> sessions = new ArrayList<Session>();
	
	private MultiSessionManager() {
	}
	
	
	public static Session getMultiSessions() throws Exception {

		if (sessions.size()<MAX) {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			sessions.add(session);
		  return session;
		}
		 throw new Exception();
}


}
