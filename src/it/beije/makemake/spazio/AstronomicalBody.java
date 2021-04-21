package it.beije.makemake.spazio;

public abstract class AstronomicalBody implements Movable {
	//in Km
	private final Double diameter;
	//in Kg
	private final Double mass;
	//in g/cm^3
	private final Double meanDensity;
	
	private Vector3D position;
	
	public AstronomicalBody(Double diameter, Double mass, Double meanDensity) {
		this.diameter = diameter;
		this.mass = mass;
		this.meanDensity = meanDensity;
		this.position = new Vector3D(0,0, 0);
	}

	public Double getDiameter() {
		return diameter;
	}

	public Double getMass() {
		return mass;
	}

	public Double getMeanDensity() {
		return meanDensity;
	}
	
	public abstract String bodyType();
	
	@Override
	public void move(Vector3D trasl) {
		position = position.add(trasl);
	}
}
