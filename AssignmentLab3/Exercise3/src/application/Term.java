package application;

/** Represents the term of mortgages in the system. */
public enum Term {

	// The Types of Gender
	S("Short-term"), M("Medium-term"), L("Long-term");

	private String description;

	private Term(String description) {
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
