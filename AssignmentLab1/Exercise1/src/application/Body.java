package application;

//This class represents a body's person in weight and height
public class Body {
	// Attributes for the class
	private double weight;// the weight in pounds
	private double height;// the height in feet

	// Must receive the values in height and weight
	public Body(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}

	// getter
	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	// setter
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
