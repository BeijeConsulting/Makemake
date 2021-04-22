package it.beije.makemake.Matematica;

public class Rettangolo implements Poligoni {

	private double base;
	private double altezza;
	
	public Rettangolo(double base,double altezza){
		this.base=base;
		this.altezza=altezza;
	}
	
	public double getPerimetro() {
		double perimetro=0;
		
		perimetro=(base+altezza)*2;
		return perimetro;
	}
	
	public double getArea() {
		double Area=0;
		
		Area=((base*altezza)/2);
		return Area;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getAltezza() {
		return altezza;
	}
}
