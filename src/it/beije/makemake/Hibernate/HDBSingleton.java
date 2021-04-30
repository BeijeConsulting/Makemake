package it.beije.makemake.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.Hibernate.Contatto;

import org.hibernate.Session;

public class HDBSingleton {

	private  Configuration configuration;
	
	private  SessionFactory sessionFactory;
	
	private static HDBSingleton instance;
	
	private HDBSingleton() {}
	
	public static HDBSingleton getHDBSingleton() {
		if(instance == null) {
			instance=new HDBSingleton();
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
