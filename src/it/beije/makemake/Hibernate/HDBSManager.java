package it.beije.makemake.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class HDBSManager {
	private static HDBSingleton newSingleton ;
	//static List<Contatto> contatti ;
	
	public static void main(String[] args) {
		
		newSingleton =  HDBSingleton.getHDBSingleton();
		
		
		System.out.println(select());
		
		insert(new Contatto("Antony","Shenouda","3333333","antony.shenouda@gmail.com"));
		//delete();
		//update();
		
	}
	
	public static List<Contatto> select() {
		Session mySession = newSingleton.getSession();
		
		Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		
		List<Contatto> contatti = myQuery.list();
		
			for(Contatto c : contatti)
				System.out.println(c);
		
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
	
	public static void update() {
		Session mySession = newSingleton.getSession();
	
		Scanner in = new Scanner(System.in);
		
		Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> tableContact = myQuery.list();
		//List<Contatto> tableContact = select();
		
		System.out.println("Choose the contact id you want to update");
		
		int id = Integer.parseInt(in.nextLine());
		System.out.println("Change the name ");
		String name = in.nextLine();
		System.out.println("Change the surname ");
		String surname = in.nextLine();
		
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
		in.close();

		mySession.close();

	}

	public static void delete() {
		Session mySession = newSingleton.getSession();
		Transaction transaction = mySession.beginTransaction();
		Scanner in = new Scanner(System.in);
		Contatto updCont = null;
		List<Contatto> tableContact = select();
		
		
		System.out.println("Choose the contact id you want to remove");
		
		int id = in.nextInt();
		
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
}
