package it.beije.makemake.db;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.ContattiManager;
import it.beije.makemake.rubrica.ContattoRubrica;

public class MyDbManagerSession { //gestione db con sessioni

	public static List<ContattoRubrica> selectAll() {
		try {
			Session session = MultiSessionManager.getSession();
			Query<ContattoRubrica> query = session.createQuery("SELECT c FROM ContattoRubrica as c");
			List<ContattoRubrica> contatti = query.list();
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
		return null;
	}

	public static List<ContattoRubrica> selectBy(String filter, String value) {
		try {
			Session session = MultiSessionManager.getSession();
			Query<ContattoRubrica> query = session
					.createQuery("SELECT c FROM ContattoRubrica as c WHERE c." + filter + " = '" + value + "'");
			List<ContattoRubrica> contatti = query.list();
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
		return null;
	}

	public static void insert(ContattoRubrica contatto) {
		try {
			Session session = MultiSessionManager.getSession();
			session.save(contatto);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	public static void insert(List<ContattoRubrica> contatti) {
		try {
			Session session = MultiSessionManager.getSession();
			for (ContattoRubrica contatto : contatti) {
				session.save(contatto);
				Transaction transaction = session.beginTransaction();
				transaction.commit();
			}
			MultiSessionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	public static void update(ContattoRubrica oldContatto, ContattoRubrica newContatto) {
//		//UPDATE
//		contatto.setCognome("Ronaldo");
//		contatto.setNome("Cristiano");		
//		
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);
	}

	public static void delete(ContattoRubrica contatto) {
		try {
			Session session = MultiSessionManager.getSession();
			session.remove(contatto);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}
	
	public static void delete(List<ContattoRubrica> contatti) {
		try {
			Session session = MultiSessionManager.getSession();
			for (ContattoRubrica contatto : contatti) {
				session.remove(contatto);
				Transaction transaction = session.beginTransaction();
				transaction.commit();
			}
			MultiSessionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	// non funzia
	public static void deleteBy(String filter, String value) {
		try {
			Session session = MultiSessionManager.getSession();
			session.createQuery("DELETE FROM ContattoRubrica WHERE " + filter + " = :" + filter).setParameter(filter, value);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	public static void main(String[] args) throws Exception {
		insert(ContattiManager.getContactList(new File(ContattiManager.rubricaDir)));
		//delete(selectBy("nome", "NOME"));
	}
}