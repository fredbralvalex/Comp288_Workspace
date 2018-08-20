package application;

public class Cylinder extends Circle {

	// Fields
	private double _height;


	public Cylinder(String _name, String _color, double _radius, double _height) {
		super(_name, _color, _radius);
		this._height = _height;
	}

	// Getters
	public double getHeight() {
		return _height;
	}

	// Setters
	public void setHeight(double _height) {
		this._height = _height;
	}

	@Override
	public double calcArea() {
		return (2 * Math.PI * this._radius * this._height) + 2 * super.calcArea() * this._height;
	}

	public double calcCiliVolume() {
		return super.calcArea() * this._height;
	}

	@Override
	public String toString() {
		return this._height + ", " + super.toString();
	}

}
