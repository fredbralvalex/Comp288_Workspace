package application;

public class Sphere {

	/** Fields */
	private double _radius;

	public Sphere(double newRad) {
		this._radius = newRad;
	}

	/** Methods */
	double getRadius() {
		return _radius;
	}

	public double calcSphereVolume() {
		double volume = 4.0 / 3.0 * Math.PI * Math.pow(_radius, 3);
		return volume;

	}
}
