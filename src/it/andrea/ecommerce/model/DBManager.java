package it.andrea.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import it.andrea.ecommerce.JpaConnectionManager;
import it.andrea.ecommerce.TooManySessionsException;
import it.andrea.ecommerce.entity.Order;
import it.andrea.ecommerce.entity.OrderItem;
import it.andrea.ecommerce.entity.Product;
import it.andrea.ecommerce.entity.User;

public class DBManager {
	private static final String TOO_MANY_EM = "Too many entity managers!";

	public List<User> getAllUsers() {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
			List<User> result = query.getResultList();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}

	public List<Product> getAllProducts() {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
			List<Product> result = query.getResultList();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}

	public void viewOrder(int orderId) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();

			Order order = getOrderById(orderId);
			User user = getUserById(order.getUserId());
			List<OrderItem> orderItems = getOrderItemsByOrderId(order.getId());
			
			System.out.println("ID ordine: " + order.getId());
			System.out.println("Spesa totale: " + order.getTotal() + "€");
			System.out.println("Username acquirente: " + user.getUsername());
			System.out.println("Elenco prodotti:");
			for (OrderItem orderItem : orderItems) {
				Product product = getProductById(orderItem.getProductId());
				
				System.out.println(product.getName());
				System.out.println(product.getBrand());
				System.out.println("Prezzo per singolo prodotto: " + product.getPrice() + "€");
				System.out.println("Quantita' acquistata: " + orderItem.getQuantity());
			}

			JpaConnectionManager.closeEntityManager(em);
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
	}

	public void createOrder(User user, List<OrderItem> orderItems) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();

			Order order = new Order();
			order.setDate(LocalDateTime.now());
			order.setUserId(user.getId());
			order.setStatus("Ordine effettuato");
			order.setTotal(BigDecimal.ZERO);

			EntityTransaction entityTransaction = em.getTransaction();
			entityTransaction.begin();
			em.persist(order);
			entityTransaction.commit();
//			System.out.println(order.getId());

			BigDecimal total = BigDecimal.ZERO;
			for (OrderItem orderItem : orderItems) {
				orderItem.setOrderId(order.getId());
				Product product = getProductById(orderItem.getProductId());
				orderItem.setPrice(product.getPrice());
				product.setQuantity(product.getQuantity() - orderItem.getQuantity());
				entityTransaction.begin();
				em.persist(orderItem);
				em.merge(product);
				entityTransaction.commit();
				total = total.add(orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
//				System.out.println(orderItem.getId());
			}

			order.setTotal(total);
			entityTransaction.begin();
			em.persist(order);
			entityTransaction.commit();

			JpaConnectionManager.closeEntityManager(em);
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
	}

//	----------------------------------------------------------------------
	public User getUserByUsername(String username) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
			User result = query.setParameter("username", username).getSingleResult();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}

	public User getUserById(int id) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
			User result = query.setParameter("id", id).getSingleResult();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}

	public Product getProductById(int id) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class);
			Product result = query.setParameter("id", id).getSingleResult();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}

	public Order getOrderById(int id) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.id = :id", Order.class);
			Order result = query.setParameter("id", id).getSingleResult();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}

	public List<OrderItem> getOrderItemsByOrderId(int orderId) {
		try {
			EntityManager em = JpaConnectionManager.getEntityManager();
			TypedQuery<OrderItem> query = em.createQuery("SELECT o FROM OrderItem o WHERE o.orderId = :orderId",
					OrderItem.class);
			List<OrderItem> result = query.setParameter("orderId", orderId).getResultList();
			JpaConnectionManager.closeEntityManager(em);
			return result;
		} catch (TooManySessionsException e) {
			System.out.println(TOO_MANY_EM);
		}
		return null;
	}
}
