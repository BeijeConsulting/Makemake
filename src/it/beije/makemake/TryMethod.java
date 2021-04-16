package it.beije.makemake;

public class TryMethod {
	public static void main(String[] args) {
		
	String string1 = "occurence";	
	char cht = 'c';
		
	int cnt = contaLettera(cht, string1);
	System.out.println("Occorrenze di "+cht+" nella stringa: "+string1+" = "+cnt);
		
	}
	
	public static int contaLettera(char c, String s) {
		int counter = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == c)
				counter++;
		}
		return counter;
	}

}
