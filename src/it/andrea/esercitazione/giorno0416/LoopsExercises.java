package it.andrea.esercitazione.giorno0416;

public class LoopsExercises {
	// Scrivere un programma che stampi a video i primi dieci numeri interi
	public static void tenPrinter() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// Scrivere un programma che stampi a video i primi dieci interi pari compresi
	// fra 20 e 0, partendo da 20.
	public static void twentyEvenRevPrinter() {
		for (int i = 20; i > 0; i -= 2) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// Scrivere un programma che stampi le tabellina del numero dato come argomento
	public static void tablePrinter(int num) {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i * num + " ");
		}
		System.out.println();
	}

	// Stampare a video la seguente figura:
	// ******
	// *****
	// ****
	// ***
	// **
	// *
	public static void triangle1(int size) {
		for (int lenght = size; lenght > 0; lenght--) {
			for (int i = lenght; i > 0; i--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Stampare a video la seguente figura:
	// #
	// ##
	// ###
	// ####
	// #####
	// ######
	public static void triangle2(int size) {
		for (int lenght = 1; lenght <= size; lenght++) {
			for (int i = lenght; i > 0; i--) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	// Stampare a video la seguente figura:
	// 1 [6 spazi] 654321
	// 12 [6 spazi] 54321
	// 123 [6 spazi] 4321
	// 1234 [6 spazi] 321
	// 12345 [6 spazi] 21
	// 123456 [6 spazi] 1
	public static void numberTriangles(int size) {
		for (int row = 1; row <= size; row++) {
			for (int i = 1; i <= row; i++) {
				System.out.print(i);
			}
			System.out.print("      ");
			for (int i = size - row + 1; i >= 1; i--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	// Scrivere un programma che stampi i primi 100 elementi della successione di
	// Fibonacci.
	public static void fibos(int iterations) {
		long fib1 = 0;
		long fib2 = 1;
		long fibo = 1;
		for (int i = 0; i < iterations; i++) {
			System.out.print(fibo + " ");
			fibo = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibo;
		}
		System.out.println();
	}

	// Scrivere un programma che stampi le n righe della successione di Fibonacci in
	// questo modo:
	// 1
	// 1, 1
	// 1, 1, 2
	// 1, 1, 2, 3
	// 1, 1, 2, 3, 5
	// 1, 1, 2, 3, 5, 8
	// 1, 1, 2, 3, 5, 8, 13
	public static void manyFibs(int iterations) {
		for (int i = 1; i <= iterations; i++) {
			fibos(i);
		}
	}

	public static void main(String[] args) {
		tenPrinter();
		twentyEvenRevPrinter();
		tablePrinter(7);
		triangle1(6);
		triangle2(6);
		numberTriangles(6);
		fibos(100);
		manyFibs(7);
	}

}
