package it.beije.rubrica.campagnoli;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.RubricaCraiteria.AddressBook;
import it.beije.makemake.rubrica.Contatto;
import it.beije.rubrica.campagnoli.*;

public class GestoreRubrica {
	// STAMPA MENU______________________________________________________________________________________________________
	public static void menu() {
		System.out.println("[-------------Menù----------------]");
		System.out.println("[1)inserisci contatto             ]");
		System.out.println("[2)rimuovi contatto               ]");
		System.out.println("[3)mostra rubrica                 ]");
		System.out.println("[4)modifica contatto              ]");
		System.out.println("[0)esci                           ]");
		System.out.println("[---------------------------------]");
	}

	// SELETTORE OPERAZIONE______________________________________________________________________________________________________
	private static void valoreIngrsso(int option) {
		switch (option) {
		case 1:
			JPASingleton.getInstance();
			EntityManager entityManager1 = JPASingleton.getEntityManager();
			inserisciContatto(entityManager1);
			break;
		case 2:
			JPASingleton.getInstance();
			EntityManager entityManager2 = JPASingleton.getEntityManager();
			cancellaContatto(entityManager2);
			break;
		case 3:
			JPASingleton.getInstance();
			EntityManager entityManager3 = JPASingleton.getEntityManager();
			mostraRubrica(entityManager3);
			break;
		case 4:
			JPASingleton.getInstance();
			EntityManager entityManager4 = JPASingleton.getEntityManager();
			modificaContatto(entityManager4);
			break;
		case 5:
			break;

		}
	}
	// MODIFICA CONTATTO ______________________________________________________________________________________________________
	public static void modificaContatto(EntityManager entityManager) {
		
		Contatto c = entityManager.find(Contatto.class, 20);
		System.out.println(c);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			c.setNome("Gianluca");
			c.setCognome("Bertolasi");
			c.setTelefono("55673495");
			c.setEmail("g.bertolasi@gmail.com");
			entityManager.persist(c);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		
		
	}
	// INSERIMENTO CONTATTO ______________________________________________________________________________________________________
	public static void inserisciContatto(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		try {
			Contatto newContatto = new Contatto();
			newContatto.setCognome("campagnoli");
			newContatto.setNome("jacopo");
			newContatto.setEmail("j.campagnoli1@beije.it");
			System.out.println("contatto PRE : " + newContatto);
			entityManager.persist(newContatto);
			System.out.println("contatto POST : " + newContatto);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}

	

		entityManager.close();
	}
	// CANCELLA DA RUBRICA ______________________________________________________________________________________________________
	public static void cancellaContatto(EntityManager entityManager) {
		Contatto c = entityManager.find(Contatto.class, 26);
		System.out.println(c);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.remove(c);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}
	// MOSTRA RUBRICA ______________________________________________________________________________________________________
	public static void mostraRubrica(EntityManager entityManager) {
		String jpqlSelect = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Contatto> contatti = query.getResultList();

		for (Contatto contatto : contatti) {
			System.out.print("[CONTATTO] = ");
			System.out.print("Id : " + contatto.getId());
			System.out.print("   /   ");
			System.out.print("Nome : " + contatto.getNome());
			System.out.print("   /   ");
			System.out.print("Cognome : " + contatto.getCognome());
			System.out.print("   /   ");
			System.out.print("Telefono : " + contatto.getTelefono());
			System.out.print("   /   ");
			System.out.println("Email : " + contatto.getEmail());
			System.out.println("_______________________________________________________________________"
					+ "_________________________________________________________________________________________________________________");

		}
	}

	// MAIN ______________________________________________________________________________________________________
	public static void main(String[] args) {
		boolean flag= true;
		
		while(flag) {
		menu();
		
		System.out.println("Scegli l'operazione che vuoi eseguire");
		Scanner tastiera = new Scanner(System.in);
		int scelta = tastiera.nextInt();
		tastiera.nextLine();
		
		if (scelta == 0 ) {
			flag= false;
		}
		
		valoreIngrsso(scelta);

		}
	}
}
