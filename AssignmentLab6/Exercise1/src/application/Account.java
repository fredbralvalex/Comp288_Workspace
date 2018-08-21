package application;

/** This represents an account in the system */
public class Account {
	private double amount = 0;

	//Getter
	public double getAmount() {
		return amount;
	}

	// construct a SimpleArrayof a given size
	public Account() {
	} // end constructor

	// makes a deposit in the account
	public synchronized void deposit(double value) {
		this.amount += value;
		System.out.println("A deposit of " + value + " |  Balance : " + amount);
	}

	// makes a withdraw in the account
	public synchronized void withdraw(double value) {
		this.amount -= value;
		System.out.println("A withdraw of " + value + " | Balance : " + amount);
	}

	/* Print the value of amount */
	public String toString() {
		return "The actual value of the account is: " + amount;
	}

}
