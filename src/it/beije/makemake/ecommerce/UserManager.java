package it.beije.makemake.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;

import rubrica.Contatto;
import rubrica.ListaContatti;


public class UserManager {
		private static JPASingleton instance;
		private static Scanner tastiera = new Scanner(System.in);
		private static List<User> utenti;
		

		public static void getUsers() {
			String jplSelect = "SELECT u FROM User as u";
			Query query = instance.getEntityManager().createQuery(jplSelect);
			List<User> utenti = query.getResultList();
			utenti.toString();
		}
		
		public static void insertUser(User utente) {
			EntityTransaction transaction = instance.getEntityManager().getTransaction();
			transaction.begin();
			instance.getEntityManager().persist(utente);
			transaction.commit();
		}
		
		public static List<User> dbToListaUtenti() {
			utenti = new ArrayList<>();
			String jplSelect = "SELECT c FROM Contatto as c";
			Query query = instance.getEntityManager().createQuery(jplSelect);
			List<User> utenti = query.getResultList();
			System.out.println(utenti);
			return utenti;
		}
		
		public static void listaToDb() {
			EntityTransaction entityTransaction = instance.getEntityManager().getTransaction();
			for(User u: utenti) {
				entityTransaction.begin();
				instance.getEntityManager().persist(u);
				entityTransaction.commit();
			}
		}
//		
//		public static void getProducts() {
//			String jplSelect = "SELECT order";
//			Query query = instance.getEntityManager().createQuery(jplSelect);
//			List<User> utenti = query.getResultList();
//			utenti.toString();
//		}
		
		
		public static void getOrderDetails() {
			
			String orderSelect = "SELECT o FROM Order as o ";
			String orderItemSelect = "SELECT i FROM OrderItem as i ";
			String userSelect = "SELECT u FROM User as u ";
			String productSelect = "SELECT p FROM Product as p";
			Query queryOrder = instance.getEntityManager().createQuery(orderSelect);
			Query queryOItem = instance.getEntityManager().createQuery(orderItemSelect);
			Query queryUser = instance.getEntityManager().createQuery(userSelect);
			Query queryProduct = instance.getEntityManager().createQuery(productSelect);

			List<User> user = queryUser.getResultList();
			List<Order> order = queryOrder.getResultList();
			List<OrderItem> orderItem = queryOItem.getResultList();
			List<Product> product = queryProduct.getResultList();

			for(Order o : order) {
				System.out.println("Id number"+o.getId());
				User u =instance.getEntityManager().find(User.class,o.getUserId());
				System.out.println("username : "+u.getUsername());
				for(OrderItem oi: orderItem) {
					if(o.getId().equals(oi.getOrderId())) {
						System.out.println("quantità: "+oi.getQuantity());
						Product p = instance.getEntityManager().find(Product.class, oi.getProductId());
					}
					
				}
			}

		}
		
		
		
}
