package application;

/* This is a Transaction in the system */
public abstract class Transaction  implements Runnable {

	//Declaration
	private double value;
	protected Account account;

	//Getter for the value
	public double getValue() {
		return value;
	}

	//A simple constructor
	public Transaction(Account account, double value) {
		this.value = value;
		this.account = account;
	}
}
