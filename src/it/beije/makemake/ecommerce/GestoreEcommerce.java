package it.beije.makemake.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.makemake.rubrica.Contatto;



public class GestoreEcommerce {
	//___________________________________________________________________
	public static List<Order> SelectAllOrder() {

		EntityManager entityManager = SingletonJpa.getInstance();

		String jpqlSelect = "SELECT c FROM Order as c";

		Query query = entityManager.createQuery(jpqlSelect);

		List<Order> orders = query.getResultList();
		
		return orders;
	}
	//___________________________________________________________________
	public static List<Product> SelectAllProduct() {

		EntityManager entityManager = SingletonJpa.getInstance();

		String jpqlSelect = "SELECT c FROM Product as c";

		Query query = entityManager.createQuery(jpqlSelect);

		List<Product> products = query.getResultList();


		return products;
	}
	//___________________________________________________________________	
	public static List<OrderItem> SelectAllOrderItem() {

		EntityManager entityManager = SingletonJpa.getInstance();

		String jpqlSelect = "SELECT c FROM OrderItem as c";

		Query query = entityManager.createQuery(jpqlSelect);

		List<OrderItem> orderItems = query.getResultList();
		System.out.println(orderItems);
		return orderItems;
	}
	//___________________________________________________________________
	public static List<User> SelectAllUser() {

			EntityManager entityManager = SingletonJpa.getInstance();

			String jpqlSelect = "SELECT c FROM User as c";

			Query query = entityManager.createQuery(jpqlSelect);

			List<User> Users = query.getResultList();

			return Users;
		}
	//___________________________________________________________________
	public static void PrintListProduct(List<Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}
	// ___________________________________________________________________
	public static void PrintListOrder(List<Order> orders) {
		for (Order order : orders) {
			System.out.println(order);
		}
	}

	// ___________________________________________________________________
	public static void PrintListUser(List<User> users) {
		for (User user : users) {
			System.out.println(user);
		}
	}
	//___________________________________________________________________
	public static String getOrderDetails(Order order) {
        StringBuilder output = new StringBuilder();
        
        EntityManager entityManager = SingletonJpa.getInstance();
        Integer id = order.getId();
        //append order info
        output.append("ORDER INFO: " + "\n");
        output.append(order.toString());
        //get data about user
        output.append("\n\nUSER INFO: " + "\n");
        User user = getUser(order.getUserId());
        output.append(user.toString());
        //get data about products
        output.append("\n\nPRODUCT INFO:\n-----------------------------------------------------\n");
        String selectOrderItem = "SELECT oi from OrderItem as oi WHERE oi.orderId =: id";
        Query query = entityManager.createQuery(selectOrderItem);
        query.setParameter("id", id);
        List<OrderItem> orderItems = query.getResultList();
        for (OrderItem orderItem: orderItems) {
            Integer productId = orderItem.getProductId();
            Product product = getProduct(productId);
            output.append(product.toString());
            output.append("\nOrdered amount: " + orderItem.getQuantity() + "\n");
            output.append("\nPrice amount: " + orderItem.getPrice()+ "\n");
            output.append("-----------------------------------------------------\n");
        }
        
        return output.toString();
    }
	//___________________________________________________________________
	public static void createNewOrder(int idUser, HashMap<Integer, Integer> products) {

		EntityManager entityManager = SingletonJpa.getInstance();
		User user = entityManager.find(User.class, idUser);
		if (user == null) {
			throw new IllegalArgumentException("Id utente non valido");
		}
		BigDecimal total = new BigDecimal(0);
		LocalDateTime dateTime = LocalDateTime.now();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Order order = new Order();
		order.setUserId(idUser);
		order.setDate(dateTime);
		order.setStatus("ok");
		order.setTotal(total);
		entityManager.persist(order);

		Integer orderId = order.getId();

		for (Integer productId : products.keySet()) {
			Product product = entityManager.find(Product.class, productId);
			if (product == null) {
				throw new IllegalArgumentException("Id prodotto " + productId + " non valido");
			}
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(orderId);
			orderItem.setProductId(productId);
			orderItem.setQuantity(products.get(productId));
			orderItem.setPrice(product.getPrice());
			entityManager.persist(orderItem);
			total = total.add(product.getPrice().multiply(BigDecimal.valueOf(products.get(productId))));
		}
		order.setTotal(total);
		entityManager.merge(order);
		entityTransaction.commit();

	}
	
	//___________________________________________________________________
	public static String getOrderDetails(Integer orderId) {
		Order order = getOrder(orderId);
		return getOrderDetails(order);
	}
	//___________________________________________________________________
	private static User getUser(Integer userId) {
        
        EntityManager entityManager = SingletonJpa.getInstance();
        User user = entityManager.find(User.class, userId);
        
        return user;
    }
	//___________________________________________________________________
    private static Product getProduct(Integer productId) {
       
        EntityManager entityManager = SingletonJpa.getInstance();
        Product product = entityManager.find(Product.class, productId);
        
        return product;
    }
	//__________________________________________________________________
    private static Order getOrder(Integer orderId) {
        
    	EntityManager entityManager = SingletonJpa.getInstance();
        Order order = entityManager.find(Order.class, orderId);
        
        return order;
    }
    //__________________________________________________________________
	public static void main(String[] args) {
		
		List<Product> products = SelectAllProduct();
		
		PrintListProduct(products);
		System.out.println("___________________________________________________________________________________________________________");
		
		List<Order> orders = SelectAllOrder();
		PrintListOrder(orders);
		
		System.out.println("___________________________________________________________________________________________________________");
		
		List<User> users = SelectAllUser();
		PrintListUser(users);
		
		System.out.println("___________________________________________________________________________________________________________\n");
		
		System.out.println(getOrderDetails(3));
		
	
		
      //testing order creation
//      HashMap<Integer, Integer> orderData = new HashMap<>();
//      orderData.put(2,3);
//      orderData.put(3, 5);
//      createNewOrder(1, orderData);

     
      System.out.println("_______________________________________________FINE________________________________________________________");
  
    }

}
