package it.beije.makemake.secondasettimana.venerdi;

public class Contrario {
	public static void main(String arg[]) {
		System.out.println(contrario(arg.toString()));
	}
	
	public static String contrario(String str) {
		StringBuilder newStr = new StringBuilder();
		
		for(int i = str.length()-1; i >= 0; i--) {
			newStr.append(str.charAt(i));
		}
		
		return newStr.toString();
		
	}

}
