package it.beije.makemake.matematica;

public class Cubo extends Quadrato{
	 
	private double lato; 
	
	public Cubo() {
		super();
		lato=super.getBase();
	}
	public double getVolume() {
		return super.getArea()*lato;
		
	}
	public double getSuperficeLat() {
		return super.getPerimetro()*4;
	}
	public double getSuperficeTot() {
		return super.getPerimetro()*6;
	}
	
	
}
