package EcommerceEx;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.beije.makemake.ecommerce.Order;
import it.beije.makemake.ecommerce.Product;
import it.beije.makemake.ecommerce.User;
import it.beije.makemake.rubrica.Contatto;

public class Ecomm {
	@SuppressWarnings("deprecation")
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");	
	static Scanner x = new Scanner(System.in);
	static int idx=0;
	static List <User> ulist = Ecomm.listallUsers();
	static List <Product> plist = Ecomm.listallProducts();
	
	public static void main(String[] args) {
	 
	  boolean exit_pool = true;
		
	 
		System.out.println("Inserisci lo username/mail e la password per l'identificazione");
		System.out.println("Username: ");
		String nome = x.nextLine();
		System.out.println("Password: ");
		String psswrd = x.nextLine();
		
		boolean flag=false;
		
					
		for (int i=0; i<ulist.size();i++) {
			if((nome+psswrd).equals(ulist.get(i).getUsername()+ulist.get(i).getPassword())) {
				idx = i;
				System.out.println("Utente registrato!");
				flag = true;
			}
				
		if (flag) {	
		CICL: while(exit_pool) {	
			System.out.println("Benvenuto "+ulist.get(idx).getName()+" "+ulist.get(idx).getSurname());

			System.out.println("Scegli un'opzione dal nostro menù "
			+ "o digita 'exit' per uscire");
			
			System.out.println("-----------Menù----------");
			System.out.println("Digita '1' per visualizzare la lista dei nostri prodotti");
			System.out.println("Digita '2' per effettuare un ordine");
			System.out.println("Digita '3' per rimuovere un prodotto dal carrello");
			System.out.println("Digita '4' per cercare un prodotto");
			System.out.println("Digita 'exit' per uscire                   ");	
			
			
			switch(x.nextLine()) {
			case "1":
				Ecomm.listallProducts();
				break;
			case "2":
				Ecomm.takeOrder();
				break;
			}
		}			
		}
		
		else {
			System.out.println("Utente non registrato!");
			System.out.println("Grazie e arrivederci!");
		}
	  }	
	}
	
	
	// stampo tutti gli user
	public static List<User> listallUsers() {
		EntityManager entityManager = factory.createEntityManager();
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaQuery<User> q = cb.createQuery(User.class);
		Root<User> c = q.from(User.class);
		CriteriaQuery<User> select = q.select(c);
		TypedQuery<User> contatto = entityManager.createQuery(select);
		List<User> contatti = contatto.getResultList();
		
		for (User contat : contatti) {
			System.out.println("id : " + contat.getId());
			System.out.println("name : " + contat.getName());
			System.out.println("surname : " + contat.getSurname());
			System.out.println("username : " + contat.getUsername());
			System.out.println("password : " + contat.getPassword());
		}	
		
		//Transaction
		entityTransaction.commit();
		entityManager.close();	
		return contatti;
	}

	public static List<Product> listallProducts() {
		EntityManager entityManager = factory.createEntityManager();
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaQuery<Product> q = cb.createQuery(Product.class);
		Root<Product> c = q.from(Product.class);
		CriteriaQuery<Product> select = q.select(c);
		TypedQuery<Product> contatto = entityManager.createQuery(select);
		List<Product> prodotti= contatto.getResultList();
		
		for (Product contat : prodotti) {
			System.out.println("id : " + contat.getId());
			System.out.println("name : " + contat.getName());
			System.out.println("brand : " + contat.getBrand());
			System.out.println("description : " + contat.getDesc());
			System.out.println("price : " + contat.getPrice());
			System.out.println("image : " + contat.getImage());
			System.out.println("quantity : " + contat.getQuantity());
		}	
		//Transaction
		entityTransaction.commit();
		entityManager.close();	
		return prodotti;
	}

	public static void takeOrder() {
		int quant = 0;
		List<Product> queries = new ArrayList<Product>();
		int i=0;
		double total = 0;
		double prezzo;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");		
		EntityManager entityManager = factory.createEntityManager();
				
		Order ord = new Order();
		
		System.out.println("Seleziona prodotto e rispettiva quantità");
		String st="start";
		boolean vero = true;
		while (true) {
			Product pr = new Product();
			st = x.nextLine();
			if(st.equalsIgnoreCase("ok")) break;
			System.out.println("Prodotto: "+st);
			pr.setName(st);
			quant = Integer.parseInt(x.nextLine());
			System.out.println("Quantità: "+quant);
			pr.setQuantity(quant);
			queries.add(pr);
			i++;
		}		
		System.out.println("BYE!!");
		
		for(int j=0; j<queries.size(); j++) {
			//Query JPQL
			String term = queries.get(j).getName();
			String jpqlSelect = "SELECT c FROM Product as c WHERE c.name LIKE :name ";
			
			Query query = entityManager.createQuery(jpqlSelect);
			query.setParameter("name", term);
			List<Product> prodotti = query.getResultList();
			
			prezzo = prodotti.get(0).getPrice();
			total =+ prezzo*quant;
		}
		
		//Transaction
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		
		ord.setDate(LocalDateTime.now());
		ord.setIduser(ulist.get(idx).getId());
		ord.setStatus("ordine effettuato!");
		ord.setTotal(total);
		
		entityManager.persist(ord);
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Ordine aggiunto al carrello!");		
	}
}
