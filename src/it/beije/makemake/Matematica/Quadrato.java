package it.beije.makemake.Matematica;

public class Quadrato implements Poligoni  {

	private double lato;
	public Quadrato(double lato) {
		this.lato=lato;
		
	}
	
	public double getPerimetro() {
		double perimetro=0;
		perimetro=lato*4;
		return perimetro;
	}
	
	public double getArea() {
		double Area=0;
		Area=lato*lato;
		
		return Area;
	}
	
	public double getAltezza() {
		return lato;
	}
	
	public double getBase() {
		return lato;
	}
}
