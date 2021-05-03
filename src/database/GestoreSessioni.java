package database;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class GestoreSessioni {

	private GestoreSessioni() {

	}

	static Session session = null;

	public static Session getDBConnection() {

		if (session == null || (!(session.isOpen()))) {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");// SELECT * FROM rubrica
			List<Contatto> contatti = query.list();

			Contatto contatto = null;
			for (Contatto c : contatti) {
				System.out.println(c);
				contatto = c;
			}

			Transaction transaction = session.beginTransaction();
			transaction.commit();

			System.out.println(session.isOpen());

		}
		session.close();
		return session;

	}

}
