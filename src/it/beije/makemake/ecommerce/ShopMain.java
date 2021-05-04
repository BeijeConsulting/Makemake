package it.beije.makemake.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {
		
		int scelta = 0;
		Scanner input = new Scanner(System.in);
		ShopManager sm = new ShopManager();
		List<User> usersList = new ArrayList<User>();
		List<Product> productsList = new ArrayList<Product>();
		List<Order> ordersList = new ArrayList<Order>();
		
		System.out.println("Premere uno di questi numeri per accedere alle seguenti operazioni:");
		System.out.println("1) Visualizza tutti gli utenti.");
		System.out.println("2) Visualizza tutti i prodotti.");
		System.out.println("3) Visualizza tutti gli ordini.");
		System.out.println("4) Effettua un ordine.");
		System.out.print("Scegli l'operazione: ");
		scelta = input.nextInt();
		input.close();
		System.out.println();
		
		switch(scelta) {
			case 1:
				usersList = sm.getUsersList();
				for(User user : usersList) {
					System.out.println("Username: " + user.getUsername());
					System.out.println("Nome: " + user.getName());
					System.out.println("Cognome: " + user.getSurname());
					System.out.println();
				}
			break;
			
			case 2:
				productsList = sm.getProductsList();
				for(Product product : productsList) {
					System.out.println("Nome: " + product.getName());
					System.out.println("Brand: " + product.getBrand());
					System.out.println("Descrizione: " + product.getDesc());
					System.out.println("Prezzo: " + product.getPrice());
					System.out.println();
				}
			break;
			
			case 3:
				ordersList = sm.getOrdersList();
			break;
			
			case 4:
			break;
		}
	}

}
