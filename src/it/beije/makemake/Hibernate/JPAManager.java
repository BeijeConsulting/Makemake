package it.beije.makemake.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



public class JPAManager {

	private static JPASingleton manager = JPASingleton.getJPASingleton();
	
	public static void main(String[] args) {
		
		//System.out.println(select());
		
	
	}

	public static Contatto findContatto(int id) {
		EntityManager entityManager = manager.getEntityManager();
		Contatto c = entityManager.find(Contatto.class ,id);
		entityManager.close();
		return c;
	}
	
	public static List<Contatto> select(){
		EntityManager entityManager = manager.getEntityManager();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//creation of the query object, the attribute of the query will be modified with the details of the query 
		CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
		//is called to select Query Root
		Root<Contatto> from = criteriaQuery.from(Contatto.class);
		//Type of the query
		CriteriaQuery<Contatto> select = criteriaQuery.select(from);
		//is used to prepare a query for execution and specifying the type of the query result
		TypedQuery<Contatto> contat = entityManager.createQuery(select);
		
		List<Contatto> rubrica = contat.getResultList();
		entityManager.close();
		return rubrica;
		
	}
	
	public static void insert(Contatto contatto) {
		EntityManager entityManager = manager.getEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(contatto);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void search(String name, String surname) {
		EntityManager entityManager = manager.getEntityManager();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
		
		Root<Contatto> from = criteriaQuery.from(Contatto.class);
		
		Predicate predicateforName = criteriaBuilder.equal(from.get("nome"), name);
		Predicate predicateforSurname = criteriaBuilder.equal(from.get("cognome"),surname);
		Predicate finalPredicate = criteriaBuilder.and(predicateforName,predicateforSurname);
		
		criteriaQuery.where(finalPredicate);
		
		List<Contatto> contatto = entityManager.createQuery(criteriaQuery).getResultList();
		
		for(Contatto c : contatto) {
			System.out.println(c);
		}
		entityManager.close();
	}
	
	public static void update(int id,String name,String surname) {
		EntityManager entityManager = manager.getEntityManager();
		
		Contatto c = findContatto(id);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		c.setCognome(surname);
		c.setNome(name);
		
		entityManager.persist(c);
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void remove(int id) {
		Contatto c = findContatto(id);
		EntityManager entityManager = manager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(c);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
}
