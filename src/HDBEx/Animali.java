package HDBEx;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Animali {
	
public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(Animal.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		System.out.println(session.isOpen());
				
		//Query HQL
		//Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		Query<Animal> query = session.createQuery("SELECT c FROM Animal as c WHERE habitat = 'mare'");
		List<Animal> animali = query.list();
				
		Animal animal = null;
		for (Animal c : animali) {
			System.out.println(c);
			animal = c;
		}
		
		Transaction transaction = session.beginTransaction();	
		transaction.commit();
		//transaction.rollback();		
		session.close();
}
}
