package it.andrea.esercitazione.contatti.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import it.andrea.esercitazione.contatti.entity.Contatto;

public class HDBManager {
	public static List<Contatto> selectAll() {
		List<Contatto> contatti;
		try {
			Session session = HDBConnectionManager.getSession();
			Criteria criteria = session.createCriteria(Contatto.class);
			contatti = criteria.list();
//			Transaction transaction = session.beginTransaction();
//			transaction.commit();
			HDBConnectionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
			return null;
		}
	}

	public static List<Contatto> selectBy(String filter, String value) {
		List<Contatto> contatti;
		try {
			Session session = HDBConnectionManager.getSession();
			Criteria criteria = session.createCriteria(Contatto.class);
			criteria.add(Restrictions.eq(filter, value));
			contatti = criteria.list();
//			Transaction transaction = session.beginTransaction();
//			transaction.commit();
			HDBConnectionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
			return null;
		}
	}

	/**
	 * Controlla se il contatto dato come argomento è presente nella tabella,
	 * restituendo una lista con tutte le occorrenze.
	 * 
	 * @param contatto il contatto da cercare nella tabella
	 * @return List<Contatto>
	 */
	public static List<Contatto> getContattiByFullContatto(Contatto contatto) {
		List<Contatto> contatti;
		try {
			Session session = HDBConnectionManager.getSession();
			Criteria criteria = session.createCriteria(Contatto.class);
			criteria.add(Restrictions.eqOrIsNull("nome", contatto.getNome()));
			criteria.add(Restrictions.eqOrIsNull("cognome", contatto.getCognome()));
			criteria.add(Restrictions.eqOrIsNull("telefono", contatto.getTelefono()));
			criteria.add(Restrictions.eqOrIsNull("email", contatto.getEmail()));
			contatti = criteria.list();
//			Transaction transaction = session.beginTransaction();
//			transaction.commit();
			HDBConnectionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
			return null;
		}
	}

	/**
	 * Controlla se il contatto dato come argomento è presente nella tabella,
	 * restituendo una lista con tutte le occorrenze. A differenza di
	 * getContattiByFullContatto(Contatto contatto), questo utilizza la stessa
	 * sessione del metodo chiamante.
	 * 
	 * @param contatto il contatto da cercare nella tabella
	 * @return List<Contatto>
	 */
	private static List<Contatto> getContattiByFullContatto(Contatto contatto, Session session) {
		List<Contatto> contatti;
		Criteria criteria = session.createCriteria(Contatto.class);
		criteria.add(Restrictions.eqOrIsNull("nome", contatto.getNome()));
		criteria.add(Restrictions.eqOrIsNull("cognome", contatto.getCognome()));
		criteria.add(Restrictions.eqOrIsNull("telefono", contatto.getTelefono()));
		criteria.add(Restrictions.eqOrIsNull("email", contatto.getEmail()));
		contatti = criteria.list();
		return contatti;
	}

	public static List<Contatto> getContattiByMask(Contatto mask) {
		List<Contatto> contatti;
		try {
			Session session = HDBConnectionManager.getSession();
			Criteria criteria = session.createCriteria(Contatto.class);
			if (mask.getNome() != null && !mask.getNome().trim().equals("")) {
				criteria.add(Restrictions.eqOrIsNull("nome", mask.getNome()));
			}
			if (mask.getCognome() != null && !mask.getCognome().trim().equals("")) {
				criteria.add(Restrictions.eqOrIsNull("cognome", mask.getCognome()));
			}
			if (mask.getTelefono() != null && !mask.getTelefono().trim().equals("")) {
				criteria.add(Restrictions.eqOrIsNull("telefono", mask.getTelefono()));
			}
			if (mask.getEmail() != null && !mask.getEmail().trim().equals("")) {
				criteria.add(Restrictions.eqOrIsNull("email", mask.getEmail()));
			}
			contatti = criteria.list();
//			Transaction transaction = session.beginTransaction();
//			transaction.commit();
			HDBConnectionManager.closeSession(session);
			return contatti;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
			return null;
		}
	}

	public static boolean tableContains(Contatto contatto) {
		if (getContattiByFullContatto(contatto).size() >= 1) {
			return true;
		}
		return false;
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
		try {
			Session session = HDBConnectionManager.getSession();
			Contatto oldDBContatto = getContattiByFullContatto(oldContatto, session).get(0);
			oldDBContatto.setNome(newContatto.getNome());
			oldDBContatto.setCognome(newContatto.getCognome());
			oldDBContatto.setTelefono(newContatto.getTelefono());
			oldDBContatto.setEmail(newContatto.getEmail());
			session.save(oldDBContatto);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			HDBConnectionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
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
}
