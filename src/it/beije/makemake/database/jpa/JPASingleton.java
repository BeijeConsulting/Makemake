package it.beije.makemake.database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPASingleton {

	private static JPASingleton instance;
	private  EntityManagerFactory factory;
	
	private JPASingleton() {
		
	}

	public static JPASingleton getInstance() {
		if(instance == null) {
			instance = new JPASingleton();
			instance.factory = Persistence.createEntityManagerFactory("Makemake");
		}
		
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
