package it.beije.makemake.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.Contatto;

public class SessionManager {

	private static Session config;

	private SessionManager() {}
	
	private static Session init(){
		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(Contatto.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		config = session;
		return session;
	}
	
	public static Session getSession() throws Exception {
		if (config == null) { 
			return init();
			}
		return config;			
	}
	public static void close(Session session) {
		config = null;
		session.close();
	}
	}

