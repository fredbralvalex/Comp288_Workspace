package application;

/** Represents the type of job */
public enum Job {
	P("Part-Time"), F("Full-Time");

	private String description;

	private Job(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
