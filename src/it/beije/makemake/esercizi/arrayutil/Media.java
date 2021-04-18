package it.beije.makemake.esercizi.arrayutil;

//MEDIA QUADRATICA SEMPLICE
public class Media {
	
	public static double media(int [] array){
		double media=0;
		int somma=0;
		int i=0;
		for( int cerca : array) {
			
			
				somma += cerca*cerca;
				i++;
			
			
		}
		media= Math.sqrt((double)somma/(double)i);
		
		
	return media;	
	}
	
	public static void main (String [] args ) {
		int [] numeri = { -3, 2, -2, 4, 5, 6, 7, 4 };
		System.out.println(media( numeri ));
		
		
		
	}

}
