package it.beije.makemake.space;

public class Vector3D {

    private final double x;
    private final double y;
    private final double z;


    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(x+v.x, y+v.y, z+v.z);
    }


}
