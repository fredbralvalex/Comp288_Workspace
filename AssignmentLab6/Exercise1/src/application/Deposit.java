package application;

public class Deposit extends Transaction {

	public Deposit(Account account, double value) {
		super(account, value);
		// TODO Auto-generated constructor stub
	}

	//Method run to perform the deposits and withdraws
	public void run()
	{
		account.deposit(getValue());
	} // end method run
}
