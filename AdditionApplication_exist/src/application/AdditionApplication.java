package application;

import java.util.Locale;
import java.util.Scanner;

public class AdditionApplication {

	static {
		Locale.setDefault(Locale.CANADA);
	}

	public static void main(String[] args) {

		// Declaration and initialization
		int firstNum; // this represents the first value
		double secondNum; // this represents the second value
		double sum = 0d; // represents the total
		double x = 0d;

		String var;

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number...");
		firstNum = input.nextInt();

		System.out.print("Enter a floating point value...");
		secondNum = input.nextDouble();

		/*
		 * do { System.out.print("Enter a float number... or '00' "); var =
		 * input.nextLine(); if (!"00".equals(var)) { sum = sum +
		 * Double.parseDouble(var); } } while("00".equals(var));
		 */

		sum = firstNum + secondNum;
		System.out.print("The total is:" + sum);
		// System.out.printf("%d + %.2f = %.2f",firstNum , secondNum , sum);

	}
}
