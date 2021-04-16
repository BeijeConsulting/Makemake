package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class figuraNumeri {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		for(int i=0; i<6; i++) {
			for(int j=1; j<=i+1; j++) {
				System.out.print(j);
			}
			for(int j=0; j<3; j++) {
				System.out.print(" ");
			}
			for(int j=6; j>i; j--) {
				System.out.print(j-i);
			}System.out.println();
	}
}
}