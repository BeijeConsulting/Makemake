package it.beije.makemake.esercizi.stringhe;

import java.util.Scanner;

public class morraCinese {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("scegli carta forbice o sasso: ");
		String s1= in.nextLine();
		System.out.println("scegli carta forbice o sasso: ");
		String s2= in.nextLine();
		in.close();
		if(s1.equals(s2)) {
			System.out.println("Pareggio");
		}
		
		else if(s1.equals("carta") && s2.equals("forbici"))
			System.out.println("forbici vince su carta");
		else if(s1.equals("forbici") && s2.equals("carta"))
			System.out.println("forbici vince su carta");
		else if(s1.equals("sasso") && s2.equals("forbici"))
			System.out.println("sasso vince su forbici");
		else if(s1.equals("forbici") && s2.equals("sasso"))
			System.out.println("sasso vince su forbici");
		else if(s1.equals("carta") && s2.equals("sasso"))
			System.out.println("carta vince su sasso");
		else if(s1.equals("sasso") && s2.equals("carta"))
			System.out.println("carta vince su sasso");
	}

}
