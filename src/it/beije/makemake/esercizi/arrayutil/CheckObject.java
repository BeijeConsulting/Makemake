package it.beije.makemake.esercizi.arrayutil;

public class CheckObject {

	public static boolean boolean_contains (Object  e, Object [] array) {
		boolean flag = false;
		for (Object cerca : array)
			if(cerca==e)
				flag=true;
		
		
	return flag;	
	}
	public static void main(String[] args) {
		Object ricercato = "2";
		Object [] numeri = { "ciao", -34, 2, 0, "lol" };
		System.out.println(boolean_contains(ricercato, numeri));

	}

}