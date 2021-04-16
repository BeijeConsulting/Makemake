package it.beije.makemake.esercizi.stringutil;


public class StampaMaiuscole {
	public static void main(String[] args) {
		
		
		for (int i=0 ; i<args.length ; i++)
		if ( args[i].charAt(0) > 61 && args[i].charAt(0) <91)
			System.out.println(args[i]);
		
		
		
		
	}

}
