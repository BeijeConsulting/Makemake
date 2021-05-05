package it.beije.makemake.myEcommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPASingleton {
	
	private EntityManagerFactory factory;
	
	private static JPASingleton instance;
	
	private JPASingleton() {}
	
	public static JPASingleton getJPASingleton() {
		if(instance == null) {
			instance = new JPASingleton();
			instance.factory = Persistence.createEntityManagerFactory("Makemake");
			
			}
		return instance ; 
	}
	
	public EntityManager getEntityManager() {
		EntityManager entityManager = instance.factory.createEntityManager();
		return entityManager;
	}
}
