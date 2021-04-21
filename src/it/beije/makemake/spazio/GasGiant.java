package it.beije.makemake.spazio;

public class GasGiant extends Planet{

	public GasGiant(Double diameter, Double mass, Double meanDensity) {
		super(diameter, mass, meanDensity);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String bodyType() {
		return "I am a Gas Giant";
	}
}
