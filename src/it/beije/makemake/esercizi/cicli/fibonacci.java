package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class fibonacci {
	public static void main(String[] args) {
		for(int i=0; i<100; i++)
		System.out.println(fibonaccio(i));
	}
						
	public static int fibonaccio(int n)  {
	    if (n < 2) 
	    	return n;

	    return (fibonaccio(n - 1) + fibonaccio(n - 2));
	}
}
