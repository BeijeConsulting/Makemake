package it.beije.makemake.esercizi.stringutil;

public class Getter {
    public static String ilMetodo(String laVariabile)
    {
        String ilMetodo = laVariabile.substring(0, 1).toUpperCase()+laVariabile.substring(1);
 
        return "get" + ilMetodo + "()";
    }
	public static void main(String[] args) {
		System.out.println(ilMetodo("ciaoCiao"));
	}
}
