package it.andrea.esercitazione.contatti.db.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.andrea.esercitazione.contatti.db.DbManager;
import it.andrea.esercitazione.contatti.db.TooManySessionsException;
import it.andrea.esercitazione.contatti.entity.Contatto;

public class JpaManager implements DbManager {
	private static void tooManyEMError() {
		System.out.println("Too many entity managers!");
	}

	@Override
	public List<Contatto> selectAll() {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
			TypedQuery<Contatto> query = entityManager.createQuery("SELECT c FROM Contatto c", Contatto.class);
			return query.getResultList();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
		return null;
	}

	@Override
	public List<Contatto> selectBy(String filter, String value) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Contatto> query = builder.createQuery(Contatto.class);
			Root<Contatto> root = query.from(Contatto.class);
			query.select(root).where(builder.equal(root.get(filter), value));
			return null;
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
		return null;
	}

	@Override
	public List<Contatto> getContattiByFullContatto(Contatto contatto) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
		return null;
	}

	@Override
	public List<Contatto> getContattiByMask(Contatto mask) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
		return null;
	}

	@Override
	public boolean tableContains(Contatto contatto) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
		return false;
	}

	@Override
	public void insert(Contatto contatto) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
	}

	@Override
	public void insert(List<Contatto> contatti) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
	}

	@Override
	public void update(Contatto oldContatto, Contatto newContatto) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
	}

	@Override
	public void delete(Contatto contatto) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
	}

	@Override
	public void delete(List<Contatto> contatti) {
		try {
			EntityManager entityManager = JpaConnectionManager.getEntityManager();
		} catch (TooManySessionsException e) {
			tooManyEMError();
		}
	}
}
