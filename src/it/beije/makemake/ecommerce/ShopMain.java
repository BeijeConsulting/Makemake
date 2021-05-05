package it.beije.makemake.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {
		
		int scelta = 0, i, j, x = 1;
		Scanner input = new Scanner(System.in);
		ShopManager sm = new ShopManager();
		List<User> usersList = new ArrayList<User>();
		List<Product> productsList = new ArrayList<Product>();
		List<Order> ordersList = new ArrayList<Order>();
		List<OrderItem> items = new ArrayList<OrderItem>();
		
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
				usersList = sm.getUsersList();
				productsList = sm.getProductsList();
				for(Order o : ordersList) {
					items = o.getListOrderItems();
					System.out.println("ID Ordine: " + o.getId());
					System.out.println("Totale: " + o.getTotal());
					LOOP: for(i=0; i<ordersList.size(); i++) {
						for(j=0; j<usersList.size(); j++) {
							if(((ordersList.get(i).getUserId()) == (usersList.get(j).getId())) && ((ordersList.get(i).getId()) == o.getId())) {
								System.out.println("Nome del cliente: " + usersList.get(j).getName());
								System.out.println("Cognome del cliente: " + usersList.get(j).getSurname());
								break LOOP;
							}
						}
					}
					System.out.println("Elenco dei prodotti acquistati:");
					for(i=0; i<items.size(); i++) {
						LOOP:for(j=0; j<productsList.size(); j++) {
							if((items.get(i).getProductId()) == (productsList.get(j).getId())) {
								x+=i;
								System.out.println("Prodotto numero " + x + ":");
								System.out.println("  Nome: " + productsList.get(j).getName());
								System.out.println("  Brand " + productsList.get(j).getBrand());
								System.out.println("  Prezzo: " + productsList.get(j).getPrice());
								System.out.println();
								break LOOP;
							}
						}
					}
					System.out.println();
				}
			break;
			
			case 4:
			break;
		}
	}

}
