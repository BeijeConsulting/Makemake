package it.beije.makemake.database;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.ContattoRubrica;

import it.beije.makemake.rubrica.ContattoRubrica;


public class HDBmanager {
	public static void main(String[] args) throws Exception {
		SessionManager.getSessionManager();
		Session s = SessionManager.getSession();
		
		System.out.println("vuoi modificare lo Database ? S/N");
		Scanner tastiera = new Scanner(System.in);
		
		
		boolean flag= true;
		
		while(flag) {
		String t = tastiera.nextLine();
		switch(t.toUpperCase()) {
		default:
			System.out.println("ERRORE!!!Inserisci SI/NO: ");
			
			break;
		case "NO" :
			SessionManager.closeSession(s);
			flag=false;
			break;
			
		case "SI" :
			System.out.println(s);
			flag=false;
			
			Query<ContattoRubrica> query = s.createQuery("SELECT c FROM ContattoRubrica as c");//SELECT * FROM rubrica
			
			List<ContattoRubrica> contatti = query.list();
			
			ContattoRubrica contatto = null;
			for (ContattoRubrica c : contatti) {
				System.out.println(c);
				contatto = c;
			}
			
			
			Transaction transaction = s.beginTransaction();
			transaction.commit();
			break;
		
		}
		}
	
	
	}
}
