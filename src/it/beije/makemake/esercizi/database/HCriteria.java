package it.beije.makemake.esercizi.database;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import it.beije.makemake.esercizi.database.SessionManager;
import it.beije.makemake.rubrica.ContattoAnnotation;
public class HCriteria {
	public static void main(String[] args) throws Exception {
		
		Session session = SessionManager.getSession();
		//criteria.add(Restrictions.eq("nome", "carlo maria"));
		//criteria.add(Restrictions.gt("id", 12)); //greater than = GT
		
		
		boolean flag =true;
		int scelta;
		Scanner tastiera = new Scanner(System.in);
		
		while( flag) {
			System.out.println("Scegli cosa vuoi fare:");
			System.out.println("1)Aggiungi Contatto");
			System.out.println("2)Rimuovi Contatto");
			System.out.println("3)Stampa Contatti");
			System.out.println("4)ESCI");
			scelta= tastiera.nextInt();
				
				
				switch (scelta) {
				case 1: // Aggiungi
					addContact(HDBManager.leggiContatto(), session);
					
					break;
				case 2: // Rimuovi
					deleteContact(new ContattoAnnotation("Zippo","Andrea","789569879","mia@email.it"),session);
					
					break;
				case 3:// mostra tutti i contatti
					selectAll(session);
					break;
				case 4:// mostra tutti i contatti
					System.out.println("FINE");
					flag= false;
					break;
				default:
					System.out.println("Hai inserito un numero inesistente!");
				}
			} 
			
		}
		
		
		
		
		
		
		
		
	
	//mostra tutti i contatti
	public static List<ContattoAnnotation> selectAll(Session session) throws Exception {
		
		Criteria criteria = session.createCriteria(ContattoAnnotation.class);
		
		List<ContattoAnnotation> contatti = criteria.list();
		
		for(ContattoAnnotation c : contatti)
			System.out.println(c);
		return contatti;
	}
	
	public static List<ContattoAnnotation> selectContact(ContattoAnnotation c,Session session) throws Exception {
		
		Criteria criteria = session.createCriteria(ContattoAnnotation.class);
		criteria.add(Restrictions.eq("cognnome", c.getCognome())).add(Restrictions.eq("nome", c.getNome())).add(Restrictions.eq("email", c.getEmail())).add(Restrictions.eq("telefono", c.getTelefono()));
		List<ContattoAnnotation> contatti = criteria.list();
//		
//		for(Contatto c1 : contatti)
//			System.out.println(c1);
		
		return contatti;
		
	}
	public static void deleteContact(ContattoAnnotation c, Session session) throws Exception {
		
		
		List<ContattoAnnotation> contatti = selectAll(session);
		ContattoAnnotation contatto = null;
		for (ContattoAnnotation c1 : contatti) {
			if(c1.equals(c)) {
				Transaction transaction = session.beginTransaction();
				session.delete(c1);
				transaction.commit();
				System.out.println("I campi selezionai sono stati eliminati.");
			}
			
		}
		
		
	
		
		
		
		
	}
	
	public static void addContact(ContattoAnnotation c,Session session) throws Exception {
		Transaction transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		
	}
}