package it.beije.makemake;

public class SoloVocali {
	public static void main(String[] args) {
		String string1 = "Vocali";
		String vect_voc = "aeiou";
		String new_str = new String();
		
		boolean flag = false;
		string1 = string1.toLowerCase();
		int x = string1.length();
		
		//Ciclo sulle due stringhe
		for(int  k=0; k<x; k++) {
			for (int  j=0; j<vect_voc.length(); j++) {	
				//se trovo una vocale la memorizzo!
			if (string1.charAt(k) == vect_voc.charAt(j)) { 
				new_str += string1.charAt(k);
				flag = true;
			}
			}
		}
		//Solo se ho il flag stampo le vocali trovate!
		if(flag) System.out.println(new_str);
		else System.out.println("Nessuna vocale!");
		

	}

}