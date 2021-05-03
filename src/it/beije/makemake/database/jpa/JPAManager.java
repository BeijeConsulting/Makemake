package it.beije.makemake.database.jpa;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import it.beije.makemake.file.rubrica.Contatto;

public class JPAManager {
	private static JPASingleton instance = JPASingleton.getInstance();
	
	public static void main(String ...args) {
		
	}

	@SuppressWarnings("unchecked")
	public static List<Contatto> selectAll(){
		EntityManager entityManager = instance.getEntityManager();
		
		String jpqlQuery = "SELECT c FROM Contatto AS c";
		Query query = entityManager.createQuery(jpqlQuery);
		List<Contatto> contactList = query.getResultList();
		
		entityManager.close();
		
		return contactList;
	}
	
	@SuppressWarnings("unchecked")
	public static void delete() {
		//Session mySession = newSingleton.getSession();
		EntityManager entityManager = instance.getEntityManager();
		Scanner in = new Scanner(System.in);

		
		//Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		String jpqlQuery = "SELECT c FROM Contatto AS c";
		Query query = entityManager.createQuery(jpqlQuery);
		List<Contatto> contactList = query.getResultList();
		
		for(Contatto c : contactList) {
			System.out.println(c);
		}
		
		System.out.println("Choose the contact id you want to remove!");
		String id = in.nextLine();
		int input = Integer.parseInt(id);
		
		for(Contatto c : contactList) {
			if(c.getId() == input) {
				//Transaction transaction = mySession.beginTransaction();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				//mySession.remove(c);
				entityManager.remove(c);
				//transaction.commit();
				entityTransaction.commit();
				break;
			}
		}
		
		//mySession.close();
		entityManager.close();
		in.close();

	}
	
	public static void insert(Contatto contact) {
		//Session mySession = newSingleton.getSession();
		EntityManager entityManager = instance.getEntityManager();
		//Transaction transaction = mySession.beginTransaction();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		//mySession.save(contatto);
		entityManager.persist(contact);
		
		//transaction.commit();
		entityTransaction.commit();
		
		//mySession.close();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void update() {
		//Session mySession = newSingleton.getSession();
		EntityManager entityManager = instance.getEntityManager();
		Scanner in = new Scanner(System.in);

		
		//Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		String jpqlQuery = "SELECT c FROM Contatto AS c";
		Query query = entityManager.createQuery(jpqlQuery);
		List<Contatto> contactList = query.getResultList();
		
		for(Contatto c : contactList) {
			System.out.println(c);
		}
		
		System.out.println("Choose the contact id you want to update!");
		String id = in.nextLine();
		int input = Integer.parseInt(id);
		System.out.println("Change the name");
		String name = in.nextLine();
		System.out.println("Change the surname");
		String surname = in.nextLine();
		
		
		for(Contatto c : contactList) {
			if(c.getId() == input) {
				c.setNome(name);
				c.setCognome(surname);
				
				//Transaction transaction = mySession.beginTransaction();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				
				//mySession.save(c);
				entityManager.persist(c);
				//transaction.commit();
				entityTransaction.commit();
				break;
			}
		}
	
		//mySession.close();
		entityManager.close();
		in.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
