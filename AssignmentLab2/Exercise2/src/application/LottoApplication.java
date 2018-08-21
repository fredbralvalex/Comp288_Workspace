package application;

import javax.swing.JOptionPane;

//This class represents a Lotto application
public class LottoApplication {

	public void runFiveChanceToWin() {
		// The system give to the user 5 chances to get one number
		for (int index = 1; index <= 5; index++) {
			int luckyNumber = shuffleNumbers();
			int numberPicked = inputNumber(index);
			if (numberPicked == luckyNumber) {
				JOptionPane.showMessageDialog(null, "You have got the number in the attempt number " + index + "!");
				System.exit(0);
			}
		}

		// if the system reaches here, the system wins
		JOptionPane.showMessageDialog(null, "Sorry! Run out of Chance!!!");
	}

	// Method that process a number to be considerate the lotto number.
	public int shuffleNumbers() {
		Lotto lotto = new Lotto();
		int[] numbers = lotto.getNumbers();
		int sum = 0;
		for (int index = 0; index < numbers.length; index++) {
			sum = sum + numbers[index];
		}
		return sum;
	}

	// Method that prompts the user for numbers
	public int inputNumber(int attempt) {

		// Prompts the user
		String numberString = JOptionPane
				.showInputDialog("Attempt " +
		attempt + " - Try your luck with a number between 3 and 27");

		// user pushed cancel
		if (numberString == null) {
			System.exit(1);
		}
		int numberPicked;
		try {
			// Parse the input to a number
			numberPicked = Integer.parseInt(numberString);

			//verify it the is a valid number
			if (numberPicked < 3 || numberPicked > 27) {
				JOptionPane.showMessageDialog(null, "Try your luck with a number between 3 and 27, or Cancel!");
				return inputNumber(attempt);
			}

			return numberPicked;
		} catch (NumberFormatException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			JOptionPane.showMessageDialog(null,
					"Try your luck with a number between 3 and 27, or Cancel!");
			return inputNumber(attempt);
		}
	}

}
