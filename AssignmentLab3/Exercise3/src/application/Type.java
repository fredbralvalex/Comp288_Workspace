package application;

/** Represents the type of mortgages in the system. */
public enum Type {

	// The Types of Gender
	B("Business"), P("Personal");

	private String description;

	private Type(String description) {
		this.description = description;
	}

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
