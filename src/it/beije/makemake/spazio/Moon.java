package it.beije.makemake.spazio;

public class Moon extends AstronomicalBody {

	public Moon(Double diameter, Double mass, Double meanDensity) {
		super(diameter, mass, meanDensity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String bodyType() {
		return "I am a moon";
	}
}
