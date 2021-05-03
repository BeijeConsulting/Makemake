package it.beije.makemake.db.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.makemake.rubrica.ContattoRubrica;

public class JpaManager {
	static Scanner in = new Scanner(System.in);

	public static void selectAll() {
		EntityManager entityManager = SingletonJpa.getInstance();

		String select = "SELECT c FROM ContattoRubrica as c";
		Query query = entityManager.createQuery(select);
		List<ContattoRubrica> contatti = query.getResultList();

		for (ContattoRubrica contatto : contatti) {
			System.out.println("id : " + contatto.getId());
			System.out.println("nome : " + contatto.getNome());
			System.out.println("cognome : " + contatto.getCognome());
			System.out.println("telefono : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}

	}

	public static void selectById() {
		EntityManager entityManager = SingletonJpa.getInstance();
		System.out.println("inserisci id: ");
		int id = in.nextInt();
		ContattoRubrica c = entityManager.find(ContattoRubrica.class, id);
		System.out.println(c);
	}

	public static ContattoRubrica selectByField(String value) {
		EntityManager entityManager = SingletonJpa.getInstance();

		String select = "SELECT c FROM ContattoRubrica as c";
		Query query = entityManager.createQuery(select);
		List<ContattoRubrica> contatti = query.getResultList();
		for (ContattoRubrica contatto : contatti) {

			if (contatto.getNome() != null && contatto.getNome().equalsIgnoreCase(value)
					|| contatto.getCognome() != null && contatto.getCognome().equalsIgnoreCase(value)
					|| contatto.getTelefono() != null && contatto.getTelefono().equalsIgnoreCase(value)
					|| contatto.getEmail() != null && contatto.getEmail().equalsIgnoreCase(value))

				return contatto;
		}
		return null;
	}

	public static void insert() {
		EntityManager entityManager = SingletonJpa.getInstance();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		ContattoRubrica newContatto = new ContattoRubrica();
		System.out.println("inserisci cognome: ");
		String cognome = in.nextLine();
		newContatto.setCognome(cognome);
		System.out.println("inserisci nome: ");
		String nome = in.nextLine();
		newContatto.setNome(nome);
		System.out.println("inserisci telefono: ");
		String telefono = in.nextLine();
		newContatto.setEmail(telefono);
		System.out.println("inserisci email: ");
		String email = in.nextLine();
		newContatto.setEmail(email);

		System.out.println("contatto PRE : " + newContatto);
		entityManager.persist(newContatto);
		System.out.println("contatto POST : " + newContatto);
		entityTransaction.commit();

		entityManager.close();

	}
	//da sistemare
	public static void remove(ContattoRubrica c) {
		EntityManager entityManager = SingletonJpa.getInstance();
			entityManager.remove(c);
	}
	public static ContattoRubrica update(ContattoRubrica c, String field, String value) {
		EntityManager entityManager = SingletonJpa.getInstance();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		switch (field.toLowerCase()) {
		case "nome":
			c.setNome(value);
			break;
		case "cognome":
			c.setCognome(value);
			break;
		case "telefno":
			c.setTelefono(value);
			break;
		case "email":
			c.setEmail(value);
			break;
		default:
			break;
		}
		
		entityTransaction.commit();

		entityManager.close();
		return c;
	}

	public static void main(String[] args) {
//		System.out.println("inserisci nome: ");
//		String n=in.nextLine();
//		System.out.println("inserisci cognome: ");
//		String c=in.nextLine();
//		System.out.println("inserisci telefono: ");
//		String t=in.nextLine();
//		System.out.println("inserisci email: ");
//		String m=in.nextLine();
//		ContattoRubrica cont=new ContattoRubrica(n ,c, t , m);
		System.out.println("inserisci campo da modificare");
		String campo = in.nextLine();
		System.out.println("inserisci un nuove valore");
		String valore = in.nextLine();
		// selectAll();
		// selectById();
		// insert();
		// selectByField(campo);
		System.out.println("quale contatto vuoi modificare?");
		update(selectByField(in.nextLine()), campo, valore);
		
	}
}