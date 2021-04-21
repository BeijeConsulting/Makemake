package it.beije.makemake.spazio;

public abstract class IceGiant extends Planet {

	public IceGiant(Double diameter, Double mass, Double meanDensity) {
		super(diameter, mass, meanDensity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String bodyType() {
		return "I am a IceGiant";
	}
}
