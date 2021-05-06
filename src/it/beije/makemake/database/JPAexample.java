package it.beije.makemake.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.OrderItem;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.rubrica.Contatto;

public class JPAexample {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");
		
		EntityManager entityManager = factory.createEntityManager();
	
//		
//		Contatto c = entityManager.find(Contatto.class, 26);
//		System.out.println(c);
		
//		//Query JPQL
//		String jpqlSelect = "SELECT c FROM Contatto as c";
//		Query query = entityManager.createQuery(jpqlSelect);
//		List<Contatto> contatti = query.getResultList();
//
//		for (Contatto contatto : contatti) {
//			System.out.println("id : " + contatto.getId());
//			System.out.println("name : " + contatto.getNome());
//			System.out.println("surname : " + contatto.getCognome());
//			System.out.println("telephone : " + contatto.getTelefono());
//			System.out.println("email : " + contatto.getEmail());
//		}
		
//		//Query JPQL
//		String jpqlSelect = "SELECT o FROM Order as o";
//		Query query = entityManager.createQuery(jpqlSelect);
//		List<Order> orders = query.getResultList();
//
//		for (Order o : orders) {
//			System.out.println("id : " + o.getId());
//		}
		//Query JPQL
		String jpqlSelect = "SELECT u FROM User as u";
		Query query = entityManager.createQuery(jpqlSelect);
		List<User> users = query.getResultList();

		for (User user : users) {
			System.out.println(user);
			for (Order order : user.getOrders()) {
				System.out.println(order);
			}
		}
		String jpqlSelect1 = "SELECT u FROM Order as u";
		Query query1 = entityManager.createQuery(jpqlSelect1);
		List<Order> orders = query1.getResultList();
		System.out.println("\n=========================================================================================================\n");
		
		for (Order order : orders) {
			System.out.println(order);
			for (OrderItem orderitem : order.getOrdersItem()) {
				System.out.println(orderitem);
			}
			System.out.println("\n........................................................................\n");
		}
		
		
		//Transaction
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
//		
//		//INSERT
//		Contatto newContatto = new Contatto();
//		newContatto.setCognome("Viscomi");
//		newContatto.setNome("Filippo");
//		newContatto.setEmail("f.viscomi@beije.it");
//		System.out.println("contatto PRE : " + newContatto);
//		entityManager.persist(newContatto);
//		System.out.println("contatto POST : " + newContatto);
		
//		//UPDATE
//		c.setCognome("GIOVANNI");
//		c.setTelefono("43214342");
//		entityManager.persist(c);
		
//		//DELETE
//		entityManager.remove(c);
		
		entityTransaction.commit();
//		entityTransaction.rollback();
		
		entityManager.close();

	}

}
