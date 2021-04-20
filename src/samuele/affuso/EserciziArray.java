package samuele.affuso;
import java.lang.reflect.Array;
import java.util.Arrays;

public class EserciziArray {

	public static void main(String[] args) {
		int[] Array1 = new int[] {112121,0, 2,3,5,2,63,2323};
		
		int[] Array12 = new int[] {1,2,2,3,4,5,6,2,2,3,0};

		Object [] Array2 = new Object[] {1,2,3,4,5,6};
		System.out.println("il max dell'array è " + massimo(Array1) + " e si trova in posizione " + indiceMassimo(Array1));
		
		System.out.println("il minimo dell'array è " + minimo(Array1) + " e si trova in posizione " + indiceMinimo(Array1));
		
		System.out.println("E' contenuto nell'array di partenza? " + contains(3,Array1));
		System.out.println("E' contenuto nell'array di partenza? " + contains(3,Array2));

		System.out.println("Crescente? no");
		System.out.println(isCrescente(Array1));
		
		System.out.println("Crescente?");
		System.out.println(isCrescente(Array12));
		
		
		
		System.out.println("piu ricorrente è "+mostRecurrent(Array12));

		
		int[] Array123 = new int[] {3,6,9,12,15};
		System.out.println("la media è "+ mediaMultipliDiTre(Array123));
		
		int[] Array110 = new int[] {0,1,2,3,4,5,6,7,8,9,10};
		System.out.println("ordine a zig zag ");
		stampaZigZag(Array110);
		
		System.out.println("\nla media dell'array è "+media(Array123));
		
		String [] parole = {"prova" , "prova1", "prova1!" };
		String inserisci = "Inserito";
		System.out.println(Arrays.toString(addString( inserisci , parole)));
	

	}
	public static int massimo(int[] array1) {
		int max = array1[0]; 
		for(int i = 0;i < array1.length; i++) {
			if (array1[i] > max) {
				max = array1[i];}
			}
		
		return max;
	}
	
	public static int indiceMassimo(int[] array1) {
		int max = array1[0]; 
		for(int i = 0;i < array1.length; i++) {
			if (array1[i] > max) {
				max = i;}
			}
		
		return max;
	}
	
	public static int minimo(int[] array1) {
		int min = array1[0]; 
		for(int i = 0;i < array1.length; i++) {
			if (array1[i] < min) 
				min = array1[i];}
		
		return min;
	}
	
	public static int indiceMinimo(int[] array1) {
		int min = array1[0]; 
		for(int i = 0;i < array1.length; i++) {
			if (array1[i] < min) 
				min = i;}
		
		return min;
	}
	
	public static boolean contains(int e, int[] array1) {
		for(int i = 0; i < array1.length ;i++) {
			if (array1[i] == e)
				return true;
		}
		return false;
	}
	
	public static boolean contains(Object e, Object[] array1) {
		for(int i = 0; i < array1.length ;i++) {
			if (array1[i].equals(e))
				return true;
		}
		return false;
	}
	
	public static boolean isCrescente(int[] array1) {
		int temp = array1[0];
		for(int i = 1;i<array1.length ; i++) {
			if (array1[i]<temp)
				return false;
		}
		return true;
	}
	
	public static int mostRecurrent(int[] array1) {
		int i=0;
		int ricorrente = 0;
		int cont1 = 0; // cont del piu ricorrente
		do {
			int cont = 0;
			for(int j=0; j < array1.length; j++) {
				if(array1[i]==array1[j])
						cont++;
			}
			if (cont > cont1) {
				cont1= cont;
				ricorrente = array1[i];
				}
			i++;
			
		}while(i < array1.length);
			
		
		return ricorrente;
		

		
	}

	public static int mediaMultipliDiTre(int[] array1) {
		int totale=0;
		int posti_usati = 0;
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] % 3 == 0) {
				totale += array1[i];
				posti_usati++;
			}
		}
		int media = totale/posti_usati;
		return media;
	}

	public static void stampaZigZag(int[] array1) {
		for(int i = 0; i < array1.length /2; i++) {
				System.out.print(array1[i]);	
				System.out.print(array1[array1.length-i-1]);	
		}
		if(array1.length%2!=0)
			System.out.print(array1[array1.length/ 2] );				
	}

	public static int media(int[] array1) {
		int totale=0;
		int posti_usati = 0;
		for(int i = 0; i < array1.length; i++) {
				totale += array1[i];
		}
		int media = totale/array1.length;
		return media;

}
	public static String [] addString ( String s , String [] a) {
		String [] b = new  String [a.length + 1];
		for ( int i=0 ; i<a.length ; i++) {
			b[i]= a[i];
			}
		b[a.length] = s;
		return b;
		}
	
	}
