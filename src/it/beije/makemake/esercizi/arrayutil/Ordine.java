package it.beije.makemake.esercizi.arrayutil;

// SENZA SORT
public class Ordine {

	
	public static boolean  booleanIsCrescente (int [] array ) {
		boolean flag = false;
		
/*UPPER:*/	for ( int i=0 ; i<array.length-2 ; i++) {
				if(  array[array.length-1] >= array[array.length-2] && array[i] <= array[i+1]) {
					flag = true;
					//continue UPPER;
				}else {
			
			
				flag = false;
				//break UPPER;
				}
			
			}
	        
		return flag;	
	}
	public static void main (String [] args ) {
		int [] numeri = { -122, 2, 12, 12};
		System.out.println(booleanIsCrescente ( numeri));
		
		
		
	}
	
	
}
