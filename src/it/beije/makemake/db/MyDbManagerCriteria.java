package it.beije.makemake.db;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;

import it.beije.makemake.rubrica.ContattoRubrica;

public class MyDbManagerCriteria {// gestione db con sessioni

	public static List<ContattoRubrica> selectAll() throws TooManySessionsException {
		Session s = MultiSessionManager.getSession();
		System.out.println(s);
		s.isOpen();
		Criteria c = s.createCriteria(ContattoRubrica.class);
		List<ContattoRubrica> result = c.list();
		for (int i = 0; i < result.size(); i++) {
			ContattoRubrica cont = result.get(i);
			System.out.print("Contatto -----> ");
			System.out.print("nome: " + cont.getNome() + " | ");
			System.out.print("cognome: " + cont.getCognome() + " | ");
			System.out.print("telefono: " + cont.getTelefono() + " | ");
			System.out.println("email: " + cont.getEmail());

		}MultiSessionManager.closeSession(s);
		return result;
	}

	public static List<ContattoRubrica> selectBy(String filter, String value) throws TooManySessionsException {
		Session s = MultiSessionManager.getSession();
		System.out.println(s);
		s.isOpen();
		Criteria c = s.createCriteria(ContattoRubrica.class);
		
		c.add(Restrictions.eq(filter, value));
		List<ContattoRubrica> result= c.list();
	for (int i = 0; i < result.size(); i++) {
		ContattoRubrica cont = result.get(i);
		System.out.print("Contatto -----> ");
		System.out.print("nome: " + cont.getNome() + " | ");
		System.out.print("cognome: " + cont.getCognome() + " | ");
		System.out.print("telefono: " + cont.getTelefono() + " | ");
		System.out.println("email: " + cont.getEmail());

	}MultiSessionManager.closeSession(s);
	return result;
	
	}
	
	public static void insert(ContattoRubrica cont) throws TooManySessionsException {
//		Scanner in=new Scanner(System.in);
//		Session s = MultiSessionManager.getSession();
//		System.out.println(s);
//		s.isOpen();
//		Criteria c = s.createCriteria(ContattoRubrica.class);
//		 cont = new ContattoRubrica();
//		cont.setNome("Cristiano");
//		cont.setCognome("ronaldo");
//		cont.setTelefono("1234567890");
//		cont.setEmail("siuuum@mail.com");
//		
//	    System.out.println(c.list().add(cont));
//		
//		
		
		
		
//		System.out.prin("nome:  ");
//		String n=in.nextLine();
//		System.out.print("cognome: ");
//		String c=in.nextLine();
//		System.out.print("telefono: ");
//		String t=in.nextLine();
//		System.out.println("email: ");
//		String e=in.nextLine();
//
//		c.list.add()
		try {
			Session s = MultiSessionManager.getSession();
			s.save(cont);
			Transaction transaction = s.beginTransaction();
			transaction.commit();
			MultiSessionManager.closeSession(s);
		} catch (TooManySessionsException e) {
			System.out.println("Too many open sessions!");
		}
	
		
		
	}

	public static void main(String[] args) throws TooManySessionsException {
		ContattoRubrica contatt= new ContattoRubrica("Ronaldo", "cristiano", "467389032", "siiiium@mail.com");
		
		//selectBy("nome", "pierantonio2");
		insert(contatt);
		 selectAll();
	}

}
