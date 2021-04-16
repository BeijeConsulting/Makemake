package it.beije.makemake;

public class FirstLetterSt {
	
	public static void main(String[] args) {
		
		String[] strings = {"Uno", "due", "Tre", "quattro"};
		boolean flag = false;
		int min = 65, max = 90;
		String ext = new String();
		
		for(int k=0; k < strings.length; k++) {
			if(strings[k].charAt(0) >= min && strings[k].charAt(0) <= max) {
				 ext += strings[k]+", ";
				 flag = true;
			}
		}
		
		if (flag) System.out.println("Stringhe trovate: "+ext);
			else System.out.println("Non trovate stringhe UpperInit");
}
}