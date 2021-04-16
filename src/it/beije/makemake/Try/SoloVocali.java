package it.beije.makemake.Try;
import java.util.Arrays;
import java.util.Scanner;
public class SoloVocali {

	
	public static char[] vocali= {'a','e','i','o','u'};
	
	
	
	public static void main(String [] args) {
		
		String [] vett= {"Ciao","ciao","Sapere"};
		//stampaVocali(args[0]);
		soloMaiuscole(vett);
		 int result=contaLettera('a',"aaaaaaaaaao");
		 System.out.println(result);
		 stampaContrario("Ciao");
		 
		 String [] s = new String[args.length];
		 for(int i=0;i<args.length;i++) {
			 s[i]=args[i];
			 
		 }
	
		 myConcat(s);
		
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
	
	public static int contaLettera(char c,String str) {
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==c) {
				count+=1;
			}
		}
	
		return count;
	}
	
	public static void stampaContrario(String str) {
		
		String s="";
		
		for(int i=str.length()-1;i>=0;i--) {
			s+=str.charAt(i);
		}
		System.out.println(s);
		
	}
	
	public static void myConcat( String [] stri) {
		
		
		String  str="" ;
		
		for(int i=0;i<stri.length;i++) {
			if(i<(stri.length-1))	
			
				str+= stri[i] + "*";
			else str+=stri[i];
			
			}
		System.out.println(str);
		
	}
}

