package it.andrea.esercitazione.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HDBManager {
	private static final int MAX_SESSIONS = 10;
	private static List<Session> sessions = new ArrayList<Session>();

	private HDBManager() {
	}

	public static Session getSession() throws Exception {
		if (sessions.size() < MAX_SESSIONS) {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			sessions.add(session);
			return session;
		}
		throw new Exception();
	}
	
	public static void closeSession(Session session) {
		session.close();
		sessions.remove(session);
	}
}
