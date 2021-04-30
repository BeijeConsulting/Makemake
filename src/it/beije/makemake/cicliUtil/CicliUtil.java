package it.beije.makemake.cicliUtil;

public class CicliUtil {

	public static void main(String[] args) {
		// stampaNumeri();
		// fibonacci2(5);
		// stampaNumeriInteri(10);
		// stampaNumeriPari();
		// stampaAsterischi();
		stampaCancelletto();

	}

	public static void fibonacci2(int n) {
		int array[] = new int[n + 1];
		array[0] = 0;
		array[1] = 1;
		System.out.println(array[1]);
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i - 1] + array[i - 2];
			for (int j = 0; j < i; j++) {
				if (j > 0)
					System.out.print(",");
				System.out.print(array[j + 1]);
			}
			System.out.println();
		}
	}

	public static void stampaNumeri() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j + 1);
			}
			System.out.print("    ");
			for (int j = 6; j > i; j--) {
				System.out.print(j - i);
			}
			System.out.println();

		}

	}

	public static void fibonacci() {
		int prev = 0;
		int fol = 1;
		int temp = prev;
		System.out.println(prev);
		System.out.println(fol);
		for (int i = 0; i < 100; i++) {
			System.out.println(fol);
			temp = prev;
			prev = fol;
			fol = prev + temp;
		}
	}

	public static void stampaNumeriInteri(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(i + 1);
		}
	}

	public static void stampaNumeriPari() {
		int cont = 0;
		for (int i = 20; i > 0; i--) {
			if (cont < 10 && i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	public static void stampaAsterischi() {
		final int LOOPS = 6;
		for (int i = LOOPS; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void stampaCancelletto() {
		final int LOOPS = 6;
		for (int i = 0; i < LOOPS; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

}
