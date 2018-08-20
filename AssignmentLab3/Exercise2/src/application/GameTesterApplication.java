package application;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;

/** The application to test the logic. */
public class GameTesterApplication {

	// Method to interact with the user
	public static void main(String[] args) {
		GameTesterApplication app = new GameTesterApplication();
		GameTester[] testers = new GameTester[0];
		int count = 0;
		while (true) {
			// prints all information to the user when asking for a new
			// asks for the insurance type
			GameTester gameTester = app.promptUserForGameTester();
			// creates a new array, considering adding a new object
			testers = app.createAndFillArray(testers);
			// set the instance in the array of superclass
			testers[count++] = gameTester;
			app.showArrayInformation(testers);
		}

	}

	private void showArrayInformation(GameTester[] testers) {
		String info = "";
		for (int index = 0; index < testers.length; index++) {
			info = info + "\n" + testers[index];
		}
		JOptionPane.showMessageDialog(null, info);
	}

	// Prompts the user for the Type
	private GameTester promptUserForGameTester() {
		String typeString = JOptionPane
				.showInputDialog("Which Type of job the tester is?\n (P) Part-Time, (F) Full-Time or (E) Exit");
		// Exiting
		if (typeString == null) {
			System.exit(0);
		}
		Job jobType;
		try {
			// get the value of enum
			jobType = Job.valueOf(StringUtils.capitalize(typeString));
			if (Job.P == jobType) {
				String name = promptUserForName();
				int hours = promptUserForHour();
				return new PartTimeGameTester(name, hours);
			} else if (Job.F == jobType) {
				String name = promptUserForName();
				return new FullTimeGameTester(name);
			}
		} catch (IllegalArgumentException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			if ("E".equals(StringUtils.capitalize(typeString))) {
				System.exit(0);
			} else {
				return promptUserForGameTester();
			}
		}
		// never reached
		throw new IllegalArgumentException();
	}

	// Prompts the user for the amount of hour of the part-time job
	private int promptUserForHour() {

		String numericString = JOptionPane.showInputDialog("Please enter the Amount of hour.");
		// Exiting is not allowed now
		if (numericString == null) {
			return promptUserForHour();
		}
		try {
			int hourValue = Integer.parseInt(numericString);
			if (hourValue < 0 || hourValue > 80) {// maximum hour allowed in one
													// month (20 * 4)
				promptUserForHour();
			}
			return hourValue;
		} catch (NumberFormatException e) {
			// when it is not a valid number, prompt one more time.
			return promptUserForHour();
		}
	}

	// Prompts the user for the Name
	private String promptUserForName() {

		String name = JOptionPane.showInputDialog("Please enter the Name.");
		// Exiting is not allowed now
		if (name == null) {
			return promptUserForName();
		} else {
			return name;
		}
	}

	// Builds a new array with one more element capacity (avoid using ArrayList)
	public GameTester[] createAndFillArray(GameTester[] initialArray) {
		GameTester[] testers;
		testers = new GameTester[initialArray.length + 1];
		for (int index = 0; index < initialArray.length; index++) {
			testers[index] = initialArray[index];
		}
		return testers;
	}

}
