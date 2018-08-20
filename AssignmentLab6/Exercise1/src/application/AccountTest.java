package application;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*This class represents a class to test the application. */
public class AccountTest {

	public static void main(String[] arg) {
		// construct the arraylist for the transactions
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		Account account = new Account();
		// create two tasks to write to the shared SimpleArray
		transactions.add(new Deposit(account, 150.0));
		transactions.add(new Withdraw(account, 700d));
		transactions.add(new Deposit(account, 1000));
		transactions.add(new Withdraw(account, 50));
		transactions.add(new Withdraw(account, 500));
		transactions.add(new Deposit(account, 100));

		// execute the tasks with an ExecutorService
		ExecutorService executor = Executors.newCachedThreadPool();
		for (Transaction transaction : transactions) {
			executor.execute(transaction);
		}
		executor.shutdown();
		//finishing the creation

		try {
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
			if (tasksEnded)
				System.out.println(account.toString()); // print contents
			else
				System.out.println("Timed out while waiting for tasks to finish.");
		} // end try
		catch (InterruptedException ex) {
			System.out.println("Interrupted while wait for tasks to finish.");
		} // end catch

	}
}
