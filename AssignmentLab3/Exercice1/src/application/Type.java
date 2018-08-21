package application;

/** The enum for the type of Insurance */
public enum Type {

	L("Life"), H("Health");

	// Fields
	private String description;

	private Type(String description) {
		this.description = description;
	}

	// Getters and Setters
	protected String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
