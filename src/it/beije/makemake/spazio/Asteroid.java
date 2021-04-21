package it.beije.makemake.spazio;

public class Asteroid extends AstronomicalBody{

	public Asteroid(Double diameter, Double mass, Double meanDensity) {
		super(diameter, mass, meanDensity);
		// TODO Auto-generated constructor stub
	}
	
	public String bodyType() {
		return "I am an Asteroid";
	}
	
}
