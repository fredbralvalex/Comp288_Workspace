package application;

//This class represents the application that make the calculus the BMI for a person
public class BMIApplication {
	// Constants for the application
	final static double POUNDS_IN_KG = 0.453;
	final static double FOOT_IN_M = 0.304;

	// Constants for assert the BMI
	final static String UNDERWEIGHT = "Underweight";
	final static String NORMAL = "Normal";
	final static String OVERWEIGHT = "Overweight";
	final static String OBESE = "Obese";

	// Makes the calculation for the BMI
	public double calculate(Body person) {
		double weightInKg = person.getWeight() * POUNDS_IN_KG;
		double heightInM = person.getHeight() * FOOT_IN_M;

		// the weight divided by square of height
		return weightInKg / (heightInM * heightInM);
	}

}
