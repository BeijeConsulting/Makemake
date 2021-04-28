package it.beije.makemake.space;

public class GasGiant extends Planet {

    public GasGiant(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    @Override
    public String bodyType() {
        return "Gas giant " + super.bodyType();
    }
}
