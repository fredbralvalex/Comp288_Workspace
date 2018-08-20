package application;

/** Represents a Personal Mortgage in the system. */
public class PersonalMortgage extends Mortgage {
	//Constructor
	//2% over the current prime rate.
	public PersonalMortgage(int number, String customerName, double amount, double interestRate, Term term) {
		super(number, customerName, amount, interestRate*( 1 + 0.02), term);
	}

	@Override
	public String getMortgageInfo() {
		return "Type: Personal " + super.getMortgageInfo();
	}

}
