package it.beije.makemake.space;

public class Asteroid extends AstronomicalBody {


    public Asteroid(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    public Asteroid(double diameter, double mass, double meanDensity, Vector3D position) {
        super(diameter, mass, meanDensity, position);
    }

    @Override
    public String bodyType() {
        return "Asteroid";
    }
}
