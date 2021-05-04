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
	private User user;
	private List<Product> productsList = new ArrayList<Product>();
	private Product product;
	private List<Order> ordersList = new ArrayList<Order>();
	private Order order;
	
	public List<User> getUsersList() {
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> r = cq.from(User.class);
		cq.select(r);
		TypedQuery<User> tq = em.createQuery(cq);
		usersList = tq.getResultList();           
		em.close();
		return usersList;
	}
	
	public List<Product> getProductsList() {
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> r = cq.from(Product.class);
		cq.select(r);
		TypedQuery<Product> tq = em.createQuery(cq);
		productsList = tq.getResultList();
		em.close();
		return productsList;
	}
	
	public List<Order> getOrdersList(){
		List<Integer> userID = new ArrayList<Integer>();
		int i, j;
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> r = cq.from(Order.class);
		cq.select(r);
		TypedQuery<Order> tq = em.createQuery(cq);
		ordersList = tq.getResultList();
		usersList = getUsersList();
		for(i=0; i<ordersList.size(); i++) {
			userID.add(ordersList.get(i).getUserId());
		}
		for(Order o : ordersList) {
			System.out.println("ID Ordine: " + o.getId());
			System.out.println("Totale: " + o.getTotal());
			for(i=0; i<userID.size(); i++) {
				for(j=0; j<usersList.size(); j++) {
					if(((userID.get(i)) == (usersList.get(j).getId())) && ((ordersList.get(i).getId()) == o.getId())) {
						System.out.println("Nome del cliente: " + usersList.get(j).getName());
						System.out.println("Cognome del cliente: " + usersList.get(j).getSurname());
						System.out.println();
						break;
					}
				}
			}
		}
		return ordersList;
	}
}
