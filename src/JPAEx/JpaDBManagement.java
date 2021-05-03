package JPAEx;

import java.util.List;
import java.util.Scanner;
import javax.persistence.criteria.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import HDBEx.DbManagement;
import it.beije.makemake.rubrica.Contatto;

public class JpaDBManagement {
	@SuppressWarnings("deprecation")
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");	
	static Scanner x = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		
		boolean exit_pool = true;
	
		CICLO: while(exit_pool) {		
			System.out.println("Benvenuto!: ");

			System.out.println("Scegli un'opzione dal nostro menù "
			+ "o digita 'exit' per uscire");
			System.out.println("-----------Menù----------");
			System.out.println("Digita '1' per stampare il DB su PC");
			System.out.println("Digita '2' per aggiungere al DB una lista di "
			+ "nuovi contatti");
			System.out.println("Digita '4' per scaricare il contenuto di un DB"
			+ " in un file xml sul PC");
			System.out.println("Digita '5' per rimuovere un contatto dal DB");
			System.out.println("Digita '6' per stampare il totale dei contatti");
			System.out.println("Digita '7' per cercare un contatto");
			System.out.println("Digita 'exit' per uscire                   ");
		
		switch(x.nextLine()) {
		
		case "1":
			//stampo il contenuto dell'intero DB
			JpaDBManagement.selectAll();	
			break;
		case "2":
			//aggiungo a DB una lista di nuovi contatti
			break;
		case "3":
			//salvo contenuto del db in csv
			break;
		case "4":
			//salvo contenuto del db in xml
			break;
		case "5":
			break;
		case "6":
			//conto e stampo il n di contatti
			break;
		case "7":
			//Ricerca di contatto in rubrica
			JpaDBManagement.findContact();
			break;			
		}
		}
	}
	

	 
	
	private static void selectAll() {	
		EntityManager entityManager = factory.createEntityManager();
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
		Root<Contatto> c = q.from(Contatto.class);
		CriteriaQuery<Contatto> select = q.select(c);
		TypedQuery<Contatto> contatto = entityManager.createQuery(select);
		List<Contatto> contatti = contatto.getResultList();
		
		for (Contatto contat : contatti) {
			System.out.println("id : " + contat.getId());
			System.out.println("name : " + contat.getNome());
			System.out.println("surname : " + contat.getCognome());
			System.out.println("telephone : " + contat.getTelefono());
			System.out.println("email : " + contat.getEmail());
		}	
		//Transaction
		entityTransaction.commit();
		entityManager.close();
	}

	private static void findContact() {
		   try {
			    EntityManager entityManager = factory.createEntityManager();
				CriteriaBuilder cb = entityManager.getCriteriaBuilder();
				
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();

				CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
				Root<Contatto> c = q.from(Contatto.class);
				System.out.println("Inserisci Cognome: ");
				String sur = x.nextLine();
				Predicate predicateForSurname = cb.equal(c.get("cognome"), sur);
				System.out.println("Inserisci Nome: ");
				String nm = x.nextLine();
				Predicate predicateForName = cb.equal(c.get("nome"), nm);
				Predicate predicateForTot =cb.and(predicateForSurname,  predicateForName);
				q.where(predicateForTot);
				List<Contatto> contatti = entityManager.createQuery(q).getResultList();
				for (Contatto contat : contatti) {
					System.out.println("id : " + contat.getId());
					System.out.println("name : " + contat.getNome());
					System.out.println("surname : " + contat.getCognome());
					System.out.println("telephone : " + contat.getTelefono());
					System.out.println("email : " + contat.getEmail());
				}	
				
				//Transaction
				entityTransaction.commit();		
				entityManager.close(); 
		   } finally {
		   }	
	}
}
