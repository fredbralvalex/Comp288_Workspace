package application;

public class Shape {

	//Fields
	protected String _name;
	protected String _color;

	public Shape(String _name, String _color) {
		this._name = _name;
		this._color = _color;
	}

	//Getters
	public String getName() {
		return _name;
	}

	public String getColor() {
		return _color;
	}

	//Setters
	public void setName(String _name) {
		this._name = _name;
	}

	public void setColor(String _color) {
		this._color = _color;
	}

	public void printInformation() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return this._name + ", " + this._color;
	}

}
