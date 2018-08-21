package application;

/** Health as a subclass of Insurance. */
public class Health extends Insurance {

	public Health() {
		super(Type.H.getDescription());
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
