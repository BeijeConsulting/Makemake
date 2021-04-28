package it.beije.makemake.space;

public class DwarfStar extends Star {


    public DwarfStar(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    @Override
    public String bodyType() {
        return "Dwarf " + super.bodyType();
    }
}
