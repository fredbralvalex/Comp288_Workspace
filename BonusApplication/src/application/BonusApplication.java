package application;

import java.util.Scanner;

/**
 *
 * This is the Bonus Class Application to earn some percentages.
 *
 */
public class BonusApplication {

	/**
	 * 1. create an integer array n elements (prompt the user the n elements)
	 * </br>
	 * 2. prompt for values
	 */
	public static void main(String[] args) {

		// Declaration and initialization of application
		BonusApplication self = new BonusApplication();

		// self.isSortedTests();
		// self.findAverageTests();
		int[] box = self.runApplication();
		// print the results
		if (box.length > 0) {
			System.out.println("The array is in decreasing order? " + self.isSorted(box));
			System.out.printf("The average of the elements is: %.2f", self.findAverage(box));
		}

	}

	private int[] runApplication() {
		// Declaration and initialization
		Scanner scanner = new Scanner(System.in);
		int size;
		// Prompts the user for the size of the array
		System.out.println("Please enter the size of the Array: ");
		size = scanner.nextInt();
		int[] box = new int[size];
		// With the size of array, prompts the user for the values
		for (int index = 0; index < size; index++) {
			System.out.printf("Please enter the value in position[%d]: ", index);
			box[index] = scanner.nextInt();

		}
		// closes the stream
		scanner.close();
		return box;
	}

	/**
	 * Method that verify if an integer Array is decreasingly sorted. if the
	 * array is sorted in decreasing order -> true, otherwise -> false
	 */
	public boolean isSorted(int[] box) {
		int tempElement = box[0];
		// take the first element and verify that is the bigger and take the
		// next, if not returns false.
		for (int index = 1; index < box.length; index++) {
			if (tempElement > box[index]) {
				tempElement = box[index];
			} else {
				return false;
			}
		}
		return true;
	}

	/** Method that calculates and returns the average of elements */
	public double findAverage(int[] box) {
		int sum = 0;
		int qt = box.length;

		// sum all the values and divide by the number of elements.
		for (int index = 0; index < box.length; index++) {
			sum = sum + box[index];
		}
		return (double) sum / qt;
	}

	/** Tests if the method isSorted is working */
	private void isSortedTests() {
		BonusApplication self = new BonusApplication();
		System.out.println(self.isSorted(new int[] { 10, 20, 30, 40, 50, 60, 70 }));
		System.out.println(self.isSorted(new int[] { 80, 50, 30, 10 }));
		System.out.println(self.isSorted(new int[] { 100, 50, 60 }));
		System.out.println(self.isSorted(new int[] { 90, 20, 50, 10 }));
		System.out.println(self.isSorted(new int[] { 100, 60, 50 }));

	}

	/** Tests if the method find Average is working */
	private void findAverageTests() {
		BonusApplication self = new BonusApplication();
		System.out.println(self.findAverage(new int[] { 10, 20, 30, 40, 50, 60, 70 }));
		System.out.println(self.findAverage(new int[] { 80, 50, 30, 10 }));
		System.out.println(self.findAverage(new int[] { 100, 50, 60 }));
		System.out.println(self.findAverage(new int[] { 90, 20, 50, 10 }));
		System.out.println(self.findAverage(new int[] { 100, 60, 50 }));
	}
}