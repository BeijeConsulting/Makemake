package it.andrea.esercitazione0416;

public class ArrayExercises {
	// Trovare il massimo elemento in un array (o il minimo)
	public static int max(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	// Trovare l’indice del massimo elemento in un array (o il minimo)
	public static int maxIndex(int[] array) {
		if (array.length == 0) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	// scrivere un metodo “boolean contains(int e, int[] array)” che restituisca
	// true se l’elemento e è presente nell’array, false altrimenti.
	public static boolean contains(int e, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (e == array[i]) {
				return true;
			}
		}
		return false;
	}

	// Ripetere l’esercizio con “boolean contains(Object e, Object[] array)”, quali
	// differenze ci sono?
	public static boolean contains(Object e, Object[] array) {
		for (Object obj : array) {
			if (e.equals(obj)) {
				return true;
			}
		}
		return false;
	}

	// Verificare la sequenza crescente di un array. Il metodo “boolean
	// isCrescente(int [] array)” restituisce true se tutti gli elementi dell’array
	// passato sono in ordine crescente, false altrimenti.
	public static boolean isCrescente(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;
	}

	// Scrivere il metodo: “public int mostRecurrent(int [] array)” , che trova
	// l’elemento più ricorrente in un array. Il metodo restituisce l’elemento
	// trovato.
	public static int containsPos(int e, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (e == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int mostRecurrent(int[] array) {
		final int ELEMENTS_ARRAY = 0, COUNT_ARRAY = 1;
		int distinctElementsCount = 0;
		int[][] mostRecurrent = new int[2][array.length];
		for (int i = 0; i < array.length; i++) {
			int elementIndex = containsPos(array[i], mostRecurrent[ELEMENTS_ARRAY]);
			if (elementIndex != -1) {
				mostRecurrent[COUNT_ARRAY][elementIndex]++;
			} else {
				mostRecurrent[ELEMENTS_ARRAY][distinctElementsCount] = array[i];
				mostRecurrent[COUNT_ARRAY][distinctElementsCount] = 1;
				distinctElementsCount++;
			}
		}
		return mostRecurrent[ELEMENTS_ARRAY][maxIndex(mostRecurrent[COUNT_ARRAY])];
	}

	// Scrivere un programma MediaMultipliDiTre che calcoli la media di un array di
	// numeri interi, considerando i soli numeri divisibili per tre.
	public static double mediaMultipliDiTre(int[] array) {
		int sum = 0;
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 3 == 0) {
				sum += array[i];
				counter++;
			}
		}
		return (double) sum / counter;
	}

	// Scrivere un programma StampaZigZag che, dato un array di 10 numeri interi
	// contenente valori a piacere, ne stampa gli elementi secondo il seguente
	// ordine: il primo, l’ultimo, il secondo, il penultimo, il terzo, il
	// terz’ultimo, ecc…
	public static void stampaZigZag(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			System.out.print(array[i] + " " + array[array.length - 1 - i] + " ");
		}
		if (array.length % 2 == 1) {
			System.out.print(array[array.length / 2]);
		}
		System.out.println();
	}

	// Scrivere un programma Media che calcoli la media di un array di numeri interi
	public static double media(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return (double) sum / array.length;
	}

	// Scrivere il metodo: “public String [] addString(String s, String[] a)”, che
	// accetta come parametri una stringa ed un array di stringhe. Restituisce un
	// nuovo array, identico ad array, aggiungendo però, come ultimo elemento, la
	// stringa s.
	public static String[] addString(String s, String[] a) {
		String[] longerString = new String[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			longerString[i] = a[i];
		}
		longerString[a.length] = s;
		return longerString;
	}

	public static void printStringArray(String[] array) {
		for (String str : array) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		System.out.println(max(new int[] { -5, 14, 3, 0, -42 }));
		System.out.println(maxIndex(new int[] { -5, 14, 3, 0, -42 }));
		System.out.println(contains((Double) 10.0, new Object[] { 10.0, 15, "Ciao" }));
		System.out.println(isCrescente(new int[] { -15, 0, 1, 1, 4, 23, 172 }));
		System.out.println(mostRecurrent(new int[] { 3, 4, 7, 5, 3, 4, 6, 9, 3, 3 }));
		System.out.println(mediaMultipliDiTre(new int[] { 3, 6, 9, 9, 4, 32, 1 }));
		stampaZigZag(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(media(new int[] { 3, 6, 9, 9, 4, 32, 1 }));
		printStringArray(addString("Addio", new String[] { "Buongiorno", "Arrivederci" }));
	}

}
