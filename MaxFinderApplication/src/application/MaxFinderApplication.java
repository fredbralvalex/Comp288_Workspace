package application;

public class MaxFinderApplication {
	public static void main(String[] args) {
		int max3 = findMax(78, 5, 27);
		System.out.printf("The biggest value (78, 5, 27) is: %d\n", max3);
		System.out.printf("The biggest value (55, -1) is: %d\n", findMax(55, -1));
		System.out.printf("The biggest value (1.23, 0.5) is: %.2f\n", findMax(1.23, 0.5));

	}// end of the main method

	//returns the biggest between two intergers
	public static int findMax(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}
	//return the biggest between two doubles
	public static double findMax(double num1, double num2) {
		return num1 > num2 ? num1 : num2;
	}

	public static int findMax(int num1, int num2, int num3) {
		return findMax(findMax(num1, num2), num3);
	}

	public static int findMax(int num1, int num2, int num3, int num4) {
		return Math.max(findMax(num1, num2, num3), num4);
	}

	public static int findMax(int num1, int num2, int num3, int num4, int num5) {
		return Math.max(findMax(num1, num2, num3, num4), num5);
	}

}
