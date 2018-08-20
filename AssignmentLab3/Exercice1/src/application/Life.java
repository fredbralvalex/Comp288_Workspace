package application;

/** Life as a subclass of Insurance. */
public class Life extends Insurance {

	public Life() {
		super(Type.L.getDescription());
	}

	// Implements the superclass method InsuranceCost.
	@Override
	public void setInsuranceCost(double cost) {
		setCost(cost);
	}

	// Implements the superclass method display Info.
	@Override
	public String displayInfo() {
		return getType() + " Insurance" + " - " + "Cost: " + getCost();
	}

}
