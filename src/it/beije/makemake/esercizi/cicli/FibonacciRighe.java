package it.beije.makemake.esercizi.cicli;

import java.util.ArrayList;
public class FibonacciRighe {


		public static void main(String[] args) {
			ArrayList<Long>serie = new ArrayList<>();
			long first=0;
			long second=1;
			long third=0;
			
			serie.add( 0, second);
			System.out.println(serie.toString());
		
			
			for ( int i=1; i<10 ; i++ ) {
					third= first + second;
					serie.add( i, third);
					System.out.println(serie.toString());
					first= second;
					second= third;
			
			}
			

		}

	}

