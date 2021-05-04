package it.beije.makemake.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerMan {

	private static EntityManager entityManager;

	private EntityManagerMan() {
	}

	private static EntityManager init() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");

		EntityManager entityManager = factory.createEntityManager();

		return entityManager;
	}

	public static EntityManager getEntity() {
		if (entityManager == null) {
			return init();
		}
		return entityManager;
	}

	public static void close(EntityManager entity) {
		entityManager = null;
		entity.close();
	}
}
