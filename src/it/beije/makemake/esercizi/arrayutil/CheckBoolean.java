package it.beije.makemake.esercizi.arrayutil;

public class CheckBoolean {

	public static boolean boolean_contains (int e, int [] array) {
		boolean flag = false;
		for (int cerca : array)
			if(cerca==e)
				flag=true;
		
		
	return flag;	
	}
	public static void main(String[] args) {
		int ricercato = 0;
		int [] numeri = {12, 34,2, 0, -3 };
		System.out.println(boolean_contains(ricercato, numeri));

	}

}
