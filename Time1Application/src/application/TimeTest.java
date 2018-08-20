package application;

public class TimeTest {
	public static void main(String[] args) {
		// Declaration and initialization
		Time1 timeObj = new Time1();

		// set the values of time
		timeObj.setTime(23, 30, 55);

		// print time in universal format
		System.out.println("Time Universal Format >> " + timeObj.toUniversalString());
		// print time using the toString method
		System.out.println("Time >> " + timeObj.toString());

		// Invalid Time
		// Declaration and initialization
		Time1 timeInvalid = new Time1();
		// set the values of time
		try {
			timeInvalid.setTime(23, 30, -55);
		} catch (IllegalArgumentException e) {
			System.out.printf("Exception: %s%n%n", e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong! The application will end!");
			System.exit(1);//end the application
		}

	}

}
