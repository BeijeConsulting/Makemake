package it.beije.makemake.Matematica;

public class Triangolo implements Poligoni {
private double base;
private double altezza;
private double lato;
private double lato1;
private String tipo;

	public Triangolo(double base,double altezza,String tipo) {
		this.base=base;
		this.altezza=altezza;
		this.tipo=tipo;
	}
	
	public Triangolo (double lato,double base,double altezza,String tipo ) {
		this.base=base;
		this.altezza=altezza;
		this.lato=lato;
		this.tipo=tipo;
	}
	
	public Triangolo (double base,double lato,double lato1,double altezza,String tipo) {
		this.base=base;
		this.altezza=altezza;
		this.lato=lato;
		this.tipo=tipo;
		this.lato1=lato1;
	}
	
	public double getPerimetro() {
		double perimetro=0;
		
		switch(tipo.toLowerCase()) {
		case "isoscele" : 
			perimetro=((lato*2)+base);
			break;
		case "equilatero" : 
			perimetro= (base*3);
			break;
		case "scaleno" : 
			perimetro= (lato1+lato+base);
			break;
		}
		
		
		return perimetro;
	}
	
	public double getArea() {
		
		return ((base*altezza)/2);
	}
	
	public double getBase() {
		return base;
	}
	
	public double getAltezza() {
		return altezza;
	}
}
