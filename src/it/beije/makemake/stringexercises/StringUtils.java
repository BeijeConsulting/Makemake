package it.beije.makemake.stringexercises;

import java.util.Arrays;
import java.util.List;
public class StringUtils {


    private final static List<Character> VOWELS = Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'});

    public static void main(String[] args) {
        soloVocali("ciao a tutti questo programma funziona");

    }
    private static boolean isVocale(char letter){
        return  VOWELS.contains(letter) ;
    }
    public static void soloVocali(String sentence) {
        for (int i=0; i < sentence.length(); i++){
            if (isVocale(sentence.charAt(i))) {
                System.out.print(sentence.charAt(i));
            }
        }
    }



}

