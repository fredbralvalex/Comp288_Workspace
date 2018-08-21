package application;

//This class represents a question in this application
public class Question {

	// Question has one sentence and a list of multiple choice answers
	private String description;
	private Answer[] answers;

	// the constructor for question - Answers have to be added.
	public Question(String description) {
		this.description = description;
	}

	// Getters and Setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Answer[] getAnswers() {
		return answers;
	}

	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}

	// Method that gets the correct answer
	public AnswerItem getCorrectAnswer() {
		for (int index = 0; index < answers.length; index++) {
			if (answers[index].isCorrect()) {
				return answers[index].getItem();
			}
		}
		// Exception for don't have a correct answer.
		throw new IllegalStateException();
	}

	// Method that sort a list of answers based on the order item
	private void sortAnswers() {
		// Answer[] answersLocal = new Answer[answers.length];

		for (int index = 0; index < answers.length; index++) {
			Answer temp = answers[index];
			for (int jIndex = index; jIndex < answers.length; jIndex++) {
				if (answers[index].getItem().getOrder() > answers[jIndex].getItem().getOrder()) {
					temp = answers[index];
					answers[index] = answers[jIndex];
					answers[jIndex] = temp;
				}
			}
		}
	}

	// Method that prints the question with the formated answers.
	@Override
	public String toString() {
		this.sortAnswers();

		String allAnswers = "";
		for (int index = 0; index < answers.length; index++) {
			allAnswers = allAnswers + "\n" + answers[index].toString();
		}

		return "\n" + description + "\n" + allAnswers + "\n\n";
	}

}
