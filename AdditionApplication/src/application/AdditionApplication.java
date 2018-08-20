package application;

import java.util.Scanner;

public class AdditionApplication {
	public static void main(String[] args)
	{

		// Declarations & initializations
		int firstNum; // this represents the first value
		double secondNum; // this represents the second value
		double sum; // represents the total

		AdditionApplication self = new AdditionApplication();


		Scanner input = new Scanner(System.in);
		do{ // repeat

			// Input
			System.out.println("Enter two values. (two zeroes to stop)");
			System.out.print("\tEnter the first integer: ");
			firstNum = input.nextInt();
			System.out.print("\tEnter the a floating point value: ");
			secondNum = input.nextDouble();


		   if (firstNum!=0 || secondNum!=0) // prints the addition
		   {


			   sum = self.add(firstNum, secondNum);

			   // Output
			   System.out.printf("\t%d + %.2f = %.2f\n",firstNum, secondNum, sum);

		   }
		   else // stops when two zeroes are entered
		   {
			   System.out.println("You have entered two zeroes");
			   break;
		   }

		}while(true);  // infinite loop

	} //  end of the main method


	// the add method adds up the two parameters
	// returns the addition
	public double add(int num1, double num2)
	{
		return num1 + num2;
	}


}
