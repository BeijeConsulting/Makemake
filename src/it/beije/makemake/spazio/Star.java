package it.beije.makemake.spazio;

public abstract class Star extends AstronomicalBody{

	public Star(Double diameter, Double mass, Double meanDensity) {
		super(diameter, mass, meanDensity);
		// TODO Auto-generated constructor stub
	}
	
	public abstract String bodyType();
}
