package it.beije.makemake.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

	private SessionManager() {
	}

	private static Session session;

	public static Session getSession() throws Exception {

		if (session == null || !session.isOpen()) {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
		
		  return session;
		}
		return null;
}

}