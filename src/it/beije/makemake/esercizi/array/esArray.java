package it.beije.makemake.esercizi.array;

public class esArray {

	public static int ultimo(int[] x) {
		return x[x.length-1];
	}
	public static int indexMax(int[]x) {
		int k=0;
		for(int i=0; i<x.length-1; i++) {
			if(k<x[i])
				k=x[i];
		}
		return k;
	}
	
	public static boolean contains(int e, int[]x ) {
		boolean c=false;
	
		for(int i=0; i<x.length-1; i++) {
			if(e!=x[i])
				c=true;
		}
		return c;
	}

	public static boolean containsOb(String s, String[] x) {
		boolean c = false;

		for (int i = 0; i < x.length - 1; i++) {
			if (s.equals(x[i]))
				c = true;
		}
		return c;
		
		
	}
	
	public static boolean isCrescente(int [] x) {
		boolean c = false;
	LOOP:for(int i=0; i<x.length-1; i++) {
			for(int j=1; j<=x.length-1;) {
				if(x[i]<x[j]) {
					c=true;
				continue LOOP;
				}
				else {
					c=false;
				continue LOOP;
				}
			}
			
				
		}return c;
	}
	public static int mostRecurrent(int [] x) {
		int cont=0;
		
		for(int i=0; i<x.length-1; i++) {
			int cont1=0;
			for(int j=1; j<=x.length-1; j++) {
				if(x[i]==x[j])
					cont1++;
			}
			if(cont<cont1)
				cont=cont1;
		} return cont;
	}
	
	public static double mediaMultipliTre(int[]x) {
		int cont=0;
		int somm=0;
		for(int i=0; i<x.length-1; i++) {
			if(x[i]%3==0) {
				cont++;
				somm+=x[i];
			}
		}
		return (double)somm/cont;
	}
	public static void stampaZigZag(int[]x) {
		for (int i = 0; i < x.length / 2; i++) {
			System.out.print(x[i] + " " + x[x.length - 1 - i] + " ");
		}
		if (x.length % 2 == 1) {
			System.out.print(x[x.length / 2]);
		}
		System.out.println();
	}
	 
	public static double media(int[]x) {
		int som=0;
		for(int i=0; i<x.length; i++){
			som+=x[i];
			}
		return (double)som/x.length;
		}
	public static String [] addString(String s, String[] a) {
		String []x = new String[a.length +1];
		for(int i=0; i<a.length;i++) {
			x[i]=a[i];
		}
		x[a.length]=s;
	
		return x;
	}
	public static void printArray(String[] p) {
		for (String str : p) {
			System.out.print(str + " ");
		}
	}
	public static void main(String[] args) {
		int [] X= {1,2,3,5,4,6,6,3,3,9};
		String [] Y= {"ciao","come", "stai"};
		System.out.println(ultimo(X));
		System.out.println(indexMax(X));
		System.out.println(contains(3,X));
		System.out.println(containsOb("ciao",Y));
		System.out.println(isCrescente(X));
		System.out.println(mostRecurrent(X));
		System.out.println(mediaMultipliTre(X));
		stampaZigZag(X);
		System.out.println(media(X));
		
		printArray(addString("bello", Y));
	}

}
