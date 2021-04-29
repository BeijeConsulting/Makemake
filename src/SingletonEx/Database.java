package SingletonEx;

import java.sql.Connection;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.Contatto;

class Database {
	   private static Database dbObject;

	   private Database() {      
	   }

	   public static Database getInstance() {

	      // create object if it's not already created
	      if(dbObject == null) {
	         dbObject = new Database();
	         Configuration configuration = new Configuration().configure()
	 				.addAnnotatedClass(Contatto.class);
	 				//.addAnnotatedClass(Libri.class)
	 		
	 		SessionFactory sessionFactory = configuration.buildSessionFactory();
	 		
	 		Session session = sessionFactory.openSession();
	 		dbObject = (Database) session;
	      }

	       // returns the singleton object
	       return dbObject;
	   }
}