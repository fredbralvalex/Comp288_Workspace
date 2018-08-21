package application;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;

/** The Class that runs the application. */
public class ProcessMortgage {

	public static void main(String[] args) {

		// Declaration and initialization
		Mortgage[] mortgages = new Mortgage[3];
		ProcessMortgage app = new ProcessMortgage();

		// prompts for interest rating
		double rate = app.promptUserForNumericInfo("current interest rate(%)");
		while (rate < 1 || rate > 100) {
			rate = app.promptUserForNumericInfo("current interest rate (1 - 100%)");
		}

		for (int index = 0; index < mortgages.length; index++) {
			// Prompts for type.
			Type type = app.promptUserForType();

			// prompting for all relevant information
			String customerName = app.promptUserForStringInfo("customer name");
			double amount = app.promptUserForNumericInfo("mortgage amount");

			// don't allow mortgage amount over 300,000
			while (amount > Mortgage.MAX_MORTAGE_AMOUNT) {
				amount = app.promptUserForNumericInfo("mortgage amount(max 300,000)");
			}

			Term term = app.promptUserForTerm();

			Mortgage mortgage;
			if (Type.P == type) {
				mortgage = new PersonalMortgage(index + 1, customerName, amount, rate, term);
			} else {
				mortgage = new BusinessMortgage(index + 1, customerName, amount, rate, term);
			}
			mortgages[index] = mortgage;
		}
		app.print(mortgages);
	}


	// prints the mortgages information
	private void print(Mortgage[] mortgages) {
		String str = Mortgage.BANK_NAME + "\n";

		for (int index = 0; index < mortgages.length; index++) {
			str = str + "\n" + mortgages[index];
		}

		JOptionPane.showMessageDialog(null, str);
	}

	// Prompts the user for the term
	private Type promptUserForType() {
		String typeString = JOptionPane.showInputDialog("Please enter the Type.\n(B) Business\n(P) Personal");
		// Exiting not allowed
		if (typeString == null) {
			return promptUserForType();
		}
		try {
			// get the value of enum
			return Type.valueOf(StringUtils.capitalize(typeString));
		} catch (IllegalArgumentException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			return promptUserForType();
		}
	}

	// Prompts the user for the term
	private Term promptUserForTerm() {
		String termString = JOptionPane.showInputDialog("Please enter the Term.\n(S) Short\n(M) Medium\n(L) Long");
		// Exiting not allowed
		if (termString == null) {
			return promptUserForTerm();
		}
		try {
			// get the value of enum
			return Term.valueOf(StringUtils.capitalize(termString));
		} catch (IllegalArgumentException e) {
			// case the user enter a different option, force Short-term.
			return Term.S;
		}
	}

	// Prompts the user for the price or year of the book
	private double promptUserForNumericInfo(final String info) {
		String prompting = "Please enter the " + info + ".";

		String numericString = JOptionPane.showInputDialog(prompting);
		// Exiting is not allowed now
		if (numericString == null) {
			return promptUserForNumericInfo(info);
		}
		try {
			return Double.parseDouble(numericString);
		} catch (NumberFormatException e) {
			// when it is not a valid number, prompt one more time.
			return promptUserForNumericInfo(info);
		}
	}

	// Prompts the user for the title, the ISBN, the publisher of the book
	private String promptUserForStringInfo(String info) {
		String infoStr = JOptionPane.showInputDialog("Please enter a " + info + ".");
		// Exiting is not allowed now
		if (infoStr == null || infoStr.equals("")) {
			// when it is not a valid number, prompt one more time.
			return promptUserForStringInfo(info);
		} else {
			// get the value
			return infoStr;
		}
	}
}
