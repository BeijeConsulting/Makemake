package it.beije.makemake.space;

public class IceGiant extends Planet{

    public IceGiant(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    @Override
    public String bodyType() {
        return "Ice giant " + super.bodyType();
    }
}
