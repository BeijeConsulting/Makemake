package it.beije.makemake.stringa;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

		private final static List<Character> Vowels = Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'});
		
	
		private static boolean isVocale(char letter){
			return  Vowels.contains(letter) ;
		}
		public static void soloVocali(String sentence) {
			for (int i=0; i < sentence.length(); i++){
				if(isVocale(sentence.charAt(i))) {
					System.out.print(sentence.charAt(i));
				}
			}
		}
		
		public static void stampaMaiuscole(String[] stringArray) {
			for (int i = 0; i < stringArray.length; i++) {
				if(Character.isUpperCase(stringArray[i].charAt(0))) {
					System.out.println(stringArray[i]);
				}
			}
			
		}
		
		public static int contaLettera(char c,String str) {
			int cont=0;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)==c) {
					cont++;
				}
			}
			return cont;
		}
		
		public static void contrario(String str) {
			for(int i=str.length()-1;i>=0;i--) {
				System.out.print(str.charAt(i));
			}
		}

		public static void setter(String variabile) {
			String up=""+variabile.charAt(0);
			up=up.toUpperCase();
			System.out.println( "set"+up+ variabile.substring(1));
			
		}
		
		public static void getter(String variabile) {
			String up=""+variabile.charAt(0);
			up=up.toUpperCase();
			System.out.println( "get"+up+ variabile.substring(1));
			
		}
		
		public static void concatena(String word1,String word2,String word3) {
			System.out.println(word1+"*"+word2+"*"+word3);
		}
		
		public static void main(String[] args) {
			soloVocali("ciao a tutti questo programma funziona");
			System.out.println();
			stampaMaiuscole(new String[] {"Frase con maiuscola iniziale","frase senza maiuscola INIZIALE"});
		}
		
		
		
		
	}

