package it.beije.makemake.database;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class HDBexample {
	
	public static void main(String[] args) {
		

		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(Contatto.class);
				//.addAnnotatedClass(Libri.class)

		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		System.out.println(session.isOpen());
		
		//Query HQL
		Query<Contatto> query = session.createQuery("SELECT c FROM ContattoRubrica as c");//SELECT * FROM rubrica
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Rossi'");
		List<Contatto> contatti = query.list();
		
		Contatto contatto = null;
		for (Contatto c : contatti) {
			System.out.println(c);
			contatto = c;
		}
		
		
		Transaction transaction = session.beginTransaction();

		//INSERT
//		Contatto newContatto = new Contatto();
//		//newContatto.setId(30);
//		newContatto.setCognome("Miglietta");
//		newContatto.setNome("Pierantonio2");
//		newContatto.setEmail("p.miglietta2@beije.it");
//		System.out.println("contatto PRE : " + newContatto);
//		session.save(newContatto);
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
		
		transaction.commit();
		//transaction.rollback();
		
		session.close();
	}

}
