package it.beije.makemake.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.makemake.rubrica.Contatto;

public class JPAexample {

	public static void main(String[] args){
		
		EntityManager e = EntityManagerMan.getEntity();
		Contatto c = e.find(Contatto.class, 26);
		System.out.println(c);
		
		//Query JPQL
		String jpqlSelect = "SELECT c FROM Contatto as c";
		Query query = e.createQuery(jpqlSelect);
		List<Contatto> contatti = query.getResultList();

		for (Contatto contatto : contatti) {
			System.out.println("id : " + contatto.getId());
			System.out.println("name : " + contatto.getNome());
			System.out.println("surname : " + contatto.getCognome());
			System.out.println("telephone : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}
		
		
		//Transaction
		EntityTransaction entityTransaction = e.getTransaction();
		entityTransaction.begin();
		
		//INSERT
//		Contatto newContatto = new Contatto();
//		newContatto.setCognome("Viscomi");
//		newContatto.setNome("Filippo");
//		newContatto.setEmail("f.viscomi@beije.it");
//		System.out.println("contatto PRE : " + newContatto);
//		entityManager.persist(newContatto);
//		System.out.println("contatto POST : " + newContatto);
		
//		//UPDATE
//		c.setCognome("Zippo");
//		c.setTelefono("43214342");
//		entityManager.persist(c);
		
//		//DELETE
//		entityManager.remove(c);
		
		entityTransaction.commit();
//		entityTransaction.rollback();
		
		e.close();

	}

}
