package application;

import java.util.Locale;
import java.util.Scanner; // used for input

import javax.swing.JOptionPane;

public class AccountTest
{

	static
	{
		Locale.setDefault(Locale.CANADA);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		// Declaration and initializations
		Account defaultAccount = new Account();// represents an account object
		Account accTwo;// = new Account("Mary");// represents another account
						// object

		Scanner input = new Scanner(System.in);

		String userName; // represents the user's name
		double userBalance;// represents the user's balance

		System.out.println("The default account: " + defaultAccount.getName() + ", " + defaultAccount.getBalance());

		// prompt user
		//System.out.print("Enter user name:");
		//userName = input.nextLine();
		userName = JOptionPane.showInputDialog("Enter your name");

		//System.out.print("Enter user balance:");
		//userBalance = input.nextDouble();
		userBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your balance"));

		// set the user name
		// defaultAccount.setName(userName);

		// Print the info for accTwo
		accTwo = new Account(userName, userBalance);
		System.out.printf("The second account: %s , $%.2f ", accTwo.getName(), accTwo.getBalance());

		/*
		 * System.out.println("The second user's name is: " + accTwo.getName());
		 * accTwo.setName("Marie");
		 * System.out.print("The second user's new name is: " +
		 * accTwo.getName());
		 */

	}// end of the main method
}
