package application;

import java.util.Scanner;

public class ExceptionHandlingExample {
	// Declaration & initialization

	public static void main(String[] args) {
		int userValue1;// represents the first value entered by the user
		int userValue2;// represents the second value entered by the user
		Scanner input = new Scanner(System.in);

		ExceptionHandlingExample self = new ExceptionHandlingExample();

		// prompt the user fir the two inputs
		System.out.print("enter one integer value: ");
		userValue1 = input.nextInt();

		System.out.print("enter another integer value: ");
		userValue2 = input.nextInt();
		System.out.printf("%d / %d = %.2f", userValue1, userValue2, self.calcDivision(userValue1, userValue2));
		input.close();
	}

	public double calcDivision(int num1, int num2) {
		return (double) num1 / num2;
	}

}
