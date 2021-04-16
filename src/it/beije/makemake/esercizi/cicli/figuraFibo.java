package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class figuraFibo {						
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("inserisci righe: ");
		int n=in.nextInt();
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<i+1; j++) {
				System.out.print(fibonacci.fibonaccio(j)+ ", ");
		}System.out.println();
		}
	}
}
