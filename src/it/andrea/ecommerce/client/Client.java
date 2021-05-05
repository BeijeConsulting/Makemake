package it.andrea.ecommerce.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.andrea.ecommerce.entity.OrderItem;
import it.andrea.ecommerce.entity.User;
import it.andrea.ecommerce.model.DBManager;

public class Client {
	private static DBManager dbManager = new DBManager();

	public void createOrder(Scanner scanner, User user) {
		System.out.println("Ecco i prodotti disponibili:");
		System.out.println(dbManager.getAllProducts());
		System.out.println(
				"Inserisci l'ID dei prodotti che vuoi comprare, seguito dalla quantità. Scrivi 'E' quando hai finito.");
		Integer id;
		Integer quantity;
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		String input;
		do {
			System.out.print("Id: ");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("E")) {
				break;
			}
			id = Integer.parseInt(input);
			System.out.print("Quantita': ");
			quantity = Integer.parseInt(scanner.nextLine());
			orderItems.add(new OrderItem(id, quantity));
		} while (true);
		dbManager.createOrder(user, orderItems);
	}

	public User login(Scanner scanner) {
		String username;
		User user;
		do {
			System.out.println("Inserisci il tuo username:");
			username = scanner.nextLine();
			user = dbManager.getUserByUsername(username);
			if (user == null) {
				System.out.println("Username non registrato!");
			}
		} while (user == null);
		return user;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Client client = new Client();
		User user = client.login(scanner);
		scanner.close();
	}

}
