package application;

/** Represents a Part time Tester. */
public class PartTimeGameTester extends GameTester {

	private int hours;

	//A constructor to create the object
	public PartTimeGameTester(String name, int hours) {
		super(false, name);
		this.hours = hours;
	}

	// Salary is based on the quantity of hour.
	@Override
	protected double getSalary() {
		return hours * 20;
	}

}
