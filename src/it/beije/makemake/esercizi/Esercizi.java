package it.beije.makemake.esercizi;

public class Esercizi {

	private String s;

	public void getVoc(String stringa) {
		char a;
		s = stringa.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			a = s.charAt(i);
			switch (a) {

			case 'a':
				System.out.println(a);
				break;
			case 'e':
				System.out.println(a);
				break;

			case 'i':
				System.out.println(a);
				break;

			case 'o':
				System.out.println(a);
				break;

			case 'u':
				System.out.println(a);
				break;

			}

		}

	}

	public void getMiuscolo(String... strings) {
		for (int i = 0; i < strings.length; i++) {
			char x = strings[i].charAt(0);
			Character c = new Character(x);

			if (c.isUpperCase(x) == true) {
				System.out.println(c);
			}
		}

	}

	public int contaLettera(char c, String str) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				counter += 1;
			}
		}
		return counter;
	}

	public StringBuilder reverse(String stringa) {
		StringBuilder sb = new StringBuilder();
		sb.append(stringa);
		sb.reverse();

		return sb;
	}

	public StringBuilder concatenate(String... s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]);
			if (i != s.length - 1) {
				sb.append("*");

			}
		}
		return sb;
	}

}
