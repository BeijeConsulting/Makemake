package it.andrea.esercitazione.contatti.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.andrea.esercitazione.contatti.entity.Contatto;

public class HDBManager {
	public static List<Contatto> selectAll() {
		try {
			Session session = HDBConnectionManager.getSession();
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
			List<Contatto> contatti = query.list();
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			HDBConnectionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
		return null;
	}

	public static List<Contatto> selectBy(String filter, String value) {
		try {
			Session session = HDBConnectionManager.getSession();
			Query<Contatto> query = session
					.createQuery("SELECT c FROM Contatto as c WHERE c." + filter + " = '" + value + "'");
			List<Contatto> contatti = query.list();
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			HDBConnectionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
		return null;
	}

	public static void insert(Contatto contatto) {
		try {
			Session session = HDBConnectionManager.getSession();
			session.save(contatto);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			HDBConnectionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	public static void insert(List<Contatto> contatti) {
		try {
			Session session = HDBConnectionManager.getSession();
			for (Contatto contatto : contatti) {
				session.save(contatto);
				Transaction transaction = session.beginTransaction();
				transaction.commit();
			}
			HDBConnectionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	public static void update(Contatto oldContatto, Contatto newContatto) {
//		//UPDATE
//		contatto.setCognome("Staibano");
//		contatto.setNome("Andrea");		
//		
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);
	}

	public static void delete(Contatto contatto) {
		try {
			Session session = HDBConnectionManager.getSession();
			session.remove(contatto);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			HDBConnectionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}
	
	public static void delete(List<Contatto> contatti) {
		try {
			Session session = HDBConnectionManager.getSession();
			for (Contatto contatto : contatti) {
				session.remove(contatto);
				Transaction transaction = session.beginTransaction();
				transaction.commit();
			}
			HDBConnectionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	// TODO not working:
	public static void delete(String filter, String value) {
		try {
			Session session = HDBConnectionManager.getSession();
			session.createQuery("DELETE FROM Contatto WHERE " + filter + " = :" + filter).setParameter(filter, value);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			HDBConnectionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	}

	public static void main(String[] args) throws Exception {
//		insert(MyCsvManager.getContactList(new File(MyCsvManager.DEST_DIR)));
		delete(selectBy("nome", "NOME"));
	}
}
