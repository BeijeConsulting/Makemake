package it.beije.makemake.esercizi.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.beije.makemake.rubrica.ContattoAnnotation;

public class JPAManager {
	
	private static JPASingleton manager = JPASingleton.getJPASingleton();
	public static void main (String...args) {
		
		

	}

	public static ContattoAnnotation searchContatto( int id) {
		EntityManager entityManager = manager.getEntityManager();
		ContattoAnnotation contatto = entityManager.find(ContattoAnnotation.class, id);
		
	return contatto;	
	}

	public static List<ContattoAnnotation> select(){
		EntityManager entityManager = manager.getEntityManager();
	
		CriteriaBuilder criteria_builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<ContattoAnnotation> criteria_query = criteria_builder.createQuery(ContattoAnnotation.class);
		
		Root<ContattoAnnotation> from = criteria_query.from(ContattoAnnotation.class);
		
		CriteriaQuery<ContattoAnnotation> select = criteria_query.select(from);
		
		TypedQuery<ContattoAnnotation> contatto = entityManager.createQuery(select);
		
		List<ContattoAnnotation> rubrica = contatto.getResultList();
		
		return rubrica;
		
	}

	public static void insert(ContattoAnnotation contatto) {
		EntityManager entityManager = manager.getEntityManager();
		
		EntityTransaction entityTransaction  = entityManager.getTransaction();
	}
	
	public static void update(int id, String nome, String cognome) {
		
		EntityManager entityManager = manager.getEntityManager();
		
		ContattoAnnotation contatto = searchContatto(id);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		
		entityManager.persist(contatto);
		entityTransaction.commit();
//		entityManager.close();
		
		
	}

}
