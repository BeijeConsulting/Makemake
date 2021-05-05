package it.beije.makemake.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import rubrica.Contatto;

public class JpaManager {
	static Scanner in = new Scanner(System.in);

	public static ArrayList<Order> selectAllOrder() {
		EntityManager entityManager = SingletonJpa.getInstance();

		String select = "SELECT c FROM Order as c";
		Query query = entityManager.createQuery(select);
		ArrayList<Order> ordini = (ArrayList<Order>) query.getResultList();

		return ordini;

	}	
	public static ArrayList<Product> SelectAllProduct() {
		EntityManager entityManager = SingletonJpa.getInstance();
		String jpqlSelect = "SELECT c FROM Product as c";
		Query query = entityManager.createQuery(jpqlSelect);
		ArrayList<Product> products = (ArrayList<Product>) query.getResultList();
		return products;
	}	
	public static ArrayList<OrderItem> SelectAllOrderItem() {
		EntityManager entityManager = SingletonJpa.getInstance();
		String jpqlSelect = "SELECT c FROM OrderItem as c";
		Query query = entityManager.createQuery(jpqlSelect);
		ArrayList<OrderItem> orderItems = (ArrayList<OrderItem>) query.getResultList();
		return orderItems;
	}
	public static ArrayList<User> SelectAllUser() {
		EntityManager entityManager = SingletonJpa.getInstance();
		String jpqlSelect = "SELECT c FROM User as c";
		Query query = entityManager.createQuery(jpqlSelect);
		ArrayList<User> Users = (ArrayList<User>) query.getResultList();
		return Users;
	}
	
	
	public static void main(String[] args) {
		GestoreEcommerce a = new GestoreEcommerce();
		a.caricaProduct(SelectAllProduct());
		a.caricaUser(SelectAllUser());
		
		System.out.println(a);
		System.out.println("---------------------");
		System.out.println(a.getProductbyId(4));
	}
}