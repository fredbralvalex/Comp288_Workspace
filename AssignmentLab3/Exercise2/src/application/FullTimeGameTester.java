package application;

/** Represents a Full time Tester. */
public class FullTimeGameTester extends GameTester {

	//The constructor
	public FullTimeGameTester(String name) {
		super(true, name);
	}

	// A fixed salary for a full time tester.
	@Override
	protected double getSalary() {
		return 3000;
	}

}
