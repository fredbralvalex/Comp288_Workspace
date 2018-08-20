package application;

public class Withdraw extends Transaction {

	public Withdraw(Account account, double value) {
		super(account, value);
		// TODO Auto-generated constructor stub
	}

	//Method run to perform the deposits and withdraws
	public void run()
	{
		//This is the point to add wait in case of withdraw only with positive balance
		account.withdraw(getValue());
	} // end method run
}
