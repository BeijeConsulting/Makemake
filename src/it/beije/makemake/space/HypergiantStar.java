package it.beije.makemake.space;

public class HypergiantStar extends Star {
    public HypergiantStar(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    @Override
    public String bodyType() {
        return "Hypergiant " + super.bodyType();
    }
}
