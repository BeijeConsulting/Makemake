package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class figuraAsterischi {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	} 

}
