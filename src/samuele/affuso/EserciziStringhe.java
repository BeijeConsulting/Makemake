package samuele.affuso;
import java.util.Scanner;

public class EserciziStringhe {
	public static void main(String[] args) {
		 Scanner tastiera = new Scanner(System.in);
		System.out.println(getVocale("cAio"));
		String [] a = {"ciao","Ciao","ssSs","CAIIS"};
		isStampaMaiuscole(a);
		System.out.println(contaLettera('c',"ciao"));
		System.out.println(reverse("ciao"));
		System.out.println("inserisci tre stringhe per concatenarle");
		System.out.println(concatena(tastiera.nextLine(),tastiera.nextLine(), tastiera.nextLine()));
		System.out.println(setter("ciao"));
		System.out.println(getter("ciao"));
			
			
		}
	
	public static String getVocale(String s) {
		String s1 = new String();
		for(int i=0;i < s.length();i++) {
			switch (s.charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				s1 +=s.charAt(i);
				break;
			}}
		return s1;
		
	}

	public static void isStampaMaiuscole(String [] s) {
		for(int i=0; i < s.length; i++) {
			 if(Character.isUpperCase(s[i].charAt(0))) 
		         System.out.println(s[i]);
		}
		}

	public static int contaLettera(char c, String str) {
		int occ=0;
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)==c)
				occ++;
			
		}
		return occ;
		
	}
	
	public static String reverse(String str) {
		String s=new String();
		for(int i=str.length()-1;i>=0;i--) {
			s= s+(str.charAt(i));
		}
		return s;
	}

	public static String concatena(String str1, String str2, String str3) {
		String concatenata = str1 + "*" + str2 + "*" + str3;
		return concatenata;
		
	}
	
	public static String setter(String str) {
		String str1= "set"+ str + "()";
		return str1;
		
	}

	public static String getter(String str) {
		String str1= "get"+ str + "()";
		return str1;
		
	}
}
