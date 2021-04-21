package it.beije.makemake.spazio;

public class Vector3D {
	private final int x;
	private final int y;
	private final int z;
	
	public Vector3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public Vector3D add(Vector3D vector) {
		int newX, newY, newZ;
		newX = getX()+vector.getX();
		newY = getY()+vector.getY();
		newZ = getZ()+vector.getZ();
		
		return new Vector3D(newX, newY, newZ);
	}
}
