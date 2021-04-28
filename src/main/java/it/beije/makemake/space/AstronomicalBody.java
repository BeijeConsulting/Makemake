package it.beije.makemake.space;

public abstract class AstronomicalBody implements Movable {

    private final double diameter; //in kms
    private final double mass; //in kgs
    private final double meanDensity; //in g/cm^3
    private Vector3D position = new Vector3D();

    public AstronomicalBody(double diameter, double mass, double meanDensity) {
        this.diameter = diameter;
        this.mass = mass;
        this.meanDensity = meanDensity;
    }

    public AstronomicalBody(double diameter, double mass, double meanDensity, Vector3D position) {
        this.diameter = diameter;
        this.mass = mass;
        this.meanDensity = meanDensity;
        this.position = position;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getMass() {
        return mass;
    }

    public double getMeanDensity() {
        return meanDensity;
    }

    public abstract String bodyType();

    @Override
    public void move(Vector3D translation) {
        position = position.add(translation);
    }

}
