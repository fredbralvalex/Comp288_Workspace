package application;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;

/** A drive class to test the Insurance application */
public class InsuranceApplication {

	// The starting method to interact with the user
	public static void main(String[] args) {
		// calls the main application
		InsuranceApplication app = new InsuranceApplication();
		Insurance[] insurances = new Insurance[0];
		int count = 0;
		while (true) {
			// prints all information to the user when asking for a new
			// insurance
			String info = app.getInsurancesInfo(insurances);
			// asks for the insurance type
			Insurance insurance = app.promptUserForInsuranceType(info);
			// creates a new array, considering adding a new insurance
			insurances = app.createAndFillArray(insurances);
			// prompts for the cost of the insurance
			double cost = app.promptUserForCost();
			insurance.setInsuranceCost(cost);
			// set the instance of insurance (Life or Health) in the array of
			// superclass
			insurances[count++] = insurance;
		}
	}

	// Builds the information of all insurances inserted
	private String getInsurancesInfo(Insurance[] insurances) {
		String info = "";
		// using polymorphism the display information get the right insurance
		// subclass
		for (Insurance insurance : insurances) {
			info = info + "\n" + insurance.displayInfo();
		}
		return info;
	}

	// Builds a new array with one more element capacity (avoid using ArrayList)
	private Insurance[] createAndFillArray(Insurance[] initialArray) {
		Insurance[] insurances;
		insurances = new Insurance[initialArray.length + 1];
		for (int index = 0; index < initialArray.length; index++) {
			insurances[index] = initialArray[index];
		}
		return insurances;
	}

	// Prompts the user for the Type
	private Insurance promptUserForInsuranceType(final String info) {
		String typeString = JOptionPane.showInputDialog(
				info + "\n\n - Which Type of Insurance do you desire?\n (L) Life, (H) Health or (E) Exit");
		// Exiting
		if (typeString == null) {
			System.exit(0);
		}
		Type insuranceType;
		try {
			// get the value of enum
			insuranceType = Type.valueOf(StringUtils.capitalize(typeString));
			if (Type.L == insuranceType) {
				return new Life();
			} else if (Type.H == insuranceType) {
				return new Health();
			}
		} catch (IllegalArgumentException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			if ("E".equals(StringUtils.capitalize(typeString))) {
				System.exit(0);
			} else {
				return promptUserForInsuranceType(info);
			}
		}
		// never reached
		throw new IllegalArgumentException();
	}

	// Prompts the user for the Cost of insurance
	private double promptUserForCost() {
		String amountString = JOptionPane.showInputDialog(" - How much is the desired Monthly Cost?");
		// Exiting
		if (amountString == null) {
			System.exit(0);
		}
		try {
			// converts the amount information
			return Double.parseDouble(amountString);
		} catch (NumberFormatException e) {
			// case the user enter a different option. Call again this method to
			// prompt one more time.
			return promptUserForCost();
		}
	}
}
