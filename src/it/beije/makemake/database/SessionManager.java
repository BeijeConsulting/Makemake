package it.beije.makemake.database;

import java.util.ArrayList;
import java.util.List;
import it.beije.makemake.fileanalisi.Contatto;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SessionManager {
	private SessionManager() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
		this.sessionFactory = configuration.buildSessionFactory();
	}

	private static SessionManager instance;
	private static SessionFactory sessionFactory;
	private static List<Session> sessionList = new ArrayList<>();

	public static SessionManager getSessionManager() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}

	public static Session getSession() {
		Session session;
		for (Session s : sessionList) {
			if (!s.isOpen()) {
				s.close();
				sessionList.remove(s);
			}
		}
		if (sessionList.size() == 150) {
			throw new SessionException("Max number of concurrent sessions reached");
		} else {
			session = sessionFactory.openSession();
			sessionList.add(session);
		}
		return session;
	}

	public static void closeSession(Session session) {
		session.close();
		sessionList.remove(session);
		System.out.println(session.isOpen());
	}
}





		


