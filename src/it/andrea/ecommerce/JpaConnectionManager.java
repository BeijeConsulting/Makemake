package it.andrea.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnectionManager {
	private static final int MAX_SESSIONS = 5;

	private static List<EntityManager> entityManagers = new ArrayList<EntityManager>();

	private JpaConnectionManager() {
	}

	public static EntityManager getEntityManager() throws TooManySessionsException {
		if (entityManagers.size() < MAX_SESSIONS) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");
			EntityManager entityManager = factory.createEntityManager();
			entityManagers.add(entityManager);
			return entityManager;
		}
		throw new TooManySessionsException();
	}

	public static void closeEntityManager(EntityManager entityManager) {
		entityManager.close();
		entityManagers.remove(entityManager);
	}
}
