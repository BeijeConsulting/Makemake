package it.beije.makemake.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import it.beije.makemake.Hibernate.Contatto;

public class HDBSManager {
	private static HDBSingleton newSingleton = HDBSingleton.getHDBSingleton();
	//static List<Contatto> contatti ;
	
	public static void main(String[] args) {
		
		//newSingleton =  HDBSingleton.getHDBSingleton();
		
		
		//System.out.println(select());
		select();
		//listSearch("Pierantonio");
		//insert(new Contatto("Antony","Shenouda","3333333","antony.shenouda@gmail.com"));
		//delete();
		//update();
	
	}
	
	public static List<Contatto> select() {
		Session mySession = newSingleton.getSession();
		
		Criteria cr = mySession.createCriteria(Contatto.class);
		
		
		//Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		//List<Contatto> contatti = myQuery.list();
		List<Contatto> contatti = cr.list();
		
		
			/*for(Contatto c : contatti)
				System.out.println(c.toString());*/
		
		mySession.close();
		
		return contatti;
	}
	
	public static void insert(Contatto contatto) {
		Session mySession = newSingleton.getSession();
		
		Transaction transaction = mySession.beginTransaction();
		
		mySession.save(contatto);
		
		transaction.commit();
		mySession.close();
	}
	
	public static void update(int id , String name, String surname) {
		Session mySession = newSingleton.getSession();
	
		Scanner in = new Scanner(System.in);
		
		Criteria cr = mySession.createCriteria(Contatto.class);
		
		
		//Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		
		List<Contatto> tableContact = cr.list();
		
		
		
		for(Contatto c : tableContact) {
			if (c.getId() == id){
				c.setNome(name);
				c.setCognome(surname);	
				Transaction transaction = mySession.beginTransaction();
				transaction.commit();
				mySession.save(c);

				break;
			}		
		}
		

		mySession.close();

	}

	public static void delete(int id) {
		Session mySession = newSingleton.getSession();
		Transaction transaction = mySession.beginTransaction();
		
		Contatto updCont = null;
		List<Contatto> tableContact = select();
		
		
		
		for(Contatto c : tableContact) {
			if (c.getId() == id){
				updCont = c;
				break;
			}
		}
		
		mySession.remove(updCont);
		transaction.commit();

		mySession.close();

	}
	
	public static void listSearch(String search,String cognome) {
		Session mySession = newSingleton.getSession();
		Transaction tx = null;
		
		try {
			tx = mySession.beginTransaction();
			Criteria cr = mySession.createCriteria(Contatto.class);
			//System.out.println("Sono qui");
			
			cr.add(Restrictions.eq("nome", search)).add(Restrictions.eq("cognome", cognome));
			List<Contatto> contatti = cr.list();
			
			
		
			for(Contatto c : contatti) {
				System.out.println("[Nome : " + c.getNome());
				System.out.println("Cognome : " + c.getCognome());
				System.out.println("Telefono : " + c.getTelefono());
				System.out.println("Id : " + c.getId() + " ] ");
			}
			tx.commit();
		}catch(HibernateException e) {
			
			if(tx!= null) tx.rollback();
			e.printStackTrace();
			
		}finally {
			
			mySession.close();
			
		}
	}
	
	
}
