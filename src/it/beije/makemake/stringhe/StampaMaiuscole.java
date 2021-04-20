package it.beije.makemake.stringhe;

public class StampaMaiuscole {
	public static void main(String arg[]) {
		System.out.println(startsWithUpper(arg.toString()));
	}
	
	public static boolean startsWithUpper(String stringa) {
		char c = stringa.charAt(0);
		
		if(c >= 'A' && c <= 'Z')
			return true;
		else
			return false;
	}
}
