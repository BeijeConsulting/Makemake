package it.beije.makemake.esercizi.arrayutil;
import java.util.Arrays;
public class AggiungiStringa {

	public static String [] addString ( String s , String [] a) {
		String [] b = new  String [a.length + 1];
		for ( int i=0 ; i<a.length ; i++) {
			b[i]= a[i];
			
		}
		b[a.length] = s;
	return b;
	}
	public static void main(String[] args) {
		String [] parole = {"Ciao" , "Ciao!", "Ciao!?" };
		String inserisci = "Ma ciao NO";
		System.out.println(Arrays.toString(addString( inserisci , parole)));
		
	}

}
