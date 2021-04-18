package it.beije.makemake.esercizi.arrayutil;

public class MediaM3Negativi {
	
	public static double mediaMultipliDiTre(int [] array){
		double media=0;
		int somma=0;
		int i=0;
		for( int cerca : array) {
			
			if(cerca%3==0) {
				somma += cerca*cerca;
				i++;
			}
			
		}
		media= Math.sqrt((double)somma/(double)i);
		
		
	return media;	
	}
	
	public static void main (String [] args ) {
		int [] numeri = { -3, 2, -2, 4, 5, 6, 7, 4 };
		System.out.println(mediaMultipliDiTre( numeri ));
		
		
		
	}

}

