package it.beije.makemake.space;

public abstract class Star extends AstronomicalBody {


    public Star(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    public Star(double diameter, double mass, double meanDensity, Vector3D position) {
        super(diameter, mass, meanDensity, position);
    }

    @Override
    public String bodyType() {
        return "Star";
    }

}
