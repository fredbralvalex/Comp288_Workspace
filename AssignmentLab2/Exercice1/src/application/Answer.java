package application;

//represents one answer in the application
public class Answer {
	// Answer has a description, the item, and information if is correct or not
	private String description;
	private AnswerItem item;
	private boolean correct;

	// Constructor
	public Answer(String description, AnswerItem item, boolean correct) {
		this.description = description;
		this.item = item;
		this.correct = correct;
	}

	// Constructor without a item
	public Answer(String description, boolean correct) {
		this.description = description;
		this.correct = correct;
	}

	// Getters and Setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AnswerItem getItem() {
		//An item must have item when solicited
		if (item == null) {
			throw new IllegalStateException();
		}
		return item;
	}

	public void setItem(AnswerItem item) {
		this.item = item;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	// Method that prints the answer formated
	@Override
	public String toString() {
		return item + " ) " + description;
	}
}
