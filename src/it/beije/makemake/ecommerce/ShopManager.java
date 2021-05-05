             package it.beije.makemake.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.beije.makemake.database.JPAConnection;

public class ShopManager {

	private EntityManager em = JPAConnection.getConnection();
	private EntityTransaction et = em.getTransaction();
	private CriteriaBuilder cb = em.getCriteriaBuilder();
	private List<User> usersList = new ArrayList<User>();
	private List<Product> productsList = new ArrayList<Product>();
	private List<Order> ordersList = new ArrayList<Order>();
	
	public List<User> getUsersList() {
		em = JPAConnection.getConnection();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> r = cq.from(User.class);
		cq.select(r);
		TypedQuery<User> tq = em.createQuery(cq);
		usersList = tq.getResultList();           
		em.close();
		return usersList;
	}
	
	public List<Product> getProductsList() {
		em = JPAConnection.getConnection();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> r = cq.from(Product.class);
		cq.select(r);
		TypedQuery<Product> tq = em.createQuery(cq);
		productsList = tq.getResultList();
		em.close();
		return productsList;
	}
	
	public List<Order> getOrdersList(){
		em = JPAConnection.getConnection();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> r = cq.from(Order.class);
		cq.select(r);
		TypedQuery<Order> tq = em.createQuery(cq);
		ordersList = tq.getResultList();
		em.close();
		return ordersList;
	}
}
