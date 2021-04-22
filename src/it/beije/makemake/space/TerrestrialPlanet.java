package it.beije.makemake.space;

public class TerrestrialPlanet extends Planet{

    private boolean inhabited;
    private boolean hasWater;

    public TerrestrialPlanet(double diameter, double mass, double meanDensity) {
        super(diameter, mass, meanDensity);
    }

    public TerrestrialPlanet(double diameter, double mass, double meanDensity, boolean inhabited) {
        super(diameter, mass, meanDensity);
        this.inhabited = inhabited;
    }

    public TerrestrialPlanet(double diameter, double mass, double meanDensity, boolean inhabited, boolean hasWater) {
        super(diameter, mass, meanDensity);
        this.inhabited = inhabited;
        this.hasWater = hasWater;
    }

    public boolean isInhabited() {
        return inhabited;
    }

    public void setInhabited(boolean inhabited) {
        this.inhabited = inhabited;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    @Override
    public String bodyType() {
        return "Terrestrial " + super.bodyType();
    }
}
