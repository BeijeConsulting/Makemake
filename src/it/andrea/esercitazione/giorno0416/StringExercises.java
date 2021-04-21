package it.andrea.esercitazione.giorno0416;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringExercises {
	// Scrivere un programma SoloVocali che, data una stringa, ne stampa le sole
	// vocali

	private final static List<Character> VOWELS = Arrays
			.asList(new Character[] { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' });

	private static boolean isVowel(char letter) {
		return VOWELS.contains(letter);
	}

	public static void soloVocali(String sentence) {
		for (int i = 0; i < sentence.length(); i++) {
			if (isVowel(sentence.charAt(i))) {
				System.out.print(sentence.charAt(i));
			}
		}
		System.out.println();
	}

	// Scrivere un programma StampaMaiuscole che, dato un array di stringhe, ne
	// stampa solo quelle con la prima lettera maiuscola

	public static void stampaMaiuscole(String[] stringArray) {
		for (int i = 0; i < stringArray.length; i++) {
			if (Character.isUpperCase(stringArray[i].charAt(0))) {
				System.out.println(stringArray[i]);
			}
		}
	}

	// Scrivere il metodo [public int contaLettera(char c, String str)] che conta le
	// occorrenze della lettera c nella stringa str

	public static int contaLettera(char c, String str) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				counter++;
			}
		}
		return counter;
	}

	// Scrivere un programma Contrario che, data una stringa, la stampa al
	// contrario. Per esempio, la stringa “Viva Java!” verrà “!avaJ aviV”

	public static void contrario(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	// Scrivere un programma Concatena che chiede all’utente di inserire tre singole
	// parole e le ristampa interponendovi un asterisco. Per esempio, se l’utente
	// inserisce “gatto”, “cane” e “topo” il programma stamperà “gatto*cane*topo”.

	public static void concatena() {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci la prima parola:");
		String firstWord = input.nextLine();
		System.out.println("Inserisci la seconda parola:");
		String secondWord = input.nextLine();
		System.out.println("Inserisci la terza parola:");
		String thirdWord = input.nextLine();
		input.close();
		System.out.println(firstWord + "*" + secondWord + "*" + thirdWord);
	}

	// Scrivere un metodo che, data una stringa in input, assuma questa come un nome
	// di variabile e stampi per questa variabile il suo metodo “setter”

	public static void setParola(String parola) {
		System.out.println("set" + parola + "();");
	}

	// Scrivere un metodo che, data una stringa in input, assuma questa come un nome
	// di variabile e stampi per questa variabile il suo metodo “getter”
	
	public static void getParola(String parola) {
		System.out.println("get" + parola + "();");
	}

	public static void main(String[] args) {
		soloVocali("Frase con varie lettere");
		stampaMaiuscole(new String[] { "Frase con maiuscola iniziale", "frase senza maiuscolA INIZIALE" });
		System.out.println(contaLettera('a', "Frase con la a usata abbastanza spesso"));
		contrario("Viva Java!");
		// concatena();
		setParola("ParolaDaSet");
		getParola("ParolaDaGet");
	}

}
