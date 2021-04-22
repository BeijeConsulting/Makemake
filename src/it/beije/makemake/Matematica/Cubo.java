package it.beije.makemake.Matematica;
import java.lang.Math;

public class Cubo implements FigureSolide {

private double lato;

public Cubo(double lato) {
	this.lato=lato;
}

public double getVolume() {
	return Math.pow(lato, 3);
}

public double getSuperficieLat() {
	return (4*Math.pow(lato, 2));
}

public double getSuperficieTot() {
	return (6*Math.pow(lato, 2));
}
}
