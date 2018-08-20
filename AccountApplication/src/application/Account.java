package application;

public class Account {
	// field variables
	String _name;// represents the user name
	double _balance;

	// methods
	public Account() {
		this("Not set", 5.00);
	}

	public Account(String newName, double newBalance) {
		this._name = newName;
		this._balance = newBalance;
	}

	// getter
	public double getBalance() {
		return this._balance;
	}

	public String getName() {
		return this._name;
	}

	// setter
	public void setName(String newName) {
		this._name = newName;
	}

	public void setBalance(double _balance) {
		this._balance = _balance;
	}

}// end of the Account class
