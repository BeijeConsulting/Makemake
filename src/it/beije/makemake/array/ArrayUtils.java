package it.beije.makemake.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {

	public static int max(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static int maxI(int[] array) {
		int max = array[0];
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}

	public static int min(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > min) {
				min = array[i];
			}
		}
		return min;
	}

	public static boolean contains(int e, int[] array) {
		for (int i : array) {
			if (i == e) {
				return true;
			}
		}
		return false;
	}

	public static boolean contains(Object e, Object[] array) {
		for (Object i : array) {
			if (i.equals(e)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCrescente(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static int mostRecurrent(int[] array) {
		int[] freq = new int[array.length];
		for (int i = 0; i < freq.length; i++) {
			for (int j = 0; j < freq.length; j++) {
				if (array[i] == array[j]) {
					freq[i]++;
				}
			}
		}
		return maxI(array);

	}

	public static void stampaZigzag(int[] array) {
		int i;
		for (i = 0; i < array.length / 2; i++) {
			System.out.println(array[i]);
			System.out.println(array[array.length - 1 - i]);
		}
		if (array.length % 2 != 0)
			System.out.println(array[i]);

	}

	public static String[] addString(String s, String[] a) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, a);
		list.add(s);
		return list.toArray(new String[0]); // 0 è l'inizializzazione della dimensione dell'array
	}

	public static double media(int[] a) {
		int somma = 0;
		int i;
		for (i = 0; i < a.length; i++) {
			somma += a[i];
		}

		return (double) somma / i;
	}

	public static double mediaMultipliDiTre(int[] a) {
		int somma = 0;
		int cont = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				somma += a[i];
				cont++;
			}
		}
		return (double)somma/cont;

	}


}
