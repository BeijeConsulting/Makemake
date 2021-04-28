package it.beije.makemake.matematica;

public class Parallelepipedo extends Rettangolo {


	private double profondita;
	public Parallelepipedo( double profondita) {
		super();
		this.profondita=profondita;


		
	}
	public double getVolume() {
		return (super.getArea()*profondita);
		
	}
	public double getSuperficeLat() {
		return( (super.getPerimetro()*2)*profondita);
		
	}
}
