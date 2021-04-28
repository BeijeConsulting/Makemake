package it.beije.makemake.matematica;

import java.lang.Math;

public class Tetraedro extends Triangolo{
	private double altezza;
	
	
	public Tetraedro(double altezza) {
		super();
		this.altezza=altezza;
		
		
		
	}
	public double getSuperficeTot() {
		return super.getArea()*4;
	}
	public double getSuperficeLat() {
		return super.getArea()*3;
	}
	public double getVolume() {
		return super.getArea()*lato;
	}
}
