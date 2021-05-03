package JPAEx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.Contatto;

public class DatabaseJPA {
	   private static DatabaseJPA dbObject;

	   private DatabaseJPA() {      
	   }

	   public static DatabaseJPA getInstance() {

	      // create object if it's not already created
	      if(dbObject == null) {
	         dbObject = new DatabaseJPA();
	         
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");	
	 		EntityManager entityManager = factory.createEntityManager();

	 		dbObject = (DatabaseJPA) entityManager;
	      }

	       // returns the singleton object
	       return dbObject;
	   }
}