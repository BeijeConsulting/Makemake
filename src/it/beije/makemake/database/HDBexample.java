package it.beije.makemake.database;


import it.beije.makemake.file.rubrica.Contatto;



import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class HDBexample {
	private static HDBSingleton newSingleton = HDBSingleton.getHDBSingleton();;

	public static void main(String[] args) {
		

//		Configuration configuration = new Configuration().configure()
//				.addAnnotatedClass(Contatto.class);
//				//.addAnnotatedClass(Libri.class)

		
		
	}

	public static List<Contatto> select() {
		Session mySession = newSingleton.getSession();
		
		Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		
		List<Contatto> contactList = myQuery.list();
	
		mySession.close();
		
		return contactList;
	}
	
	public static void insert(Contatto contatto) {
		Session mySession = newSingleton.getSession();
		Transaction transaction = mySession.beginTransaction();
		
		mySession.save(contatto);
		
		transaction.commit();
		
		mySession.close();
	}

	public static void delete() {
		Session mySession = newSingleton.getSession();
		Scanner in = new Scanner(System.in);

		
		List<Contatto> tableContact = select();
		for(Contatto c : tableContact) {
			System.out.println(c);
		}
		
		System.out.println("Choose the contact id you want to remove!");
		String id = in.nextLine();
		int input = Integer.parseInt(id);
		
		for(Contatto c : tableContact) {
			if(c.getId() == input) {
				Transaction transaction = mySession.beginTransaction();
				mySession.remove(c);
				transaction.commit();
				break;
			}
		}
		
		mySession.close();
	
	}
	
	public static void update() {
		Session mySession = newSingleton.getSession();
		Scanner in = new Scanner(System.in);

		
		Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		
		List<Contatto> tableContact = myQuery.list();
		
		for(Contatto c : tableContact) {
			System.out.println(c);
		}
		
		System.out.println("Choose the contact id you want to update!");
		String id = in.nextLine();
		int input = Integer.parseInt(id);
		System.out.println("Change the name");
		String name = in.nextLine();
		System.out.println("Change the surname");
		String surname = in.nextLine();
		
		
		for(Contatto c : tableContact) {
			if(c.getId() == input) {
				c.setNome(name);
				c.setCognome(surname);
				
				Transaction transaction = mySession.beginTransaction();
				mySession.save(c);
				transaction.commit();
				break;
			}
		}
	
		mySession.close();
	
	}
}
