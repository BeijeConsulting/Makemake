package it.campagnoli.esercitazione;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class StringUtils {
	
	
	private final static List<Character> Vowels = Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'});
	
	public static void main(String[] args) {
		soloVocali("ciao a tutti questo programma funziona");
		stampaMaiuscole(new String[] {"Frase con maiuscola iniziale", "frase senza maiuscolA INIZIALE"});
		System.out.println(contaLettera('c', "ciao mondo"));
		contrario("viva java!");
	}
	
	//__________________________________________________________________________________________________
	//E' UNA VOCALE?____________________________________________________________________________________
	private static boolean isVocale(char letter){
		return  Vowels.contains(letter) ;
	}
	
	//__________________________________________________________________________________________________
	//SOLO VOCALI_______________________________________________________________________________________
	public static void soloVocali(String sentence) {
		for (int i=0; i < sentence.length(); i++){
			if(isVocale(sentence.charAt(i))) {
				System.out.print(sentence.charAt(i));
			}
		}
		System.out.println();
	}
	
	//__________________________________________________________________________________________________
	//STAMPA CON LA PRIMA LETTERA MAIUSCOLA_____________________________________________________________
	public static void  stampaMaiuscole(String[] stringArray) {
		for(int i=0; i < stringArray.length; i++) {
		if(Character.isUpperCase(stringArray[i].charAt(0)))
			System.out.println(stringArray[i]);
		}
	}
	
	//__________________________________________________________________________________________________
	//CONTA FREQUENZA LETTERA___________________________________________________________________________
	public static int contaLettera(char c, String str) {
		int counter=0;
		for(int i=0; i< str.length(); i++) {
				if(str.charAt(i)== c) {
					counter++;
				}
				return counter;
		}
		return 0;
	}
	
	//__________________________________________________________________________________________________
	//STAMPA AL CONTRARIO_______________________________________________________________________________
	public static void contrario(String str) {
		for(int i=str.length()-1; i>=0 ; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
			
}

