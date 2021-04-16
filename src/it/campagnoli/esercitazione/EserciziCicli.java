package it.campagnoli.esercitazione;

public class EserciziCicli {
		public static final int LOOPS = 6;
	    public static void stampaTriangolo() {
	        for (int i = 0; i < LOOPS; i++) {
	            for (int j = 0; j < LOOPS - i; j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }
	    public static void stampaTriangolo2() {
	        for (int i = 0; i < LOOPS; i++) {
	            for (int j = 0; j < i+1; j++) {
	                System.out.print("#");
	            }
	            System.out.println();
	        }
	    }
	    public static void stampaFiguraNumeri() {
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < i + 1; j++) {
	                System.out.print(j+1);
	            }
	            System.out.print("     ");
	            for (int j = 6-i; j >= 1; j--) {
	                System.out.print(j);
	            }
	            System.out.println();
	        }
	    }
	    public static void main(String[] args) {
	        stampaTriangolo();
	        stampaTriangolo2();
	        stampaFiguraNumeri();
	        fibonacci(10);
	        fibonacci2(10);
	    }
	    public static void fibonacci(int n) {
	        int i0 = 0;
	        int i1 = 1;
	        System.out.println(i0);
	        System.out.println(i1);
	        for (int i = 0; i < n - 2; i++) {
	            int temp = i1;
	            i1 = i0 + i1;
	            i0 = temp;
	            System.out.println(i1);
	        }
	    }
	    public static void fibonacci2(int n) {
	        int[] f = new int[n];
	        f[0] = 0;
	        f[1] = 1;
	        System.out.println(f[1]);
	        for (int i = 2; i < n; i++) {
	            f[i] = f[i-1]+f[i-2];
	            for (int j = 0; j < i; j++) {
	                if (j > 0) System.out.print(", ");
	                System.out.print(f[j+1]);
	            }
	            System.out.println();
	        }
	    }
	}

