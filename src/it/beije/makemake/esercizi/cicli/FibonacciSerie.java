package it.beije.makemake.esercizi.cicli;


public class FibonacciSerie {


	public static void main(String[] args) {
		
		StringBuilder serie = new StringBuilder("");
		long first=0;
		long second=1;
		long third=0;
		
		serie.append(first);
		System.out.println(serie.toString());
	
		
		for ( int i=1; i<10 ; i++ ) {
				third= first + second;
				serie.append(", " + third);
				System.out.println(serie.toString());
				first= second;
				second= third;
		
		}
		

	}

}

