package it.beije.makemake.space;

public class Moon extends AstronomicalBody {

    public Moon(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    public Moon(double diameter, double mass, double meanDensity, Vector3D position) {
        super(diameter, mass, meanDensity, position);
    }

    @Override
    public String bodyType() {
        return "Moon";
    }
}
