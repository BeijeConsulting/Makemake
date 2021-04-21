package it.beije.makemake.spazio;

public  class TerestrialPlanet extends Planet {
	private final boolean inhabited;
	private final boolean hasWater;
	
	public TerestrialPlanet(Double diameter, Double mass, Double meanDensity) {
		super(diameter, mass, meanDensity);
		this.inhabited = false;
		this.hasWater = false;
		// TODO Auto-generated constructor stub
	}
	
	public TerestrialPlanet(Double diameter, Double mass, Double meanDensity, boolean inhabited, boolean hasWater) {
		super(diameter, mass, meanDensity);
		this.inhabited = inhabited;
		this.hasWater = hasWater;
	}
	
	public boolean isInhabited() {
		return inhabited;
	}

	public boolean isHasWater() {
		return hasWater;
	}

	@Override 
	public String bodyType() {
		return "I am a terestrialPlanet";
	}
	
}
