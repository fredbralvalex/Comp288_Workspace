package application;

public class Circle extends Shape {
	// Fields

	protected double _radius;
	// Methods
	// Accessor and Mutator

	// Getters
	public double getRadius() {
		return _radius;
	}

	public Circle(String _name, String _color, double _radius) {
		super(_name, _color);
		this._radius = _radius;
	}

	// Setters
	public void setRadius(double _radius) {
		this._radius = _radius;
	}

	public double calcArea() {
		return Math.pow(_radius, 2) * Math.PI;
	}

	@Override
	public String toString() {
		return this._radius + ", " + super.toString();
	}

}
