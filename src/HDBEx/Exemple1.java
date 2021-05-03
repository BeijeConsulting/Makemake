package HDBEx;
import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class Exemple1 {
	
	
public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(Contatto.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		System.out.println(session.isOpen());
		
		
		//Query HQL
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome = 'Rossi'");
		List<Contatto> contatti = query.list();
		
		
		Contatto contatto = null;
		for (Contatto c : contatti) {
			System.out.println(c);
			contatto = c;
		}
		
		
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		//transaction.rollback();		
		session.close();


}
}
