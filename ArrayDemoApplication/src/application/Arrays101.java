package application;

import java.util.Arrays;
import java.util.Random;

public class Arrays101 {
	public static void main(String[] args) {
		// Declaration and initialization

		Arrays101 self = new Arrays101();
		int[] box = { 100, 0 - 50, 36, 78, 36 };// new int[5];
		box[0] = 100;
		box[1] = -50;
		box[2] = 36;
		box[3] = 78;
		box[4] = 65;
		// initializing the array elements with random values 1..100
		self.initializeArray(box);

		self.printElements(box);
		System.out.println("***print array in the reverse order***");
		self.printReverse(box);
		System.out.println("Elements of the array: " + self.convertToString(box));

	}// end of the main method

	public void initializeArray(int[] box) {
		// Declaration and initialization
		Random rnd = new Random();
		for (int index = 0; index < box.length; index++) {
			box[index] = rnd.nextInt(100) + 1;

		}
	}

	public void printElements(int[] box) {
		// repeat for index 0... (box.length -1)
		for (int index = 0; index < box.length; index++) {
			System.out.printf("[%d] = %d\n", index, box[index]);
		}
	}

	public void printReverse(int[] box) {

		// print the elements in reverse order
		for (int index = box.length - 1; index >= 0; index--) {
			System.out.printf("[%d] = %d\n", index, box[index]);
		}
	}

	public String convertToString(int[] box) {
		System.out.println("***using Arrays***");
		return Arrays.toString(box);
	}
}
