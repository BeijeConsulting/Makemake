package it.beije.makemake.matematica;

public class Principale {
   public static void main (String [] args) {
	   
	   Rettangolo r1 = new Rettangolo(2,3);
	   System.out.println(r1.getArea());
   
	   Parallelepipedo p1 = new  Parallelepipedo(2);
	   System.out.println(p1.getVolume());
   }
}
