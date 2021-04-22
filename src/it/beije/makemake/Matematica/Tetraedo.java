package it.beije.makemake.Matematica;


import java.lang.Math;


public class Tetraedo implements SolidiRegolari   {
	private double lato;
	
	public Tetraedo (double lato) {
		this.lato=lato;

	}
	
	public double getSuperficieTot() {
		return (Math.sqrt(3)*(lato*lato*lato));
	}
	
	public double getSuperficieLat() {
		return ((3/4)*(Math.sqrt(3))*(lato*lato));
	}
	
	public double getVolume() {
		return ((Math.sqrt(2)/12)*(lato*lato*lato));
	}
}
