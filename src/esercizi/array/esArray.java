package esercizi.array;

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
			for(int j=1; j<=x.length-1; j++) {
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
	public static void main(String[] args) {
		int [] X= {1,2,3,5,4,6,6,3,3};
		String [] Y= {"ciao","come", "stai"};
		System.out.println(ultimo(X));
		System.out.println(indexMax(X));
		System.out.println(contains(3,X));
		System.out.println(containsOb("ciao",Y));
		System.out.println(isCrescente(X));
		System.out.println(mostRecurrent(X));

	}

}
