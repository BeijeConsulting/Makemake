package it.beije.makemake.myEcommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.beije.makemake.Hibernate.JPASingleton;
import it.beije.makemake.myEcommerce.User;

public class eCommerceManager {
	private static JPASingleton manager = JPASingleton.getJPASingleton();

	static List<User> users = new ArrayList<>();
	static List<Product> products = new ArrayList<>();
	static List<Order_item> items = new ArrayList<>();

	public static void main(String[] args) {
		//Prende gli utenti e stampa gli utenti e i loro ordini
		getUsers();
		/*for(User u : users) {
			System.out.println(u.toString());
			for(Order order : u.getOrders()) {
				System.out.println(order.toString());
			}
		}*/
		

		System.out.println();
		//prende i prodotti
		getProducts();

		for(Product p : products) {
			System.out.println(p.toString());
		}
		
		System.out.println();
		//prende gli ordini
		getOrder();
		System.out.println();
		//prendi gli oggetti presenti nell'ordine
		getOrderItem();
		/*for(Order_item p : items) {
			System.out.println(p.toString());
		}*/
		System.out.println();

		getDetailsOrder();
		
		

	}

	public static void getUsers() {
		EntityManager entityManager = manager.getEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		CriteriaQuery<User> select = criteriaQuery.select(from);
		TypedQuery<User> utenti = entityManager.createQuery(select);

		users = utenti.getResultList();
			for(User u : users) {
				System.out.println(u.toString());
				for(Order order : u.getOrders()) {
					System.out.println(order.toString());
				}
			}
		entityManager.close();
	}

	public static void getProducts() {
		EntityManager entityManager = manager.getEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> from = criteriaQuery.from(Product.class);
		CriteriaQuery<Product> select = criteriaQuery.select(from);
		TypedQuery<Product> prodotti = entityManager.createQuery(select);

		products = prodotti.getResultList();
		entityManager.close();
	}

	public static void getOrderItem() {
		EntityManager entityManager = manager.getEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order_item> criteriaQuery = criteriaBuilder.createQuery(Order_item.class);
		Root<Order_item> from = criteriaQuery.from(Order_item.class);
		CriteriaQuery<Order_item> select = criteriaQuery.select(from);
		TypedQuery<Order_item> lista = entityManager.createQuery(select);

		items = lista.getResultList();
		
		entityManager.close();

	}
	public static void getDetailsOrder() {
		EntityManager entityManager = manager.getEntityManager();

		String jpqlSelect = "SELECT o FROM Order as o";

		Query queryOrdini = entityManager.createQuery(jpqlSelect);
		List<Order> ordini = queryOrdini.getResultList();

		String jpqlSelectOrder_item = "SELECT ord FROM Order_item as ord ";
		Query queryOrderItem =entityManager.createQuery(jpqlSelectOrder_item);
		List<Order_item> order_item = queryOrderItem.getResultList();

		for(Order o : ordini) {
			System.out.println("-----Dettaglio ordine-----");
			System.out.println("Id Order : " + o.getId());
			System.out.println("Tot Order : "+ o.getTotal());
			
			User u =entityManager.find(User.class, o.getUserId());
			System.out.println("Username for Order " + u.getUsername());
			for(int i=0;i<order_item.size();i++) {
				if(o.getId().equals(order_item.get(i).getOrderId())) {
					Product p = entityManager.find(Product.class, order_item.get(i).getProductId());
					System.out.println("-----Elenco prodotti-----");
					System.out.println("Product Name : " + p.getName());
					System.out.println("Price " + order_item.get(i).getPrice());
					System.out.println("Quantita " +  order_item.get(i).getQuantity() );

				}
			}

		}
	}

public static void getOrder() {
	EntityManager entityManager = manager.getEntityManager();
	String jpqlSelect = "SELECT o FROM Order as o";
	Query query = entityManager.createQuery(jpqlSelect);
	List<Order> orders = query.getResultList();
	
	for(Order order : orders) {
		System.out.println(order);
		for(Order_item item : order.getOrders_item())
			System.out.println(item.toString());
	}
}
}
