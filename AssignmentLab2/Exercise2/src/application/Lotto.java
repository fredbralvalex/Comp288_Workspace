package application;

import java.util.Random;

//The Class lotto
public class Lotto {
	//Array instance variable to hold three random integer values (from 1 to 9)
	private int[] numbers;

	//A constructor that randomly populates the array for a lotto object
	public Lotto() {
		numbers = new int[3];
		Random randomObject = new Random();
		for (int index = 0; index < numbers.length; index++) {
			numbers[index] = randomObject.nextInt(9) + 1;
		}
	}

	//Method that returns the array
	public int[] getNumbers() {
		return numbers;
	}
}
