package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class main{

	public static void main(String[] args) {
	//Session session= GestoreSessioni.getDBConnection();
Configuration configuration = new Configuration().configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Rossi'");
		List<Contatto> contatti = query.list();	//UPDATE
		Contatto contatto = null;

	contatto.setCognome("Staibano");
	contatto.setNome("Andrea");			
		System.out.println("contatto PRE : " + contatto);
	session.save(contatto);
	System.out.println("contatto POST : " + contatto);

		
	}
}
