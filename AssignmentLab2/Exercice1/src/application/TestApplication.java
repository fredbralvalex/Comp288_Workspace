package application;

import java.util.Locale;
import java.util.Random;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;

//Class that represents a Test in this application
public class TestApplication {

	static {
		Locale.setDefault(Locale.CANADA);
	}

	// Creates questions
	public void simulateQuestion() {

		Question[] questions = new Question[5];
		// Declaration and initialization for the 5 questions
		questions[0] = new Question("When using the command 'javac', the compiler will create a file:");
		Answer[] answersQ1 = new Answer[4];
		answersQ1[3] = new Answer(".java", false);
		answersQ1[2] = new Answer(".javac", false);
		answersQ1[1] = new Answer(".class", true);
		answersQ1[0] = new Answer(".object", false);
		questions[0].setAnswers(answersQ1);

		questions[1] = new Question("The command used to execute the java program 'App' is:");
		Answer[] answersQ2 = new Answer[4];
		answersQ2[0] = new Answer("cmd App.java", false);
		answersQ2[2] = new Answer("run my App.java", false);
		answersQ2[1] = new Answer("javac App.java", false);
		answersQ2[3] = new Answer("java App.java", true);
		questions[1].setAnswers(answersQ2);

		questions[2] = new Question("Choose the correct sentence:");
		Answer[] answersQ3 = new Answer[4];
		answersQ3[1] = new Answer("Java is not case sensitive.", false);
		answersQ3[0] = new Answer("The 'main' method do not have any argument.", false);
		answersQ3[3] = new Answer("Every class declaration must have parentheses.", false);
		answersQ3[2] = new Answer("JVM will not execute the application with a non-static main.", true);
		questions[2].setAnswers(answersQ3);

		questions[3] = new Question("It is a well defined java class variable.");
		Answer[] answersQ4 = new Answer[4];
		answersQ4[0] = new Answer("_name", true);
		answersQ4[1] = new Answer("Name", false);
		answersQ4[2] = new Answer("NaME", false);
		answersQ4[3] = new Answer("naME", false);
		questions[3].setAnswers(answersQ4);

		questions[4] = new Question("Wich one is not a valid type in java:");
		Answer[] answersQ5 = new Answer[4];
		answersQ5[0] = new Answer("int", false);
		answersQ5[1] = new Answer("byte", false);
		answersQ5[2] = new Answer("double", false);
		answersQ5[3] = new Answer("string", true);
		questions[4].setAnswers(answersQ5);

		//Get a random option
		shufflerAnswers(questions);
		// Shows the question to the user
		inputAnswer(questions);
	}

	// Iterate over questions to use shuffled items
	private void shufflerAnswers(Question[] questions) {
		for (int index = 0; index < questions.length; index++) {
			shufflerItens(questions[index].getAnswers());
		}
	}

	// Shuffle items to use in each answer
	private void shufflerItens(Answer[] answers) {
		AnswerItem[] answerItems;
		answerItems = AnswerItem.values();
		for (int index = 0; index < answers.length; index++) {
			AnswerItem item = pickItem(answerItems);
			answers[index].setItem(item);
		}
	}

	// picking a non used item
	private AnswerItem pickItem(AnswerItem[] answerItems) {
		Random randomObject = new Random();
		int index = randomObject.nextInt(4);
		if (answerItems[index] == null) {
			return pickItem(answerItems);
		} else {
			AnswerItem item = answerItems[index];
			answerItems[index] = null;
			return item;
		}
	}

	// Method that shows the question, asks the user answer check if it is
	// correct, gives a feed back and show the result.
	private void inputAnswer(Question[] questions) {

		int numberQuestions = questions.length;
		int counterCorrect = 0;

		for (int index = 0; index < questions.length; index++) {
			AnswerItem answer = promptAnswer(questions[index]);
			boolean isCorrect = checkAnswer(questions[index], answer);
			if (isCorrect) {
				counterCorrect++;
			}
			String message = generateMessage(isCorrect);
			JOptionPane.showMessageDialog(null, message);
		}
		String result = "You got:\n " + counterCorrect + " correct answers!\n" + (numberQuestions - counterCorrect)
				+ " incorrect answers!\n\n" + " Your overall is: " + ((counterCorrect * 100) / numberQuestions)
				+ "% !!!";

		JOptionPane.showMessageDialog(null, result);

	}

	// Checks if the answer is correct
	private boolean checkAnswer(Question question, AnswerItem answer) {
		return question.getCorrectAnswer() == answer;
	}

	// Generates message according to the answer
	private String generateMessage(boolean isCorrect) {

		Random randomObject = new Random();
		switch (randomObject.nextInt(4)) {
		case 0:
			return (isCorrect ? "Nice work!" : "No. Please try again!");
		case 1:
			return (isCorrect ? "Excellent!" : "Wrong. Try once more!");
		case 2:
			return (isCorrect ? "Good!" : "Don't give up!");
		case 3:
			return (isCorrect ? "Keep up the good work!" : "No. Keep trying!");
		}

		// it's not supposed to happen
		throw new IllegalStateException();

	}

	// Prompts the option using swing.JOptionPane
	private AnswerItem promptAnswer(Question question) {

		String answerString = JOptionPane.showInputDialog(question.toString());

		// user pushed cancel
		if (answerString == null) {
			System.exit(1);
		}
		AnswerItem answer;
		try {
			// Capitalize to accept also lower case as answer
			answer = AnswerItem.valueOf(StringUtils.capitalize(answerString));
		} catch (IllegalArgumentException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			JOptionPane.showMessageDialog(null, "There are only 4 options.");
			return promptAnswer(question);
		}
		return answer;
	}

}