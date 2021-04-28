package it.beije.makemake.matematica;

public class Rettangolo implements FigurePiane {
	
	private double base;
	private double altezza;
	
	public Rettangolo(double base, double altezza){
		this.base=base;
		this.altezza=altezza;
		
	}
	
	 public Rettangolo () {}
	
	 public double getPerimetro() {
		 double perimetro=0;
		 
		 perimetro = 2*(base+altezza);
		
		 return perimetro;
		 
	 }
	 
	 public double getArea() {
		 double area=0;
		 
		 area=((base*altezza)/2);
		 return area;
		 
	 }
	 
	 public double getBase() {
		 
		 
		 
		 return base;
	 }
	 public double getAltezza() {
		 
		 
		 
		 return altezza;
	 }


}

