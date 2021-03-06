package application;

/** A class that represents the mortgage. */
public class Mortgage implements MortgageConstants {

	// Fields
	public static double primeRate;
	private int number;
	private String customerName;
	private double amount;
	private double interestRate;
	private Term term;

	// Constructor
	public Mortgage(int number, String customerName, double amount, double interestRate, Term term) {
		super();
		this.number = number;
		this.customerName = customerName;
		this.amount = amount;
		this.interestRate = interestRate;
		this.term = term;
	}

	// GETTERS and SETTERS
	protected int getNumber() {
		return number;
	}

	protected String getCustomerName() {
		return customerName;
	}

	protected double getAmount() {
		return amount;
	}

	protected double getInterestRate() {
		return interestRate;
	}

	protected Term getTerm() {
		return term;
	}

	protected void setNumber(int number) {
		this.number = number;
	}

	protected void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	protected void setAmount(double amount) {
		this.amount = amount;
	}

	protected void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	protected void setTerm(Term term) {
		this.term = term;
	}

	// mortgage calculate extracted from:
	// http://homeguides.sfgate.com/calculate-mortgage-payments-excel-9617.html
	private double calculateMontlyMorgageOverTime() {
		int termInMonths = Mortgage.YEARS_FOR_SHORT_TERM * 12;
		if (Term.M == getTerm()) {
			termInMonths = Mortgage.YEARS_FOR_MEDIUM_TERM * 12;
		} else if (Term.L == getTerm()) {
			termInMonths = Mortgage.YEARS_FOR_LONG_TERM * 12;
		}

		// get the interest rate in one month (not in %)
		double var = getInterestRate() / 1200;
		//rate over the years
		double var2 = Math.pow((1 + var), termInMonths);
		double var3 = (var * var2) / (var2 - 1);
		return var3 * getAmount();
	}

	// show the mortgages info
	@Override
	public String getMortgageInfo() {

		return " Number: " + number + " Customer Name: " + customerName + " Amount: " + String.format("%.4f", amount)
				+ " Interest Rate: " + String.format("%.4f", interestRate) + "% Term: " + term + " Montly payment: "
				+ String.format("%.4f", calculateMontlyMorgageOverTime());

	}

	// to String calling the mortgages info
	@Override
	public String toString() {
		return getMortgageInfo();
	}

}
