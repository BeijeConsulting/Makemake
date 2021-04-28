package it.beije.makemake.matematica;

public class Triangolo implements FigurePiane {

private double base;
private double altezza;
private double lato1;
private String tipo;
private double lato2;

	public Triangolo(double base, double altezza, String tipo) {
		this.base=base;
		this.altezza=altezza;
		this.tipo=tipo;
	
		
		
	}

	public Triangolo(double lato1, double base, double altezza, String tipo ) {
		this.lato1=lato1;
		this.base=base;
		this.altezza=altezza;
		this.tipo=tipo;
	}
	public Triangolo(double lato1, double lato2, double base, double altezza, String tipo ) {
		this.lato2=lato2;
		this.lato1=lato1;
		this.base=base;
		this.altezza=altezza;
		this.tipo=tipo;
	}
	
	
	
	public double getPerimetro() {
		
		double perimetro=0;
		switch(tipo.toLowerCase()) {
		case "isoscele":
			perimetro=((lato1*2)+base);
			break;
		case "equilatero":
			perimetro= (base*3);
			break;
		case "scaleno":
			perimetro=(lato1 + lato2 + base);
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
