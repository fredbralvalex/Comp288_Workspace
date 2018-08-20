package application;

/**This is the abstract class Insurance*/
public abstract class Insurance {
	//Fields
	protected String type;
	protected double cost;

	//Constructors
	public Insurance(String type) {
		this.type = type;
	}

	// Getters and Setters
	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	protected double getCost() {
		return cost;
	}

	protected void setCost(double cost) {
		this.cost = cost;
	}

	// Insurance cost Setter for the subclasses.
	protected abstract void setInsuranceCost(double cost);

	// Show the information about the subclasses.
	protected abstract String displayInfo();


}
