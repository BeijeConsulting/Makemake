package it.beije.makemake.Matematica;

import java.lang.Math;
public class Parallelepipedo extends Rettangolo implements FigureSolide{

	
	private double profondita;
	public Parallelepipedo(double base, double altezza,double profondita) {
		super(base,altezza);
		
		this.profondita=profondita;
	
	}
	
	public double getVolume() {
		return (super.getArea()*profondita);
	}
	
	public double getSuperficieLat() {
		return( (super.getPerimetro()*2)*profondita);
	}
	
}
