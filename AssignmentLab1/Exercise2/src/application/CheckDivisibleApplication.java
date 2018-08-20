package application;
//Method that Checks if a number is divisible for a number received as parameter.
public class CheckDivisibleApplication {

	//Receive two numbers and verify if the first is divided by the second
	public boolean isDivisibleBy(int number, int dividedBy) {
		return number % dividedBy == 0;
	}
}
