package application;

import java.util.Calendar;
import java.util.Date;

//The class that possesses 3 overloaded methods
public class OverloadedApplication {

	//Creates a java.util.Date without any argument
	public static Date createSimpleDate() {
		return createSimpleDate(1990, 11, 31, 23, 59, 59);
	}

	//Creates a java.util.Date using only date arguments
	public static Date createSimpleDate(int year, int month, int day) {
		return createSimpleDate(year, month, day, 23, 59, 59);
	}

	//Creates a java.util.Date using date and time arguments
	public static Date createSimpleDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(year, month, day, hour, minute, second);
		return cal.getTime();
	}

	//The main method that declares and initializes the application
	public static void main(String[] args) {
		//call for the method without any arguments
		Date dateOne = createSimpleDate();
		//call for the method passing year, month and day as argument
		Date dateTwo = createSimpleDate(2018, 1, 13);
		//call for the method passing information about date and time.
		Date dateThree = createSimpleDate(2018, 1, 13, 16, 0, 0);

		//print the dates
		System.out.println("This date was created using a zero argument overloaded method: " + dateOne);
		System.out.println("This date was created using only date arguments: " + dateTwo);
		System.out.println("This date was created using all arguments for a java.util.Date: " + dateThree);
	}
}
