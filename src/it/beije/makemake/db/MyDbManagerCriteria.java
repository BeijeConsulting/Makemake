package it.beije.makemake.db;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import it.beije.makemake.rubrica.ContattiManager;
import it.beije.makemake.rubrica.ContattoRubrica;

public class MyDbManagerCriteria {// gestione db con sessioni

	public static List<ContattoRubrica> selectAll() throws TooManySessionsException {

		try {
			Session s = MultiSessionManager.getSession();
			System.out.println(s);
			s.isOpen();
			Criteria c = s.createCriteria(ContattoRubrica.class);
			List<ContattoRubrica> result = c.list();
			for (int i = 0; i < result.size(); i++) {
				ContattoRubrica cont = result.get(i);
				System.out.print("Contatto -----> ");
				System.out.print("nome: " + cont.getNome() + " | ");
				System.out.print("cognome: " + cont.getCognome() + " | ");
				System.out.print("telefono: " + cont.getTelefono() + " | ");
				System.out.println("email: " + cont.getEmail());

			}
//			MultiSessionManager.closeSession(s);
			return result;

		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
			return null;
		}
	}

	public static List<ContattoRubrica> selectBy(String filter, String value) throws TooManySessionsException {

		try {
			Session s = MultiSessionManager.getSession();
			System.out.println(s);
			s.isOpen();
			Criteria c = s.createCriteria(ContattoRubrica.class);

			c.add(Restrictions.eq(filter, value));
			List<ContattoRubrica> result = c.list();
			for (int i = 0; i < result.size(); i++) {
				ContattoRubrica cont = result.get(i);
				System.out.print("Contatto -----> ");
				System.out.print("nome: " + cont.getNome() + " | ");
				System.out.print("cognome: " + cont.getCognome() + " | ");
				System.out.print("telefono: " + cont.getTelefono() + " | ");
				System.out.println("email: " + cont.getEmail());

			}
			MultiSessionManager.closeSession(s);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
			return null;
		}
	}

	public static void insert(ContattoRubrica cont) throws TooManySessionsException {

		try {
			Session s = MultiSessionManager.getSession();
			s.save(cont);
			Transaction transaction = s.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(s);
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

	public static List<ContattoRubrica> getContatto(ContattoRubrica contatto, Session session) {
		List<ContattoRubrica> contatti;
		Criteria criteria = session.createCriteria(ContattoRubrica.class);
		criteria.add(Restrictions.eqOrIsNull("nome", contatto.getNome()));
		criteria.add(Restrictions.eqOrIsNull("cognome", contatto.getCognome()));
		criteria.add(Restrictions.eqOrIsNull("telefono", contatto.getTelefono()));
		criteria.add(Restrictions.eqOrIsNull("email", contatto.getEmail()));
		contatti = criteria.list();
		return contatti;
	}

	public static void update(ContattoRubrica oldContatto, ContattoRubrica newContatto) {
		try {
			Session session = MultiSessionManager.getSession();
			ContattoRubrica oldDBContatto = getContatto(oldContatto, session).get(0);
			oldDBContatto.setNome(newContatto.getNome());
			oldDBContatto.setCognome(newContatto.getCognome());
			oldDBContatto.setTelefono(newContatto.getTelefono());
			oldDBContatto.setEmail(newContatto.getEmail());
			session.save(oldDBContatto);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(session);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
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

	public static void exportToCsv(File filename) throws Exception {
		List<ContattoRubrica> contatti = MyDbManagerCriteria.selectAll();
		try {
			filename=new File (ContattiManager.dest.getPath());
			ContattiManager.writeList(contatti, filename);
System.out.println("arriva qui");
		} catch (IOException e) {
			System.out.println("Errore nella scrittura del file");
			e.printStackTrace();
		}
	}
	
public static void main(String[] args) throws TooManySessionsException {
		ContattoRubrica contatt = new ContattoRubrica("Ronaldo", "cristiano", "467389032", "siiiium@mail.com");

		// selectBy("nome", "pierantonio2");
		insert(contatt);
		selectAll();
	}

}
