package it.beije.makemake.esercizi.arrayutil;

//media con solo numeri positivi
public class MediaM3 {
	
	public static double mediaMultipliDiTre(int [] array){
		double media=0;
		int somma=0;
		int i=0;
		for( int cerca : array) {
			if (cerca<0 && cerca%3==0) {
				System.out.println("ERRORE!C'è un numero negativo!!");
				return cerca;
			}
			if(cerca%3==0) {
				somma += cerca;
				i++;
			}
			
		}
		media= (double)somma/(double)i;
		
	return media;	
	}
	
	public static void main (String [] args ) {
		int [] numeri = { 3, 2, -2, 4, 5, 6, 7, 4 };
		System.out.println(mediaMultipliDiTre( numeri ));
		
		
		
	}

}
