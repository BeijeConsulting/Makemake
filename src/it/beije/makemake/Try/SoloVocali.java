package it.beije.makemake.Try;
import java.util.Arrays;
public class SoloVocali {

	public  String s;	
	public static char[] vocali= {'a','e','i','o','u'};
	
	
	
	public static void main(String [] args) {
		
		String [] vett= {"Ciao","ciao","Sapere"};
		stampaVocali(args[0]);
		soloMaiuscole(vett);
		
	}
	
	public static void stampaVocali(String diRitorno) {
		String vocals="";
		diRitorno=diRitorno.toLowerCase();
		  for(int i=0;i<diRitorno.length();i++) {
			 LOOP : for(int j=0;j<vocali.length;j++) {
				if(diRitorno.charAt(i)==vocali[j]) {
					vocals+=diRitorno.charAt(i);
					break LOOP;
				}
			}
			
		}
		
		System.out.println("" + vocals);
	}


	public static void soloMaiuscole(String [] parole) {
		
		for(int i=0;i<parole.length;i++) {
			//Bisogna cambiare la lettera in maiuscola per confrontarla
			String no=parole[i];
			no=no.toUpperCase();					
			char a= no.charAt(0);
			
			if(a==parole[i].charAt(0))
				System.out.println(""+ parole[i]);
			
		}
	}
	
	public int contaLettera(char c,String str) {
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==c) {
				count+=1;
			}
		}
	
		return count;
	}
}

