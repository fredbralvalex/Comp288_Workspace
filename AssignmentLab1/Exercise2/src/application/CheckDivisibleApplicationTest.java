package application;

import java.util.Scanner;

//This is the test for CheckDivisibleApplication
public class CheckDivisibleApplicationTest {

	public static void main(String[] args) {
		//Calling some tests
		// CheckDivisibleApplicationTest.divisibleByFiveTest();
		// CheckDivisibleApplicationTest.divisibleBySixTest();
		// CheckDivisibleApplicationTest.divisibleByFiveAndSixTest();
		// CheckDivisibleApplicationTest.notDivisibleByFiveOrSixTest();
		CheckDivisibleApplicationTest.runUIApplication();
	}

	// Method that prompts the usesr for a number and check
	private static void runUIApplication() {
		// The input of a integer to check if is divisible by 5 and by 6
		Scanner input = new Scanner(System.in);
		// prompt the user for a integer
		System.out.println("Enter a integer to check if can be divided by 5 or 6.");
		// declaration and initialization of a number
		int number = input.nextInt();
		input.close();// closes the stream

		// call the method to check if the number is divisible by 5 and 6
		CheckDivisibleApplicationTest.checkDivisible(number);
	}

	//check if the number can be divided by 5 or 6
	private static void checkDivisible(int number) {
		// create a instance of the checker
		CheckDivisibleApplication checker = new CheckDivisibleApplication();
		// verify if it is divisible by 6
		boolean isDivisibleBySix = checker.isDivisibleBy(number, 6);
		// verify if it is divisible by 5
		boolean isDivisibleByFive = checker.isDivisibleBy(number, 5);

		// Shows the user the result of check
		if (isDivisibleByFive && isDivisibleBySix) {
			System.out.printf("%d is divisible by both 5 and 6.\n", number);
		} else if (isDivisibleByFive || isDivisibleBySix) {
			System.out.printf("%d is divisible by 5 or 6, but not both.\n", number);
		} else {
			System.out.printf("%d is not divisible by either 5 or 6.\n", number);
		}

	}

	//Some tests for the application

	// Method that asserts a division by 5
	private static void divisibleByFiveTest() {
		CheckDivisibleApplicationTest.checkDivisible(5);
		CheckDivisibleApplicationTest.checkDivisible(15);
		CheckDivisibleApplicationTest.checkDivisible(100);
	}

	// Method that asserts a division by 6
	private static void divisibleBySixTest() {
		CheckDivisibleApplicationTest.checkDivisible(6);
		CheckDivisibleApplicationTest.checkDivisible(12);
		CheckDivisibleApplicationTest.checkDivisible(72);
	}

	// Method that asserts a division by 5 and 6
	private static void divisibleByFiveAndSixTest() {
		CheckDivisibleApplicationTest.checkDivisible(30);
		CheckDivisibleApplicationTest.checkDivisible(60);
		CheckDivisibleApplicationTest.checkDivisible(120);
	}

	// Method that asserts a division by 5 and 6
	private static void notDivisibleByFiveOrSixTest() {
		CheckDivisibleApplicationTest.checkDivisible(7);
		CheckDivisibleApplicationTest.checkDivisible(31);
		CheckDivisibleApplicationTest.checkDivisible(43);
	}
}
