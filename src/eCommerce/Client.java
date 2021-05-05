package eCommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Client {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");

	EntityManager entityManager = factory.createEntityManager();

	public User getUsers() {
		String jpqlSelect = "SELECT c FROM User as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<User> users = query.getResultList();

		for (User user : users) {
			System.out.println("id : " + user.getId());
			System.out.println("name : " + user.getName());
			System.out.println("username : " + user.getUsername());
			System.out.println("password : " + user.getPassword());
			System.out.println("surname: " + user.getSurname());

		}
		return null;
	}

	public Order getOrders() {
		String jpqlSelect = "SELECT c FROM Order as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Order> orders = query.getResultList();
		for (Order order : orders) {
			System.out.println("id : " + order.getId());
			System.out.println("data del rdine: " + order.getDate());
			System.out.println("stato del ordine: " + order.getStatus());
			System.out.println("utnete : " + order.getId_user());

		}
		return null;
	}

	public Order getProducts() {
		String jpqlSelect = "SELECT c FROM Product as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Product> products = query.getResultList();

		for (Product product : products) {
			System.out.println("id : " + product.getId());
			System.out.println("marca del ordine: " + product.getBrand());
			System.out.println("d'iscrizione : " + product.getDescription());
			System.out.println("foto del prodotto: " + product.getImage());
			System.out.println("prezzo del prodotto: " + product.getPrice());
			System.out.println("Quantita disbonibili " + product.getQuantity());
		}
		return null;
	}

}
