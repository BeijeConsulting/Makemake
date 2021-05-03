package it.beije.makemake.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.file.rubrica.Contatto;

public class HDBSingleton {

	private static HDBSingleton instance;
	
	private  Configuration configuration;
	
	private  SessionFactory sessionFactory;
	
	private HDBSingleton() {
		
	}

	public static HDBSingleton getHDBSingleton() {
		
		if(instance == null) {
			instance = new HDBSingleton();
			instance.configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
			instance.sessionFactory = instance.configuration.buildSessionFactory();
		}
		
		return instance;
	}
	
	public Session getSession() {
		Session session =  instance.sessionFactory.openSession();
		return session;
	}
	
}
