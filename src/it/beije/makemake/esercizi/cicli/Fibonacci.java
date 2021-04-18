package it.beije.makemake.esercizi.cicli;

public class Fibonacci {

	public static void main(String[] args) {
		long first=0;
		long second=1;
		long third=0;
		
		System.out.print(first + "\n" + second + "\n");
		
		for ( int i=2; i<101 ; i++ ) {
				third= first + second;
				System.out.println(third);
				first= second;
				second= third;
		
		}
		

	}

}
