package application;

import java.util.Locale;
import java.util.Scanner;

//The test for the BMI Application. Exercise 3
public class BMIApplicationTest {
	// states that I am in Canada. Actually my JRE Locale is BR
	static {
		Locale.setDefault(Locale.CANADA);
	}

	public static void main(String[] args) {
		// Creates a 'body' to verify the BMI
		BMIApplicationTest.runUIApplication();
		// Some tests
		// underweightBodyTest();
		// normalBodyTest();
		// overweightBodyTest();
		// obeseBodyTest();
	}

	// Method that prompts the uses for weight and height
	private static void runUIApplication() {
		// prompt the user for a Weight in Pounds
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter your %s (%s).", "Weight", "Pounds");
		double weight = input.nextDouble();
		// prompt the user for a Height in Feet
		System.out.printf("Enter your %s (%s).", "Height", "Feet");
		double height = input.nextDouble();

		input.close(); // close the stream

		// Creates the instance of body
		Body body = new Body(weight, height);
		BMIApplicationTest.runBMICalculus(body);
	}

	// method that calculate the BMI and show the result of it's interpretation
	private static void runBMICalculus(Body body) {
		// Creates the application for the calculation
		BMIApplication application = new BMIApplication();

		// Make the calculus
		double bmi = application.calculate(body);
		// Shows the user the result
		System.out.printf("The BMI for the parameters is: %.2f\n", bmi);
		// Shows the interpretation
		System.out.printf("The parameters indicate: '%s'!\n\n", application.printBmiDescription(bmi));
	}

	private static void underweightBodyTest() {
		BMIApplicationTest.runBMICalculus(new Body(118.98, 5.75));
	}

	private static void normalBodyTest() {
		BMIApplicationTest.runBMICalculus(new Body(158.98, 5.75));
	}

	private static void overweightBodyTest() {
		BMIApplicationTest.runBMICalculus(new Body(188.98, 5.75));
	}

	private static void obeseBodyTest() {
		BMIApplicationTest.runBMICalculus(new Body(218.98, 5.75));
	}

}
