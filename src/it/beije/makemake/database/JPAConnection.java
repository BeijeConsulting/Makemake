package it.beije.makemake.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private JPAConnection() {}
	
	public static EntityManager getConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Makemake");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
}
