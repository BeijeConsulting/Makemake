package it.beije.makemake;

public class Concatena {
	public static void main(String[] args) {
		
		String[] s_v = new String[args.length];
		String s_cat = new String();
		
		for (int i=0; i<args.length; i++) {
			s_v[i] = args[i];
		}		
		for (int j=0; j<args.length; j++) {
			if (j<(args.length-1))
			s_cat +=  (s_v[j]+"*");
			else s_cat += (s_v[j]);
		}		

		System.out.println("Stringhe Concatenate: "+s_cat);		
	}		
}
