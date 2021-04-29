package it.beije.makemake.esercizi.database;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class HDBManager {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Session s = SessionManager.getSession();
		
		
//		System.out.println(session.isOpen());
		
		//Query HQL
//		Query<Contatto> query = s.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Rossi'");
//		List<Contatto> contatti = query.list();
		
//		Contatto contatto = null;
//		for (Contatto c : contatti) {
//			System.out.println(c);
//			contatto = c;
//		}
		
		
//		Transaction transaction = session.beginTransaction();

		//INSERT
//		Contatto newContatto = new Contatto();
//		//newContatto.setId(30);
//		newContatto.setCognome("Miglietta");
//		newContatto.setNome("Pierantonio2");
//		newContatto.setEmail("p.miglietta2@beije.it");
//		System.out.println("contatto PRE : " + newContatto);
//		s.save(newContatto);
//		System.out.println("contatto POST : " + newContatto);

//		//UPDATE
//		contatto.setCognome("Staibano");
//		contatto.setNome("Andrea");		
//		
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);
		
//		//DELETE
//		session.remove(contatto);
		
		//throw new RuntimeException();
		
//		transaction.commit();
		//transaction.rollback();
		
		s.close();
	}

}
