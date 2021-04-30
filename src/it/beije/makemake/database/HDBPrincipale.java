package it.beije.makemake.database;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;


import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;

public class HDBPrincipale {

	private static HDBSingleton newSingleton;

	public static void main(String[] args) {
		newSingleton = HDBSingleton.getHDBSingleton();
		System.out.println(select());
		update();
		delete();
	}

	public static List<Contatto> select() {
		Session mySession = newSingleton.getSession();
		Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = myQuery.list();
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
		Query<Contatto> myQuery = mySession.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = myQuery.list();
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Insert contact id to update");
		int id = tastiera.nextInt();
		tastiera.nextLine();
		System.out.println("nuovo nome: ");
		String nome = tastiera.nextLine();
		System.out.println("nuovo cognome: ");
		String cognome = tastiera.nextLine();
		for (Contatto c : contatti) {
			if (c.getId() == id) {
				c.setNome(nome);
				c.setCognome(cognome);
				Transaction transaction = mySession.beginTransaction();
				mySession.save(c);
				transaction.commit();
			}
		}
		mySession.close();

	}

	public static void delete() {
		Session mySession = newSingleton.getSession();
		List<Contatto> contatti = select();
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Insert contact id to remove");
		int id = tastiera.nextInt();
		tastiera.nextLine();

		for (Contatto c : contatti) {
			if (c.getId() == id) {
				Transaction transaction = mySession.beginTransaction();
				mySession.remove(c);
				transaction.commit();
			}
		}
		mySession.close();

	}

	public static void selectWithCriteria() {
		Session session = newSingleton.getSession();
		Query<Contatto> query = session.createQuery("Select nome From ");
	}


}
