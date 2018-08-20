package application;

/** Represents a Business Mortgage in the system. */
public class BusinessMortgage extends Mortgage {
	// Constructor
	// 1% over the current prime rate.
	public BusinessMortgage(int number, String customerName, double amount, double interestRate, Term term) {
		super(number, customerName, amount, interestRate *( 1 + 0.01), term);
	}

	@Override
	public String getMortgageInfo() {
		return "Type: Business " + super.getMortgageInfo();
	}

}
