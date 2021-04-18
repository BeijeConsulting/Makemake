package it.beije.makemake.esercizi.arrayutil;

//solo se non più di un numero ricorrente
public class PiuRicorrente {

	
	public static int mostRecurrent ( int [] array ){
		
		System.out.println("Se tutti i numeri sono diversi il valore è -1");
		System.out.println("Ricerca del numero più ricorrente in corso...");
		
		int most= -1;
		int first_num = 0 , second_num= 0;
		
		for( int cerca : array ) {
			
			for(int i = 0; i<array.length ; i++) {
				
				if( cerca == array[i]) {
					second_num++;
				}
				
			}
			
		    if( second_num > first_num && second_num!=1) {
			   most=cerca;
		       first_num = second_num;
		       
		       
		    }
		    
		    
		    
		    second_num=0;
			
		}
		
			
		
	return most;	
		
	}
	public static void main (String [] args ) {
		int [] numeri = { 12, 2, 2, 4, 5, 6, 7, 9 };
		System.out.println(mostRecurrent ( numeri ));
		
		
		
	}
	
	
}
