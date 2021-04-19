package it.andrea.esercitazione0416;

import java.util.Scanner;

public class Morra {
	// Scrivere un programma che chieda agli utenti due stringhe in ingresso, le
	// stringhe possono valere solo: “carta”, “forbice” o “sasso”. Il programma
	// dovrà quindi effettuare i dovuti controlli e dichiarare il vincitore secondo
	// le note regole della “morra cinese” (forbice vince su carta, carta vince su
	// sasso, sasso vince su forbice).
	public static void morra(String player1, String player2) {
		int player1choice = switchToInt(player1);
		int player2choice = switchToInt(player2);
		if (player1choice != -1 && player2choice != -1) {
			switch (player1choice - player2choice) {
			case 0:
				System.out.println("Pareggio!");
				break;
			case 1:
			case -2:
				System.out.println("Vince il giocatore 1!");
				break;
			case -1:
			case 2:
				System.out.println("Vince il giocatore 2!");
				break;
			}
		} else {
			System.out.println("Uno dei due input e' errato!");
		}
	}

	public static int switchToInt(String choice) {
		switch (choice.toLowerCase()) {
		case "carta":
			return 0;
		case "forbice":
			return 1;
		case "sasso":
			return 2;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci la mossa di giocatore 1: ");
		String player1 = input.nextLine();
		System.out.println("Inserisci la mossa di giocatore 2: ");
		String player2 = input.nextLine();
		input.close();
		morra(player1, player2);
	}
}
