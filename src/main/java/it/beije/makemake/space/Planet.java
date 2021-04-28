package it.beije.makemake.space;

public abstract class Planet extends AstronomicalBody {

    public Planet(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    public Planet(double diameter, double mass, double meanDensity, Vector3D position) {
        super(diameter, mass, meanDensity, position);
    }

    @Override
    public String bodyType() {
        return "Planet";
    }
}
