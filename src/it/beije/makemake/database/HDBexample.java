package it.beije.makemake.database;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import it.beije.makemake.rubrica.Contatto;
import it.beije.makemake.rubrica.GestisciRubrica;

public class HDBexample {

	public static void insert(Session session, Contatto c) {
		session.save(c);
	}
	public static void insertall(Session session, List<Contatto> contatti) {
		for(Contatto c: contatti)
			session.save(c);
	}

	public static void update(Session session, Contatto c) {
		
//		//UPDATE
//		contatto.setCognome("Staibano");
//		contatto.setNome("Andrea");		
	
		
	}

	public static void delete(Session session, Contatto c) {
		session.remove(c);
	}

	public static void selectAll(Session session) {
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");// SELECT * FROM rubrica
		List<Contatto> contatti = query.list();
		for(Contatto c: contatti)
			System.out.println(c);
	}

	public static void selectContatc(Session session, Contatto c) {
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = '" + c.getCognome() + "'AND nome ='"+c.getNome()+"' AND email ='" + c.getEmail() + "'AND telefono ='" + c.getTelefono() + "' ");
		List<Contatto> contatti = query.list();
		for(Contatto con: contatti)
			System.out.println(con);
	}
	
	public static void main(String[] args) throws Exception {

		Session session = SessionManager.getSession();
		selectAll(session);
		//selectContatc(session, GestisciRubrica.leggiContatto(new Scanner(System.in)));
		delete(session, GestisciRubrica.leggiContatto(new Scanner(System.in)));
		//insert(session, GestisciRubrica.leggiContatto(new Scanner(System.in)));
	
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		// transaction.rollback();

		SessionManager.close(session);
	}

}
