package application;

/** Represents the type of a book in the system. */
public enum Gender {

	//The Types of Gender
	C("Child"), S("Science");

	private String description;

	private Gender(String description) {
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
