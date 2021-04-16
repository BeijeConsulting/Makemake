package it.beije.makemake.esercizi.stringutil;
import  java.util.Scanner;
public class Concatena {

	public static void main(String[] args) {
		System.out.println("Quante parole vuoi inserire?");
		Scanner tastiera = new Scanner(System.in);
		int numParole = tastiera.nextInt();
		System.out.println("Inserisci " + numParole + " parole, per magia le unirò con il simbolo * !!!");
		
		StringBuilder sb = new StringBuilder();
		int contatore=0;
		do{
			
			System.out.println("Parola:");
			String s1 = tastiera.next();
			if(contatore==numParole-1)
				sb.append(s1);
			else
			sb.append(s1).append('*');
			contatore++;
		}while (contatore!=numParole);
			
		tastiera.close();
		System.out.print(sb);
		
		
		

	}

}
