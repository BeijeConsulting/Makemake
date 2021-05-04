package it.beije.makemake.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.beije.makemake.database.EntityManagerMan;

public class GestoreEcommerce {

	public static void main(String[] args) throws Exception {
		EntityManager e = EntityManagerMan.getEntity();

		Scanner s = new Scanner(System.in);
		// selectUsers(e);
		// selectProduct(e);
		// selectOrderItem(e);
		// selectOrder(e);

		System.out.println("Inserisci l'id dell'ordine di cui vuoi informazioni");
		int info = s.nextInt();
		orderDetails(e, info);

	}

	public static List<User> selectUsers(EntityManager entityManager) throws Exception {

		String jpqlSelect = "SELECT c FROM User as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<User> Users = query.getResultList();

		for (User c : Users) {
			System.out.println(c);
		}
		return Users;

	}

	public static List<Product> selectProduct(EntityManager entityManager) throws Exception {

		String jpqlSelect = "SELECT c FROM Product as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Product> Product = query.getResultList();

		for (Product c : Product) {
			System.out.println(c);
		}
		return Product;

	}

	public static List<OrderItem> selectOrderItem(EntityManager entityManager) throws Exception {

		String jpqlSelect = "SELECT c FROM OrderItem as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<OrderItem> OrderItem = query.getResultList();

		for (OrderItem c : OrderItem) {
			System.out.println(c);
		}
		return OrderItem;

	}

	public static List<Order> selectOrder(EntityManager entityManager) throws Exception {

		String jpqlSelect = "SELECT c FROM Order as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Order> Order = query.getResultList();

		for (Order c : Order) {
			System.out.println(c);
		}
		return Order;

	}

	public static void orderDetails(EntityManager entityManager, int o) throws Exception {

		String jpqlSelect = "SELECT c FROM Order as c, User as u WHERE c.id =" + o + " AND c.id_user = u.id";
		String jpqlSelect2 = "SELECT u FROM Order as c, User as u WHERE c.id =" + o + " AND c.id_user = u.id";
		String jpqlSelect3 = "SELECT p FROM Product as p, Order as o, OrderItem as ot  WHERE o.id = " + o
				+ " AND o.id = ot.orderId AND p.id = ot.ProductId";

		TypedQuery<Order> query = entityManager.createQuery(jpqlSelect, Order.class);
		TypedQuery<User> query2 = entityManager.createQuery(jpqlSelect2, User.class);
		TypedQuery<Product> query3 = entityManager.createQuery(jpqlSelect3, Product.class);

		List<Order> order = query.getResultList();
		List<User> user = query2.getResultList();
		List<Product> product = query3.getResultList();
		for (Order c : order) {
			System.out.println("Total = " + c.getTotal() + "\nId = " + c.getId());
		}
		System.out.println("--------------------------------");
		for (User u : user) {
			System.out.println(
					"Username = " + u.getUsername() + "\nSurname = " + u.getSurname() + "\nName = " + u.getName());
		}
		System.out.println("--------------------------------");
		System.out.println("PRODOTTI NELL'ORDINE");
		System.out.println("--------------------------------");

		for (Product p : product) {
			System.out.println("Name =" + p.getName() + "\nPrice = " + p.getPrice() + "\nBrand = " + p.getBrand()
					+ "\nQuantity = " + p.getQuantity());
			System.out.println("--------------------------------");

		}
	}
	

}
