package application;

/** The class that represents a tester */
public abstract class GameTester {
	// Filds
	private String name;
	// The tester can be full-time or part-time
	protected boolean fulltime;

	// Constructor
	public GameTester(boolean fulltime, String name) {
		this.fulltime = fulltime;
		this.name = name;
	}

	// Getters and Setters
	protected String getName() {
		return name;
	}

	protected boolean isFulltime() {
		return fulltime;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	// each subclass implements the salary
	protected abstract double getSalary();

	// prints the information about job
	@Override
	public String toString() {
		return "Name: " + name + "; " + (fulltime ? Job.F : Job.P) + "; Salary: " + getSalary();
	}
}
