package it.beije.makemake;

public class Contrario {
	public static void main(String[] args) {
		String s = "CAZZO!";
		String inv = new String();
		
		for(int i=s.length()-1; i>=0; i--)
		{
				inv += s.charAt(i);
		}
		
		System.out.println("Stringa invertita: "+inv);
		
	}
}
